export interface CandidateIU {
    firstName: string;
    lastName: string;
    position: string;
    militaryStatus: MilitaryStatusIU;  
    noticePeriod: string;  
    phone: string;
    email: string;
    cv: string;
}

export enum MilitaryStatusIU {
    TAMAMLANDI = 'TAMAMLANDI',
    MUAF = 'MUAF',
    TECILLI = 'TECILLI'
}