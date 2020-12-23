import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {OrderService} from "../../service/order/order.service";
import {SparePart} from "../../model/spare-part";
import {ToastrService} from "ngx-toastr";
import {SparePartService} from "../../service/spare-part/spare-part.service";
import {StoreBranchService} from "../../service/store-branch/store-branch.service";
import {StoreBranch} from "../../model/store-branch";
import {CurrentUserService} from "../../service/current-user/current-user.service";

@Component({
  selector: 'app-spare-parts-store-branch',
  templateUrl: './spare-parts-store-branch.component.html',
  styleUrls: ['./spare-parts-store-branch.component.css']
})
export class SparePartsStoreBranchComponent implements OnInit {

  storeBranchId: number = 1;
  spareParts: SparePart[] = [];
  storeBranch: StoreBranch = {} as StoreBranch;

  constructor(
    private route: ActivatedRoute,
    private sparePartService: SparePartService,
    private storeBranchService: StoreBranchService,
    private orderService: OrderService,
    private currentUserService: CurrentUserService,
    private toastr: ToastrService
  ) { }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.storeBranchId = params['id'];
      this.getStoreBranch(this.storeBranchId);
      this.getSparePartsWithPositiveCount(this.storeBranchId);
    });
  }

  getSparePartsWithPositiveCount(id: number): void {
    this.sparePartService.getSparePartsWithPositiveCount(id)
      .subscribe( spareParts => {
          this.spareParts = spareParts;
        },
        error => {
          console.log(error);
        });
  }

  getStoreBranch(id: number): void {
    this.storeBranchService.getStoreBranch(id)
      .subscribe( storeBranch => {
          this.storeBranch = storeBranch;
        },
        error => {
          console.log(error);
        });
  }

  click(sparePart: SparePart):void {
    if (sparePart.id != null)
      this.orderService.buySparePart(sparePart.id).subscribe(
        () => {
          this.toastr.success("You have successfully purchased the spare part");
          this.currentUserService.getCurrentUserAfterPurchases()
          this.getSparePartsWithPositiveCount(this.storeBranchId);
        });
  }

}
