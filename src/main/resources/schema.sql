-- DROP TABLE IF EXISTS tbl_board;
-- CREATE TABLE tbl_board(
-- boardId Long auto_increment,
-- title varchar (30) not null,
-- content varchar (30) not null,
-- name varchar (30) not null,
-- read integer default 0,
-- primary key(boardId)
-- );

DROP TABLE IF EXISTS tbl_board;
create table tbl_board(
    boardId int unsigned auto_increment,
    title   varchar(30)       not null,
    content varchar(30)       not null,
    name    varchar(30)       not null,
    readCnt  integer default 0 null,
    constraint tbl_board_pk
        primary key (boardId)
    );

INSERT INTO tbl_board(title, content, name) VALUES('title1', 'content1', 'name1');
INSERT INTO tbl_board(title, content, name) VALUES('title2', 'content2', 'name2');
INSERT INTO tbl_board(title, content, name) VALUES('title3', 'content3', 'name3');
INSERT INTO tbl_board(title, content, name) VALUES('title4', 'content4', 'name4');
INSERT INTO tbl_board(title, content, name) VALUES('title5', 'content5', 'name5');
INSERT INTO tbl_board(title, content, name) VALUES('title6', 'content6', 'name6');
INSERT INTO tbl_board(title, content, name) VALUES('title7', 'content7', 'name7');
INSERT INTO tbl_board(title, content, name) VALUES('title8', 'content8', 'name8');
