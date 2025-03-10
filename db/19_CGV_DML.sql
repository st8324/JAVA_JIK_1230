# 관람 등급을 추가 
INSERT INTO MOVIE_RATINGS VALUES
("전체 관람가"),
("12세 이상 관람가"),
("15세 이상 관람가"),
("청소년 관람 불가"),
("제한 상영가");
# 장르를 추가
INSERT INTO GENRE VALUES
("액션"),
("애니메이션"),
("코미디"),
("드라마"),
("공포"),
("로맨스"),
("SF"),
("판타지"),
("스릴러"),
("범죄"),
("전쟁"),
("어드벤처");
# 국가 추가 
INSERT INTO COUNTRY VALUES
("미국"),
("영국"),
("한국"),
("오스트레일리아"),
("일본");

# 지역 추가 
INSERT INTO REGION VALUES
("서울"),
("경기"),
("인천"),
("대전/충청"),
("대구"),
("부산/울산"),
("경상"),
("광주/전라/제주");

# 요금, 성인 : 15000, 청소년 : 12000, 조조 : 11000
INSERT INTO FEE(FE_TYPE, FE_PRICE, FE_DATE) VALUES
("성인", 15000, "2025-03-01"),
("청소년", 12000, "2025-03-01"),
("조조", 11000, "2025-03-01");

# CGV 사이트를 참고하여 미키 17영화를 등록할 때 필요한 쿼리들을 작성하세요.
# 미키 영화 정보를 추가 : 제목, 상영시간, 개봉일, 내용, 상태, 관람 등급 
INSERT INTO MOVIE(MV_TITLE, MV_TIME, MV_DATE, MV_CONTENT, MV_STATE, MV_MR_AGE)
VALUES("미키 17", 137, "2025-02-28", "당신은 몇 번째 미키입니까?", "상영중", "15세 이상 관람가");

# 인물을 추가 : 봉준호, 로버트 패틴슨, 나오미 애키, 스티븐 연, 토니 콜렛, 마크 러팔로 
INSERT INTO PERSON(PR_NAME, PR_BIRTH, PR_DETAIL, PR_CT_NAME) VALUES
("봉준호", "1969-09-14", "", "한국"),
("로버트 패틴슨", "1986-05-13", "국내에서는 ...", "영국"),
("나오미 애키", "1992-11-02", "", NULL),
("스티븐 연", "1983-12-21", "한국계 미국인 ...", "미국"),
("토니 콜렛", "1972-11-01", "", "오스트레일리아"),
("마크 러팔로", "1967-11-22", "1968년 위스콘신 출생.", "미국");

# 영화인 등록
INSERT INTO ACTOR(AT_POSITION, AT_PR_NUM) VALUES
("감독", 1),
("배우", 2),
("배우", 3),
("배우", 4),
("배우", 5),
("배우", 6);

# 영화 참여 등록
INSERT INTO MOVIE_ACTOR(MA_ROLE, MA_MV_NUM, MA_AT_NUM) VALUES
("감독", 1, 1),
("미키 반스", 1, 2),
("나샤 배릿지", 1, 3),
("티모", 1, 4),
("일파 마샬", 1, 5),
("케네스 마샬", 1, 6);

# 영화 장르 등록
INSERT INTO MOVIE_GENRE(MG_MV_NUM, MG_GR_NAME) VALUES
(1, "어드벤처"), (1, "SF"), (1, "드라마");

# 제작 국가 등록
INSERT INTO MOVIE_COUNTRY(MC_CT_NAME, MC_MV_NUM) VALUES("미국", 1);

# 트레일러와 스틸컷 등록
INSERT INTO FILE(FI_NAME, FI_TYPE, FI_MV_NUM) VALUES
("미키17_1.JPG", "S", 1),
("미키17_2.JPG", "S", 1),
("미키17_3.JPG", "S", 1),
("미키17_1.MP4", "T", 1),
("미키17_2.MP4", "T", 1),
("미키17_3.MP4", "T", 1);

# 미키17 강남 3/11 상영시간을 등록할 때 필요한 쿼리들을 작성 
# 4관 13:50, 19:10, 
# 1관 16:20
# 3관 09:00, 11:50
# 5관 10:00
# 극장 등록
INSERT INTO THEATER(TT_NAME, TT_ADDR, TT_COUNT, TT_RG_NAME) 
VALUES("CGV강남", "서울특별시 강남구 강남대로 438 (역삼동)", 5, "서울");

# 상영관 등록 : CGV강남 1관 ~ 5관 
INSERT INTO SCREEN(SC_NAME, SC_SEAT, SC_TT_NUM) VALUES
("1관", 12, 1),
("2관", 10, 1),
("3관", 15, 1),
("4관", 16, 1),
("5관", 20, 1);

# 상영관 좌석 등록 
INSERT INTO SEAT(SE_NAME, SE_SC_NUM) VALUES
("A1", 1),("A2", 1),("A3", 1),("A4", 1),
("B1", 1),("B2", 1),("B3", 1),("B4", 1),
("C1", 1),("C2", 1),("C3", 1),("C4", 1),

