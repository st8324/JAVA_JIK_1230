
# SELECT * FROM 테이블명;
# 테이블에 있는 모든 속성들의 데이터를 조회하는 쿼리 

SELECT * FROM STUDENT;

# SELECT 속성1, ..., 속성N FROM 테이블명;
# 테이블에 있는 속성1, ..., 속성N의 데이터를 조회하는 쿼리 
# 학생들의 학년, 반, 번호, 이름을 조회하는 쿼리 
# 속성명 옆에 AS 새속성명을 입력하면 결과창에 속성 이름을 변경할 수 있음 
#   - AS 생략 가능 
SELECT ST_GRADE AS 학년, ST_CLASS AS "반", ST_NUM 번호, ST_NAME "이름" FROM STUDENT;

# SELECT [DISTINCT] 속성1, ..., 속성N FROM 테이블명 [WHERE 조건식]
# 조건식을 만족하는 속성들을 조회하는 쿼리. 
# 중복된 행은 제거 => 기본키 속성을 포함하지 않은 경우 중복이 가능 
# 논리 연산자
#   - AND, OR, NOT
#   - AND의 우선순위가 OR보다 높다 
# 비교 연산자
#   - =, !=, <>, <, <=, >= 
#   - 속성 BETWEEN A AND B : A이상 B이하 => 속성 >= A AND 속성 <= B
#   - 속성 NOT BETWEEN A AND B : A미만 또는 B 초과 => 속성 < A OR 속성 > B 
#   - 속성 IN(값1, ..., 값N) : 속성의 값이 값1, ..., 값N 중에 있을 때 참 => 속성 = 값1 OR ... OR 속성 = 값N
#   - 속성 NOT IN(값1, ..., 갑N) : 속성의 값이 값1, ..., 값N 중에 없을 때 참 => 속성 != 값1 AND ... AND 속성 != 값N
#   - LIKE "패턴" : 패턴과 일치하는 값을 조회할 때 사용
#     - _ : 한 글자 
#     - % : 0글자 이상 
#     - ___ : 3글자 
#     - 홍% : 홍으로 시작하는 문자열 
#   - NULL 확인
#     - IS NULL : NULL이면 참
#     - IS NOT NULL : NULL이 아니면 참

# 등록된 학생들의 학년을 조회하는 쿼리 
SELECT DISTINCT ST_GRADE 학년 FROM STUDENT;

# 1학년 학생들을 조회하는 쿼리
SELECT * FROM STUDENT WHERE ST_GRADE = 1;

# 1학년 1반의 번호가 1 ~ 3인 학생들을 조회하는 쿼리 
SELECT * FROM STUDENT WHERE ST_NUM BETWEEN 1 AND 3 AND ST_CLASS = 1 AND ST_GRADE = 1;
SELECT * FROM STUDENT WHERE ST_NUM IN(1,2,3) AND ST_CLASS = 1 AND ST_GRADE = 1;

# 성이 홍씨인 학생들을 조회하는 쿼리 
SELECT * FROM STUDENT WHERE ST_NAME LIKE "홍%";
SELECT * FROM STUDENT WHERE ST_NAME LIKE CONCAT("홍", "%");
# 이름에 길이 들어가는 학생들을 조회하는 쿼리 
SELECT * FROM STUDENT WHERE ST_NAME LIKE "%길%";
# 성이 홍씨이고 이름이 3글자인 학생들을 조회하는 쿼리 
SELECT * FROM STUDENT WHERE ST_NAME LIKE "홍__";
# 성이 홍씨가 아닌 학생들을 조회하는 쿼리 
SELECT * FROM STUDENT WHERE ST_NAME NOT LIKE "홍%";
/*
정렬하는 쿼리 
SELECT [DISTINCT]
	속성1, ..., 속성N
FROM 
	테이블명 
[WHERE
	조건]
[ORDER BY 속성A [ASC | DESC] [,속성B [ASC | DESC]]]

ASC  : 오름차순, 생략하면 기본 ASC 
DESC : 내림차순
*/
# 3학년, 2학년, 1학년 순으로 조회하고 학년이 같은 경우 1반 , 2반 순으로 조회하고, 반이 같은 경우 1번, 2번 순으로 조회하는 쿼리
SELECT * FROM STUDENT ORDER BY ST_GRADE DESC, ST_CLASS, ST_NUM;

