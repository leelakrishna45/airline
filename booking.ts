import { Passenger } from './passenger';
export class Booking
{
    
    classType:string;
    creditcardInfo:string;
    custEmail:string;
    destCity:string;
    noOfPassengers:number;
    srcCity:string;
    totalFare:number;
    passengers:Passenger[]=[];
    flightno:string;
    depTime:string;
    depDate:string;
}