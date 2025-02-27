# 내장함수 - 문자열 
# CHAR_LENGTH(문자열) : 문자열 개수 
SELECT CHAR_LENGTH("안녕하세요") AS CHAR_LENGTH;
# LENGTH(문자열) : 바이트 수 
SELECT LENGTH("안녕하세요") AS LENGTH;
# CONCAT(문자열1, ...) : 문자열을 이어 붙임 
SELECT CONCAT("안녕", "하", "세요?") AS CONCAT;
# FIELD(찾을문자열, 문자열1, ....) : 찾을 문자열의 위치를 찾아 반환 . 위치는 1부터 시작
SELECT FIELD("안녕", "안녕하", "누구 안녕?", "안녕") AS FIELD;
# INSTR(기준문자열, 부분문자열) : 기준 문자열에서 부분 문자열의 위치를 찾아 반환. 위치는 1부터 시작
SELECT INSTR("HELLO JAVA", "JAVA") AS INSTR;
# LOCATE(부분문자열, 기준문자열) : 기준 문자열에서 부분 문자열의 위치를 찾아 반환 . 위치는 1부터 시작
SELECT LOCATE("JAVA", "HELLO JAVA") AS LOCATE;
# FORMAT(숫자, 소수점자리) : 숫자를 소수점이하 자리까지 표현. 1000단위마다 ,를 추가 
SELECT FORMAT(10000.123456, 0) AS FORMAT;
# BIN(숫자), OCT(숫자), HEX(숫자) : 2,8,16진수로 변환 
SELECT BIN(255) AS BIN,OCT(255) AS OCT,HEX(255) AS HEX ;
# INSERT(기준문자열, 위치, 길이, 삽입할문자열) : 기준문자열의 위치부터 길이만큼 지우고 삽입할 문자열을 끼워서 반환
SELECT INSERT("HELLO JAVA", 7, 4, "C++") AS `INSERT`;
# LEFT(문자열, 길이), RIGHT(문자열, 길이) : 왼쪽/오른족에서 문자열의 길이만큼 반환 
SELECT LEFT("TEST.TXT", 4) AS `LEFT`, RIGHT("TEST.TXT", 3) AS `RIGHT`;
# LOWER(문자열), UPPER(문자열) : 소문자로/대문자로 
SELECT LOWER("HELLO JAVA") AS `LOWER`, UPPER("hello java") AS `UPPER`;
# LPAD(문자열, 길이, 채울문자열)/RPAD(문자열,길이,채울문자열) : 문자열을 길이만큼 늘리고 빈곳을 채울문자열로 채움 
SELECT LPAD(1, 3, "0") AS LPAD, RPAD(1, 3, "0") AS RPAD;
# REPEAT(문자열, 횟수) : 문자열을 횟수만큼 반복 
SELECT REPEAT(1, 3) `REPEAT`;
# REPLACE(문자열, 문자열A, 문자열B) : 문자열에서 문자열A를 문자열B로 바꿈 
SELECT REPLACE("HELLO JAVA", "JAVA", "C++") AS `REPLACE`;
# REVERSE(문자열) : 문자열 순서를 역순으로 반환 
SELECT REVERSE("ABCDEF") AS `REVERSE`;
# SUBSTRING(문자열, 시작위치, 길이) 문자열에서 시작위치부터 길이만큼 부분문자열을 반환 
SELECT SUBSTRING("HELLO JAVA", 7, 4) AS SUBSTRING;


# 내장함수 - 날짜/시간함수 
# ADDDATE/SUBDATE(날짜, 차이) : 날짜를 기준으로 차이만큼 일(DATE)을 더한/뺀 날짜를 반환 
SELECT ADDDATE("2025-02-27 13:00:00", 2);
SELECT ADDDATE(NOW(), 14);
SELECT SUBDATE(NOW(), 14);
# ADDTIME/SUBTIME(날짜/시간, 차이) : 날짜/시간을 기준으로 차이만큼 시간을 더한/뺀 날짜/시간을 반환 
# "시:분:초" 형태를 지켜야 함. "10:00"을 입력하면 10시간으로 해석
SELECT ADDTIME(NOW(), "2:00:00");
SELECT SUBTIME(NOW(), "00:10:00");
# YEAR/MONTH/DAY(날짜) : 날짜에서 년/월/일을 구함 
SELECT YEAR(NOW()) AS YEAR, MONTH(NOW()) AS MONTH , DAY(NOW()) AS DAY;
# HOUR/MINUTE/SECOND/MICROSECOND(시간) : 시간에서 시/분/초/마이크로초를 반환 
SELECT HOUR(NOW()) AS HOUR, MINUTE(NOW()) AS MINUTE , SECOND(NOW()) AS SECOND, 
	MICROSECOND(NOW(6)) AS MICROSECOND, MICROSECOND("2025-02-27 10:09:03.123") AS MICROSECOND;
# DATE/TIME(날짜) : 날짜에서 년-월-일/시:분:초를 반환 
SELECT DATE(NOW()) DATE, TIME(NOW()) TIME;
# DATEDIFF(날짜1, 날짜2) 날짜1에서 날짜2의 차이를 일로 반환. 날짜1 - 날짜2 
SELECT DATEDIFF(NOW(), "2025-02-26 13:00:00") DATEDIFF;
# TIMEDIFF(날짜1/시간1, 날짜2/시간2) : 날짜1/시간1에서 날짜2/시간2의 차이를 시간:분:초로 반환 
SELECT TIMEDIFF(NOW(), "2025-02-26 13:00:00") TIMEDIFF;
# NOW()/SYSDATE() : 현재 날짜와 시간을 반환 
SELECT NOW(), SYSDATE();
# DATE_ADD/DATE_SUB(기준날짜, INTERVAL 간격 종류) : 기준 날짜에서 INTERVAL만큼 더한/뺀 날짜 
# INTERVAL 종류
# YEAR/MONTH/DAY/HOUR/MINUTE/SECOND/MICROSECOND/QUARTER/WEEK
# YEAR_MONTH/DAY_HOUR/DAY_MINUTE/DAY_MICROSECOND : A_B => A에서 B까지의 시간들. 뒤에서부터 채움
SELECT DATE_ADD(NOW(), INTERVAL 1 DAY);
SELECT DATE_ADD(NOW(), INTERVAL 1 QUARTER);
SELECT DATE_ADD(NOW(), INTERVAL 1 WEEK);
SELECT DATE_ADD(NOW(), INTERVAL "1 1" YEAR_MONTH);
SELECT DATE_ADD(NOW(), INTERVAL "1 12" DAY_MICROSECOND);#1초 120000us 뒤


# 수학 함수 
# ABS(숫자) : 절대값
# CEIL(숫자) : 소수점 첫번째 자리 올림 
# FLOOR(숫자) : 소수점 첫번째 자리 내림 
# ROUND(숫자) : 소수점 첫번째 자리 반올림 
# ROUND(숫자, N) : N+1번째 자리에서 반올림
SELECT ABS(1), ABS(-1);
SELECT CEIL(1.49), FLOOR(1.49), ROUND(1.49);
SELECT ROUND(1.49, 1);
SELECT CEIL(1.59), FLOOR(1.59), ROUND(1.59);