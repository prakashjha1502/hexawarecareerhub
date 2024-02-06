package com.hexaware.controller;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.hexaware.dao.*;
import com.hexaware.exception.DatabaseConnectionException;
import com.hexaware.exception.DeadlineExceedException;
import com.hexaware.exception.FileUploadException;
import com.hexaware.exception.InvalidEmailFormatException;
import com.hexaware.exception.SalaryCalculationException;
import com.hexaware.model.Applicant;
import com.hexaware.model.Company;
import com.hexaware.model.JobListing;
import com.hexaware.util.DBConnUtil;

public class JobListingController {
//    private Connection connection;
    private DatabaseManager dbConnection;
    private JobListingService jobService;
	public JobListingController() {
		super();
		this.dbConnection = new  DatabaseManager();
		this.jobService = new JobListingService();
	}
	
	 public void start()
	 {
		 
		 
	 }
	  
	  public void applyForJob(int jobID, int applicantID, String coverLetter) {
		  jobService.applyForJob(jobID, applicantID, coverLetter);
	    }

	    // Method to retrieve applicants for a specific job
	    public List<Applicant> getApplicantsForJob(int jobID) {
	        return jobService.getApplicantsForJob(jobID);
	    }

	    // Method to allow a company to post a new job listing
	    public void postJob(int companyID, String jobTitle, String jobDescription, String jobLocation, double salary, String jobType) {
	        Company company = jobService.getCompanyByID(companyID);
	        jobService.postJob(company, jobTitle, jobDescription, jobLocation, salary, jobType);
	    }

	    // Method to retrieve all job listings
	    public List<Applicant> getAllJobListings() {
	        return jobService.getAllJobListings();
	    }

	    // Method to allow an applicant to create a profile
	    public void createApplicantProfile(String email, String firstName, String lastName, String phone, String resume) {
	        jobService.createProfile(email, firstName, lastName, phone, resume);
	    }

	    // Method to handle exceptions related to email format validation
	    public void handleInvalidEmailFormatException(InvalidEmailFormatException e) {
	        System.out.println("Invalid email format: " + e.getMessage());
	    }

	    // Method to handle exceptions related to salary calculation
	    public void handleSalaryCalculationException(SalaryCalculationException e) {
	        System.out.println("Error calculating average salary: " + e.getMessage());
	    }

	    // Method to handle exceptions related to file upload
	    public void handleFileUploadException(FileUploadException e) {
	        System.out.println("File upload error: " + e.getMessage());
	    }

	    // Method to handle exceptions related to application deadline
	    public void handleDeadlineExceededException(DeadlineExceedException e) {
	        System.out.println("Application deadline exceeded: " + e.getMessage());
	    }

	    // Method to handle exceptions related to database connection
	    public void handleDatabaseConnectionException(DatabaseConnectionException e) {
	        System.out.println("Database connection error: " + e.getMessage());
	    }
	 
 
//	public void getSelfDetails(int applicantID) {
//		try {	
//			String sql = "SELECT * FROM Applicant WHERE applicantID = ?";
//            try (PreparedStatement statement = connection.prepareStatement(sql)) {
//                statement.setInt(1, applicantID);
//                try (ResultSet resultSet = statement.executeQuery()) {
//                    if (resultSet.next()) {
//                        System.out.println(resultSet.toString());
//                    }
//                    else {
//                    	System.out.println("Hii");
//                    }
//                    }
//                }
//            }
//         catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//		
//	}
	
    
    
	
    
    
	

}