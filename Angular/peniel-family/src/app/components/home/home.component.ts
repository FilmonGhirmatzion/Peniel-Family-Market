import { Component, OnInit } from '@angular/core';
import { PhoneService } from '../../services/phone.service';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Observable } from 'rxjs';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent implements OnInit {

  models: string[]= [
    'iPhone 7',
    'Samsung Galaxy S8',
    'Huawei P10',
  ];
  phoneForm: FormGroup = new FormGroup({});
  validMessage: string = "";



  constructor(private phoneService: PhoneService) { }
  ngOnInit(): void {
    this.phoneForm = new FormGroup({
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
    if (this.phoneForm.valid) {
      this.validMessage = "Your phone registration has been submitted. Thank you!";
      this.phoneService.createPhoneRegistration(this.phoneForm.value).subscribe(
        data => {
          this.phoneForm.reset();
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
