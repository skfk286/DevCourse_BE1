-- 연봉에 커미션까지 더해서 사번, 이름, 월급, 연봉, 연봉(커미션포함) 출력하시오.
select empno as '사번', ename as '이름', sal as '월급', sal * 12 as '연봉', sal*12+IFNULL(comm, 0) as '연봉(커미션포함)' from emp;
-- 부서번호가 10번인 직원 목록을 사번, 이름, 부서번호 출력하시오.
select empno, ename, deptno from emp where deptno=10;
-- 급여가 1000이상 1500이하인 직원목록, 사번, 이름, 급여 출력하시오.(and 조건 쓰기)
select empno, ename, sal from emp where sal >= 1000 and sal <= 1500;
-- 급여가 1000이상 1500이하인 직원목록, 사번, 이름, 급여 출력하시오.(between 조건 쓰기)
select empno, ename, sal from emp where sal between 1000 and 1500;
-- 커미션 받는 직원이랑 안받는 직원 각각 사번, 이름, 커미션을 출력하시오.
select empno, ename, comm from emp where comm is not null;
-- 직원들이 속한 모든 부서번호만 출력하되 중복된 출력을 없게 하시오.
select distinct deptno from emp;
-- 30번 부서에 속한 직원들의 급여를 내림차순으로 정렬하여 그중 가장 많은 급여를 받는 상위의 3명의 이름과 급여를 조회하시오.
-- limit 은 페이징 처리에서 활용할 수 있다.
select ename, sal from emp order by sal desc limit 3;