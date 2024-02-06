
-- Table for JobListing

-- Table for Company
CREATE TABLE IF NOT EXISTS Company (
    CompanyID INT PRIMARY KEY,
    CompanyName VARCHAR(255),
    Location VARCHAR(255)
);

-- Table for Applicant
CREATE TABLE IF NOT EXISTS Applicant (
    ApplicantID INT PRIMARY KEY,
    FirstName VARCHAR(255),
    LastName VARCHAR(255),
    Email VARCHAR(255),
    Phone VARCHAR(20),
    Resume VARCHAR(1000)
);
CREATE TABLE IF NOT EXISTS JobListing (
    JobID INT PRIMARY KEY,
    CompanyID INT,
    JobTitle VARCHAR(255),
    JobDescription VARCHAR(1000),
    JobLocation VARCHAR(255),
    Salary DECIMAL(10, 2),
    JobType VARCHAR(50),
    PostedDate DATETIME,
    FOREIGN KEY (CompanyID) REFERENCES Company(CompanyID)
);

-- Table for JobApplication
CREATE TABLE IF NOT EXISTS JobApplication (
    ApplicationID INT PRIMARY KEY,
    JobID INT,
    ApplicantID INT,
    ApplicationDate DATETIME,
    CoverLetter VARCHAR(1000),
    FOREIGN KEY (JobID) REFERENCES JobListing(JobID),
    FOREIGN KEY (ApplicantID) REFERENCES Applicant(ApplicantID)
);
