package com.hexaware.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JobListing {

	private int companyID;
    private String jobTitle;
    private String jobDescription;
    private String jobLocation;
    private double salary;
    private String jobType;
    private Date postedDate;
    private List<Integer> applicants;
    
	
    public JobListing() {
    }
    public JobListing(int companyID, String jobTitle, String jobDescription, String jobLocation, double salary,
			String jobType, Date postedDate, List<Integer> applicants, int jobID) {
		super();
		this.companyID = companyID;
		this.jobTitle = jobTitle;
		this.jobDescription = jobDescription;
		this.jobLocation = jobLocation;
		this.salary = salary;
		this.jobType = jobType;
		this.postedDate = postedDate;
		this.applicants = applicants;
		this.jobID = jobID;
	}
	
		private int jobID;
	    public int getJobID() {
			return jobID;
		}
		public void setJobID(int jobID) {
			this.jobID = jobID;
		}
		public int getCompanyID() {
			return companyID;
		}
		public void setCompanyID(int companyID) {
			this.companyID = companyID;
		}
		public String getJobTitle() {
			return jobTitle;
		}
		public void setJobTitle(String jobTitle) {
			this.jobTitle = jobTitle;
		}
		public String getJobDescription() {
			return jobDescription;
		}
		public void setJobDescription(String jobDescription) {
			this.jobDescription = jobDescription;
		}
		public String getJobLocation() {
			return jobLocation;
		}
		public void setJobLocation(String jobLocation) {
			this.jobLocation = jobLocation;
		}
		public double getSalary() {
			return salary;
		}
		public void setSalary(double salary) {
			this.salary = salary;
		}
		public String getJobType() {
			return jobType;
		}
		public void setJobType(String jobType) {
			this.jobType = jobType;
		}
		public Date getPostedDate() {
			return postedDate;
		}
		public void setPostedDate(Date postedDate) {
			this.postedDate = postedDate;
		}
		public List<Integer> getApplicants() {
			return applicants;
		}
		public void setApplicants(List<Integer> applicants) {
			this.applicants = applicants;
		}
		
		
		  public void apply(int applicantID, String coverLetter) {
		        Applicant applicant = new Applicant(); // Instantiate Applicant based on applicantID
		        if (applicants == null) {
		            applicants = new ArrayList<>();
		            applicants.addAll(1, applicants);
		        }
		       
		    }

}