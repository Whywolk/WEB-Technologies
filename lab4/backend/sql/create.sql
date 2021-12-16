-- License: GNU GPL version 3 <https://www.gnu.org/licenses/gpl-3.0.html>
-- Copyright (C) 2021  Author: Alex Shirshov <https://github.com/Whywolk>

-- Database: booksDB

-- DROP DATABASE "booksDB";

CREATE DATABASE "booksDB"
	WITH
	OWNER = postgres
	ENCODING = 'UTF8'
	CONNECTION LIMIT = -1;

CREATE TABLE IF NOT EXISTS public.books
(
    id serial NOT NULL,
    title character varying(50),
    author character varying(50),
    description text,
    PRIMARY KEY (id)
);

ALTER TABLE public.books
    OWNER to postgres;
