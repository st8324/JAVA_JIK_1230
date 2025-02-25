# INSERT : 데이터 추가
# SELECT : 데이터 조회
# UPDATE : 데이터 수정
# DELETE : 데이터 삭제

# 데이터 추가
# INSERT INTO 테이블명 VALUE(값1, ..., 값N) 
#   - 값들 순서는 속성 순서에 맞게 넣어 주어야 함.  
#   - 테이블명 대신 DB명.테이블명으로 해도 됨
#   - DB명.테이블명으로 쓰면 선택된 DB와 상관없이 실행.
#   - 테이블명만 쓰면 선택된 DB에 따라 동작되지 않을 수 있음. 
USE STUDENT;
INSERT INTO STUDENT VALUE(1, 1, 1, 1, "홍길동");

# INSERT INTO 테이블명(속성1, ..., 속성N) VALUE(값1, ..., 값N)
#   - 일부 속성 값을 생략할 때 사용
#   - 생략할 수 있는 속성들
#     1. NULL 허용인 속성들 
#     2. NOT NULL이지만 DEFAULT를 이용하여 기본값을 지정한 속성들 
INSERT INTO STUDENT(ST_GRADE, ST_CLASS, ST_NUM, ST_NAME) VALUE(1, 1, 2, "임꺽정");
INSERT INTO STUDENT(ST_NUM, ST_NAME) VALUE(3, "고길동");

# INSERT INTO 테이블명(속성1, ..., 속성N) VALUES(값1, ..., 값N), (값1, ..., 값N), ...; 
INSERT INTO STUDENT(ST_NUM, ST_NAME) VALUES(4, "둘리"), (5, "하니");

# INSERT INTO 테이블명(속성1, ..., 속성N) SELECT 값1, 값2, ..., 속성A FROM 테이블명 WHERE 조건
#   - 테이블에서 검색된 값을 이용하여 추가할 때 사용 
#   - 여기서 값1, 값2.. 들은 지정된 값이고, 속성A는 검색 결과 값 


# 데이터 수정
# UPDATE 테이블명 SET 속성1 = 값1, ..., 속성N = 값N WHERE 조건 
# 조건에서 같다는 =, 같지 않다는 != 또는 <> 
# NULL과 같다는 IS NULL, NULL과 같지 않다는 IS NOT NULL 
# 1학년 1반 1번 학생의 이름을 홍길동A로 수정하는 쿼리 
UPDATE STUDENT 
SET 
    ST_NAME = '홍길동A'
WHERE
    ST_GRADE = 1 AND ST_CLASS = 1 AND ST_NUM = 1;
    
# 데이터 삭제
# DELETE FROM 테이블명 WHERE 조건;
# 1학년 1반 2번 학생의 데이터를 삭제하는 쿼리
DELETE FROM STUDENT 
WHERE
    ST_GRADE = 1 AND ST_CLASS = 1 AND ST_NUM = 2;







