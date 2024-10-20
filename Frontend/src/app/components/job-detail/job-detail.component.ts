import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { jobService } from '../../services/job.service';
import { JobPostService } from '../../services/job-post.service';
import { JobPost } from '../../jobpost';

@Component({
  selector: 'app-job-detail',
  templateUrl: './job-detail.component.html',
  styleUrl: './job-detail.component.css'
})
export class JobDetailComponent  implements OnInit {

  job: JobPost | undefined;

  constructor(private route: ActivatedRoute, private jobService: jobService) { }

  ngOnInit(): void {
    const id = this.route.snapshot.params['id'];
    if (id) {
      this.jobService.getJobById(id).subscribe({
        next: (data) => this.job = data,
        error: (error) => console.error('Error fetching job details:', error),
      });
    }
}
}