# 3학년 학생들을 이름을 사전순으로 정렬하고, 이름이 같으면 반, 번호 순으로 오름차순으로 정렬하는 쿼리 
SELECT * FROM STUDENT WHERE ST_GRADE = 3 ORDER BY ST_NAME, ST_CLASS, ST_NUM;

# 3학년 학생중 번호가 2에 가까운 학생 순으로 정렬 
SELECT *, ABS(ST_NUM - 2) AS NUM FROM STUDENT WHERE ST_GRADE = 3 ORDER BY NUM, ST_NUM;

/*
결과에서 원하는 개수를 가져오는 쿼리 
SELECT [DISTINCT]
	속성1, ..., 속성N
FROM 
	테이블명 
[WHERE
	조건]
[ORDER BY 속성A [ASC | DESC] [,속성B [ASC | DESC]]]
[LIMIT [번지,] 개수]
- 검색 결과에서 번지부터 개수만큼 가져옴
- 번지는 0번지부터.
- 번지를 생략할 수 있고, 생략하면 0번지 
*/
SELECT * FROM STUDENT LIMIT 3;
SELECT * FROM STUDENT LIMIT 0, 3;
SELECT * FROM STUDENT LIMIT 8, 3; # 8번지부터 3개

# 한 페이지에 학생 3명의 정보를 조회하는 페이지가 있고, 학생 등록순으로 조회를 한다. 
# 이 때 3페이지에서 조회 가능한 학생들을 선택하는 쿼리 
SELECT * FROM STUDENT LIMIT 6, 3; # 6=>3명 * (3페이지 - 1), 3=> 3명

/*
그룹화
SELECT [DISTINCT]
	속성1, ..., 속성N
FROM 
	테이블명 
[WHERE
	조건]
[GROUP BY 속성1 [, 속성2, ...]]
[HAVING 조건]
[ORDER BY 속성A [ASC | DESC] [,속성B [ASC | DESC]]]
[LIMIT [번지,] 개수]
 - 결과들을 그룹으로 묶어서 처리할 때 사용
   - 1학년 1반 학생수는?
   - 각학년별 각반의 학생수는?
   - 각학년의 학생수는?
 - 보통 집계함수와 함께 사용 
 - GROUP BY는 묶는 기준
   - 학년, 반을 기준으로 묶음 
   - 학년, 반을 기준으로 묶음 
   - 학년을 기준으로 묶음 
 - HAVING절은 집계함수에 조건을 걸때 사용 
 
집계함수 
 - COUNT(속성) : 결과의 개수를 셈 => 속성의 값이 NULL이 아닌 개수를 셈
 - SUM(속성) : 속성의 합 
 - AVG(속성) : 속성의 평균 
 - MIN(속성) : 속성의 최소값
 - MAX(속성) : 속성의 최대값 
*/ 
# 1학년 1반의 학생수를 조회 
SELECT COUNT(*) AS "1학년 1반 학생 수" FROM STUDENT.STUDENT WHERE ST_GRADE=1 AND ST_CLASS = 1;

# 각학년 각반의 학생수를 조회 
SELECT ST_GRADE, ST_CLASS, COUNT(*) AS "학생수" FROM STUDENT.STUDENT GROUP BY ST_GRADE, ST_CLASS;

# 각학년별 학생수를 조회 
SELECT ST_GRADE, COUNT(*) AS "학생수" FROM STUDENT.STUDENT GROUP BY ST_GRADE;

# 학생수가 5명 이상인 학년들을 조회 
SELECT ST_GRADE, COUNT(*) AS `학생 수` FROM STUDENT.STUDENT GROUP BY ST_GRADE HAVING `학생 수` >= 5;

# GROUP BY가 있는 쿼리에서 조건이 필요하면 무조건 HAVING절에 써야 한다 : X 
# 조건에 집계함수가 없으면 WHERE절, 있으면 HAVING절 

/*
JOIN 
- 여러 테이블을 묶어서 하나의 결과 테이블을 만들 때 사용 
INNER JOIN
 - 두 테이블의 교집합 
 - 성적이 등록된 학생들의 과목 성적을 조회 
   => 성적이 등록되지 않은 학생들은 조회 X
   => 성적이 등록되지 않은 과목들은 조회 X
OUTER JOIN
 - 두 테이블의 합집합 
 - 모든 과목의 성적들을 조회 
   => 성적이 등록되지 않은 과목들은 조회 O 
   => 성적이 등록되지 않은 학생들은 조회 X
 - 모든 학생들의 과목 성적들을 조회
   => 성적이 등록되지 않은 과목들은 조회 X 
   => 성적이 등록되지 않은 학생들은 조회 O
SELF JOIN
  - 하나의 테이블로 JOIN
*/

