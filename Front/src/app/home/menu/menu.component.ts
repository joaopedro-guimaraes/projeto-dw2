import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.scss']
})
export class MenuComponent implements OnInit {

  isCollapsed = true;
  user;

  constructor() { }

  ngOnInit() {
    this.user =  JSON.parse(localStorage.getItem('user'));
  }

}
