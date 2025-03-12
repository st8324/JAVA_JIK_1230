# 컴퓨터공학과를 등록. 학과코드 COM, 학과 코드 번호 160, 사무실 KH 1관 401호를 등록하는 쿼리 
INSERT INTO DEPARTMENT VALUE("COM", "컴퓨터공학과", "사무실 KH 1관 401호", 160, NULL);
# 디자인공학과를 등록. 학과코드 DEG, 학과 코드 번호 123, 사무실 KH 3관 101호를 등록하는 쿼리 
INSERT INTO DEPARTMENT VALUE("DEG", "디자인공학과", "사무실 KH 3관 101호", 123, NULL);
# 기계공학과를 등록. 학과코드 MEC, 학과 코드 번호 456, 사무실 KH 4관 201호를 등록하는 쿼리 
INSERT INTO DEPARTMENT VALUE("MEC", "기계공학과", "사무실 KH 4관 201호", 456, NULL);

#교수를 등록. 이름 홍교수, 연락처 012-1234-5678, 주민번호 601111-1, 취임연도 2000. 컴퓨터공학과
INSERT INTO PROFESSOR 
SELECT 
	CONCAT("P", 2000, DE_NAME_NUM, LPAD(COUNT(PR_NUM) + 1, 3, "0")), 
	"홍교수", "012-1234-5678", "601111-1", 2000, DE_NUM
FROM 
	(SELECT * FROM PROFESSOR WHERE PR_YEAR = 2000) P
RIGHT JOIN 
	DEPARTMENT ON DE_NUM = PR_DE_NUM
WHERE 
	DE_NAME = "컴퓨터공학과";
#교수를 등록. 이름 김교수, 연락처 012-1111-5555, 주민번호 630101-2, 취임연도 2000. 컴퓨터공학과
INSERT INTO PROFESSOR 
SELECT 
	CONCAT("P", 2000, 160, LPAD(COUNT(PR_NUM) + 1, 3, "0")), 
	"김교수", "012-1111-5555", "630101-2", 2000, "COM"
FROM 
	PROFESSOR
WHERE 
	PR_YEAR = 2000;
#교수를 등록. 이름 박교수, 연락처 012-7788-4455, 주민번호 670331-1, 취임연도 2005. 디자인공학과 
INSERT INTO PROFESSOR 
SELECT 
	CONCAT("P", 2005, DE_NAME_NUM, LPAD(COUNT(PR_NUM) + 1, 3, "0")), 
	"박교수", "012-7788-4455", "670331-1", 2005, DE_NUM
FROM 
	(SELECT * FROM PROFESSOR WHERE PR_YEAR = 2005) P
RIGHT JOIN 
	DEPARTMENT ON DE_NUM = PR_DE_NUM
WHERE 
	DE_NAME = "디자인공학과";
#교수를 등록. 이름 이교수, 연락처 012-7781-4451, 주민번호 701231-2, 취임연도 2010. 디자인공학과 
INSERT INTO PROFESSOR 
SELECT 
	CONCAT("P", 2010, DE_NAME_NUM, LPAD(COUNT(PR_NUM) + 1, 3, "0")), 
	"이교수", "012-7781-4451", "701231-2", 2010, DE_NUM
FROM 
	(SELECT * FROM PROFESSOR WHERE PR_YEAR = 2010) P
RIGHT JOIN 
	DEPARTMENT ON DE_NUM = PR_DE_NUM
WHERE 
	DE_NAME = "디자인공학과";
#교수를 등록. 이름 최교수, 연락처 012-3333-4444, 주민번호 650101-1, 취임연도 2005. 기계공학과 
INSERT INTO PROFESSOR 
SELECT 
	CONCAT("P", 2005, DE_NAME_NUM, LPAD(COUNT(PR_NUM) + 1, 3, "0")), 
	"최교수", "012-3333-4444", "650101-1", 2005, DE_NUM
FROM 
	(SELECT * FROM PROFESSOR WHERE PR_YEAR = 2005) P
RIGHT JOIN 
	DEPARTMENT ON DE_NUM = PR_DE_NUM
WHERE 
	DE_NAME = "기계공학과";
#교수를 등록. 이름 최교수, 연락처 012-4567-4444, 주민번호 750101-1, 취임연도 2020. 기계공학과 
INSERT INTO PROFESSOR 
SELECT 
	CONCAT("P", 2020, DE_NAME_NUM, LPAD(COUNT(PR_NUM) + 1, 3, "0")), 
	"최교수", "012-4567-4444", "750101-1", 2020, DE_NUM
