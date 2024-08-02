/*
 제약조건의 종류와 참조 관계에서의 데이터 삭제 이슈 등 학습
 가상 테이블 View(서브쿼리에서 인라인뷰 등장했던 것)의 정체, 장점, insert, update, delete 제약
 */

use workshop;

create table member_tb (
    user_id varchar(30) primary key,
    user_pw varchar(50) not null
)

    insert into member_tb(user_id, user_pw) values('grepp', '1234');
insert into member_tb(user_id, user_pw) values('programmers', '9999');

insert into board_tb(writer, content, reg_date) values('grepp', 'content', now());

select * from member_tb;
update board_tb set writer='programmers' where no=2;
delete from member_tb where user_id='programmers';

alter table board_tb add constraint fk_writer_member_id foreign key(writer)
    references member_tb(user_id) on delete cascade;

alter table board_tb drop foreign key fk_writer_member_id;


select * from information_schema.table_constraints where table_name=''


select empno, ename, deptno, dname
from emp natural join dept;

create view emp_dept
as
(select empno, ename, deptno, dname
from emp natural join dept);

show tables;

-- 이 구문을 실행하는 순간에 저 위에 join 하는 select를 실행한다.
-- 즉, 서브 쿼리로 select가 두번 실행된다.
select ename, dname from emp_dept;
insert into emp_dept (empno, ename, deptno, dname)
values (9999, 'ycjung', 90, 'developers'); -- 불가능

-- 내 권한 밖의 데이터는 참고할 수 없다.(데이터의 볼 수 있는 권한을 관리한다.)
create view empno_ename
as
select empno, ename from emp;

select * from empno_ename;
insert into empno_ename (empno, ename) values(1111,'ycjung');

select * from emp;

create view emp_cnt
as
select count(ename) from emp;

select * from emp_cnt;