("A1", 2),("A2", 2),("A3", 2),("A4", 2),("A5", 2),
("B1", 2),("B2", 2),("B3", 2),("B4", 2),("B5", 2),

("A1", 3),("A2", 3),("A3", 3),
("B1", 3),("B2", 3),("B3", 3),
("C1", 3),("C2", 3),("C3", 3),
("D1", 3),("D2", 3),("D3", 3),
("E1", 3),("E2", 3),("E3", 3),

("A1", 4),("A2", 4),("A3", 4),("A4", 4),
("B1", 4),("B2", 4),("B3", 4),("B4", 4),
("C1", 4),("C2", 4),("C3", 4),("C4", 4),
("D1", 4),("D2", 4),("D3", 4),("D4", 4),

("A1", 5),("A2", 5),("A3", 5),("A4", 5),("A5", 5),
("B1", 5),("B2", 5),("B3", 5),("B4", 5),("B5", 5),
("C1", 5),("C2", 5),("C3", 5),("C4", 5),("C5", 5),
("D1", 5),("D2", 5),("D3", 5),("D4", 5),("D5", 5);

# 상영 시간 등록.
# 4관 13:50, 19:10, 
# 1관 16:20
# 3관 09:00, 11:50
# 5관 10:00
INSERT INTO SCHEDULE(SD_DATE, SD_TIME, SD_POS_SEAT, SD_EARLY, SD_MV_NUM, SD_SC_NUM) VALUES
("2025-03-11", "13:50", 16, "N", 1, 4),
("2025-03-11", "19:10", 16, "N", 1, 4),
("2025-03-11", "16:20", 12, "N", 1, 1),
("2025-03-11", "09:00", 15, "Y", 1, 3),
("2025-03-11", "11:50", 15, "N", 1, 3),
("2025-03-11", "10:00", 20, "Y", 1, 5);

# 회원가입하는 쿼리. 아이디 : abc123, 비번 : abc123, 사용자 
INSERT INTO MEMBER(ME_ID, ME_PW) VALUES("abc123", "abc123");

# abc123 회원이 3번 스케쥴(미키 17, 1관 3월 11일 16:20)의 예약 가능한 좌석 A1, A2를 예매했을 때 필요한 쿼리 
# 성인 1, 청소년 1 
# 예매 테이블(TICKET)에 추가하는 쿼리
INSERT INTO TICKET(TI_ADULT, TI_TEEN, TI_PRICE, TI_ME_NUM, TI_SD_NUM)
VALUES(1, 1, 27000, 1, 3);
# 예매 리스트 테이블(TICKET_LIST)에 추가하는 쿼리 
INSERT INTO TICKET_LIST(TL_TI_NUM, TL_SE_NUM) VALUES(1, 1), (1,2);
# 스케쥴에 예매 가능 좌석 수를 변경 
UPDATE SCHEDULE SET SD_POS_SEAT = SD_POS_SEAT - 2 WHERE SD_NUM = 3;

# abc123 회원이 1번 스케쥴(미키 17, 4관 3월 11일 13:50)의 예약 가능한 좌석 A1, A2를 예매했을 때 필요한 쿼리 
INSERT INTO TICKET(TI_ADULT, TI_TEEN, TI_PRICE, TI_ME_NUM, TI_SD_NUM)
VALUES(1, 1, 27000, 1, 1);
INSERT INTO TICKET_LIST(TL_TI_NUM, TL_SE_NUM) VALUES(2, 38), (2,39);
UPDATE SCHEDULE SET SD_POS_SEAT = SD_POS_SEAT - 2 WHERE SD_NUM = 1;

# abc123 회원이 2번 스케쥴(미키 17, 4관 3월 11일 19:10)의 예약 가능한 좌석 A1, A2를 예매했을 때 필요한 쿼리 
INSERT INTO TICKET(TI_ADULT, TI_TEEN, TI_PRICE, TI_ME_NUM, TI_SD_NUM)
VALUES(1, 1, 27000, 1, 2);
INSERT INTO TICKET_LIST(TL_TI_NUM, TL_SE_NUM) VALUES(3, 38), (3,39);
UPDATE SCHEDULE SET SD_POS_SEAT = SD_POS_SEAT - 2 WHERE SD_NUM = 2;

# abc123 회원이 2번 스케쥴(미키 17, 4관 3월 11일 19:10)의 예약 가능한 좌석 A3, A4를 예매했을 때 필요한 쿼리 
INSERT INTO TICKET(TI_ADULT, TI_TEEN, TI_PRICE, TI_ME_NUM, TI_SD_NUM)
VALUES(1, 1, 27000, 1, 2);
INSERT INTO TICKET_LIST(TL_TI_NUM, TL_SE_NUM) VALUES(4, 40), (4,41);
UPDATE SCHEDULE SET SD_POS_SEAT = SD_POS_SEAT - 2 WHERE SD_NUM = 2;

# abc123회원이 2번 스케쥴에 예약했던 좌석 A3, A4를 취소했을 때 필요한 쿼리 
UPDATE TICKET SET TI_STATE = "취소" WHERE TI_NUM = 4;
UPDATE SCHEDULE SET SD_POS_SEAT = SD_POS_SEAT + 2 WHERE SD_NUM = 2;












