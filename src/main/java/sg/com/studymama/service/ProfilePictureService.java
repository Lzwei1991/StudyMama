package sg.com.studymama.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import sg.com.studymama.model.DAOProfilePicture;
import sg.com.studymama.model.DAOUserProfile;
import sg.com.studymama.model.ProfilePictureDTO;
import sg.com.studymama.repository.ProfilePictureRepository;
import sg.com.studymama.repository.UserProfileRepository;

@Service
public class ProfilePictureService {

	private static final Logger LOG = LoggerFactory.getLogger(ProfilePictureService.class);
	
	@Autowired
	ProfilePictureRepository profilePictureRepository;
	
	@Autowired
	private UserProfileRepository userProfileDao;

	public DAOProfilePicture getProfilePicById(long id) {
		return profilePictureRepository.findById(id).get();
	}

	public DAOProfilePicture saveOrUpdate(ProfilePictureDTO profilePictureDTO) {
		Optional<DAOUserProfile> tempProfile = userProfileDao.findById(profilePictureDTO.getUser_profile_id());
		DAOUserProfile updateProfile = tempProfile.orElse(null);
		if(updateProfile!=null) { //to check if profile exists first
			DAOProfilePicture daoProfilePic = new DAOProfilePicture();
			daoProfilePic.setProfilePic(profilePictureDTO.getProfilePic());
			daoProfilePic.setUser_profile_id(profilePictureDTO.getUser_profile_id());
			daoProfilePic.setUsername(profilePictureDTO.getUsername());
			LOG.info("saveOrUpdate " + profilePictureDTO.toString());
			return profilePictureRepository.save(daoProfilePic);
		}
		throw new UsernameNotFoundException("User Profile not found with username: " + profilePictureDTO.getUsername());
	}
}
