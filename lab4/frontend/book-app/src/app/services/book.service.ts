// License: GNU GPL version 3 <https://www.gnu.org/licenses/gpl-3.0.html>
// Copyright (C) 2021  Author: Alex Shirshov <https://github.com/Whywolk>

import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { Book } from "../models/book.model";

const apiUrl = 'http://localhost:8081/lab4/api'

@Injectable({
  providedIn: 'root'
})
export class BookService {

  constructor(private http: HttpClient) { }

  getAll(): Observable<Book[]> {
    return this.http.get<Book[]>(`${apiUrl}/books`);
  }

  get(id: any): Observable<Book> {
    return this.http.get<Book>(`${apiUrl}/book/${id}`);
  }

  create(data: any): Observable<any> {
    return this.http.post(`${apiUrl}/books`, data);
  }

  update(id: any, data: any): Observable<any> {
    return this.http.put(`${apiUrl}/book/${id}`, data);
  }

  delete(id: any): Observable<any> {
    return this.http.delete(`${apiUrl}/book/${id}`);
  }
}
