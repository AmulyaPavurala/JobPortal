import { Component, OnInit } from '@angular/core';
import { jobService } from '../../services/job.service';
import { Jobpost } from '../../jobpost';
import { JobPostService } from '../../services/job-post.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-job-list',
  templateUrl: './job-list.component.html',
  styleUrl: './job-list.component.css'
})

export class JobListComponent implements OnInit {
  jobPosts: Jobpost[] = [];

  constructor(private jobPostService: JobPostService,private router: Router) { }

  ngOnInit(): void {
    this.fetchJobPosts();
  }    
  viewJobDetails(jobId: number): void {
    // Navigate to the Job Details page
    this.router.navigate(['/job-details', jobId]);
  }
  
  fetchJobPosts(): void {
    this.jobPostService.getAllJobPosts().subscribe({
      next: (data) => this.jobPosts = data,
      error: (error) => console.error('Error fetching jobs:', error)
    });
  }
}


