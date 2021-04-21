package sg.com.studymama.Entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//import org.hibernate.envers.Audited;

@Entity
//@Audited
@Table(name = "post")
public class PostEntity implements Serializable {
	
	private static final long serialVersionUID = -2379013249132428687L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "POST_ID", nullable = false, length = 6)
    private Integer postId; 
	
    @Column(name = "TITLE", length = 30, nullable = false)
    private String title;
    
    @Column(name = "DESCRIPTION", length = 255, nullable = false)
    private String description;
    
    @Column(name = "ACCOUNT_ID", length = 10)
    private Integer accountId;

    @Column(name = "CATEGORY", length = 5, nullable = false)
    private String category;
    
    @Column(name = "WEBSITE", length = 5, nullable = true)
    private String website;
    
    @Column(name = "PRICE", length = 5, nullable = true)
    private String price;
    
    @Column(name = "CONTACT", length = 15, nullable = true)
    private String contact;
    
    @Column(name = "IMAGE", length = 5, nullable = true)
    private String images;
    
    @Column(name = "GPS_X", length = 5, nullable = true)
    private Double gpsX;
    
    @Column(name = "GPS_Y", length = 5, nullable = true)
    private Double gpsY;
    
    @Column(name = "STATUS", length = 5, nullable = false)
    private String status;

    @Column(name = "CREATION_DATE", nullable = false)
    private Timestamp creationDate;
    
    @Column(name = "LAST_UPDATED_DATE")
    private Timestamp lastUpdatedDate;

	public Integer getPostId() {
		return postId;
	}

	public void setPostId(Integer postId) {
		this.postId = postId;
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

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Timestamp getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}

	public Timestamp getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(Timestamp lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

}
