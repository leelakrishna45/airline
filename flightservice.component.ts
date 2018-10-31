import { Injectable } from '@angular/core';
import { Http, Response, Headers, RequestOptions } from '@angular/http'
import { Flight } from './flight';
import { Observable } from 'rxjs/Observable'
import "rxjs/add/operator/map"

@Injectable()
export class FlightService {
    static selectedFlight: Flight;
    constructor( private http: Http ) {
    }
    getSelectedFlight(): Flight {
        return FlightService.selectedFlight;
    }
    setSelectedFlight( flight: Flight ): void {
        FlightService.selectedFlight = flight;
    }

    getEnquiredFlights( source: string, destination: string, date: string ): Observable<any> {
        return this.http.get( 'http://10.102.51.18:8888/enquiry/' + source + '/' + destination + '/' + date ).map(( res: Response ) => <Flight[]>res.json() );
    }

    updateFlightDetails( flight: Flight ): Observable<any> {
        let flightData = JSON.stringify( flight );
        let cpHeaders = new Headers( { 'Content-Type': 'application/json' } );
        let options = new RequestOptions( { headers: cpHeaders } );
        return this.http.put( 'http://10.102.51.18:8888//updateFlight', flightData, options )
        .map(( res: Response ) => <any>res.json());
    }
}