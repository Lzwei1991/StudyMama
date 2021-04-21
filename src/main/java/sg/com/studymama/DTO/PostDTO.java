package sg.com.studymama.DTO;

import java.io.Serializable;
import java.math.BigDecimal;

public class PostDTO implements Serializable {
	
	private static final long serialVersionUID = 5017807602995665018L;
	
	private Integer postId;
	private Integer accountId;
	private String title;
	private String description;
	private String category;
	private String price;
	private String website;
	private String status;
	private Double gpsX;
	private Double gpsY;
	private String contact;
	private String images;
	
	public PostDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PostDTO(Integer postId, Integer accountId, String title, String description, String category, String price,
			String website, String status, Double gpsX, Double gpsY, String contact, String images) {
		super();
		this.postId = postId;
		this.accountId = accountId;
		this.title = title;
		this.description = description;
		this.category = category;
		this.price = price;
		this.website = website;
		this.status = status;
		this.gpsX = gpsX;
		this.gpsY = gpsY;
		this.contact = contact;
		this.images = images;
	}

	public Integer getPostId() {
		return postId;
	}

	public void setPostId(Integer postId) {
		this.postId = postId;
	}

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Double getGpsX() {
		return gpsX;
	}

	public void setGpsX(Double gpsX) {
		this.gpsX = gpsX;
	}

	public Double getGpsY() {
		return gpsY;
	}

	public void setGpsY(Double gpsY) {
		this.gpsY = gpsY;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

}
