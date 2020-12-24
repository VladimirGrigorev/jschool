import { Component } from '@angular/core';
import {CurrentUserService} from "./service/current-user/current-user.service";
import {User} from "./model/user";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'auto-pandemia-app';

  user: User = {} as User;

  constructor(
    private currentUserService: CurrentUserService
  ) {
  }

  isAdmin(): boolean{
    if(this.currentUserService.isAuthenticated())
      return !!this.currentUserService.getCurrentUser().roles.find(role => role.name == "ROLE_ADMIN");
    else
      return false;
  }

  isUser(): boolean{
    if(this.currentUserService.isAuthenticated())
      return !!this.currentUserService.getCurrentUser().roles.find(role => role.name == "ROLE_USER");
    else
      return false;
  }

  isAuthenticated(): boolean{
      return this.currentUserService.isAuthenticated();
  }

  logout() {
    this.currentUserService.logout();
    location.reload();
  }
}
