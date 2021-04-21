package sg.com.studymama.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sg.com.studymama.model.Post;
import sg.com.studymama.service.ElasticsearchRestTemplateServiceImpl;
import sg.com.studymama.service.SpringDataPostService;

@RestController
@RequestMapping("/postService")
public class PostController {
    private static final Logger LOG = LoggerFactory.getLogger(PostController.class);


    @Autowired
    private  SpringDataPostService springDataPostService;

    @Operation(summary = "Create a post")
    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public ResponseEntity<?> post(@RequestBody Post post) throws Exception {
        LOG.info("Adding Posts to Elasticsearch " + post.toString());

        return ResponseEntity.ok(springDataPostService.createPost(post));
    }

    @Operation(summary = "delete a post by id")
    @RequestMapping(value = "/post", method = RequestMethod.DELETE)
    public ResponseEntity<?> post( @Parameter(description = "the id of post to be deleted ") @RequestParam String id) throws Exception {
        LOG.info("Delete Post id "+id);
        springDataPostService.deletePost(id);
        return ResponseEntity.ok("Delete Successfully");
    }

    @Operation(summary = "Retrieving  all posts")
    @RequestMapping(value = "/allPost", method = RequestMethod.GET)
    public ResponseEntity<?> getAllPosts() throws Exception {
        LOG.info("retrieving all Post");

        return ResponseEntity.ok(springDataPostService.getAllPost());
    }

    @Operation(summary = "Retrieving posts base on title")
    @RequestMapping(value = "/searchPostBySimilarTitle", method = RequestMethod.GET)
    public ResponseEntity<?> searchPostsBySimilarTitle(
            @Parameter(description = "The keyword to search in title")
            @RequestParam String title) throws Exception {
        LOG.info("Retrieving posts base on title");

        return ResponseEntity.ok(springDataPostService.searchPostByName(title));
    }

    @Operation(summary = "Retrieving posts base on category")
    @RequestMapping(value = "/searchPostByCategory", method = RequestMethod.GET)
    public ResponseEntity<?> searchPostsByCategory(
            @Parameter(description = "The category name")
            @RequestParam String category) throws Exception {
        LOG.info("Retrieving posts base on category");

        return ResponseEntity.ok(springDataPostService.searchPostByCategory(category));
    }

    @Operation(summary = "Retrieving posts base  on keyword in category")
    @RequestMapping(value = "/searchPostBySimilarCategory", method = RequestMethod.GET)
    public ResponseEntity<?> searchPostsByKeywordInCategory(
            @Parameter(description = "The keyword to search in Category ")
            @RequestParam String keyword) throws Exception {
        LOG.info("Retrieving posts base  on keyword in category");

        return ResponseEntity.ok(springDataPostService.searchPostBySimilarCategory(keyword));
    }


    @Operation(summary = "Retrieving posts base on keyword in the Title,Descriptions and Category")
    @RequestMapping(value = "/searchPostByKeywordInTitleDescCategory", method = RequestMethod.GET)
    public ResponseEntity<?> searchPostsByByKeywordInTitleDescriptionCategory(
            @Parameter(description = "The keyword to search in Title,Description and Category ")
            @RequestParam String keyword) throws Exception {
        LOG.info("Retrieving posts base on keyword in the Title,Descriptions and Category");

        return ResponseEntity.ok(springDataPostService.searchPostsByByKeywordInTitleDescriptionCategory(keyword));
    }


    @Operation(summary = "Retrieving  all posts around certain distance")
    @RequestMapping(value = "/postNearMe", method = RequestMethod.GET)
    public ResponseEntity<?> getAllPostsNearMe(@Parameter(description = "The value of distance you want to search ") @RequestParam Double distance,
                                               @Parameter(description = "latitude ") @RequestParam Double lat,
                                               @Parameter(description = "longitude ") @RequestParam Double lon,
                                               @Parameter(description = "km or m ")  @RequestParam String unit) throws Exception {

        return ResponseEntity.ok(springDataPostService.searchWithin(new GeoPoint(lat,lon),distance,unit));
    }

}
