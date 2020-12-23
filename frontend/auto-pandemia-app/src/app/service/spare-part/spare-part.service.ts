import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {CurrentUserService} from "../current-user/current-user.service";
import {Observable} from "rxjs";
import {SparePart} from "../../model/spare-part";

@Injectable({
  providedIn: 'root'
})
export class SparePartService {

  constructor(
    private http: HttpClient,
    private currentUserService: CurrentUserService
  ) {
  }

  getSparePartsWithPositiveCount(storeBranchId: number): Observable<SparePart[]> {
    return this.http.get<SparePart[]>(`api/v1/spare-parts/positive/${storeBranchId}`, this.buildOpts());
  }

  getSpareParts(): Observable<SparePart[]> {
    return this.http.get<SparePart[]>(`api/v1/spare-parts/all`, this.buildOpts());
  }

  createSparePart(sparePart: SparePart, storeBranchId: number): Observable<SparePart> {
    return this.http.post<SparePart>(`api/v1/spare-parts/${storeBranchId}`, sparePart, this.buildOpts());
  }

  updateSparePart(sparePart: SparePart, storeBranchId: number): Observable<SparePart> {
    return this.http.put<SparePart>(`api/v1/spare-parts/${sparePart.id}/${storeBranchId}`, sparePart, this.buildOpts());
  }

  deleteSparePart(sparePartId: number): Observable<void> {
    return this.http.delete<void>(`api/v1/spare-parts/${sparePartId}`, this.buildOpts());
  }

  private buildOpts(): object {
    return {
      headers: new HttpHeaders({
        Authorization: `Bearer ${this.currentUserService.getToken()}`
      })
    };
  }
}
