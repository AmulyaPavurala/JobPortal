export interface Jobpost {
    id: number;
    jobTitle?: string;
    jobDescription?: string;
    location?: string;
    salaryRange?: string;
    company:Companies;

}
export interface JobPost {
   id:number;
    jobTitle: string;
    jobDescription: string;
    skillsRequired?: string;
    location?: string;
    jobType?: string;
    salaryRange?: string;
    // "company": {
    //         "id": 1
    //     };
        company:Companies;
  }
 export interface Companies{
    id:number;
    companyName:string;
 }
  