FROM 
	(SELECT * FROM PROFESSOR WHERE PR_YEAR = 2020) P
RIGHT JOIN 
	DEPARTMENT ON DE_NUM = PR_DE_NUM
WHERE 
	DE_NAME = "기계공학과";
    
# 최종 합격 명단
# 이름 홍길동, 연락처 013-1234-5678, 입학연도 2025, 주민번호 060303-3, 컴퓨터공학과
# 이름 고길동, 연락처 013-1111-1111, 입학연도 2025, 주민번호 060401-3, 컴퓨터공학과
# 이름 김길동, 연락처 013-1111-2222, 입학연도 2025, 주민번호 060505-3, 컴퓨터공학과
# 이름 하니, 연락처 013-1111-3333, 입학연도 2025, 주민번호 060606-4, 컴퓨터공학과
INSERT INTO FINAL_PASS(FP_NAME, FP_PHONE, FP_YEAR, FP_RES_NUM, FP_DE_NUM) VALUES
("홍길동","013-1234-5678", 2025, "060303-3", "COM"),
("고길동","013-1111-1111", 2025, "060401-3", "COM"),
("김길동","013-1111-2222", 2025, "060505-3", "COM"),
("하니","013-1111-3333", 2025, "060606-4", "COM"),
# 이름 나애리, 연락처 013-1111-4444, 입학연도 2025, 주민번호 060625-4, 디자인공학과
# 이름 오영심, 연락처 013-1111-5555, 입학연도 2025, 주민번호 060717-4, 디자인공학과
# 이름 오두리, 연락처 013-1111-6666, 입학연도 2025, 주민번호 060815-4, 디자인공학과
# 이름 전지현, 연락처 013-1111-7777, 입학연도 2025, 주민번호 051003-4, 디자인공학과
("나애리","013-1111-4444", 2025, "060625-4", "DEG"),
("오영심","013-1111-5555", 2025, "060717-4", "DEG"),
("오두리","013-1111-6666", 2025, "060815-4", "DEG"),
("전지현","013-1111-7777", 2025, "051003-4", "DEG"),
# 이름 김둘리, 연락처 013-1111-8888, 입학연도 2025, 주민번호 061224-3, 기계공학과
# 이름 김군, 연락처 013-1111-9999, 입학연도 2025, 주민번호 070101-3, 기계공학과
# 이름 박명수, 연락처 013-1111-0000, 입학연도 2025, 주민번호 060405-3, 기계공학과
# 이름 유재석, 연락처 013-1111-1234, 입학연도 2025, 주민번호 061009-3, 기계공학과
("김둘리","013-1111-8888", 2025, "061224-3", "MEC"),
("김군","013-1111-9999", 2025, "070101-3", "MEC"),
("박명수","013-1111-0000", 2025, "060405-3", "MEC"),
("유재석","013-1111-1234", 2025, "061009-3", "MEC");

# 최종 합격한 컴퓨터공학과 학생들을 학생으로 등록하는 쿼리 
INSERT INTO STUDENT
SELECT 
	CONCAT(FP_YEAR, DE_NAME_NUM, LPAD(RANK() OVER(ORDER BY FP_NAME, FP_RES_NUM) , 3, "0")) AS ST_NUM,
	FP_NAME, 
    FP_RES_NUM, 
    FP_PHONE, 
    FP_YEAR ,
    DE_NUM,
    NULL
FROM 
	FINAL_PASS 
JOIN
	DEPARTMENT ON FP_DE_NUM = DE_NUM
WHERE 
	FP_DE_NUM = "COM" AND FP_YEAR = YEAR(NOW());
# 최종 합격한 디자인공학과 학생들을 학생으로 등록하는 쿼리 
INSERT INTO STUDENT
SELECT 
	CONCAT(FP_YEAR, DE_NAME_NUM, LPAD(RANK() OVER(ORDER BY FP_NAME, FP_RES_NUM) , 3, "0")) AS ST_NUM,
	FP_NAME, 
    FP_RES_NUM, 
    FP_PHONE, 
    FP_YEAR ,
    DE_NUM,
    NULL
FROM 
	FINAL_PASS 
JOIN
	DEPARTMENT ON FP_DE_NUM = DE_NUM
