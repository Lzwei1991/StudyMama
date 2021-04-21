package sg.com.studymama.repository;

import org.springframework.data.repository.CrudRepository;

import sg.com.studymama.model.DAOPostPicture;

public interface PostPictureRepository extends CrudRepository<DAOPostPicture, Long>  {

}