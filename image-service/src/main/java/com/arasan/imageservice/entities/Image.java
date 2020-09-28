package com.arasan.imageservice.entities;


public class Image {
	
	private int imageId;
	private String imageName;
	private String imageURL;
	
	public Image(int imageId, String imageName, String imageURL) {
		super();
		this.imageId = imageId;
		this.imageName = imageName;
		this.imageURL = imageURL;
	}

	public int getImageId() {
		return imageId;
	}

	public void setImageId(int imageId) {
		this.imageId = imageId;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
	
	

}
