package sg.com.studymama.repository;

import org.springframework.data.repository.CrudRepository;

import sg.com.studymama.model.DAOProfilePicture;

public interface ProfilePictureRepository extends CrudRepository<DAOProfilePicture, Long>  {

}