import { Component, OnInit } from '@angular/core';
import {StoreBranch} from "../../model/store-branch";
import {StoreBranchService} from "../../service/store-branch/store-branch.service";

@Component({
  selector: 'app-store-branch-list',
  templateUrl: './store-branch-list.component.html',
  styleUrls: ['./store-branch-list.component.css']
})
export class StoreBranchListComponent implements OnInit {

  storeBranches: StoreBranch[] = [];

  constructor(
    private storeBranchService: StoreBranchService
  ) { }

  ngOnInit(): void {
    this.getStoreBranches();
  }

  getStoreBranches(): void {
    this.storeBranchService.getStoreBranches().subscribe(storeBranches => this.storeBranches = storeBranches);
  }

  click(id: number) {

  }
}
