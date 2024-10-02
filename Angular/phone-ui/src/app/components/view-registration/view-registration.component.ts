import { Component } from '@angular/core';
import { PhoneService } from '../../services/phone.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-view-registration',
  templateUrl: './view-registration.component.html',
  styleUrl: './view-registration.component.css'
})
export class ViewRegistrationComponent {

  public phoneReg: any;

  constructor(private phoneService: PhoneService, private route: ActivatedRoute) { }

  ngOnInit() {
    this.getPhoneReg(this.route.snapshot.params['id']);

  }
  getPhoneReg(id: number) {
    this.phoneService.getPhones().subscribe(
      data => {
        this.phoneReg = data;
      },
      err => console.error(err),
      () => console.log('phones loaded')

    );
  }

}
