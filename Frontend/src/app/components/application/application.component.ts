import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-application',
  templateUrl: './application.component.html',
  styleUrl: './application.component.css'
})
export class ApplicationComponent {
  applyForm: FormGroup;

  constructor(private fb: FormBuilder, private http: HttpClient) {
    this.applyForm = this.fb.group({
      id: ['', Validators.required],
      userId: ['', Validators.required], // Typically, this would be retrieved from an auth service
      coverLetter: ['', Validators.required],
      resumeUrl: ['', Validators.required], // Assume this is a text field or URL for the file
    });
  }

  applyToJob() {
    if (this.applyForm.valid) {
      this.http.post('http://localhost:8080/api/applications/apply', this.applyForm.value)
        .subscribe(
          (response) => {
            console.log('Application submitted successfully:', response);
            alert('Application successfully submitted!');
          },
          (error) => {
            console.error('Error submitting application:', error);
          }
        );
    }
  }

}




 