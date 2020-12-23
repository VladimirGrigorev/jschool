import { Injectable } from '@angular/core';
import {User} from "../../model/user";
import {HttpClient, HttpHeaders} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class CurrentUserService {

  token: string | null = null;
  currentUser: User = {} as User;

  constructor(
    private http: HttpClient
  ) {
  }

  setToken(token: string): void {
    this.token = token;
  }

  getToken(): string | null {
    return this.token;
  }

  setCurrentUser(user: User): void {
    this.currentUser = user;
  }

  getCurrentUser(): User {
    return this.currentUser;
  }

  getCurrentUserAfterPurchases(): User {
    this.setSession(this.token)
    return this.currentUser;
  }

  isAuthenticated(): boolean {
    return !!this.token;
  }

  public setSession(token: string | null) {

    this.http.get('/api/v1/me', this.buildOpts())
      .subscribe(user => {
          this.setCurrentUser(user as User);
        },
        error => {
          console.log(error);
        });
  }

  private buildOpts(): object {
    return {
      headers: new HttpHeaders({
        Authorization: `Bearer ${this.getToken()}`
      })
    };
  }
}