WHERE 
	DE_NAME = "디자인공학과" AND FP_YEAR = YEAR(NOW());
# 최종 합격한 기계공학과 학생들을 학생으로 등록하는 쿼리 
INSERT INTO STUDENT
SELECT 
	CONCAT(FP_YEAR, DE_NAME_NUM, LPAD(RANK() OVER(ORDER BY FP_NAME, FP_RES_NUM) , 3, "0")) AS ST_NUM,
	FP_NAME, 
    FP_RES_NUM, 
    FP_PHONE, 
    FP_YEAR ,
    DE_NUM,
    NULL
FROM 
	FINAL_PASS 
JOIN
	DEPARTMENT ON FP_DE_NUM = DE_NUM
WHERE 
	DE_NAME = "기계공학과" AND FP_YEAR = YEAR(NOW());

# 과목 분류를 등록하는 쿼리 
# 학과코드 등록
INSERT INTO SUBJECT_CATEGORY SELECT DE_NUM FROM DEPARTMENT;
# 교직(TEA), 교양(CUL), 기본(MSC) 등록
INSERT INTO SUBJECT_CATEGORY VALUES("TEA"), ("CUL"), ("MSC");

# 과목을 등록하는 쿼리. 
# 과목명 : 컴퓨터 개론, 학점 : 2, 시간 : 2, 분류 : COM, 과목코드 : COM001
# 과목명 : 프로그래밍 언어, 학점 : 3, 시간 : 3, 분류 : COM, 과목코드 : COM002
# 과목명 : 알고리즘, 학점 : 3, 시간 : 3, 분류 : COM, 과목코드 : COM003
INSERT INTO SUBJECT(SJ_TITLE, SJ_POINT, SJ_TIME, SJ_CODE, SJ_SC_CODE)
SELECT "컴퓨터 개론", 2, 2, CONCAT("COM", LPAD(COUNT(*) + 1, 3, "0")), "COM"  FROM SUBJECT WHERE SJ_SC_CODE = "COM";
INSERT INTO SUBJECT(SJ_TITLE, SJ_POINT, SJ_TIME, SJ_CODE, SJ_SC_CODE)
SELECT "프로그래밍 언어", 3, 3, CONCAT("COM", LPAD(COUNT(*) + 1, 3, "0")), "COM"  FROM SUBJECT WHERE SJ_SC_CODE = "COM";
INSERT INTO SUBJECT(SJ_TITLE, SJ_POINT, SJ_TIME, SJ_CODE, SJ_SC_CODE)
SELECT "알고리즘", 3, 3, CONCAT("COM", LPAD(COUNT(*) + 1, 3, "0")), "COM"  FROM SUBJECT WHERE SJ_SC_CODE = "COM";

# 과목명 : 확률과 통계, 학점 : 3, 시간 : 3, 분류 : MSC, 과목코드 : MSC001
# 과목명 : 미분과 적분, 학점 : 4, 시간 : 4, 분류 : MSC, 과목코드 : MSC002
INSERT INTO SUBJECT(SJ_TITLE, SJ_POINT, SJ_TIME, SJ_CODE, SJ_SC_CODE)
SELECT "확률과 통계", 3, 3, CONCAT("MSC", LPAD(COUNT(*) + 1, 3, "0")), "MSC"  FROM SUBJECT WHERE SJ_SC_CODE = "MSC";
INSERT INTO SUBJECT(SJ_TITLE, SJ_POINT, SJ_TIME, SJ_CODE, SJ_SC_CODE)
SELECT "미분과 적분", 4, 4, CONCAT("MSC", LPAD(COUNT(*) + 1, 3, "0")), "MSC"  FROM SUBJECT WHERE SJ_SC_CODE = "MSC";


# 과목명 : 영어1, 학점 : 3, 시간 : 3, 분류 : CUL, 과목코드 : CUL001
# 과목명 : 음악과 감상, 학점 : 2, 시간 : 2, 분류 : CUL, 과목코드 : CUL002
INSERT INTO SUBJECT(SJ_TITLE, SJ_POINT, SJ_TIME, SJ_CODE, SJ_SC_CODE)
SELECT "영어1", 3, 3, CONCAT("CUL", LPAD(COUNT(*) + 1, 3, "0")), "CUL"  FROM SUBJECT WHERE SJ_SC_CODE = "CUL";
INSERT INTO SUBJECT(SJ_TITLE, SJ_POINT, SJ_TIME, SJ_CODE, SJ_SC_CODE)
SELECT "음악과 감상", 2, 2, CONCAT("CUL", LPAD(COUNT(*) + 1, 3, "0")), "CUL"  FROM SUBJECT WHERE SJ_SC_CODE = "CUL";

