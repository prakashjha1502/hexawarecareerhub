package com.hexaware.model;

import java.util.List;

public class Company {
	private int companyID;
    private String companyName;
    private String location;
    private List<JobListing> jobListings;

	    public int getCompanyID() {
		return companyID;
	}

	public void setCompanyID(int companyID) {
		this.companyID = companyID;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public List<JobListing> getJobListings() {
		return jobListings;
	}

	public void setJobListings(List<JobListing> jobListings) {
		this.jobListings = jobListings;
	}

		
	    // Constructors, getters, setters, and other methods

	    public void postJob(String jobTitle, String jobDescription, String jobLocation, double salary, String jobType) {
	        // Implement the logic to post a new job listing
	    }

	  
	}


