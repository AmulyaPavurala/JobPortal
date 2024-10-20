import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Jobpost } from '../jobpost';

@Injectable({
  providedIn: 'root'
})
export class jobService {

  constructor(private http: HttpClient) { }
  private baseUrl = 'http://localhost:8080/api/jobs'; // Replace with your backend URL

  createJobPost(jobPost: Jobpost): Observable<Jobpost> {
    const headers = new HttpHeaders({ 'Content-Type': 'application/json' });
    return this.http.post<Jobpost>(this.baseUrl, jobPost, { headers });
  }

  getJobPosts(): Observable<Jobpost[]> {
    return this.http.get<Jobpost[]>(this.baseUrl);
  }

  getJobById(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${id}`);
  }
  
  // Update a job
  updateJob(id: number, job: any): Observable<any> {
    return this.http.put(`${this.baseUrl}/${id}`, job);
  }

  // Delete a job
  deleteJob(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`);
  }
}
  


 