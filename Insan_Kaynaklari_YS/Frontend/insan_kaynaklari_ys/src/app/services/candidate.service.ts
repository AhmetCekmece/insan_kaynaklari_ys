import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Candidate } from '../models/candidate.model';
import { CandidateIU } from '../models/candidateiu.model';

@Injectable({
  providedIn: 'root'
})
export class CandidateService {

  private baseUrl: string = 'http://localhost:8080/api/candidates';

  constructor(private httpClient: HttpClient) { }

  getAllCandidates() {
    return this.httpClient.get<Candidate[]>(`${this.baseUrl}/list`); 
  }

  createCandidate(data: CandidateIU) {
    return this.httpClient.post(`${this.baseUrl}/create`, data);  
  }

  getCandidateById(id: number) {
    return this.httpClient.get<Candidate>(`${this.baseUrl}/list/${id}`);  
  }

  updateCandidate(data: Candidate) {
    return this.httpClient.put<Candidate>(`${this.baseUrl}/update/${data.id}`, data);  
  }

  deleteCandidate(id: number) {
    return this.httpClient.delete(`${this.baseUrl}/delete/${id}`);  
  }
}
