// License: GNU GPL version 3 <https://www.gnu.org/licenses/gpl-3.0.html>
// Copyright (C) 2021  Author: Alex Shirshov <https://github.com/Whywolk>

import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BookListComponent } from "./components/book-list/book-list.component";
import { BookDetailsComponent } from "./components/book-details/book-details.component";
import { AddBookComponent } from "./components/add-book/add-book.component";
import { HomeComponent } from "./components/home/home.component";
import { AboutComponent } from "./components/about/about.component";
import { PageNotFoundComponent } from "./components/page-not-found/page-not-found.component";

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'books', component: BookListComponent },
  { path: 'book/:id', component: BookDetailsComponent },
  { path: 'add', component: AddBookComponent },
  { path: 'about', component: AboutComponent },
  { path: '**', component: PageNotFoundComponent},
  { path: 'page_not_found', component: PageNotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
