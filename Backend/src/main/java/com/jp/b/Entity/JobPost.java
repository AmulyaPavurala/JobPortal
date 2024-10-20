package com.jp.b.Entity;



import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "job_posts")
public class JobPost {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)

	 private Long id;
	   // Foreign key to companies
	    private String jobTitle;
	    private String jobDescription;
	    private String skillsRequired;
	    private String location;
	    private String jobType;
	    private String salaryRange;
	    private Timestamp createdAt;
	    @ManyToOne
	    @JoinColumn(name = "company_id", nullable = false)
	   private companies company;
	    
	   
		public companies getCompany() {
			return company;
		}
		public void setCompany(companies company) {
			this.company = company;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
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
		public String getSkillsRequired() {
			return skillsRequired;
		}
		public void setSkillsRequired(String skillsRequired) {
			this.skillsRequired = skillsRequired;
		}
		public String getLocation() {
			return location;
		}
		public void setLocation(String location) {
			this.location = location;
		}
		public String getJobType() {
			return jobType;
		}
		public void setJobType(String jobType) {
			this.jobType = jobType;
		}
		public String getSalaryRange() {
			return salaryRange;
		}
		public void setSalaryRange(String salaryRange) {
			this.salaryRange = salaryRange;
		}
		public Timestamp getCreatedAt() {
			return createdAt;
		}
		public void setCreatedAt(Timestamp createdAt) {
			this.createdAt = createdAt;
		}
}

