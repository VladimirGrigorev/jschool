import { Component, OnInit } from '@angular/core';
import {StoreBranch} from "../../model/store-branch";
import {StoreBranchService} from "../../service/store-branch/store-branch.service";

@Component({
  selector: 'app-store-branches',
  templateUrl: './store-branches.component.html',
  styleUrls: ['./store-branches.component.css']
})
export class StoreBranchesComponent implements OnInit {

  currentStoreBranch: StoreBranch | null = null;
  storeBranches: StoreBranch[] = [];

  constructor(
    private storeBranchService: StoreBranchService
  ) { }

  ngOnInit(): void {
    this.onClear();
    this.getStoreBranches();
  }

  getStoreBranches(): void {
    this.storeBranchService.getStoreBranches().subscribe(storeBranches => this.storeBranches = storeBranches);
  }

  onClear(): void {
    this.currentStoreBranch = {
      id: null,
      address: '',
      description: '',
    };
  }

  onSetDevice(storeBranch: StoreBranch): void {
    this.currentStoreBranch = { ...storeBranch };
  }

  onSave(storeBranch: StoreBranch): void {
    if (this.currentStoreBranch.id) {
      this.storeBranchService.updateDevice(storeBranch).subscribe();
    } else {
      this.storeBranchService.createStoreBranch(storeBranch).subscribe();
    }
    this.onClear();
    this.getStoreBranches();
  }

  onDelete(deviceId: number): void {
    this.storeBranchService.deleteDevice(deviceId).subscribe(() => this.getStoreBranches());
  }

}


