import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BsDropdownModule } from 'ngx-bootstrap/dropdown';
import { CollapseModule } from 'ngx-bootstrap/collapse';

import { HomeRoutingModule } from './home-routing.module';
import { HomeComponent } from './home.component';
import { MenuComponent } from './menu/menu.component';

@NgModule({
  declarations: [HomeComponent, MenuComponent],
  imports: [
    CommonModule,
    CollapseModule.forRoot(),
    HomeRoutingModule
  ]
})
export class HomeModule { }
