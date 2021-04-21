package sg.com.studymama.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import sg.com.studymama.model.PostPictureDTO;
import sg.com.studymama.model.ProfilePictureDTO;
import sg.com.studymama.service.PostPictureService;
import sg.com.studymama.service.ProfilePictureService;

@RestController
public class FileController {

	private static final Logger LOG = LoggerFactory.getLogger(FileController.class);
	
	@Autowired
	private ProfilePictureService profilePictureService;
	
	@Autowired
	private PostPictureService postPictureService;
	
	@RequestMapping(value = "/profilePicture", method = RequestMethod.POST)
	public ResponseEntity<?> saveUserProfilePicture(@RequestBody ProfilePictureDTO profilePictureDTO) throws Exception {
		LOG.info("new profile pic upload: " + profilePictureDTO.toString());
		return ResponseEntity.ok(profilePictureService.saveOrUpdate(profilePictureDTO));
	}
	
	@RequestMapping(value = "/postPicture", method = RequestMethod.POST)
	public ResponseEntity<?> savePostPicture(@RequestBody PostPictureDTO postPictureDTO) throws Exception {
		LOG.info("new post pic upload: " + postPictureDTO.toString());
		return ResponseEntity.ok(postPictureService.saveOrUpdate(postPictureDTO));
	}
}
