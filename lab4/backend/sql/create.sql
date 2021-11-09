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
