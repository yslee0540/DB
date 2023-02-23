-- 테이블명 + 항목명 + 항목에 들어가는 데이터타입

CREATE TABLE member2 (
	id varchar2(100),
	pw varchar2(100),
	name varchar2(100),
	tel varchar2(100)
)

CREATE TABLE bbs2 (
	id varchar2(100),
	title varchar2(100),
	content varchar2(100),
	writer varchar2(100)
)

CREATE TABLE product2 (
	NO varchar2(100),
	name varchar2(100),
	content varchar2(100),
	price number(10,0)
)

CREATE TABLE "HR"."MEMBER3" 
   ( "ID" VARCHAR2(100), 
	"PW" VARCHAR2(100), 
	"NAME" VARCHAR2(100), 
	"TEL" VARCHAR2(100)
   )

INSERT INTO "member" VALUES ('park', '1234', 'park', '011')

INSERT INTO "member" VALUES ('apple', '1111', 'apple', '011')

INSERT INTO "member" VALUES ('ice', '2222', 'ice', '012')

INSERT INTO "member" VALUES ('melon', '3333', 'melon', '013')


SELECT * FROM "member" -- 모든 컬럼

SELECT id FROM "member"

SELECT id, pw FROM "member"
