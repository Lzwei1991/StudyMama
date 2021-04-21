package sg.com.studymama.model;

import java.util.Arrays;

public class PostPictureDTO {

	private String username;
	private long user_profile_id;
	private long post_id;
	private byte[] postPic;
	
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
	
	@Override
	public String toString() {
		return "PostPictureDTO [username=" + username + ", user_profile_id=" + user_profile_id + ", post_id=" + post_id
				+ ", postPic=" + Arrays.toString(postPic) + "]";
	}
	
}
