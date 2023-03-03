-- delete는 컬럼명을 지정하지 않음
-- delete -> row만, update -> column 단위
-- delete: 저장공간은 남겨두고 데이터만 지움, 데이터 복구/취소(rollback) 가능
-- truncate: 저장공간도 남겨두지 않고 지움, 복구/취소 불가능
-- insert, delete, update의 결과는 실행된 row의 수(정수)
-- select의 결과는 테이블

-- varchar2: 변하다 + 문자 -> 2글자면 2글자 들어갈 만큼만 저장공간 사용
-- char: 저장공간이 고정 (주민번호, 전화번호, 우편번호, 사번 등)

SELECT * FROM EMP 

SELECT LOWER(ENAME) FROM EMP  

SELECT LENGTH(ENAME) FROM EMP 

SELECT SUBSTR(ENAME, 2, 2) FROM EMP  

SELECT SUBSTR(ENAME, -2) FROM EMP 

SELECT REPLACE(ENAME, ' ', '') FROM EMP 

SELECT CONCAT(EMPNO, ENAME) FROM EMP

SELECT CONCAT(CONCAT(EMPNO, ':'), ENAME) AS empno_ename FROM EMP

SELECT EMPNO || ':' || ENAME AS empno_ename FROM EMP

SELECT TRIM(BOTH 'A' FROM ENAME) FROM EMP -- 양쪽 끝 A 제거

SELECT TRIM(LEADING 'A' FROM ENAME) FROM EMP -- 앞쪽 A 제거

SELECT TRIM(TRAILING 'A' FROM ENAME) FROM EMP -- 뒷쪽 A 제거

SELECT LENGTH(TRIM(ENAME)) FROM EMP 

SELECT TRIM(ename) FROM EMP  

SELECT TO_DATE('20230303', 'YYYY-MM-DD') FROM DUAL

SELECT TO_CHAR(sysdate, 'HH:MI:SS PM') FROM dual  

UPDATE emp SET COMM = 0 WHERE COMM IS NULL

SELECT * FROM EMP 

SELECT SAL + COMM AS total FROM emp 

-- 정리문제

SELECT LENGTH(ename) FROM emp 

SELECT LENGTH(ename) FROM emp WHERE JOB = 'MANAGER' 

SELECT ename, job FROM emp WHERE COMM IS NULL 

SELECT HIREDATE FROM emp WHERE COMM IS NOT NULL 

SELECT SUBSTR(ename, 2) FROM emp  

SELECT SUBSTR(job, 1, 3) FROM emp

SELECT REPLACE(ename, 'K', 'P') FROM emp 

SELECT EMPNO || '번은 ' || ENAME || '입니다' FROM emp

SELECT TO_CHAR(HIREDATE, 'MON') AS MONTH,
TO_CHAR(HIREDATE, 'DAY') 
AS DAY FROM EMP 

SELECT job,
CASE job
	WHEN 'MANAGER' THEN 'level1'
	WHEN 'SALESMAN' THEN 'level2'
	ELSE 'level3'
END AS LEVEL_RESULT FROM emp 


SELECT count(*) FROM emp 

SELECT count(SAL), sum(SAL), AVG(SAL), MIN(SAL), MAX(SAL) 
FROM emp WHERE job = 'SALESMAN'

SELECT job, count(SAL), sum(SAL), ROUND(AVG(SAL)), MIN(SAL), MAX(SAL) 
FROM emp
GROUP BY JOB 
ORDER BY JOB DESC 

SELECT job, count(SAL), sum(SAL), ROUND(AVG(SAL)), MIN(SAL), MAX(SAL) 
FROM emp
GROUP BY JOB 
HAVING count(SAL) >= 4 --그룹을 지어서 검색 후, 필터링을 하고자 하는 경우
ORDER BY JOB DESC --모든 검색이 다 끝난 후, 그 결과를 정렬하고자 하는 경우 맨 끝

-- 문제

SELECT COUNT(*) FROM emp 

SELECT COUNT(*) FROM emp WHERE DEPTNO = 20 OR MGR <= 7700

SELECT MIN(sal) FROM emp WHERE DEPTNO = 20 OR DEPTNO = 10

SELECT MIN(sal), MAX(sal), SUM(sal) FROM emp 

SELECT AVG(sal) FROM emp GROUP BY DEPTNO  

SELECT DEPTNO, SUM(sal) FROM emp GROUP BY DEPTNO
ORDER BY DEPTNO

SELECT DEPTNO, AVG(sal) FROM emp
GROUP BY DEPTNO
HAVING AVG(SAL) >= 2000 
ORDER BY DEPTNO DESC 

SELECT COUNT(*), AVG(sal) FROM emp WHERE JOB = 'MANAGER'

SELECT COUNT(*) FROM emp WHERE ENAME LIKE '%S%'

SELECT COUNT(*) FROM EMP 
WHERE SAL >= 3000 AND COMM IS NOT NULL 
ORDER BY sal DESC 


--join: 검색을 하고 싶은데 항목들이 여러개의 테이블에 흩어져 있는 경우 테이블을 합해서 검색
--2개의 테이블의 공통된 값들만 조인해서 검색

SELECT * 
FROM BBS b, MEMBER m 
WHERE m.ID = b.WRITER 

SELECT b."no", b.TITLE, name 
FROM BBS b, MEMBER m 
WHERE m.ID = b.WRITER 

--Inner join: 테이블 간 공통된 값만 추출

SELECT EMPNO, ENAME, JOB, d.DEPTNO, loc
FROM EMP e , DEPT d 
WHERE e.DEPTNO = d.DEPTNO 

SELECT * 
FROM MEMBER m 
LEFT OUTER JOIN BBS b 
ON (m.ID = b.WRITER) 
ORDER BY b."no" 

SELECT * 
FROM MEMBER m 
RIGHT OUTER JOIN BBS b 
ON (m.ID = b.WRITER) 

--emp 전부 보임
SELECT *
FROM EMP e 
LEFT OUTER JOIN DEPT d 
ON (e.DEPTNO = d.DEPTNO)

--dept 전부 보임
SELECT *
FROM EMP e 
RIGHT OUTER JOIN DEPT d 
ON (e.DEPTNO = d.DEPTNO)

--확인문제

SELECT *
FROM "MEMBER" m , BBS b 
WHERE b.WRITER = m.ID 

SELECT m.ID , m.NAME , b.TITLE , b.CONTENT 
FROM "MEMBER" m 
LEFT OUTER JOIN BBS b 
ON (b.WRITER = m.ID)

SELECT m.ID , m.NAME , b.TITLE , b.CONTENT 
FROM "MEMBER" m 
RIGHT OUTER JOIN BBS b 
ON (b.WRITER = m.ID)


CREATE TABLE company (
	id varchar(200) PRIMARY KEY,
	name varchar(200),
	addr varchar(200),
	tel varchar(200)
)

INSERT INTO company VALUES ('c100', 'good', 'seoul', '011')

INSERT INTO company VALUES ('c200', 'joa', 'busan', '012')

INSERT INTO company VALUES ('c300', 'maria', 'ulsan', '013')

INSERT INTO company VALUES ('c400', 'my', 'kwangju', '014')

SELECT * FROM company


SELECT *
FROM PRODUCT p , COMPANY c 
WHERE p.COMPANY = c.ID 

SELECT *
FROM PRODUCT p 
LEFT OUTER JOIN COMPANY c 
ON (p.COMPANY = c.ID)

SELECT *
FROM PRODUCT p 
RIGHT OUTER JOIN COMPANY c 
ON (p.COMPANY = c.ID)

