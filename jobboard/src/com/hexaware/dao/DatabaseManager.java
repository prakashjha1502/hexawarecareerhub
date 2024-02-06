package com.hexaware.dao;

import java.sql.*;

import java.util.ArrayList;

import java.util.List;

import com.hexaware.model.Applicant;
import com.hexaware.model.Company;
import com.hexaware.model.JobApplication;
import com.hexaware.model.JobListing;
 
public class DatabaseManager {

    private static final String URL = "jdbc:mysql://localhost:3306/jobboard";

    private static final String USER = "root";

    private static final String PASSWORD = "Root";
 
    private Connection connection;
 
    public DatabaseManager() {

        try {

            connection = DriverManager.getConnection(URL, USER, PASSWORD);

        } catch (SQLException e) {

            e.printStackTrace();

        }

    }
 
    public void initializeDatabase() {

        try (Statement stmt = connection.createStatement()) {


            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS Companies (" +

                    "CompanyID INT AUTO_INCREMENT PRIMARY KEY," +

                    "CompanyName VARCHAR(255) NOT NULL," +

                    "Location VARCHAR(255) NOT NULL" +

                    ")");

            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS Jobs (" +

                    "JobID INT AUTO_INCREMENT PRIMARY KEY," +

                    "CompanyID INT," +

                    "JobTitle VARCHAR(255) NOT NULL," +

                    "JobDescription TEXT," +

                    "JobLocation VARCHAR(255)," +

                    "Salary DECIMAL(10, 2)," +

                    "JobType VARCHAR(50)," +

                    "PostedDate DATETIME," +

                    "FOREIGN KEY (CompanyID) REFERENCES Companies(CompanyID)" +

                    ")");

            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS Applicants (" +

                    "ApplicantID INT AUTO_INCREMENT PRIMARY KEY," +

                    "FirstName VARCHAR(50) NOT NULL," +

                    "LastName VARCHAR(50) NOT NULL," +

                    "Email VARCHAR(255) UNIQUE NOT NULL," +

                    "Phone VARCHAR(20) NOT NULL," +

                    "Resume TEXT" +

                    ")");

            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS Applications (" +

                    "ApplicationID INT AUTO_INCREMENT PRIMARY KEY," +

                    "JobID INT," +

                    "ApplicantID INT," +

                    "ApplicationDate DATETIME," +

                    "CoverLetter TEXT," +

                    "FOREIGN KEY (JobID) REFERENCES Jobs(JobID)," +

                    "FOREIGN KEY (ApplicantID) REFERENCES Applicants(ApplicantID)" +

                    ")");

        } catch (SQLException e) {

            e.printStackTrace();

        }

    }
 
    public void insertJobListing(JobListing jobListing) {

        String sql = "INSERT INTO Jobs (CompanyID, JobTitle, JobDescription, JobLocation, Salary, JobType, PostedDate) " +

                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setInt(1, jobListing.getCompanyID());

            pstmt.setString(2, jobListing.getJobTitle());

            pstmt.setString(3, jobListing.getJobDescription());

            pstmt.setString(4, jobListing.getJobLocation());

            pstmt.setDouble(5, jobListing.getSalary());

            pstmt.setString(6, jobListing.getJobType());

            pstmt.setTimestamp(7, new Timestamp(jobListing.getPostedDate().getTime()));

            pstmt.executeUpdate();

        } catch (SQLException e) {

            e.printStackTrace();

        }

    }
 
    public void insertCompany(Company company) {

        String sql = "INSERT INTO Companies (CompanyName, Location) VALUES (?, ?)";

        try (PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, company.getCompanyName());

            pstmt.setString(2, company.getLocation());

            pstmt.executeUpdate();

            ResultSet rs = pstmt.getGeneratedKeys();

            if (rs.next()) {

                company.setCompanyID(rs.getInt(1));

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

    }
 
    public void insertApplicant(Applicant applicant) {

        String sql = "INSERT INTO Applicants (FirstName, LastName, Email, Phone, Resume) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, applicant.getFirstName());

            pstmt.setString(2, applicant.getLastName());

            pstmt.setString(3, applicant.getEmail());

            pstmt.setString(4, applicant.getPhone());

            pstmt.setString(5, applicant.getResume());

            pstmt.executeUpdate();

            ResultSet rs = pstmt.getGeneratedKeys();

            if (rs.next()) {

                applicant.setApplicantID(rs.getInt(1));

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

    }
 
    public void insertJobApplication(JobApplication jobApplication) {

        String sql = "INSERT INTO Applications (JobID, ApplicantID, ApplicationDate, CoverLetter) VALUES (?, ?, ?, ?)";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setInt(1, jobApplication.getJobID());

            pstmt.setInt(2, jobApplication.getApplicantID());

            pstmt.setTimestamp(3, new Timestamp(jobApplication.getApplicationDate().getTime()));

            pstmt.setString(4, jobApplication.getCoverLetter());

            pstmt.executeUpdate();

        } catch (SQLException e) {

            e.printStackTrace();

        }

    }
 
    public List<JobListing> getJobListings() {

        List<JobListing> jobListings = new ArrayList<>();

        String sql = "SELECT * FROM Jobs";

        try (Statement stmt = connection.createStatement()) {

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {

                JobListing jobListing = new JobListing();

                jobListing.setJobID(rs.getInt("JobID"));

                jobListing.setCompanyID(rs.getInt("CompanyID"));

                jobListing.setJobTitle(rs.getString("JobTitle"));

                jobListing.setJobDescription(rs.getString("JobDescription"));

                jobListing.setJobLocation(rs.getString("JobLocation"));

                jobListing.setSalary(rs.getDouble("Salary"));

                jobListing.setJobType(rs.getString("JobType"));

                jobListing.setPostedDate(rs.getTimestamp("PostedDate"));

                jobListings.add(jobListing);

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return jobListings;

    }
 
    public List<Company> getCompanies() {

        List<Company> companies = new ArrayList<>();

        String sql = "SELECT * FROM Companies";

        try (Statement stmt = connection.createStatement()) {

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {

                Company company = new Company();

                company.setCompanyID(rs.getInt("CompanyID"));

                company.setCompanyName(rs.getString("CompanyName"));

                company.setLocation(rs.getString("Location"));

                companies.add(company);

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return companies;

    }
 
    public List<Applicant> getApplicants() {

        List<Applicant> applicants = new ArrayList<>();

        String sql = "SELECT * FROM Applicants";

        try (Statement stmt = connection.createStatement()) {

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {

                Applicant applicant = new Applicant();

                applicant.setApplicantID(rs.getInt("ApplicantID"));

                applicant.setFirstName(rs.getString("FirstName"));

                applicant.setLastName(rs.getString("LastName"));

                applicant.setEmail(rs.getString("Email"));

                applicant.setPhone(rs.getString("Phone"));

                applicant.setResume(rs.getString("Resume"));

                applicants.add(applicant);

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return applicants;

    }
 
    public List<JobApplication> getApplicationsForJob(int jobID) {

        List<JobApplication> jobApplications = new ArrayList<>();

        String sql = "SELECT * FROM Applications WHERE JobID = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setInt(1, jobID);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {

                JobApplication jobApplication = new JobApplication();

                jobApplication.setApplicationID(rs.getInt("ApplicationID"));

                jobApplication.setJobID(rs.getInt("JobID"));

                jobApplication.setApplicantID(rs.getInt("ApplicantID"));

                jobApplication.setApplicationDate(rs.getTimestamp("ApplicationDate"));

                jobApplication.setCoverLetter(rs.getString("CoverLetter"));

                jobApplications.add(jobApplication);

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return jobApplications;

    }

}
