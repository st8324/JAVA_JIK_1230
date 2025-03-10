# 상영중인 영화를 조회하는 쿼리 : 영화 제목, 개봉일 
SELECT MV_TITLE 영화, MV_DATE 개봉일 FROM MOVIE WHERE MV_STATE = "상영중";

# CGV강남(1)을 선택하고, 미키 17(1)를 선택했을 때 상영 가능한 날짜를 조회하는 쿼리 
SELECT DISTINCT SD_DATE FROM SCHEDULE 
JOIN SCREEN ON SC_NUM = SD_SC_NUM
WHERE SD_MV_NUM = 1 AND SC_TT_NUM = 1;

SELECT DISTINCT SD_DATE FROM SCHEDULE 
JOIN SCREEN ON SC_NUM = SD_SC_NUM
JOIN THEATER ON TT_NUM = SC_TT_NUM
JOIN MOVIE ON MV_NUM = SD_MV_NUM
WHERE MV_TITLE = "미키 17" AND TT_NAME = "CGV강남";

# CGV강남 1관의 등록된 모든 좌석을 조회하는 쿼리 
SELECT SE_NAME FROM SEAT 
JOIN SCREEN ON SC_NUM = SE_SC_NUM
JOIN THEATER ON TT_NUM = SC_TT_NUM
WHERE SC_NAME = "1관" AND TT_NAME = "CGV강남" AND SE_POS = "Y";

SELECT SE_NAME FROM SEAT 
WHERE SE_SC_NUM = 1 AND SE_POS = "Y";

# CGV강남 1관(1)의 3월 11일 16:20에 상영하는 미키 17(3)의 좌석을 조회하는 쿼리 
SELECT SE_NAME FROM SEAT 
JOIN SCHEDULE ON SD_SC_NUM = SE_SC_NUM
WHERE SE_POS = "Y" AND SD_NUM = 3;

# 2번 스케쥴에서 예약된 좌석들
SELECT SEAT.* FROM SEAT 
	JOIN SCHEDULE ON SD_SC_NUM = SE_SC_NUM
	LEFT JOIN TICKET ON TI_SD_NUM = SD_NUM
	LEFT JOIN TICKET_LIST ON TI_NUM = TL_TI_NUM
	WHERE SE_POS = "Y" AND SD_NUM = 2 AND TL_SE_NUM = SE_NUM AND TI_STATE = "결제";

# CGV강남 4관의 3월 11일 19:10에 상영하는 미키 17의 예약 가능한 좌석을 조회하는 쿼리 
# 예매 리스트와 JOIN해서 예매가 안된 좌석을 조회 
SELECT SE_NAME FROM SEAT 
WHERE SE_SC_NUM = 4 AND SE_NUM NOT IN(
	SELECT SE_NUM FROM SEAT 
	JOIN SCHEDULE ON SD_SC_NUM = SE_SC_NUM
	LEFT JOIN TICKET ON TI_SD_NUM = SD_NUM
	LEFT JOIN TICKET_LIST ON TI_NUM = TL_TI_NUM
	WHERE SE_POS = "Y" AND SD_NUM = 2 AND TL_SE_NUM = SE_NUM  AND TI_STATE = "결제");
    
# 장르별 등록된 영화수를 조회하는 쿼리
SELECT GR_NAME, COUNT(MG_GR_NAME) 영화수 FROM GENRE
LEFT JOIN MOVIE_GENRE ON GR_NAME = MG_GR_NAME
GROUP BY GR_NAME;

# 현재 시간을 기준으로 한달 사이에 개봉한 영화를 조회하는 쿼리 
SELECT * FROM MOVIE 
WHERE
	MV_DATE BETWEEN DATE_SUB(NOW(), INTERVAL 1 MONTH) AND NOW();

# 각 영화별 예매수를 조회하는 쿼리
# 예매수는 상영시간이 지나지 않은 예매만 해당 
SELECT MOVIE.*, SUM(TI_TEEN + TI_ADULT) 예매수 FROM MOVIE 
LEFT JOIN SCHEDULE ON SD_MV_NUM = MV_NUM 
LEFT JOIN TICKET ON TI_SD_NUM = SD_NUM 
WHERE TI_STATE = "결제" AND CONCAT(SD_DATE, " ", SD_TIME) >= NOW()
GROUP BY MV_NUM;

# 각 영화별 예매수를 조회하여 예매가 높은 순으로 조회하는 쿼리 
SELECT MOVIE.*, SUM(TI_TEEN + TI_ADULT) 예매수 FROM MOVIE 
LEFT JOIN SCHEDULE ON SD_MV_NUM = MV_NUM 
LEFT JOIN TICKET ON TI_SD_NUM = SD_NUM 
WHERE TI_STATE = "결제" AND CONCAT(SD_DATE, " ", SD_TIME) >= NOW()
GROUP BY MV_NUM
ORDER BY 예매수 DESC;

# 각 영화별 예매수를 조회하여 예매율을 조회하는 쿼리  => 예매율 = 영화 예매수 / 전체 영화 예매수 * 100
SELECT MOVIE.*, SUM(TI_TEEN + TI_ADULT) 예매수, 
SUM(TI_TEEN + TI_ADULT) * 100 / SUM(SUM(TI_TEEN + TI_ADULT)) OVER() AS 예매율
 FROM MOVIE 
LEFT JOIN SCHEDULE ON SD_MV_NUM = MV_NUM 
LEFT JOIN TICKET ON TI_SD_NUM = SD_NUM 
WHERE TI_STATE = "결제" AND CONCAT(SD_DATE, " ", SD_TIME) >= NOW()
GROUP BY MV_NUM
ORDER BY 예매수 DESC;

# 각 영화별 예매수를 조회하여 예매율을 조회하는 쿼리  => 예매율 = 영화 예매수 / 전체 영화 예매수 * 100
SELECT M.*, 예매수 * 100 / SUM(예매수) AS 예매율 FROM (
	SELECT MOVIE.*, SUM(TI_TEEN + TI_ADULT) 예매수
		FROM MOVIE 
		LEFT JOIN SCHEDULE ON SD_MV_NUM = MV_NUM 
		LEFT JOIN TICKET ON TI_SD_NUM = SD_NUM 
		WHERE TI_STATE = "결제" AND CONCAT(SD_DATE, " ", SD_TIME) >= NOW()
		GROUP BY MV_NUM) M;


