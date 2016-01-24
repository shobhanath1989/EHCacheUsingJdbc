package com.newslive.actions.db.entity;

public class News {
	
	private long id;
	
	private String newsHeading;
	
	private String newsBody;

	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNewsHeading() {
		return newsHeading;
	}

	public void setNewsHeading(String newsHeading) {
		this.newsHeading = newsHeading;
	}

	public String getNewsBody() {
		return newsBody;
	}

	public void setNewsBody(String newsBody) {
		this.newsBody = newsBody;
	}

	@Override
	public String toString() {
		return "News [id=" + id + ", newsHeading=" + newsHeading
				+ ", newsBody=" + newsBody + "]";
	}
	
	
	

}
