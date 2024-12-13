import { Component, OnInit } from '@angular/core';
import { Candidate } from '../models/candidate.model';
import { CandidateService } from '../services/candidate.service';

@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})
export class HomePage implements OnInit {

  allCandidates: Candidate[] = []; 

  filteredCandidates = [...this.allCandidates];
  filter = {
    id: '',
    firstName: '',
    lastName: '',
    position: '',
    militaryStatus: '',
    noticePeriod: '',
    phone: '',
    email: '',
    cv: ''
  };

  constructor(private candidateService: CandidateService) {}

  ngOnInit(): void {
    this.candidateService.getAllCandidates().subscribe((data) => {
      this.allCandidates = data;
      this.filteredCandidates = this.allCandidates;
    });
  }

  filterCandidates(): void {
    this.filteredCandidates = this.allCandidates.filter(item => {
      return (
        (this.filter.id ? item.id.toString().includes(this.filter.id) : true) &&
        (this.filter.firstName ? item.firstName.toLowerCase().includes(this.filter.firstName.toLowerCase()) : true) &&
        (this.filter.lastName ? item.lastName.toLowerCase().includes(this.filter.lastName.toLowerCase()) : true) &&
        (this.filter.position ? item.position.toLowerCase().includes(this.filter.position.toLowerCase()) : true) &&
        (this.filter.militaryStatus ? item.militaryStatus.toLowerCase().includes(this.filter.militaryStatus.toLowerCase()) : true) &&
        (this.filter.noticePeriod ? item.noticePeriod.includes(this.filter.noticePeriod) : true) &&
        (this.filter.phone ? item.phone.includes(this.filter.phone) : true) &&
        (this.filter.email ? item.email.toLowerCase().includes(this.filter.email.toLowerCase()) : true) &&
        (this.filter.cv ? item.cv.toLowerCase().includes(this.filter.cv.toLowerCase()) : true)
      );
    });
  }

  deleteC(id: number){
    this.candidateService.deleteCandidate(id).subscribe({
      next: (data) => {
        window.location.reload();
      },
      error: (err) => {
        console.log(err);
      }
    });
  }
  
}
