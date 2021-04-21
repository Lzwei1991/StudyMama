package sg.com.studymama.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.elasticsearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.IndexOperations;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;
import org.springframework.data.elasticsearch.core.query.Criteria;
import org.springframework.data.elasticsearch.core.query.CriteriaQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.stereotype.Service;
import sg.com.studymama.model.Post;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class ElasticsearchRestTemplateServiceImpl implements ElasticsearchRestTemplateService {

  @Autowired
  private  ElasticsearchRestTemplate elasticsearchRestTemplate;
  @PostConstruct
  public void init() {
    IndexOperations indexOperations = elasticsearchRestTemplate.indexOps(Post.class);
    indexOperations.putMapping(indexOperations.createMapping());
    indexOperations.refresh();
  }


  public Post getPostById(String id) {

    SearchHits<Post> searchHits = elasticsearchRestTemplate
        .search(new CriteriaQuery(new Criteria("id").is(id)), Post.class);
    return searchHits.get().map(SearchHit::getContent).findFirst().orElse(null);
  }

  public List<Post> getPostsByName(String name) {
    Query query = new NativeSearchQueryBuilder()
        .withQuery(QueryBuilders.matchQuery("name", name))
        .build();
    SearchHits<Post> searchHits = elasticsearchRestTemplate.search(query, Post.class);

    return searchHits.get().map(SearchHit::getContent).collect(Collectors.toList());
  }

  public Map<String, Long> aggregateTerm(String term) {
    Query query = new NativeSearchQueryBuilder()
        .addAggregation(new TermsAggregationBuilder(term).field(term).size(10))
        .build();

    SearchHits<Post> searchHits = elasticsearchRestTemplate.search(query, Post.class);
    Map<String, Long> result = new HashMap<>();
    searchHits.getAggregations().asList().forEach(aggregation -> {
      ((Terms) aggregation).getBuckets()
          .forEach(bucket -> result.put(bucket.getKeyAsString(), bucket.getDocCount()));
    });

    return result;
  }

  public  CriteriaQuery getGeoQuery(GeoPoint point, String distance) {
    return new CriteriaQuery(
            new Criteria("location").within(point,distance)
    );
  }

}
