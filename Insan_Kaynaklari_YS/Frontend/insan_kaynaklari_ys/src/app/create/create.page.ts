import { Component, OnInit } from '@angular/core';
import { CandidateIU, MilitaryStatusIU } from '../models/candidateiu.model';
import { CandidateService } from '../services/candidate.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create',
  templateUrl: './create.page.html',
  styleUrls: ['./create.page.scss'],
})
export class CreatePage implements OnInit {

  constructor(private candidateService: CandidateService, private router: Router) { }

  ngOnInit() {
  }

  formData : CandidateIU = {
    firstName: '',
    lastName: '',
    position: '',
    militaryStatus: MilitaryStatusIU.TECILLI,
    noticePeriod: '', 
    phone: '',
    email: '',
    cv: '',
  }

  create(){
    this.candidateService.createCandidate(this.formData).subscribe({
      next:(data) => {
        this.router.navigate(['/candidates/home']).then(() => { window.location.reload(); });
      },
      error:(err) => {
        console.log(err)
      }
    })
  }
}
