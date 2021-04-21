package sg.com.studymama.repository;


import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.core.IndexOperations;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import sg.com.studymama.model.Post;

import javax.annotation.PostConstruct;
import java.util.List;

public interface PostElasticSearchRepository extends ElasticsearchRepository<Post, String> {

  List<Post> findAllByCategory(String category);

  @Query("{\"match_all\":{}}")
  List<Post> findAll();

  @Query("{\"match_bool_prefix\":{\"title\":\"?0\"}}")
  List<Post> findPostBySimilarTitle(String title);

  @Query("{\"match_bool_prefix\":{\"category\":\"?0\"}}")
  List<Post> findPostBySimilarCategory(String category);


  @Query("{\"multi_match\":{\"query\":\"?0\", \"type\":\"phrase_prefix\",\n\"fields\": [ \"title\", \"description\",\"category\"] }}")
  List<Post> findPostsByByKeywordInTitleDescriptionCategory(String keyword);


}
