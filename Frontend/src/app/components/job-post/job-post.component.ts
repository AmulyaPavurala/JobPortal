import { Component, OnInit } from '@angular/core';
import { JobPostService } from '../../services/job-post.service';
import { JobPost, Jobpost } from '../../jobpost';
import { FormBuilder, FormGroup, NumberValueAccessor, Validators } from '@angular/forms';
import { jobService } from '../../services/job.service';
import { HttpClient } from '@angular/common/http';
import { catchError } from 'rxjs/operators';
import { throwError } from 'rxjs';


@Component({
  selector: 'app-job-post',
  templateUrl: './job-post.component.html',
  styleUrls: ['./job-post.component.css']
})
export class JobPostComponent {
  newJobPost: JobPost = {
    id: 0,
    jobTitle: '',
    jobDescription: '',
    skillsRequired: '',
    location: '',
    jobType: '',
    salaryRange: '',
    company: {
      id: 1, // Make sure this ID corresponds to a valid company
      companyName: '' // Include other required fields here
    }
    
  };
  
  constructor( private http: HttpClient,private jobService: jobService) {}
 
  createJobPost() {
    this.http.post<JobPost>('http://localhost:8080/api/jobs', this.newJobPost)
      .subscribe(
        (response) => {
          console.log('Job post created successfully:', response);
          alert('Job successfully created!');
        },
       
      );
      
  }
  
}




  
   

