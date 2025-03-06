USE SHOPPINGMALL;
# 회원이 다음의 정보로 회원 가입을 했을 때 필요한 쿼리
# 아이디 : abc123, 비번 : abc123, 이메일 : abc123@db.com, 전화번호 : 111-1234-5678
INSERT INTO MEMBER(ME_ID, ME_PW, ME_EMAIL, ME_NUMBER) 
VALUES("abc123", "abc123", "abc123@db.com", "111-1234-5678");

# 관리자가 다읨 정보로 회원 가입을 했을 때 필요한 쿼리 
# 아이디 : admin123, 비번 : admin123, 이메일 : admin123@db.com, 전화번호 : 111-2222-3333
INSERT INTO MEMBER(ME_ID, ME_PW, ME_EMAIL, ME_NUMBER, ME_AUTHORITY) 
VALUES("admin123", "admin123", "admin123@db.com", "111-2222-3333" ,"ADMIN");

# 카테고리를 등록할 때 필요한 쿼리
# 상의 : TOP, 하의 : PAN, 악세사리 : ACC, 모자 : CAP, 신발 : SHO
INSERT INTO CATEGORY(CA_NAME, CA_CODE) VALUES
("상의", "TOP"),("하의", "PAN"),("악세사리", "ACC"),("모자", "CAP"),("신발", "SHO");

# 제품을 등록하기 위한 프로시저를 만드세요. 

DROP PROCEDURE IF EXISTS INSERT_PRODUCT;

DELIMITER //
CREATE PROCEDURE INSERT_PRODUCT(
	IN _CA_CODE CHAR(3),
    IN _TITLE VARCHAR(100),
    IN _CONTENT LONGTEXT,
    IN _PRICE INT,
    IN _THUMB VARCHAR(200)
)
BEGIN
	DECLARE _COUNT INT;
    DECLARE _COUNT_STR CHAR(3);
    DECLARE _PR_CODE CHAR(6);
    DECLARE _CA_NUM INT;
    
    # PR_CODE가 _CA_CODE로 시작하는 제품의 개수 + 1를 구함 
    SET _COUNT = (SELECT COUNT(*) + 1 FROM PRODUCT WHERE PR_CODE LIKE CONCAT(_CA_CODE, '%'));
    
    # 제품의 개수를 이용하여 3자리 문자열을 만듬. 빈 자리는 앞에 0으로 채움 
    SET _COUNT_STR = LPAD(_COUNT, 3, "0");
    
    # 제품 코드는 _CA_CODE와 위에서 구한 3자리 문자열을 합해서 구함 
    SET _PR_CODE = CONCAT(_CA_CODE, _COUNT_STR);
    
    # _CA_CODE를 이용해서 PR_CA_NUM를 구함 
    SET _CA_NUM = (SELECT CA_NUM FROM CATEGORY WHERE CA_CODE = _CA_CODE);
    # 위에서 구한 값들을 이용하여 INSERT문 작성 
    INSERT PRODUCT(PR_CODE, PR_TITLE, PR_CONTENT, PR_PRICE, PR_THUMB, PR_CA_NUM)
    VALUES(_PR_CODE, _TITLE, _CONTENT, _PRICE, _THUMB, _CA_NUM );
END //
DELIMITER ;

CALL INSERT_PRODUCT("TOP", "셔츠입니다.", "셔츠를 싸게 팝니다.", 10000, "/IMG/TOP_01.JPG");
CALL INSERT_PRODUCT("TOP", "반팔", "반팔입니다.", 5000, "/IMG/TOP_02.JPG");
CALL INSERT_PRODUCT("TOP", "긴팔", "긴팔입니다..", 15000, "/IMG/TOP_03.JPG");

CALL INSERT_PRODUCT("PAN", "반바지", "시원한 반바지입니다.", 7000, "/IMG/PAN_01.JPG");
CALL INSERT_PRODUCT("PAN", "청바지", "스타일한 청바지입니다.", 30000, "/IMG/PAN_02.JPG");
CALL INSERT_PRODUCT("PAN", "면바지", "편한 면바지입니다.", 40000, "/IMG/PAN_03.JPG");

CALL INSERT_PRODUCT("ACC", "반지 14K", "커플링", 100000, "/IMG/ACC_01.JPG");
CALL INSERT_PRODUCT("ACC", "목걸이 14K", "금목걸이", 150000, "/IMG/ACC_02.JPG");
CALL INSERT_PRODUCT("ACC", "순금반지 1돈", "돌반지", 400000, "/IMG/ACC_03.JPG");

CALL INSERT_PRODUCT("CAP", "빈티지 모자", "모자입니다.", 12000, "/IMG/CAP_01.JPG");
CALL INSERT_PRODUCT("CAP", "위생 모자", "모자입니다.", 15000, "/IMG/CAP_02.JPG");
CALL INSERT_PRODUCT("CAP", "선캡", "모자입니다.", 40000, "/IMG/CAP_03.JPG");

CALL INSERT_PRODUCT("SHO", "장화", "장화", 20000, "/IMG/SHO_01.JPG");
CALL INSERT_PRODUCT("SHO", "런닝화", "편한 런닝화", 200000, "/IMG/SHO_02.JPG");
CALL INSERT_PRODUCT("SHO", "구두", "스타일 좋은 구두", 300000, "/IMG/SHO_03.JPG");

# abc123회원이 TOP001 제품을 장바구니에 3개 담았을 때 쿼리
INSERT CART(CT_AMOUNT, CT_ME_ID, CT_PR_CODE) VALUES(3, "abc123", "TOP001");
# abc123회원이 SHO001 제품을 장바구니에 1개 담았을 때 쿼리
INSERT CART(CT_AMOUNT, CT_ME_ID, CT_PR_CODE) VALUES(1, "abc123", "SHO001");

# abc123회원이 장바구니에 담긴 모든 제품을 구매할 때 쿼리 
# 구매 테이블에 총 가격과 구매자를 추가하는 쿼리 
INSERT INTO BUY(BU_TOTAL_PRICE, BU_ME_ID) VALUES("50000", "abc123");
# 구매 리스트에 장바구니에 담긴 제품들을 추가하는 쿼리 
INSERT INTO BUY_LIST(BL_AMOUNT, BL_PRICE, BL_BU_NUM, BL_PR_CODE)
SELECT 3, 30000, MAX(BU_NUM), "TOP001" FROM BUY;
INSERT INTO BUY_LIST(BL_AMOUNT, BL_PRICE, BL_BU_NUM, BL_PR_CODE)
SELECT 1, 20000, MAX(BU_NUM), "SHO001" FROM BUY;
# 장바구니에 있는 목록들을 제거하는 쿼리 
DELETE FROM CART WHERE CT_ME_ID = 'abc123' AND CT_PR_CODE = 'TOP001';
DELETE FROM CART WHERE CT_ME_ID = 'abc123' AND CT_PR_CODE = 'SHO001';








