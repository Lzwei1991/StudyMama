package sg.com.studymama.DTO;

public class CommentDTO {
	
	private Integer postId;
	private Integer accountId;
    private Integer commentId;
    private String description;
    
	public CommentDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CommentDTO(Integer postId, Integer accountId, Integer commentId, String description) {
		super();
		this.postId = postId;
		this.accountId = accountId;
		this.commentId = commentId;
		this.description = description;
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

	public Integer getCommentId() {
		return commentId;
	}

	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
