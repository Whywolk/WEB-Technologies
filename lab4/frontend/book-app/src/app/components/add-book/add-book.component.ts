import { Component, OnInit } from '@angular/core';
import { Book } from "../../models/book.model";
import { BookService } from "../../services/book.service";

@Component({
  selector: 'app-add-book',
  templateUrl: './add-book.component.html',
  styleUrls: ['./add-book.component.css']
})
export class AddBookComponent implements OnInit {

  book: Book = {};
  isBookAdded = false;
  message = '';

  constructor(
    private bookService: BookService
  ) { }

  ngOnInit(): void { }

  addBook(): void {
    if (!this.book.title) {
      this.message = 'Добавьте название!'
      return;
    }

    this.bookService.create(this.book)
      .subscribe({
        next: (data) => {
          console.log(data);
          this.book = data;
          this.isBookAdded = true;
        },
        error: (e) => console.error(e)
        })
  }
}
