import { Component, OnInit } from '@angular/core';
import {CurrentUserService} from "../../service/current-user/current-user.service";
import {User} from "../../model/user";

@Component({
  selector: 'app-purchased-spare-parts',
  templateUrl: './purchased-spare-parts.component.html',
  styleUrls: ['./purchased-spare-parts.component.css']
})
export class PurchasedSparePartsComponent implements OnInit {

  user: User = {} as User;

  constructor(
    private currentUserService: CurrentUserService
  ) {
  }

  ngOnInit(): void {
    this.user = this.currentUserService.getCurrentUserAfterPurchases();
  }

}
