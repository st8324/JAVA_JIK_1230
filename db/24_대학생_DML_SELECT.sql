# 컴공 학생들의 전공 수업 강의를 조회하는 쿼리 
SELECT 
	SJ_TITLE 강의명, 
    LE_CLASS_ROOM 강의실,
    SJ_POINT 학점,
    SJ_TIME 시수,
    LE_MAX 정원,
    LE_CLASS 분반
FROM 
	LECTURE 
JOIN 
	SUBJECT ON LE_SJ_NUM = SJ_NUM
WHERE 
	SJ_SC_CODE = (SELECT DE_NUM FROM DEPARTMENT WHERE DE_NAME = "컴퓨터공학과");

# 홍교수(P2000160001)님이 강의하는 강의들을 조회하는 쿼리 
SELECT 
	SJ_TITLE, LECTURE.*
FROM 
	LECTURE 
JOIN 
	SUBJECT ON LE_SJ_NUM = SJ_NUM
WHERE 
	LE_PR_NUM = "P2000160001";

# 고길동(2025160001) 학생이 수강 신청한 목록 
SELECT 
	SUBJECT.*, LECTURE.*
FROM
    COURSE
JOIN
	LECTURE ON CO_LE_NUM = LE_NUM
JOIN
	SUBJECT ON LE_SJ_NUM = SJ_NUM
WHERE
    CO_ST_NUM = '2025160001';

# 각 강의별 현재 수강 신청한 인원수를 조회하는 쿼리 
SELECT 
    SUBJECT.*, LECTURE.*, COUNT(CO_NUM) 신청수
FROM
    LECTURE
        LEFT JOIN
    COURSE ON LE_NUM = CO_LE_NUM
        LEFT JOIN
    SUBJECT ON LE_SJ_NUM = SJ_NUM
WHERE 
	LE_YEAR = 2025 AND LE_SEMESTER = 1
GROUP BY LE_NUM ;

