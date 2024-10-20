package com.jp.b.Entity;


import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "applications")
public class Application {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
    	private Long id;
       // Foreign key to user
        @ManyToOne
        @JoinColumn(name = "job_post_id", nullable = false)
        private JobPost jobPost;
        @ManyToOne
        @JoinColumn(name = "user_id", nullable = false)
        private User user;  // Assume you have a User entity for the applicant
        private String resumeUrl;
        private String coverLetter;
        private Timestamp createdAt;
        
        public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public JobPost getJobPost() {
			return jobPost;
		}
		public void setJobPost(JobPost jobPost) {
			this.jobPost = jobPost;
		}
		public User getUser() {
			return user;
		}
		public void setUser(User user) {
			this.user = user;
		}
		public String getResumeUrl() {
			return resumeUrl;
		}
		public void setResumeUrl(String resumeUrl) {
			this.resumeUrl = resumeUrl;
		}
		public String getCoverLetter() {
			return coverLetter;
		}
		public void setCoverLetter(String coverLetter) {
			this.coverLetter = coverLetter;
		}
		public Timestamp getCreatedAt() {
			return createdAt;
		}
		public void setCreatedAt(Timestamp createdAt) {
			this.createdAt = createdAt;
		}
		 
       

        // Getters and setters
    }



