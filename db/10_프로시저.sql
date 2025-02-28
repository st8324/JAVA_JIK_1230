# 프로시저 : 일련의 쿼리를 하나의 함수처럼 실행하기 위한 쿼리의 집합 
# 프로시저 목록 확인
SHOW PROCEDURE STATUS;
# 프로시저 스크립트 확인 
# SAKILA DB에 있는 FILM_IN_STOCK 프로시저 확인 
USE SAKILA;
# Create Procedure에 있는 내용이 프로시저 스크립트 
SHOW CREATE PROCEDURE FILM_IN_STOCK;

/*
프로시저 삭제 
DROP PROCEDURE IF EXISTS 프로시저명; 

프로시저 정의 
DELIMITER 기호 
CREATE PROCEDURE 프로시저명(
	[IN|OUT|INOUT 변수명1 타입,]
	[...]
)
BEGIN
	프로시저 구현;
END 기호
DELIMITER ;

- 설명
DELIMITER 
  - 문장의 끝을 나타내는 기호를 정할 때 사용 
  - 사용하는 이유 : 프로시저 안에 사용되는 ;이 프로시저를 정의하는 동안 실행되면 안되기 때문에,
    프로시저를 정의하는 동안에 ;이 문장의 끝을 나타내는 기호가 아닌것처럼 사용하기 위해서 
IN : 매개변수처럼 값을 프로시저 안에서 사용. 
OUT : 프로시저 안에서 나온 결과를 넘길 때 사용 
INOUT : 매개변수처럼 값을 가져와서 프로시저에서 사용하고 결과를 받아서 밖에서 활용 

프로시저 호출 
CALL 프로시저명(매개변수 또는 값들);
*/
# 학생 성적을 추가할 때 성적 0미만, 100초과면 추가하지 않는 프로시저 
USE STUDENT;
DROP PROCEDURE IF EXISTS INSERT_SCORE;

DELIMITER //
CREATE PROCEDURE INSERT_SCORE(
	IN _ST_KEY INT,
    IN _SJ_NUM INT,
    IN _SCORE INT
)
BEGIN
	IF _SCORE BETWEEN 0 AND 100 THEN
		INSERT INTO SCORE(SC_ST_KEY, SC_SJ_NUM, SC_SCORE) VALUES(_ST_KEY, _SJ_NUM, _SCORE);
    END IF;
END //
DELIMITER ;

CALL INSERT_SCORE(16, 7, 90);
CALL INSERT_SCORE(16, 8, 150);

# 프로시저 예제
DROP PROCEDURE IF EXISTS P_TEST1;

DELIMITER //
CREATE PROCEDURE P_TEST1(
	IN _NUM INT,
    OUT _RES INT
)
BEGIN
	SET _RES = _NUM * 2;
END //
DELIMITER ;

# 세션 변수 VALUE 선언 
SET @VALUE = 3;
CALL P_TEST1(10, @VALUE);
SELECT @VALUE;

DROP PROCEDURE IF EXISTS P_TEST2;

DELIMITER //
CREATE PROCEDURE P_TEST2(
	INOUT _NUM INT
)
BEGIN
	SET _NUM = _NUM * 2;
END //
DELIMITER ;
CALL P_TEST2(@VALUE);
SELECT @VALUE;

/* 
프로시저에서 사용하는 문법 
1. 변수 선언 
  - 변수는 프로시저 시작 위치에 모아 놓아야 함. 중간에 선언할 수 없음. 
DECLARE 변수명 자료형 [DEFAULT 초기값];
2. 검색 결과를 변수에 저장 
SET 변수 = (SELECT 속성 FROM 테이블명 [WHERE ...]);
3. 조건문 - IF
IF 조건식 THEN
	실행문;
ELSEIF 조건식 THEN
	실행문;
ELSE
	실행문;
END IF;
4. 조건문 - CASE 
CASE 변수 
	WHEN 값 THEN
		실행문;
	WHEN 값 THEN
		실행문;
	ELSE 
		실행문;
END CASE;
5. 반복문 - WHILE
WHILE 조건식 DO
	실행문;
END WHILE;
6. 반복문 - REPEAT
REPEAT
	실행문;
UNTIL 조건식
END REPEAT;
7. 반복문 - CURSOR 
  - 검색 결과를 반복문으로 활용할 때 
DECLARE 커서명 CURSOR FOR SELECT 속성1, ... FROM 테이블명;
DECLARE CONTINUE HANDLER FOR NOT FOUND SET 변수명A = TRUE;
OPEN 커서명;
루프명 : LOOP
FETCH 커서명 INTO 변수명1 , ....; 
IF 변수명A THEN
	LEAVE 루프명;
END IF;
반복문 실행문;
END LOOP;
CLOSE 커서명; studentstudent
*/

# AVERAGE 테이블에 등록된 학생만큼 1학년 1학기~3학년 2학기 평균 초기 데이터를 추가하는 프로시저 

DROP PROCEDURE IF EXISTS INIT_AVERAGE;

DELIMITER //
CREATE PROCEDURE INIT_AVERAGE()
BEGIN
	DECLARE _COUNT INT;
    DECLARE _CURSOR CURSOR FOR SELECT ST_KEY FROM STUDENT;
    
    SET _COUNT = (SELECT COUNT(*) FROM AVERAGE);
    
    IF _COUNT != 0 THEN
		
    END IF;
    
END //
DELIMITER ;
















