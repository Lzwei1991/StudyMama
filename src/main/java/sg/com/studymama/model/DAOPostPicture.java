package sg.com.studymama.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "post_pic")
public class DAOPostPicture extends Auditable<String> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column
	private String username;
	@Column
	private long user_profile_id;
	@Column
	private long post_id;
	@Column
	@Lob
	private byte[] postPic;
	
	public long getId() {
		return id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public long getUser_profile_id() {
		return user_profile_id;
	}
	public void setUser_profile_id(long user_profile_id) {
		this.user_profile_id = user_profile_id;
	}
	public long getPost_id() {
		return post_id;
	}
	public void setPost_id(long post_id) {
		this.post_id = post_id;
	}
	public byte[] getPostPic() {
		return postPic;
	}
	public void setPostPic(byte[] postPic) {
		this.postPic = postPic;
	}
	
}
