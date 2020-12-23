import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {first, shareReplay, tap} from "rxjs/operators";
import {User} from "../../model/user";
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

  public setSession(token: string | null) {

    this.http.get('/api/v1/me', this.buildOpts())
      .subscribe(user => {
          this.currentUserService.setCurrentUser(user as User);
        },
        error => {
          console.log(error);
        });
  }

  register(login: string, password: string): Observable<LoginRes> {
    let body = {
      login,
      password
    };

    return this.http.post<LoginRes>('api/v1/security/register', body);
  }

  private buildOpts(): object {
    return {
      headers: new HttpHeaders({
        Authorization: `Bearer ${this.currentUserService.getToken()}`
      })
    };
  }
}


export interface LoginRes {
  token: string;
}