# 과목명 : 교육학 개론, 학점 : 2, 시간 : 3, 분류 : TEA, 과목코드 : TEA001
# 과목명 : 교육 방법론, 학점 : 3, 시간 : 3, 분류 : TEA, 과목코드 : TEA002
INSERT INTO SUBJECT(SJ_TITLE, SJ_POINT, SJ_TIME, SJ_CODE, SJ_SC_CODE)
SELECT "교육학 개론", 2, 3, CONCAT("TEA", LPAD(COUNT(*) + 1, 3, "0")), "TEA"  FROM SUBJECT WHERE SJ_SC_CODE = "TEA";
INSERT INTO SUBJECT(SJ_TITLE, SJ_POINT, SJ_TIME, SJ_CODE, SJ_SC_CODE)
SELECT "교육 방법론", 3, 3, CONCAT("TEA", LPAD(COUNT(*) + 1, 3, "0")), "TEA"  FROM SUBJECT WHERE SJ_SC_CODE = "TEA";

# 과목명 : 디자인의 이해, 학점 : 2, 시간 : 2, 분류 : DEG, 과목코드 : DEG001
# 과목명 : 시각 디자인, 학점 : 3, 시간 : 3, 분류 : DEG, 과목코드 : DEG002
# 과목명 : 제품 디자인, 학점 : 3, 시간 : 3, 분류 : DEG, 과목코드 : DEG003
INSERT INTO SUBJECT(SJ_TITLE, SJ_POINT, SJ_TIME, SJ_CODE, SJ_SC_CODE)
SELECT "디자인의 이해", 2, 2, CONCAT("DEG", LPAD(COUNT(*) + 1, 3, "0")), "DEG"  FROM SUBJECT WHERE SJ_SC_CODE = "DEG";
INSERT INTO SUBJECT(SJ_TITLE, SJ_POINT, SJ_TIME, SJ_CODE, SJ_SC_CODE)
SELECT "시각 디자인", 3, 3, CONCAT("DEG", LPAD(COUNT(*) + 1, 3, "0")), "DEG"  FROM SUBJECT WHERE SJ_SC_CODE = "DEG";
INSERT INTO SUBJECT(SJ_TITLE, SJ_POINT, SJ_TIME, SJ_CODE, SJ_SC_CODE)
SELECT "제품 디자인", 3, 3, CONCAT("DEG", LPAD(COUNT(*) + 1, 3, "0")), "DEG"  FROM SUBJECT WHERE SJ_SC_CODE = "DEG";

# 과목명 : 프로그래밍 언어, 학점 : 3, 시간 : 3, 분류 : MEC, 과목코드 : MEC001
# 과목명 : 동역학, 학점 : 3, 시간 : 3, 분류 : MEC, 과목코드 : MEC002
# 과목명 : 기계의 이해, 학점 : 2, 시간 : 2, 분류 : MEC, 과목코드 : MEC003
INSERT INTO SUBJECT(SJ_TITLE, SJ_POINT, SJ_TIME, SJ_CODE, SJ_SC_CODE)
SELECT "프로그래밍 언어", 3, 3, CONCAT("MEC", LPAD(COUNT(*) + 1, 3, "0")), "MEC"  FROM SUBJECT WHERE SJ_SC_CODE = "MEC";
INSERT INTO SUBJECT(SJ_TITLE, SJ_POINT, SJ_TIME, SJ_CODE, SJ_SC_CODE)
SELECT "동역학", 3, 3, CONCAT("MEC", LPAD(COUNT(*) + 1, 3, "0")), "MEC"  FROM SUBJECT WHERE SJ_SC_CODE = "MEC";
INSERT INTO SUBJECT(SJ_TITLE, SJ_POINT, SJ_TIME, SJ_CODE, SJ_SC_CODE)
SELECT "기계의 이해", 2, 2, CONCAT("MEC", LPAD(COUNT(*) + 1, 3, "0")), "MEC"  FROM SUBJECT WHERE SJ_SC_CODE = "MEC";

