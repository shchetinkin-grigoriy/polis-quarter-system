import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HouseService } from './house.service';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { HouseListComponent } from './house-list/house-list.component';

import { MatButtonModule, MatCardModule, MatInputModule, MatListModule, MatToolbarModule } from '@angular/material';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations'

@NgModule({
  declarations: [
    AppComponent,
    HouseListComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatCardModule,
    MatInputModule,
    MatListModule,
    MatToolbarModule
  ],
  providers: [HouseService],
  bootstrap: [AppComponent]
})
export class AppModule { }
