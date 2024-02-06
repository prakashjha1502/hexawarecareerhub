package com.hexaware.dao;

import java.util.List;
import com.hexaware.model.Applicant;
import com.hexaware.model.Company;

public class JobListingService {

	public void applyForJob(int jobID, int applicantID, String coverLetter) {
		// TODO Auto-generated method stub
		
	}
	
	public List<Applicant> getApplicantsForJob(int jobID){
		return  null;	
	}
	
	public List<Applicant> getAllJobListings(){
		return null;
	}
	
	public Company getCompanyByID(int jobID){
		return  null;	
	}
	
	public void postJob(Company company, String jobTitle, String jobDescription, String jobLocation, double salary, String jobType) {
		
	}
	
	public void createProfile(String email, String firstName,String lastName,String phone,String resume){
		
	}
	
	
}
