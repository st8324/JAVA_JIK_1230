/* 
다음을 만족하는 쿼리를 작성해서 데이터베이스와 테이블을 생성하세요. 
데이터베이스명 : COMMUNITY
테이블명 : BOARD
 - 게시글을 제목, 내용, 작성자를 입력하여 등록한다.
 - 제목은 최대 50자, 내용은 긴 문자열, 작성자는 최대 15자 
 - 게시글은 게시글 목록에서 번호, 제목, 작성자, 작성일, 조회수를 확인할 수 있다 
 - 작성일은 년,월,일,시,분,초를 확인할 수 있다. 
*/
DROP DATABASE IF EXISTS COMMUNITY;

CREATE DATABASE COMMUNITY;

USE COMMUNITY;

DROP TABLE IF EXISTS BOARD;

CREATE TABLE BOARD(
	BO_NUM INT PRIMARY KEY AUTO_INCREMENT,
    BO_TITLE VARCHAR(50) NOT NULL,
    BO_CONTENT LONGTEXT NOT NULL,
    BO_WRITER VARCHAR(15) NOT NULL,
    BO_DATE DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP, 
    BO_VIEW INT NOT NULL DEFAULT 0
);
# abc123회원이 "인사"라는 제목으로 "안녕하세요"라는 내용을 작성했을 때 필요한 쿼리 
INSERT INTO COMMUNITY.BOARD(BO_TITLE, BO_CONTENT, BO_WRITER) VALUES("인사", "안녕하세요.", "abc123");
INSERT INTO COMMUNITY.BOARD(BO_TITLE, BO_CONTENT, BO_WRITER) VALUES("공지", "공지입니다.", "ADMIN");

# 1번 게시글을 클릭해서 게시글 내용을 조회할 때 필요한 쿼리 => 조회수 증가, 게시글 내용을 조회 
# 조회수 증가
UPDATE BOARD
SET
	BO_VIEW = BO_VIEW + 1
WHERE
	BO_NUM = 1;
# 1번 게시글 내용을 조회 
SELECT * FROM BOARD WHERE BO_NUM = 1;

# abc123 회원이 1번 게시글을 삭제할 때 쿼리 
# DELETE FROM BOARD WHERE BO_NUM = 1;

# 2025년 2월 25일에 작성된 게시글을 조회하는 쿼리 
SELECT * FROM BOARD WHERE BO_DATE BETWEEN "2025-02-25" AND "2025-02-25 23:59:59";

# 제목이나 내용에 "안녕"을 포함하는 게시글을 조회하는 쿼리 
SELECT * FROM BOARD WHERE BO_TITLE LIKE "%안녕%" OR BO_CONTENT LIKE "%안녕%";

# 최신글을 조회하는 쿼리 => 등록된 날짜가 최근 => 날짜 순으로 정렬
SELECT * FROM COMMUNITY.BOARD ORDER BY BO_DATE DESC;
SELECT * FROM COMMUNITY.BOARD ORDER BY BO_NUM DESC;

# 인기글을 조회하는 쿼리 => 조회수가 높은 글이 인기글 => 조회순으로 정렬 
SELECT * FROM COMMUNITY.BOARD ORDER BY BO_VIEW DESC;





