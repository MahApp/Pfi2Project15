package se.mah.k3.pfi2.project.social;

public class PostData {
	private String imgUrl;
	private String userName;
	private String imgText;
	private String imgUserUrl;
	private String timePosted;

	public PostData(String userName, String imgUserUrl, String imgUrl, String imgText, String timePosted) {
		
		this.userName = userName;
		this.imgUserUrl = imgUserUrl;
		this.imgUrl = imgUrl;
		this.imgText = imgText;
		this.timePosted = timePosted;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public String getUserName() {
		return userName;
	}

	public String getImgText() {
		return imgText;
	}

	public String getImgUserUrl() {
		return imgUserUrl;
	}

	public String getTimePosted() {
		return timePosted;
	}
}
