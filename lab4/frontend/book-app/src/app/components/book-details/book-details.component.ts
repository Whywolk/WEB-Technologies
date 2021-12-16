// License: GNU GPL version 3 <https://www.gnu.org/licenses/gpl-3.0.html>
// Copyright (C) 2021  Author: Alex Shirshov <https://github.com/Whywolk>

import {Component, Input, OnInit} from '@angular/core';
import { ActivatedRoute, Router } from "@angular/router";
import { BookService } from "../../services/book.service";
import { Book } from "../../models/book.model";

@Component({
  selector: 'app-book-details',
  templateUrl: './book-details.component.html',
  styleUrls: ['./book-details.component.css']
})
export class BookDetailsComponent implements OnInit {

  book: Book = {};
  isChanging = false;
  message = '';

  constructor(
    private bookService: BookService,
    private route: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.getBook(this.route.snapshot.params["id"]);
  }

  change(): void {
    this.isChanging = true;
  }

  getBook(id: number | undefined): void {
    this.bookService.get(id)
      .subscribe({
        next: (data) => {
          console.log(data);
          this.book = data;
        }
      })
  }

  cancel(): void{
    this.isChanging = false;
  }

  updateBook(): void {
    if (!this.book.title) {
      this.message = 'Добавьте название!';
      return;
    }

    this.message = '';
    this.bookService.update(this.book.id, this.book)
      .subscribe({
        next: (data) =>{
          console.log(data);
          this.book = data;
          this.isChanging = false;
        },
        error: (e) => {
          console.error(e);
        }
      });
  }

  deleteBook(): void {
    this.bookService.delete(this.book.id)
      .subscribe({
        next: (res) => {
          console.log(res);
          this.router.navigate(['/books'])
        },
        error: (e) => {
          console.log(e);
          this.router.navigate(['/404']);
        }
      });
  }
}