# 강의명 : 컴퓨터 개론(1), 2025,학기 : 1,강의실 : KH 1관 501호, 분반 : 1, 정원 : 30,강의계획서 : 없음,교수 : 홍교수(P2000160001)
# 시간 : 월1A, 월1B, 월2A, 월2B
INSERT INTO LECTURE(LE_YEAR, LE_SEMESTER, LE_CLASS_ROOM, LE_CLASS, LE_MAX, LE_PLAN, LE_SJ_NUM, LE_PR_NUM) VALUES
(2025, 1, "KH 1관 501호", 1, 30, "없음", 1, "P2000160001");
INSERT INTO LECTURE_SCHEDULE(LC_DAY, LC_TIME, LC_MINUTE, LC_LE_NUM) VALUES
("월", 1, "A", 1), ("월", 1, "B", 1), ("월", 2, "A", 1), ("월", 2, "B", 1);

# 강의명 : 프로그래밍 언어(2), 2025,학기 : 1,강의실 : KH 1관 501호, 분반 : 1, 정원 : 30,강의계획서 : 없음,교수 : 홍교수(P2000160001)
# 시간 : 월4A, 월4B, 월5A, 수4A, 수4B, 수5A
INSERT INTO LECTURE(LE_YEAR, LE_SEMESTER, LE_CLASS_ROOM, LE_CLASS, LE_MAX, LE_PLAN, LE_SJ_NUM, LE_PR_NUM) VALUES
(2025, 1, "KH 1관 501호", 1, 30, "없음", 2, "P2000160001");
INSERT INTO LECTURE_SCHEDULE(LC_DAY, LC_TIME, LC_MINUTE, LC_LE_NUM) VALUES
("월", 4, "A", 2), ("월", 4, "B", 2), ("월", 5, "A", 2), 
("수", 4, "A", 2), ("수", 4, "B", 2), ("수", 5, "A", 2);

# 강의명 : 프로그래밍 언어(2), 2025,학기 : 1,강의실 : KH 1관 502호, 분반 : 2, 정원 : 30,강의계획서 : 없음,교수 : 김교수(P2000160002)
# 시간 : 월4A, 월4B, 월5A, 수4A, 수4B, 수5A
INSERT INTO LECTURE(LE_YEAR, LE_SEMESTER, LE_CLASS_ROOM, LE_CLASS, LE_MAX, LE_PLAN, LE_SJ_NUM, LE_PR_NUM) VALUES
(2025, 1, "KH 1관 502호", 1, 30, "없음", 2, "P2000160002");
INSERT INTO LECTURE_SCHEDULE(LC_DAY, LC_TIME, LC_MINUTE, LC_LE_NUM) VALUES
("월", 4, "A", 3), ("월", 4, "B", 3), ("월", 5, "A", 3), 
("수", 4, "A", 3), ("수", 4, "B", 3), ("수", 5, "A", 3);

# 강의명 : 알고리즘(3), 2025,학기 : 1,강의실 : KH 1관 502호, 분반 : 1, 정원 : 30,강의계획서 : 없음,교수 : 김교수(P2000160002)
# 시간 : 목1A, 목1B, 목2A, 목2B, 목3A, 목3B
INSERT INTO LECTURE(LE_YEAR, LE_SEMESTER, LE_CLASS_ROOM, LE_CLASS, LE_MAX, LE_PLAN, LE_SJ_NUM, LE_PR_NUM) VALUES
(2025, 1, "KH 1관 502호", 1, 30, "없음", 3, "P2000160002");
INSERT INTO LECTURE_SCHEDULE(LC_DAY, LC_TIME, LC_MINUTE, LC_LE_NUM) VALUES
("목", 1, "A", 4), ("목", 1, "B", 4), ("목", 2, "A", 4), ("목", 2, "B", 4), ("목", 3, "A", 4), ("목", 3, "B", 4);

# 강의명 : 확률과 통계(4), 2025,학기 : 1,강의실 : KH 3관 501호, 분반 : 1, 정원 : 30,강의계획서 : 없음,교수 : 김교수(P2000160002)
# 시간 : 화1A, 화1B, 화2A, 금1A,금1B,금2A
INSERT INTO LECTURE(LE_YEAR, LE_SEMESTER, LE_CLASS_ROOM, LE_CLASS, LE_MAX, LE_PLAN, LE_SJ_NUM, LE_PR_NUM) VALUES
(2025, 1, "KH 3관 501호", 1, 30, "없음", 4, "P2000160002");
INSERT INTO LECTURE_SCHEDULE(LC_DAY, LC_TIME, LC_MINUTE, LC_LE_NUM) VALUES
("화", 1, "A", 5), ("화", 1, "B", 5), ("화", 2, "A", 5), 
("금", 1, "A", 5), ("금", 1, "B", 5), ("금", 2, "A", 5);

