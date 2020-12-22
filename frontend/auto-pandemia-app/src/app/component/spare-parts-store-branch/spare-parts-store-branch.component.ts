import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {StoreBranch} from "../../model/store-branch";
import {StoreBranchService} from "../../service/store-branch/store-branch.service";

@Component({
  selector: 'app-spare-parts-store-branch',
  templateUrl: './spare-parts-store-branch.component.html',
  styleUrls: ['./spare-parts-store-branch.component.css']
})
export class SparePartsStoreBranchComponent implements OnInit {

  storeBranchId: number = 1;
  storeBranch: StoreBranch = {} as StoreBranch;

  constructor(
    private route: ActivatedRoute,
    private storeBranchService: StoreBranchService
  ) { }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.storeBranchId = params['id'];
      this.getStoreBranchById(this.storeBranchId);
    });
  }

  getStoreBranchById(id: number): void {
    this.storeBranchService.getStoreBranch(id)
      .subscribe( storeBranch => {
          this.storeBranch= storeBranch;
        },
        error => {
          console.log(error);
        });
  }

}
