import { Component } from '@angular/core';
import { FlightService } from './flightservice.component';
import { BookingService } from './bookingservice.component';
import { Flight } from './flight';
import { Passenger } from './passenger';
import { Booking } from './booking';
import { NgForm, FormsModule } from '@angular/forms';
import { Observable } from 'rxjs/Observable';
import {Router} from '@angular/router';
@Component( {

    selector: 'payment',
    templateUrl: './payment.component.html',
    providers: [FlightService, BookingService],
    styleUrls:['./styles.css']
} )
export class Payment {
    updatedFlight: Flight=new Flight();
    flight: Flight;
    bookingInformation: Booking;
    bookingId:number[]=[];
    message:string[]=[];
    customerEmail: string;
    creditCardNumber: string;
    isPaymentDone=false;
    constructor( private flightService: FlightService, private bookingService: BookingService ,private router:Router) {
        this.bookingInformation = this.bookingService.getBookingDetails();
        this.flight = this.flightService.getSelectedFlight();
        this.updateFlightDetails();
    }

    updateFlightDetails(): void {
        this.updatedFlight.flightno = this.flight.flightno;
        this.updatedFlight.airline = this.flight.airline;
        this.updatedFlight.depCity = this.flight.depCity;
        this.updatedFlight.depDate = this.flight.depDate;
        this.updatedFlight.depTime = this.flight.depTime;
        this.updatedFlight.arrCity = this.flight.arrCity;
        this.updatedFlight.arrDate = this.flight.arrDate;
        this.updatedFlight.arrTime = this.flight.arrTime;
        this.updatedFlight.firstseatfare = this.flight.firstseatfare;
        this.updatedFlight.bussseatfare = this.flight.bussseatfare;
        this.updatedFlight.firstseats=this.flight.firstseats;
        this.updatedFlight.bussseats=this.flight.bussseats;
        if ( this.bookingInformation.classType == "first" ) {
            this.updatedFlight.firstseats -= this.bookingInformation.noOfPassengers;
            this.updatedFlight.bussseats = 0;
        } else {
            this.updatedFlight.bussseats -= this.bookingInformation.noOfPassengers;
            this.updatedFlight.firstseats = 0;
        }
    }
    confirmPayment(): void {
        this.bookingInformation.creditcardInfo = this.creditCardNumber;
        this.bookingInformation.custEmail = this.customerEmail;
        this.flightService.updateFlightDetails(this.updatedFlight).subscribe(mes=>this.message=mes);
        this.bookingService.addBookingDetails(this.bookingInformation).subscribe(mes=>this.bookingId=mes);
        this.flightService.setSelectedFlight(null);
        this.bookingService.setBookingDetails(null);
        this.isPaymentDone=true;
    }
    cancelPayment():void
    {
        this.router.navigateByUrl("/enquiry");
    }
    
}