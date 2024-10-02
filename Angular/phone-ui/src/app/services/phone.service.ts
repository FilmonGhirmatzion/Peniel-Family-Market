import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable({
  providedIn: 'root'
})
export class PhoneService {

  constructor(private http:HttpClient) { }

  getPhones(): Observable<any> {
    return this.http.get('/server/phones/list');
  }

  getPhone(id: number): Observable<any> {
    return this.http.get('/server/phones/' + id);
}
   createPhoneRegistration(phone: any): Observable<any> {
    let body = JSON.stringify(phone);
    return this.http.post('/server/phones/', body, httpOptions);
}
}
