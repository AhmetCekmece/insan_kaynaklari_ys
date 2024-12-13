export interface Candidate {
    id: number;
    firstName: string;
    lastName: string;
    position: string;
    militaryStatus: MilitaryStatus;  
    noticePeriod: string;  
    phone: string;
    email: string;
    cv: string;
}

export enum MilitaryStatus {
    TAMAMLANDI = 'TAMAMLANDI',
    MUAF = 'MUAF',
    TECILLI = 'TECILLI'
}