/*
- 테이블A가 테이블B에 참조되고 있으면 테이블B에는 외래키, 테이블 A에는 기본키로 연결이 되어 있있을 때 JOIN을 사용 
  => 학생테이블이 성적테이블에 참조되고 있으면 성적테이블의 외래키로 SC_ST_KEY, 학생 테이블 ST_KEY로 연결이 되어 있음 
INNER JOIN 

SELECT 테이블A.속성1, 테이블A.속성2, ..., 테이블B.속성1, 테이블B.속성2 
FROM
	테이블A
JOIN 
	테이블B ON 테이블A.기본키 = 테이블B.외래키 
 - 속성명이 겹치지 않으면 테이블명을 쓰지 않아도 됨 
*/
# 등록된 모든 학생들의 성적을 조회하는 쿼리 
SELECT 
    ST_GRADE 학년, ST_CLASS 반, ST_NUM 번호, ST_NAME 이름,
    SJ_GRADE 학년, SJ_SEMESTER 학기, SJ_NAME 과목명, SC_SCORE 성적
FROM
    SCORE
JOIN
	STUDENT ON ST_KEY = SC_ST_KEY
JOIN
	SUBJECT ON SC_SJ_NUM = SJ_NUM;
# 뷰를 이용한 쿼리 재사용 
# 뷰는 미리 정의된 쿼리를 이용해서 마치 일반 테이블처럼 사용하는 가상의 테이블
# 뷰의 장점. 1. 재사용 2. 가독성 3. 쿼리 단순화 4. 보안 강화 => 특정 컬럼이나 데이터만 보여줄수 있음 
/*
CREATE VIEW 뷰명 AS SELECT쿼리문;
*/
DROP VIEW STUDENT_SCORE;
CREATE VIEW STUDENT_SCORE AS 
	SELECT 
		ST_GRADE 학년, ST_CLASS 반, ST_NUM 번호, ST_NAME 이름,
		SJ_GRADE 과목학년, SJ_SEMESTER 학기, SJ_NAME 과목명, SC_SCORE 성적,
        ST_KEY 학생번호
	FROM
		SCORE
	JOIN
		STUDENT ON ST_KEY = SC_ST_KEY
	JOIN
		SUBJECT ON SC_SJ_NUM = SJ_NUM;

# 1학년의 1학년 1학기 국어 성적을 조회하는 쿼리 
SELECT * FROM STUDENT_SCORE WHERE 학년 = 1 AND 과목학년 = 1 AND 학기 = 1 AND 과목명 = "국어";

# 1학년의 1학년 1학기 국어 성적의 평균을 조회하는 쿼리 
SELECT 학년, 과목학년, 학기, 과목명, AVG(성적) 평균 FROM STUDENT_SCORE WHERE 학년 = 1 AND 과목학년 = 1 AND 학기 = 1 AND 과목명 = "국어";

# 2학년의 1학년 2학기 국어 성적의 평균을 각 반별로 조회하는 쿼리 
SELECT 
	학년, 반, 과목학년, 학기, 과목명, AVG(성적) 평균 
FROM 
	STUDENT_SCORE 
WHERE 
	학년 = 2 AND 과목학년 = 1 AND 학기 = 2 AND 과목명 = "국어"
GROUP BY 반;

# 각 학생별 평균(학년, 학기별)을 조회 하는 쿼리
SELECT 학년, 반, 번호, 이름, 과목학년, 학기, AVG(성적) 평균 FROM STUDENT_SCORE 
GROUP BY 학생번호, 과목학년, 학기;

# 각 학생의 학년별 평균을 조회하는 쿼리
SELECT 학년, 반, 번호, 이름, 과목학년, AVG(성적) 평균 FROM STUDENT_SCORE 
GROUP BY 학생번호, 과목학년;

# 각 학생의 1학년 평균이 가장 높은 학생을 조회하는 쿼리 
SELECT 학년, 반, 번호, 이름, 과목학년, AVG(성적) 평균 FROM STUDENT_SCORE 
WHERE 과목학년 = 1
GROUP BY 학생번호, 과목학년
ORDER BY 평균 DESC
LIMIT 1;

