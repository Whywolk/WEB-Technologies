// License: GNU GPL version 3 <https://www.gnu.org/licenses/gpl-3.0.html>
// Copyright (C) 2021  Author: Alex Shirshov <https://github.com/Whywolk>

import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor, HttpErrorResponse
} from '@angular/common/http';
import {
  catchError,
  Observable,
  throwError
} from 'rxjs';
import { Router } from "@angular/router";

@Injectable()
export class HttpErrorInterceptor implements HttpInterceptor {
  constructor(private router: Router) {  }

  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    return next.handle(request)
      .pipe(catchError((error: HttpErrorResponse) => {
        let errorMsg = '';
        if (error.error) {
          this.router.navigate(['/page_not_found']);
        }
        errorMsg = `Error code: ${error.status}, Message: ${error.message}`;
        return throwError(errorMsg);
      }))
  }
}
