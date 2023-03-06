INSERT INTO STUDENT_INFORMATION VALUES (502, '추신수', '미국 클리브랜드', '컴퓨터과')

INSERT INTO "record" VALUES (502, '자료구조', 4.0)

UPDATE STUDENT_INFORMATION SET 주소 = '대한민국 서울' WHERE 학생번호 = 501

SELECT si.학생번호 , si.학생이름 , si.주소 , si.학과 , d.학과사무실
FROM STUDENT_INFORMATION si , DEPARTMENT d
WHERE si.학과 = d.학과

SELECT s.강좌이름, s.강의실 , r.성적 
FROM "record" r , SUBJECT s 
WHERE r.강좌이름 = s.강좌이름

SELECT si.학생번호 , si.학생이름 , si.주소 , si.학과 , d.학과사무실 , s.강좌이름, s.강의실 , r.성적 
FROM STUDENT_INFORMATION si , DEPARTMENT d , "record" r , SUBJECT s 
WHERE si.학과 = d.학과 AND si.학생번호 = r.학생번호 AND r.강좌이름 = s.강좌이름

SELECT * FROM STUDENT_INFORMATION si
WHERE 학생번호 IN 
(SELECT 학생번호 FROM "record" r WHERE 성적 = 3.5)

SELECT * FROM "record"
WHERE 강좌이름 = 
(SELECT 강좌이름 FROM SUBJECT s WHERE 강의실 = '공학관 110')


INSERT INTO CHANNEL VALUES ('tvN', 90000, 10000)

UPDATE VIDEO SET 조회수 = 5000000 WHERE 카테고리 = '음악'

SELECT v.제목 , v.조회수 , v.카테고리 , c.채널명 , c.구독자수 , c.동영상수 
FROM VIDEO v , CHANNEL c 
WHERE v.채널명 = c.채널명 AND v.카테고리 = '예능'

SELECT *
FROM YOUTUBE_MEMBER ym
INNER JOIN CHANNEL c 
ON ym.구독채널명 = c.채널명 