# 강의명 : 미분과 적분(5), 2025,학기 : 1,강의실 : KH 3관 502호, 분반 : 1, 정원 : 30,강의계획서 : 없음,교수 : 홍교수(P2000160001)
# 시간 : 화1A, 화1B, 화2A, 금1A,금1B,금2A
INSERT INTO LECTURE(LE_YEAR, LE_SEMESTER, LE_CLASS_ROOM, LE_CLASS, LE_MAX, LE_PLAN, LE_SJ_NUM, LE_PR_NUM) VALUES
(2025, 1, "KH 3관 502호", 1, 30, "없음", 5, "P2000160001");
INSERT INTO LECTURE_SCHEDULE(LC_DAY, LC_TIME, LC_MINUTE, LC_LE_NUM) VALUES
("화", 1, "A", 6), ("화", 1, "B", 6), ("화", 2, "A", 6), 
("금", 1, "A", 6), ("금", 1, "B", 6), ("금", 2, "A", 6);

# 강의명 : 영어1(6), 2025,학기 : 1,강의실 : KH 2관 501호, 분반 : 1, 정원 : 30,강의계획서 : 없음,교수 : 이교수(P2010123001)
# 시간 : 화1A, 화1B, 화2A, 금1A,금1B,금2A
INSERT INTO LECTURE(LE_YEAR, LE_SEMESTER, LE_CLASS_ROOM, LE_CLASS, LE_MAX, LE_PLAN, LE_SJ_NUM, LE_PR_NUM) VALUES
(2025, 1, "KH 2관 501호", 1, 30, "없음", 6, "P2010123001");
INSERT INTO LECTURE_SCHEDULE(LC_DAY, LC_TIME, LC_MINUTE, LC_LE_NUM) VALUES
("화", 1, "A", 7), ("화", 1, "B", 7), ("화", 2, "A", 7), 
("금", 1, "A", 7), ("금", 1, "B", 7), ("금", 2, "A", 7);

# 강의명 : 음악감상(7), 2025,학기 : 1,강의실 : KH 2관 502호, 분반 : 1, 정원 : 30,강의계획서 : 없음,교수 : 최교수(P2020456001)
# 시간 : 월6A,월6B,월7A,월7B,월8A,월8B
INSERT INTO LECTURE(LE_YEAR, LE_SEMESTER, LE_CLASS_ROOM, LE_CLASS, LE_MAX, LE_PLAN, LE_SJ_NUM, LE_PR_NUM) VALUES
(2025, 1, "KH 2관 502호", 1, 30, "없음", 7, "P2020456001");
INSERT INTO LECTURE_SCHEDULE(LC_DAY, LC_TIME, LC_MINUTE, LC_LE_NUM) VALUES
("월", 6, "A", 8), ("월", 6, "B", 8), ("월", 7, "A", 8), ("월", 7, "B", 8),  ("월", 8, "A", 8), ("월", 8, "B", 8);

# 강의명 : 교육학 개론(8), 2025,학기 : 1,강의실 : KH 4관 501호, 분반 : 1, 정원 : 30,강의계획서 : 없음,교수 : 최교수(P2005456001)
# 시간 : 화1A,화1B,화2A,화2B,화3A,화3B
INSERT INTO LECTURE(LE_YEAR, LE_SEMESTER, LE_CLASS_ROOM, LE_CLASS, LE_MAX, LE_PLAN, LE_SJ_NUM, LE_PR_NUM) VALUES
(2025, 1, "KH 4관 501호", 1, 30, "없음", 8, "P2005456001");
INSERT INTO LECTURE_SCHEDULE(LC_DAY, LC_TIME, LC_MINUTE, LC_LE_NUM) VALUES
("화", 1, "A", 9), ("화", 1, "B", 9), ("화", 2, "A", 9), ("화", 2, "B", 9),  ("화", 3, "A", 9), ("화", 3, "B", 9);

