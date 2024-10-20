package com.jp.b.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.jp.b.Entity.JobPost;
import com.jp.b.Repository.JobPostRepository;
import com.jp.b.Service.JobPostService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/jobs")
@CrossOrigin(origins = "http://localhost:4200")  // For CORS support with Angular
public class JobController {
	    @Autowired
	    private JobPostService jobPostService;
	    @Autowired
	    private JobPostRepository jobPostRepository;
	    
//	    @PostMapping
//	    public ResponseEntity<JobPost> createJobPost(@RequestBody JobPost jobPost) {
//	        JobPost createdJobPost = jobPostService.saveJobPost(jobPost);
//	        return ResponseEntity.ok(createdJobPost);
//	    }

	    @PostMapping
	    public ResponseEntity<JobPost> createJobPost(@RequestBody JobPost jobPost) {
	        try {
	            // Check if the company is set properly
	            if (jobPost.getCompany() == null) {
	                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);  // Return error if company is not set
	            }

	            // Save jobPost using service
	            JobPost createdJobPost = jobPostService.saveJobPost(jobPost);
	            return ResponseEntity.ok(createdJobPost);
	        } catch (Exception e) {
	            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }
	    @GetMapping
	    public ResponseEntity<List<JobPost>> getAllJobPosts() {
	        return ResponseEntity.ok(jobPostService.getAllJobPosts());
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<JobPost> getJobPostById(@PathVariable Long id) {
	        return jobPostService.getJobPostById(id)
	                .map(ResponseEntity::ok)
	                .orElse(ResponseEntity.notFound().build());
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteJobPost(@PathVariable Long id) {
	        jobPostService.deleteJobPost(id);
	        return ResponseEntity.noContent().build();
	    }

	    
	 
	    // Additional endpoints (update job post) can be added here
	}

