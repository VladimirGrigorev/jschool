import { Component, OnInit } from '@angular/core';
import {SparePart} from "../../model/spare-part";
import {SparePartService} from "../../service/spare-part/spare-part.service";
import {StoreBranch} from "../../model/store-branch";

@Component({
  selector: 'app-spare-parts',
  templateUrl: './spare-parts.component.html',
  styleUrls: ['./spare-parts.component.css']
})
export class SparePartsComponent implements OnInit {

  currentSparePart: SparePart = {} as SparePart;
  spareParts: SparePart[] = [];

  constructor(
    private sparePartService: SparePartService
  ) { }

  ngOnInit(): void {
    this.onClear();
    this.getSpareParts();
    this.onClear();
  }

  getSpareParts(): void {
    this.sparePartService.getSpareParts().subscribe(
      spareParts => this.spareParts = spareParts);
  }

  onClear(): void {
    this.currentSparePart = {
      id: null,
      name: '',
      description: '',
      count: 0,
      cost: 0,
      storeBranch: {} as StoreBranch,
    };
  }

  onSetSparePart(sparePart: SparePart): void {
    this.currentSparePart = { ...sparePart };
  }

  onSave(sparePart: SparePart, storeBranchId: number | null): void {
    if(storeBranchId != null) {
    if (this.currentSparePart.id) {
      this.sparePartService.updateSparePart(sparePart, storeBranchId).subscribe(() => {
        this.onClear();
        this.getSpareParts();
      });
    } else {
      this.sparePartService.createSparePart(sparePart, storeBranchId).subscribe(() => {
        this.onClear();
        this.getSpareParts();
      });
    }
    }
  }

  onDelete(sparePartId: number | null): void {
    if(sparePartId != null)
      this.sparePartService.deleteSparePart(sparePartId).subscribe(() => this.getSpareParts());
  }

}
