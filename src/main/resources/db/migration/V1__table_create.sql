-- 著者
create table author (
      id serial not null
    , name character varying(100) not null
    , birthday date
    , constraint author_PKC primary key (id)
) ;

-- 書籍
create table book (
      id serial not null
    , isbn character varying(17)
    , author_id integer not null
    , title character varying(100) not null
    , constraint book_PKC primary key (id)
) ;

comment on table author is '著者';
comment on column author.id is 'id';
comment on column author.name is '著者名';
comment on column author.birthday is '誕生日';

comment on table book is '書籍';
comment on column book.id is 'ID';
comment on column book.isbn is 'ISBN';
comment on column book.author_id is '著者ID';
comment on column book.title is 'タイトル';
