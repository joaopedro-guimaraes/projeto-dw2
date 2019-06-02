import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { services } from './services';

@NgModule({
  declarations: [],
  imports: [
    HttpClientModule,
    CommonModule
  ],
  providers: [
    ...services,
  ],
})
export class CoreModule { }
