package sg.com.studymama.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sg.com.studymama.model.DAOUserProfile;

@Repository
public interface UserProfileRepository extends JpaRepository<DAOUserProfile, Long>  {
}
