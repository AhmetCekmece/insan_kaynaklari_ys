import { Component, OnInit } from '@angular/core';
import { CandidateService } from '../services/candidate.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Candidate, MilitaryStatus } from '../models/candidate.model';
import { NavController } from '@ionic/angular';

@Component({
  selector: 'app-update',
  templateUrl: './update.page.html',
  styleUrls: ['./update.page.scss'],
})
export class UpdatePage implements OnInit {

  constructor(
    private candidateService: CandidateService,
    private router: Router,
    private route: ActivatedRoute,
    private navController: NavController
  ) { }

  formData : Candidate = {
    id: 0,
    firstName: '',
    lastName: '',
    position: '',
    militaryStatus: MilitaryStatus.TECILLI,
    noticePeriod: '', 
    phone: '',
    email: '',
    cv: '',
  }

  ngOnInit(): void {
    this.route.paramMap.subscribe((param) => {
      let id = Number(param.get('id'))
      this.getById(id)
    })
  }

  getById(id: number){
    this.candidateService.getCandidateById(id).subscribe((data) => {
      this.formData = data;
    })
  }

  update(){
    this.candidateService.updateCandidate(this.formData).subscribe({
      next:(data) => {
        this.router.navigate(['/candidates/home']).then(() => { window.location.reload(); });                 
      },
      error:(err) => {
        console.log(err)
      }
    })
  }

}
