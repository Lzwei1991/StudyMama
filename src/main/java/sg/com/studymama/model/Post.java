package sg.com.studymama.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.GeoPointField;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;

import javax.validation.constraints.NotBlank;
@Document(indexName = "post")
public class Post{

    @Id
    private String id;

    private String title;

    private String description;

    private String website;

    private GeoPoint location;

    private String status;

    private String post_dt;

    private String edited_dt;

    private String price;

    private String category;

    private Picture picture;

    private String accountId;

    public Post(String id, @NotBlank(message = "Title is mandatory") String title, @NotBlank(message = "Description is mandatory") String description, String website, GeoPoint location, String status, String post_dt, String edited_dt, String price, String category, Picture picture, String accountId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.website = website;
        this.location = location;
        this.status = status;
        this.post_dt = post_dt;
        this.edited_dt = edited_dt;
        this.price = price;
        this.category = category;
        this.picture = picture;
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

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public GeoPoint getLocation() {
        return location;
    }

    public void setLocation(GeoPoint location) {
        this.location = location;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPost_dt() {
        return post_dt;
    }

    public void setPost_dt(String post_dt) {
        this.post_dt = post_dt;
    }

    public String getEdited_dt() {
        return edited_dt;
    }

    public void setEdited_dt(String edited_dt) {
        this.edited_dt = edited_dt;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    @Override
    public String toString() {
        return "Post{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", website='" + website + '\'' +
                ", location=" + location +
                ", status='" + status + '\'' +
                ", post_dt='" + post_dt + '\'' +
                ", edited_dt='" + edited_dt + '\'' +
                ", price='" + price + '\'' +
                ", category='" + category + '\'' +
                ", picture=" + picture +
                ", accountId='" + accountId + '\'' +
                '}';
    }
}