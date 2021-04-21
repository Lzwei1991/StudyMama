package sg.com.studymama.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import sg.com.studymama.model.DAOUser;
import sg.com.studymama.model.UserProfileDTO;
import sg.com.studymama.service.CustomUserDetailsService;
import sg.com.studymama.service.UserProfileService;

@RestController
public class UserProfileController {
	
	private static final Logger LOG = LoggerFactory.getLogger(UserProfileController.class);
	
	@Autowired
	private CustomUserDetailsService userDetailsService;
	
	@Autowired
	private UserProfileService userProfileService;
	
	@RequestMapping(value = "/updateProfile", method = RequestMethod.POST)
	public ResponseEntity<?> updateProfile(@RequestBody UserProfileDTO userProfile) throws Exception {
		LOG.info("Update profile: " + userProfile.toString());
		DAOUser user = userDetailsService.find(userProfile.getUsername());
		return ResponseEntity.ok(userProfileService.update(userProfile, user.getUser_profile_id()));
	}

}
