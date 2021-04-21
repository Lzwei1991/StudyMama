package sg.com.studymama.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import sg.com.studymama.Entity.PostEntity;
import sg.com.studymama.model.DAOPostPicture;
import sg.com.studymama.model.PostPictureDTO;
import sg.com.studymama.repository.PostPictureRepository;
import sg.com.studymama.repository.PostRepository;

@Service
public class PostPictureService {

	private static final Logger LOG = LoggerFactory.getLogger(PostPictureService.class);
	
	@Autowired
	PostRepository postRepository;
	
	@Autowired
	PostPictureRepository postPictureRepository;

	public DAOPostPicture saveOrUpdate(PostPictureDTO postPictureDTO) {
		Optional<PostEntity> tempProfile = postRepository.findById((int) postPictureDTO.getPost_id());
		PostEntity updateProfile = tempProfile.orElse(null);
		if(updateProfile!=null) { //to check if profile exists first
			DAOPostPicture daoProfilePic = new DAOPostPicture();
			daoProfilePic.setPostPic(postPictureDTO.getPostPic());
			daoProfilePic.setUser_profile_id(postPictureDTO.getUser_profile_id());
			daoProfilePic.setUsername(postPictureDTO.getUsername());
			LOG.info("saveOrUpdate " + postPictureDTO.toString());
			return postPictureRepository.save(daoProfilePic);
		}
		throw new UsernameNotFoundException("post not found with id: " + postPictureDTO.getPost_id());
	}
}
