import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent } from './app.component';
import { BookingForm } from './bookingform.component';
import { Payment } from './payment.component';
import { EnquiryForm } from './enquiryform.component';
import { Booking } from './booking';
import { Flight } from './flight';
import { Passenger } from './passenger';
import { Routes, RouterModule } from '@angular/router';
import { HttpModule } from '@angular/http';
import { FormsModule } from '@angular/forms';
const appRoutes: Routes = [
    { path: '', redirectTo: '/enquiry', pathMatch: 'full' },
    { path: 'enquiry', component: EnquiryForm },
    { path: 'enquiry/booking', component: BookingForm },
    { path: 'payment', component: Payment }

];


@NgModule( {
    imports: [BrowserModule, RouterModule.forRoot( appRoutes ), FormsModule, HttpModule],
    declarations: [AppComponent, BookingForm, EnquiryForm, Payment],
    bootstrap: [AppComponent]
} )
export class AppModule { }