create table board_tb (
  no int primary key auto_increment,
  writer varchar(30) not null, -- foreign key 달아서 회원만 글 쓸수 있게 제한할 수도 있음.
  read_count int default 0,
  title varchar(100) not null default 'no title',
  content text,
  reg_date datetime not null
);