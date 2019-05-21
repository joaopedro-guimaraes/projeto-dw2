import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { HomeRoutingModule } from './home-routing.module';
import { HomeComponent } from './home.component';
import { MenuComponent } from './menu/menu.component';
import { MainComponent } from './main/main.component';


@NgModule({
  declarations: [HomeComponent, MenuComponent, MainComponent],
  imports: [
    CommonModule,
    NgbModule.forRoot(),
    HomeRoutingModule
  ]
})
export class HomeModule { }
