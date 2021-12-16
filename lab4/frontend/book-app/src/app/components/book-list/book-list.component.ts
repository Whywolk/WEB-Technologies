// License: GNU GPL version 3 <https://www.gnu.org/licenses/gpl-3.0.html>
// Copyright (C) 2021  Author: Alex Shirshov <https://github.com/Whywolk>

import { Component, OnInit } from '@angular/core';
import { Book } from "../../models/book.model";
import { BookService } from "../../services/book.service";

@Component({
  selector: 'app-book-list',
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.css']
})
export class BookListComponent implements OnInit {

  books?: Book[];
  currentBook: Book = {};

  constructor(private bookService: BookService) { }

  ngOnInit(): void {
    this.retrieveBooks();
  }

  retrieveBooks(): void {
    this.bookService.getAll()
      .subscribe({
        next: (data) => {
          this.books = data;
          console.log(data);
        },
        error: (e) => {
          console.error(e);
        }
      })
  }

}
