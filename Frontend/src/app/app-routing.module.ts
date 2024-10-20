import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { JobListComponent } from './components/job-list/job-list.component';
import { JobPostComponent } from './components/job-post/job-post.component';
import { JobDetailComponent } from './components/job-detail/job-detail.component';
import { ApplicationComponent } from './components/application/application.component';

const routes: Routes = [
  { path: '', redirectTo: '/jobs', pathMatch: 'full' },
  { path: 'jobs', component: JobListComponent },
  { path: 'post-job', component: JobPostComponent },
  { path: 'job-details/:id', component: JobDetailComponent },
  // Add more routes as needed
  { path: 'jobs/:id', component: JobDetailComponent }, // For viewing job details
  { path: 'post-job', component: JobPostComponent },   // For posting new jobs
  { path: 'create-job', component: JobPostComponent },
  { path: 'apply-job', component: ApplicationComponent },
  { path: '**', redirectTo: 'jobs' },
  { path: '', redirectTo: '/create-job', pathMatch: 'full' } // Default route
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }






