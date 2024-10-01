import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';


const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class PhoneService {

  constructor(private http:HttpClient) { }

  getPhones(): Observable<any[]> {
      return this.http.get<any[]>('/server/phones/list').pipe(
        catchError(this.handleError)
      );
  }

  getPhoneById(id: number): Observable<any> {
      return this.http.get<any>('/server/phones/get/' + id).pipe(
        catchError(this.handleError)
      );
  }
  createPhoneRegistration(phone: any): Observable<any> {
      let body = JSON.stringify(phone);
      return this.http.post<any>('/server/phones/new', body, httpOptions).pipe(
        catchError(this.handleError)
      );
  }

  private handleError(error: any) {
    console.error('An error occurred', error);
    return throwError(error);
  }

}