/*
OUTER 조인 
SELECT 속성, ... 
FROM 테이블A 
LEFT | RIGHT JOIN 테이블 B ON 테이블A.속성1 = 테이블B.속성2 
  - OUTER 조인은 순서가 중요 
  - 왼쪽 테이블을 기준으로 연결 
*/
# 모든 과목의 평균을 조회하는 쿼리 
SELECT SUBJECT.*, IFNULL(AVG(SC_SCORE), 0) 평균
FROM 
	SUBJECT
LEFT JOIN
	SCORE ON SJ_NUM = SC_SJ_NUM
GROUP BY SJ_NUM;
SELECT SUBJECT.*, IFNULL(AVG(SC_SCORE), 0) 평균
FROM 
	SCORE
RIGHT JOIN
	SUBJECT ON SJ_NUM = SC_SJ_NUM
GROUP BY SJ_NUM;

# 모든 학생의  학생 평균을 조회하는 쿼리. 성적이 없는 경우는 0이 나오도록 처리. 
SELECT STUDENT.*, IFNULL(AVG(SC_SCORE), 0) 평균
FROM STUDENT
LEFT JOIN SCORE ON SC_ST_KEY = ST_KEY
GROUP BY ST_KEY;

# 등록된 학생수를 조회하는 쿼리 
SELECT COUNT(*) 전체학생수 FROM STUDENT;

# 크로스 조인 : 모든 경우의 수를 조합하여 합치는 조인 
SELECT * FROM STUDENT JOIN SUBJECT;

# JOIN USING : 테이블B의 외래키와 테이블A의 외래키가 같은 경우(속성이름이) 
/*
SELECT * FROM 테이블A JOIN 테이블B ON 테이블B.속성1 = 테이블A.속성1;
SELECT * FROM 테이블A JOIN 테이블B USING(속성1);
*/

# 서브 쿼리 : 쿼리 안에 쿼리가 들어가는 형태 
# 장점 
# 1. 쿼리의 구조화 
# 2. JOIN보다 가독성이 좋음 
# 3. 속도를 향상 시킬 수 있음 
#   홍길동이라는 사람이 KH 학원에 다니는 아들을 찾으러 왔음 
#   일반 JOIN : 모든 강의장에 있는 학생들 중에 성이 홍씨인 남자를 찾고, 그중에 아들을 찾음 
#   서브쿼리 : 각 강의장에서 성이 홍씨고 남자인 학생들을 찾고, 그중에서 아들을 찾음 
# 서브쿼리 적용 위치
# 1. SELECT문에서 속성 위치 
# 2. SELECT문에서 FROM 다음에 나오는 테이블명 위치 
# 3. SELECT문에서 WHERE절에서 특정 값 위치 
# 4. SELECT문에서 HAVING절에서 특정 값 위치 
# 5. INSERT SELECT
# 6. UPDATE문에서 수정할 값 위치 

# 내장함수 - 조건 
# IF(식, 식1, 식2) : 식이 참이면 식1을, 거짓을 식2를 반환 
# IFNULL(식1, 식2) : 식1이 NULL이면 식2를, 아니면 식1을 반환 
# NULLIF(식1, 식2) : 식1과 식2가 같으면 NULL, 다르면 식1을 반환
# CASE 속성 WHEN 값 THEN 결과 ELSE 결과 END
# CASE 속성
# 	WHEN 값1	THEN 
# 		결과1 
# 	WHEN 값2	THEN 
# 		결과2 
#	ELSE
#		값3
# END 

# 성적이 60이상이면 O, 60미만이면 X라고 출력하는 쿼리 
SELECT *, IF(SC_SCORE >= 60, "O", "X") AS 통과 FROM SCORE;

# 성적이 60이상이면 O, 60미만이면 X라고 출력하는 쿼리 
SELECT *, CASE WHEN SC_SCORE >= 60 THEN "O" ELSE "X" END AS 통과 FROM SCORE;

# 성적이 90이상이면 A, 80이상이면 B, 70이상이면 C, 60이상이면 D, 60미만이면 F로 출력하는 쿼리 
SELECT *, 
	IF(SC_SCORE >= 90, "A", 
		IF(SC_SCORE >= 80, "B",
			IF(SC_SCORE >= 70, "C",
				IF(SC_SCORE >= 60, "D", "F")))) AS 학점 FROM SCORE;

