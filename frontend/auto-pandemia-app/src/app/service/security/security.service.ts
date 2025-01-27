import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {CurrentUserService} from "../current-user/current-user.service";

@Injectable({
  providedIn: 'root'
})
export class SecurityService {

  constructor(
    private http: HttpClient,
    private currentUserService: CurrentUserService
  ) {
  }

  login(login: string, password: string): Observable<LoginRes> {
    let body = {
      login,
      password
    };

    return this.http.post<LoginRes>('api/v1/security/login', body);
  }

  register(login: string, password: string): Observable<LoginRes> {
    let body = {
      login,
      password
    };

    return this.http.post<LoginRes>('api/v1/security/register', body);
  }
}


export interface LoginRes {
  token: string;
}
