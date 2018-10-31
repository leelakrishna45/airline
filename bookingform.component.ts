import { Component } from '@angular/core';
import { FlightService } from './flightservice.component';
import { BookingService } from './bookingservice.component';
import { Flight } from './flight';
import { Passenger } from './passenger';
import { Booking } from './booking';
import { NgForm, FormsModule } from '@angular/forms';
import {Router} from '@angular/router';


@Component( {

    selector: 'booking-form',
    templateUrl: './bookingform.component.html',
    providers: [FlightService, BookingService],
    styleUrls:['./styles.css']
} )
export class BookingForm {
    flight: Flight;
    totalPassengers: number = 0;
    bookingInformation: Booking = new Booking();
    passengerList: Passenger[] = [];
    passenger: Passenger = new Passenger();
    index: number;
    maxPassengerLimit: number = 0;
    classType: string;
    seatFare: number;
    flag: boolean = false;
    isClassSelected: boolean = false;

    constructor( private flightService: FlightService ,private bookingService: BookingService,private router: Router) {
        this.passenger = new Passenger();
        this.flight = this.flightService.getSelectedFlight();
        this.router=router;
    }
    addPassenger( frm2: NgForm ): void {

        if ( this.totalPassengers == this.maxPassengerLimit ) {

            alert( "Maximum passengers added!!" );
        } else {
            this.flag = true;
            let name = frm2.controls["txtPsgName"].value;
            let age = +frm2.controls["txtPsgAge"].value;
            let newPassenger = new Passenger();
            newPassenger.age = age;
            newPassenger.name = name;
            this.totalPassengers = this.totalPassengers + 1;
            this.passengerList.push( newPassenger );
            this.passenger = new Passenger();
        }

    }
    deletePassenger( passenger: Passenger ): void {
        this.index = this.passengerList.indexOf( passenger );
        this.totalPassengers = this.totalPassengers - 1;
        this.passengerList.splice( this.index, 1 );
        if ( this.totalPassengers == 0 ) {
            this.flag = false;
        }
    }
    enableAddPassengers(): void {
        this.isClassSelected = true;
        this.passengerList = [];
        this.flag = false;
        if ( this.classType == "business" ) {
            this.seatFare=this.flight.bussseatfare;
            if ( this.flight.bussseats > 5 ) {
                this.maxPassengerLimit = 5;
            } else {
                this.maxPassengerLimit = this.flight.bussseats;
            }
        } else {
            this.seatFare=this.flight.firstseatfare;
            if ( this.flight.firstseats > 5 ) {
                this.maxPassengerLimit = 5;
            } else {
                this.maxPassengerLimit = this.flight.firstseats;
            }
        }

    }
    addBookingDetails(): void {
        this.bookingInformation.classType=this.classType;
        this.bookingInformation.destCity=this.flight.arrCity;
        this.bookingInformation.srcCity=this.flight.depCity;
        this.bookingInformation.noOfPassengers=this.totalPassengers;
        this.bookingInformation.passengers=this.passengerList;
        this.bookingInformation.totalFare=this.seatFare*this.totalPassengers;
        this.bookingService.setBookingDetails(this.bookingInformation);
        this.bookingInformation.flightno=this.flight.flightno;
        this.bookingInformation.depDate=this.flight.depDate;
        this.bookingInformation.depTime=this.flight.depTime;
        this.router.navigateByUrl('/payment');
        
    }
}