SELECT *,
	CASE 
		WHEN SC_SCORE >= 90 THEN "A" 
        WHEN SC_SCORE >= 80 THEN "B" 
        WHEN SC_SCORE >= 70 THEN "C" 
        WHEN SC_SCORE >= 60 THEN "D" 
		ELSE "F"
	END AS 학점
FROM SCORE;

# 성적이 최고성적과 같으면 NULL, 다르면 성적을 출력하는 쿼리
SELECT *, NULLIF(SC_SCORE, (SELECT MAX(SC_SCORE) FROM SCORE)) AS 결과 FROM SCORE;

# GROUP BY 할 때 GROUP BY에 사용한 속성이 아닌 속성을 조회하는 경우 에러가 발생하는데 이를 해결하는 쿼리 
SET GLOBAL sql_mode = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION';
# 원상 복구하는 쿼리
SET GLOBAL sql_mode = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION,ONLY_FULL_GROUP_BY';

# 각 학생별 평균을 조회하는 쿼리 
SELECT ST_GRADE 학년, ST_CLASS 반, ST_NUM 번호, ST_NAME 이름, IFNULL(AVG(SC_SCORE), 0) 평균
FROM SCORE
RIGHT JOIN STUDENT ON SC_ST_KEY = ST_KEY
GROUP BY ST_KEY;

# 1학년 1반 반 등수를 조회는 쿼리(평균). 
# 평균이 같으면 국어, 영어, 수학 점수 순으로 비교하여 등수를 결정. 다 같으면 같은 등수 
# 같은 등수는 나오는 경우, 다음 등수는 같은 등수 수만큼 건너 뜀 
SELECT RANK() OVER(ORDER BY 평균 DESC, 국어평균 DESC, 영어평균 DESC, 수학평균 DESC ) 순위, T.*
FROM 
	(SELECT 
		ST_GRADE 학년, 
        ST_CLASS 반, 
        ST_NUM 번호, 
        ST_NAME 이름, 
        IFNULL(AVG(SC_SCORE), 0) 평균,
        AVG(CASE WHEN SJ_NAME = '국어' THEN SC_SCORE END) 국어평균, 
        AVG(CASE WHEN SJ_NAME = '수학' THEN SC_SCORE END) 수학평균, 
        AVG(CASE WHEN SJ_NAME = '영어' THEN SC_SCORE END) 영어평균
	FROM 
		SCORE
	JOIN 
		SUBJECT ON SC_SJ_NUM = SJ_NUM
	RIGHT JOIN 
		STUDENT ON SC_ST_KEY = ST_KEY
	WHERE 
		ST_GRADE = 1 AND ST_CLASS = 1
	GROUP BY ST_KEY) AS T;

# 2학년 등수를 조회는 쿼리(평균). 
SELECT RANK() OVER(ORDER BY 평균 DESC) 순위, T.*
FROM 
	(SELECT ST_GRADE 학년, ST_CLASS 반, ST_NUM 번호, ST_NAME 이름, IFNULL(AVG(SC_SCORE), 0) 평균
		FROM SCORE
		RIGHT JOIN STUDENT ON SC_ST_KEY = ST_KEY
        WHERE ST_GRADE = 2
		GROUP BY ST_KEY) AS T;

# 2학년들의 1학년 성적 평균을 이용하여 반 등수를 조회하는 쿼리 
SELECT 
	RANK() OVER(ORDER BY 반평균 DESC) 반등수, T.*
FROM
	(
	SELECT 
		학년, 반, AVG(학생평균) 반평균
	FROM 
		(SELECT 
			ST_GRADE 학년,
			ST_CLASS 반,
			ST_KEY, 
			IFNULL(AVG(SC_SCORE), 0) 학생평균
		FROM 
			SCORE 
		RIGHT JOIN 
			STUDENT ON ST_KEY = SC_ST_KEY
		GROUP BY 
			ST_KEY
		) AS T
	WHERE 
		학년 = 2
	GROUP BY
		학년, 반) AS T;

SELECT 
	RANK() OVER(ORDER BY 반평균 DESC) 반등수, T.*
FROM
	(
	SELECT 
		ST_GRADE 학년, ST_CLASS 반, IFNULL(AVG(SC_SCORE), 0) 반평균
	FROM 
		SCORE 
	RIGHT JOIN
		STUDENT ON SC_ST_KEY = ST_KEY
	WHERE 
		ST_GRADE = 3
	GROUP BY
		ST_GRADE, ST_CLASS) AS T;


