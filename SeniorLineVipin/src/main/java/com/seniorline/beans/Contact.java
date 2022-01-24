package com.seniorline.beans;

public class Contact {

	// {"data":[{"title":"Mr","contactName":"Vikas
	// Sharma","contactNumber":9981454921},{"title":"Mr","contactName":"Sachin
	// Sjarma","contactNumber":8989777362},{"title":"Mrs","contactName":"Lav
	// Dubey","contactNumber":9867453221}],"message":"Getting List Of Contact
	// Successfully "}
	private String title;
	private String contactName;
	private Long contactNumber;
	private String image ; 
	
	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(Long contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}



}
