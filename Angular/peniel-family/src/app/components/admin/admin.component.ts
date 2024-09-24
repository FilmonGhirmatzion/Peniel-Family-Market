import { Component, OnInit } from '@angular/core';
import { PhoneService } from '../../services/phone.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrl: './admin.component.css'
})
export class AdminComponent implements OnInit {
  public phones: any;

  constructor(private phoneService: PhoneService) { }

  ngOnInit() {
    this.getPhones();
  }

  getPhones() {
    this.phoneService.getPhones().subscribe(
      data => {this.phones = data},
      err => console.error(err),
      () => console.log('phones loaded')

    );
  }

}