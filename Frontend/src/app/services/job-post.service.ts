import { Injectable } from '@angular/core';
import { Jobpost } from '../jobpost';
import { JobPostComponent } from '../components/job-post/job-post.component';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class JobPostService {

    private apiUrl = 'http://localhost:8080/api/jobs'; // Your Spring Boot API URL
  
    constructor(private http: HttpClient) {}
  
    getAllJobPosts(): Observable<Jobpost[]> {
      return this.http.get<Jobpost[]>(this.apiUrl); // This should return an observable
    }
  
    // Ensure this method returns an Observable<JobPost>
    createJobPost(createJobPost: Jobpost): Observable<Jobpost> {
      return this.http.post<Jobpost>(this.apiUrl, createJobPost);
    }
}
