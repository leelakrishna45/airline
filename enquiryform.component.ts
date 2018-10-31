import { Component } from '@angular/core';
import { Flight } from './flight';
import { FlightService } from './flightservice.component';
import { NgForm, FormsModule } from '@angular/forms';
import {Router} from '@angular/router';
@Component( {

    selector: 'enquiry-form',
    templateUrl: './enquiryform.component.html',
    providers: [FlightService],
    styleUrls:['./styles.css']
} )
export class EnquiryForm {
    flightList: Flight[] = [];
    sourceCity: string;
    flag: boolean = false;
    noFlightFound:boolean=false;
    isFlightSelected:boolean=false;
    destinationCity: string;
    date:string;
    startDate: string;
    endDate: string;
    constructor( private service: FlightService ) {
        this.setInputDate();
    }
    submit( frm1: NgForm ): void {
        console.log(this.date);
        this.service.getEnquiredFlights( this.sourceCity.toLowerCase(), this.destinationCity.toLowerCase(), this.date ).subscribe( result =>{ this.flightList = result;
                if(this.flightList.length>0){
                    this.flag=true;
                    this.noFlightFound=false;
                }else{
                    this.noFlightFound=true;
                    this.flag=false;
                }        
        }
        )
       
    }
    sendFlight( flight: Flight ): void {
        this.service.setSelectedFlight( flight );
        this.isFlightSelected=true;
    }

    setInputDate():void{
        
        var start = new Date();
        var end = new Date();
        end.setDate(start.getDate()+3);
        var d = start.getDate();
        var m = start.getMonth()+1; 
        var y = start.getFullYear();
        var day:string=d.toString();
        var month:string=m.toString();
        if(d < 10){
            day = "0"+d;
        };
        if(m < 10){
            month = "0"+m;
        };

        this.startDate = y+"-"+month+"-"+day;
        console.log(this.startDate);
        d = end.getDate();
        m = end.getMonth()+1; 
        y = end.getFullYear();
        day=d.toString();
        month=m.toString();
        if(d < 10){
            day = "0"+d;
        };
        if(m < 10){
            month = "0"+m;
        };
        this.endDate = y+"-"+month+"-"+day;
        this.date=this.startDate;
    };

    

}