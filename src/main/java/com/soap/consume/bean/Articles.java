package com.soap.consume.bean;

public class Articles {

	private String title;
	private String category;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "Articles [title=" + title + ", category=" + category + "]";
	}
	
	
}
