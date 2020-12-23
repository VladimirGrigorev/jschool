import { Injectable } from '@angular/core';
import {User} from "../../model/user";

@Injectable({
  providedIn: 'root'
})
export class CurrentUserService {

  token: string | null = null;
  currentUser: User = {} as User;

  constructor() { }

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

  isAuthenticated(): boolean {
    return !!this.token;
  }
}
