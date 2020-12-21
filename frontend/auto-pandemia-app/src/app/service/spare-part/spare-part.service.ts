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

  getSpareParts(): Observable<SparePart[]> {
    return this.http.get<SparePart[]>('api/v1/spare-parts', this.buildOpts());
  }

  createSparePart(sparePart: SparePart): Observable<SparePart> {
    return this.http.post<SparePart>('api/v1/spare-parts', sparePart, this.buildOpts());
  }

  updateSparePart(sparePart: SparePart): Observable<SparePart> {
    return this.http.put<SparePart>(`api/v1/spare-parts/${sparePart.id}`, sparePart, this.buildOpts());
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
