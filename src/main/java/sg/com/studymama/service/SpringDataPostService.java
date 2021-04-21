package sg.com.studymama.service;

import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;
import sg.com.studymama.model.Post;

import java.util.List;
import java.util.Optional;

public interface SpringDataPostService {

  Post createPost(Post post);

  Optional<Post> getPost(String id);

  void deletePost(String id);

  Iterable<Post> insertBulkPost(List<Post> Posts);

  List<Post> getPostsByCategory(String category);

  List<Post> getAllPost();

  List<Post> searchPostBySimilarTitle(String title);
  List<Post> searchPostByName(String title);

  List<Post> searchPostBySimilarCategory(String category);

  List<Post> searchPostByCategory(String category);

  List<Post> searchPostsByByKeywordInTitleDescriptionCategory(String keyword);

  public List<Post> searchWithin(GeoPoint geoPoint, Double distance, String unit);
}
