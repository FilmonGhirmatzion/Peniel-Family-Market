import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';


const httpOptions = {
  Headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class PhoneService {

  constructor(private http:HttpClient) { }

  getPhones() {
      return this.http.get('/server/phones/list');
  }

  // getPhoneById(id: number) {
  //     return this.http.get(`/server/phones/get/${id}`);
  // }

}
