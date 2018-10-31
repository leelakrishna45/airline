import { Injectable } from '@angular/core';
import { Http, Response, Headers, RequestOptions } from '@angular/http'
import { Booking } from './booking';
import { Observable } from 'rxjs/Observable'
import "rxjs/add/operator/map"

@Injectable()
export class BookingService {
    static bookingDetils: Booking;
    constructor( private http: Http ) {
    }

    getBookingDetails(): Booking {
        return BookingService.bookingDetils;
    }

    setBookingDetails( booking: Booking ): void {
        BookingService.bookingDetils = booking;
    }

    addBookingDetails( booking: Booking ): Observable<any> {
        let bookingData = JSON.stringify( booking );
        let cpHeaders = new Headers( { 'Content-Type': 'application/json' } );
        let options = new RequestOptions( { headers: cpHeaders } );
        return this.http
            .post( 'http://10.102.51.18:8888/addbooking', bookingData, options )
            .map(( res: Response ) => <any>res.json() );
    }
}


