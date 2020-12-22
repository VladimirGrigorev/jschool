import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {CurrentUserService} from "../current-user/current-user.service";
import {StoreBranch} from "../../model/store-branch";

@Injectable({
  providedIn: 'root'
})
export class StoreBranchService {

  constructor(
    private http: HttpClient,
    private currentUserService: CurrentUserService
  ) {
  }

  getStoreBranches(): Observable<StoreBranch[]> {
    return this.http.get<StoreBranch[]>('api/v1/store-branches', this.buildOpts());
  }

  getStoreBranch(storeBranchId: number): Observable<StoreBranch> {
    return this.http.get<StoreBranch>(`api/v1/store-branches/${storeBranchId}`, this.buildOpts());
  }

  createStoreBranch(storeBranch: StoreBranch): Observable<StoreBranch> {
    return this.http.post<StoreBranch>('api/v1/store-branches', storeBranch, this.buildOpts());
  }

  updateStoreBranch(storeBranch: StoreBranch): Observable<StoreBranch> {
    return this.http.put<StoreBranch>(`api/v1/store-branches/${storeBranch.id}`, storeBranch, this.buildOpts());
  }

  deleteStoreBranch(storeBranchId: number): Observable<void> {
    return this.http.delete<void>(`api/v1/store-branches/${storeBranchId}`, this.buildOpts());
  }

  private buildOpts(): object {
    return {
      headers: new HttpHeaders({
        Authorization: `Bearer ${this.currentUserService.getToken()}`
      })
    };
  }
}
