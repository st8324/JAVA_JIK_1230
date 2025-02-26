
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





