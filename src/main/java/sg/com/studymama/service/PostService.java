package sg.com.studymama.service;

import java.util.List;

import sg.com.studymama.DTO.PostsDTO;
import sg.com.studymama.Entity.PostsEntity;
import sg.com.studymama.model.PaginationParamDTO;
import sg.com.studymama.model.PaginationResultDTO;

public interface PostService {
	
	public List<PostsDTO> getAllPost();//?
	
	public List<PostsDTO> getPosts(Integer accountId);
	
	public PostsDTO findById(Integer postId);
	
	public PostsEntity save(PostsDTO dto);
	
	public Integer deletePost(Integer postId);

}
