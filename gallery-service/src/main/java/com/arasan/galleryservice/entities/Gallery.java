package com.arasan.galleryservice.entities;

import java.util.List;

public class Gallery {

	private int id;
	private List<Object> images;
	
	public Gallery(int id, List<Object> images) {
		super();
		this.id = id;
		this.images = images;
	}

	public Gallery() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Object> getImages() {
		return images;
	}

	public void setImages(List<Object> images) {
		this.images = images;
	}
	
	
	
}
