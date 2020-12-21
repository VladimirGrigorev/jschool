import { Component, OnInit } from '@angular/core';
import {SparePart} from "../../model/spare-part";
import {SparePartService} from "../../service/spare-part/spare-part.service";

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
  }

  getSpareParts(): void {
    this.sparePartService.getSpareParts().subscribe(spareParts => this.spareParts = spareParts);
  }

  onClear(): void {
    this.currentSparePart = {
      id: null,
      name: '',
      description: '',
      count: 0,
      cost: 0
    };
  }

  onSetSparePart(sparePart: SparePart): void {
    this.currentSparePart = { ...sparePart };
  }

  onSave(sparePart: SparePart): void {
    if (this.currentSparePart.id) {
      this.sparePartService.updateSparePart(sparePart).subscribe(() => {
        this.onClear();
        this.getSpareParts();
      });
    } else {
      this.sparePartService.createSparePart(sparePart).subscribe(() => {
        this.onClear();
        this.getSpareParts();
      });
    }
  }

  onDelete(sparePartId: number | null): void {
    if(sparePartId != null)
      this.sparePartService.deleteSparePart(sparePartId).subscribe(() => this.getSpareParts());
  }

}
