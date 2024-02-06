package com.hexaware.model;

public class Applicant {
	private int applicantID;
	private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String resume;
	
    
    
    
    public Applicant() {
	}
    
	public Applicant(int applicantID, String firstName, String lastName, String email, String phone, String resume) {
		super();
		this.applicantID = applicantID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.resume = resume;
	}
	public int getApplicantID() {
		return applicantID;
	}
	public void setApplicantID(int applicantID) {
		this.applicantID = applicantID;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getResume() {
		return resume;
	}
	public void setResume(String resume) {
		this.resume = resume;
	}
	
	

}
