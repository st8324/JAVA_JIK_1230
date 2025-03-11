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

# 강의명 : 프로그래밍 언어(2), 2025,학기 : 1,강의실 : KH 1관 501호, 분반 : 1, 정원 : 30,강의계획서 : 없음,교수 : 홍교수(P2000160001)
# 시간 : 월4A, 월4B, 월5A, 수4A, 수4B, 수5A

# 강의명 : 프로그래밍 언어(2), 2025,학기 : 1,강의실 : KH 1관 502호, 분반 : 2, 정원 : 30,강의계획서 : 없음,교수 : 김교수(P2000160002)
# 시간 : 월4A, 월4B, 월5A, 수4A, 수4B, 수5A

# 강의명 : 알고리즘(3), 2025,학기 : 1,강의실 : KH 1관 502호, 분반 : 1, 정원 : 30,강의계획서 : 없음,교수 : 김교수(P2000160002)
# 시간 : 목1A, 목1B, 목2A, 목2B, 목3A, 목3B

# 강의명 : 확률과 통계(4), 2025,학기 : 1,강의실 : KH 3관 501호, 분반 : 1, 정원 : 30,강의계획서 : 없음,교수 : 김교수(P2000160002)
# 시간 : 화1A, 화1B, 화2A, 금1A,금1B,금2A

# 강의명 : 미분과 적분(5), 2025,학기 : 1,강의실 : KH 3관 502호, 분반 : 1, 정원 : 30,강의계획서 : 없음,교수 : 홍교수(P2000160001)
# 시간 : 화1A, 화1B, 화2A, 금1A,금1B,금2A

# 강의명 : 영어1(6), 2025,학기 : 1,강의실 : KH 2관 501호, 분반 : 1, 정원 : 30,강의계획서 : 없음,교수 : 이교수(P2010123001)
# 시간 : 화1A, 화1B, 화2A, 금1A,금1B,금2A

# 강의명 : 음악감상(7), 2025,학기 : 1,강의실 : KH 2관 502호, 분반 : 1, 정원 : 30,강의계획서 : 없음,교수 : 최교수(P2020456001)
# 시간 : 월6A,월6B,월7A,월7B,월8A,월8B

# 강의명 : 교육학 개론(8), 2025,학기 : 1,강의실 : KH 4관 501호, 분반 : 1, 정원 : 30,강의계획서 : 없음,교수 : 최교수(P2005456001)
# 시간 : 화1A,화1B,화2A,화2B,화3A,화3B

# 강의명 : 교육 방법론(9), 2025,학기 : 1,강의실 : KH 4관 502호, 분반 : 1, 정원 : 30,강의계획서 : 없음,교수 : 박교수(P2005123001)
# 시간 : 화1A,화1B,화2A,화2B,화3A,화3B









