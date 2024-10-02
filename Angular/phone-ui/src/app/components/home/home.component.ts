import { Component } from '@angular/core';
import { PhoneService } from '../../services/phone.service';
import { FormGroup, FormControl, Validators } from '@angular/forms';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent {
  models: string[] = [
    'iPhone 7',
    'Samsung Galaxy S8',
    'Huawei P10',
  ];
  phoneform: FormGroup = new FormGroup({});
  validMessage: string = "";


  constructor(private phoneService: PhoneService) { }

  ngOnInit(): void {
    this.phoneform = new FormGroup({
      name: new FormControl('', Validators.required),
      email: new FormControl('', Validators.required),
      phoneNumber: new FormControl('', Validators.required),
      model: new FormControl('', Validators.required),
      serialNumber: new FormControl('', Validators.required),
      price: new FormControl('', Validators.required),
      purchaseDate: new FormControl('', Validators.required),
      contact: new FormControl('', Validators.required),
    });
  }
  submitRegistration() {
    if (this.phoneform.valid) {
      this.validMessage = "Your phone registration has been submitted. Thank you!";
      this.phoneService.createPhoneRegistration(this.phoneform.value).subscribe(
        data => {
          this.phoneform.reset();
          return true;
        },
        error => {
          return console.error('Error saving phone!');
        }
      );
    } else {
      this.validMessage = "Please fill out the form before submitting!";
    }
  }


}
