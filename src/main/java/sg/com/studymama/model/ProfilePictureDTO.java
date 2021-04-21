package sg.com.studymama.model;

public class ProfilePictureDTO {

	private String username;
	private long user_profile_id;
	private byte[] profilePic;

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

	public byte[] getProfilePic() {
		return profilePic;
	}

	public void setProfilePic(byte[] profilePic) {
		this.profilePic = profilePic;
	}

	@Override
	public String toString() {
		return "ProfilePictureDTO [username=" + username + ", user_profile_id=" + user_profile_id + ", profilePic="
				+ profilePic + "]";
	}
}
