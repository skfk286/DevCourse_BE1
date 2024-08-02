/*
  인덱스의 기본 개념, 자동생성 인덱스
  인덱스는 크게 클러스터형, 보조 인덱스로 나뉜다.
  - 인덱스를 언제 써야하고 언제 안쓰는게 나은지 알아야할 필요성이 있음
 */


use workshop;

select * from emp;

-- 각 컬럼의 row 에 인덱스를 부여해서 중간 위치(log2 N)에서 찾아가는 기능
-- 무언가를 찾을 때 성능을 보장, 자주 사용되는 데이터들에 있어서 파티셔닝 등
-- 인덱스를 이용해서
-- 검색 속도가 빨라진다. => 특정 컬럼 값에 인덱스를 만든다.

drop table member_tb;

create table member_tb (
                           user_id varchar(30) primary key,
                           user_pw varchar(50) not null,
                           phone varchar(20) unique
);

show index from board_tb;
show index from emp; -- index type : BTREE

-- 클러스터형 인덱스
-- 자동 index 생성 되는 컬럼 : Pk column, unique column..

create index idx_emp_empno
    on emp(empno);
