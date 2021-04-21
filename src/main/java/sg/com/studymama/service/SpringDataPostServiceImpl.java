package sg.com.studymama.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.IndexOperations;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.Criteria;
import org.springframework.data.elasticsearch.core.query.CriteriaQuery;
import org.springframework.data.elasticsearch.core.query.GeoDistanceOrder;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.stereotype.Service;
import sg.com.studymama.model.Post;
import sg.com.studymama.repository.PostElasticSearchRepository;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SpringDataPostServiceImpl implements SpringDataPostService {

  @Autowired
  private PostElasticSearchRepository postRepository;

  @Autowired
  private  ElasticsearchOperations operations;


  public Post createPost(Post Post) {
    return postRepository.save(Post);
  }

  public Optional<Post> getPost(String id) {
    return postRepository.findById(id);
  }

  public void deletePost(String id) {
    postRepository.deleteById(id);
  }

  @Override
  public Iterable<Post> insertBulkPost(List<Post> Posts) {
    return postRepository.saveAll(Posts);
  }

  @Override
  public List<Post> getPostsByCategory(String category) {
    return postRepository.findAllByCategory(category);
  }

  @Override
  public List<Post> getAllPost() {
    return postRepository.findAll();
  }

  @Override
  public List<Post> searchPostBySimilarTitle(String title) {
    return postRepository.findPostBySimilarTitle(title);
  }

  @Override
  public List<Post> searchPostBySimilarCategory(String category) {
    return postRepository.findPostBySimilarCategory(category);
  }

  @Override
  public List<Post> searchPostByCategory(String category) {
    return postRepository.findAllByCategory(category);
  }

  @Override
  public List<Post> searchPostsByByKeywordInTitleDescriptionCategory(String keyword) {
    return postRepository.findPostsByByKeywordInTitleDescriptionCategory(keyword);
  }

  public Iterable<Post> insertBulk(List<Post> Posts) {
    return postRepository.saveAll(Posts);
  }

  public List<Post> getPostsByName(String name) {
    return postRepository.findAllByCategory(name);
  }

  public List<Post> getAllPosts(String name) {
    return postRepository.findAll();
  }


  public List<Post> searchWithin(GeoPoint geoPoint, Double distance, String unit) {

    Query query = new CriteriaQuery(
            new Criteria("location").within(geoPoint, distance.toString() + unit)
    );
    // add a sort to get the actual distance back in the sort value
    Sort sort = Sort.by(new GeoDistanceOrder("location", geoPoint).withUnit(unit));
    query.addSort(sort);

    return toResultData(operations.search(query, Post.class).getSearchHits());
  }

  @Override
  public List<Post> searchPostByName(String title){
    Criteria criteria = new Criteria("title").contains(title);

    Query searchQuery = new CriteriaQuery(criteria);
    Sort sort = Sort.by(new Sort.Order(Sort.Direction.DESC,"post_dt.keyword"));
    searchQuery.addSort(sort);

    return  toResultData(operations
            .search(searchQuery,
                    Post.class).getSearchHits());
  }

  private List<Post> toResultData(List<SearchHit<Post>> searchHits) {
    return searchHits.stream()
            .map(searchHit -> {
              Post post = searchHit.getContent();
              return post;
            }).collect(Collectors.toList());
  }

//  private List<SearchHit<Post>> searchByCategory(String category){
//    Criteria criteria = new Criteria("category").contains(category);
//
//    Query searchQuery = new CriteriaQuery(criteria);
//    Sort sort = Sort.by(new Sort.Order(Sort.Direction.DESC,"post_dt.keyword"));
//    searchQuery.addSort(sort);
//
//    return  operations
//            .search(searchQuery,
//                    Post.class).getSearchHits();
//  }
}
