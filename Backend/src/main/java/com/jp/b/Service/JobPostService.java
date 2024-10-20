package com.jp.b.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties.Job;
import org.springframework.stereotype.Service;

import com.jp.b.Entity.JobPost;
import com.jp.b.Repository.JobPostRepository;

@Service
	public class JobPostService {

	    @Autowired
	    private JobPostRepository jobPostRepository;

	    public JobPost saveJobPost(JobPost jobPost) {
	        return jobPostRepository.save(jobPost);
	    }

	    public List<JobPost> getAllJobPosts() {
	        return jobPostRepository.findAll();
	    }

	    public Optional<JobPost> getJobPostById(Long id) {
	        return jobPostRepository.findById(id);
	    }

	    public void deleteJobPost(Long id) {
	        jobPostRepository.deleteById(id);
	    }
	   

	    // Method to save the job post
	    public JobPost createJobPost(JobPost jobPost) {
	        // Call the save() method on the repository instance
	        return jobPostRepository.save(jobPost);
	    }
	}
