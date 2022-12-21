package T4_33.bean;

public class PostCommentBean {
	private int postCommentId;
	private int postId;
	private int userId;
	private String postComment;
	private int postCommentReport;
	private int postCommentHide;
	
	public int getPostCommentId() {
		return postCommentId;
	}
	
	public void setPostCommentId(int postCommentId) {
		this.postCommentId = postCommentId;
	}
	
	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getPostComment() {
		return postComment;
	}

	public void setPostComment(String postComment) {
		this.postComment = postComment;
	}

	public int getPostCommentReport() {
		return postCommentReport;
	}

	public void setPostCommentReport(int postCommentReport) {
		this.postCommentReport = postCommentReport;
	}

	public int getPostCommentHide() {
		return postCommentHide;
	}

	public void setPostCommentHide(int postCommentHide) {
		this.postCommentHide = postCommentHide;
	}
}