# 강의명 : 교육 방법론(9), 2025,학기 : 1,강의실 : KH 4관 502호, 분반 : 1, 정원 : 30,강의계획서 : 없음,교수 : 박교수(P2005123001)
# 시간 : 화1A,화1B,화2A,화2B,화3A,화3B
INSERT INTO LECTURE(LE_YEAR, LE_SEMESTER, LE_CLASS_ROOM, LE_CLASS, LE_MAX, LE_PLAN, LE_SJ_NUM, LE_PR_NUM) VALUES
(2025, 1, "KH 4관 502호", 1, 30, "없음", 9, "P2005123001");
INSERT INTO LECTURE_SCHEDULE(LC_DAY, LC_TIME, LC_MINUTE, LC_LE_NUM) VALUES
("화", 1, "A", 10), ("화", 1, "B", 10), ("화", 2, "A", 10), ("화", 2, "B", 10),  ("화", 3, "A", 10), ("화", 3, "B", 10);

# 고길동(2025160001) 학생이 컴퓨터개론(1), 프로그래밍언어(2), 확률과 통계(5), 음악과 감상(8)을 수강 신청 했을 때 쿼리 
INSERT INTO COURSE(CO_ST_NUM, CO_LE_NUM) VALUES
("2025160001", 1), ("2025160001", 2), ("2025160001", 5), ("2025160001", 8);

# 교수님이 성적 비율을 다음과 같이 수정했을 때 필요한 쿼리
# 모든 강의의 성적 비율을 기본으로 적용하는 쿼리 
INSERT INTO LECTURE_STANDARD(LS_LE_NUM) 
SELECT LE_NUM FROM LECTURE;

# 컴퓨터개론(1)의 성적 비율 - 중간 : 45, 기말 : 45, 출석 : 10, 과제 : 0
# 프로그래밍언어(2)의 성적 비율 - 중간 : 40, 기말 : 40, 출석 : 10, 과제 : 10
UPDATE LECTURE_STANDARD 
SET
	LS_MID = 45,
    LS_FINAL = 45,
    LS_ATT = 10,
    LS_HOME = 0
WHERE
	LS_LE_NUM = 1;
UPDATE LECTURE_STANDARD 
SET
	LS_MID = 40,
    LS_FINAL = 40,
    LS_ATT = 10,
    LS_HOME = 10
WHERE
	LS_LE_NUM = 2;    

# 고길동(2025160001) 학생의 컴퓨터개론(1) 성적이 중간 100, 기말 80, 과제 0, 출석 100일때 성적을 계산하는 프로시저를
# 작성해서 실행하세요. A+ : 95이상, A : 90이상 

DROP PROCEDURE IF EXISTS INSERT_SCORE;

DELIMITER //
CREATE PROCEDURE INSERT_SCORE(
	IN _ST_NUM CHAR(10),
    IN _LE_NUM INT,
    IN _MID INT,
    IN _FINAL INT,
    IN _ATT INT,
    IN _HOME INT
)
BEGIN
	DECLARE _TOTAL INT;
    DECLARE _RES VARCHAR(4);
    SET _TOTAL = (
		SELECT 
			(_MID  * LS_MID + 
			_FINAL * LS_FINAL + 
            _ATT   * LS_ATT + 
            _HOME  * LS_HOME) / 100 
            FROM LECTURE_STANDARD WHERE LS_LE_NUM = _LE_NUM);
	IF _TOTAL >= 95 THEN SET _RES = "A+";
    ELSEIF _TOTAL >= 90 THEN SET _RES = "A";
    ELSEIF _TOTAL >= 85 THEN SET _RES = "B+";
    ELSEIF _TOTAL >= 80 THEN SET _RES = "B";
    ELSEIF _TOTAL >= 75 THEN SET _RES = "C+";
    ELSEIF _TOTAL >= 70 THEN SET _RES = "C";
    ELSEIF _TOTAL >= 65 THEN SET _RES = "D+";
    ELSEIF _TOTAL >= 60 THEN SET _RES = "D";
    ELSE SET _RES = "F";
    END IF;
    UPDATE COURSE 
    SET
		CO_MID = _MID,
        CO_FINAL = _FINAL,
        CO_ATT = _ATT,
        CO_HOME = _HOME,
        CO_TOTAL = _RES
	WHERE
		CO_ST_NUM = _ST_NUM AND CO_LE_NUM = _LE_NUM;
END //
DELIMITER ;
CALL INSERT_SCORE("2025160001", 1, 100, 80, 100,  0);



