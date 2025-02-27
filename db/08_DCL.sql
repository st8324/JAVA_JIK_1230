# 사용자 추가 
# CREATE USER '아이디'@'호스트명' IDENTIFIED BY '비밀번호';
# '아이디' : 사용자 계정명 
# '호스트명' : 접근 권한 
#   - localhost : 내부에서만 가능 => 다른 PC에서 해당 DB에 접근이 불가능 
#   - % : 외부에서도 접근 가능 
CREATE USER 'community_admin'@'%' IDENTIFIED BY 'admin';

# 사용자 조회 
SELECT USER, HOST FROM MYSQL.USER;

# 사용자 비번 변경 
# SET PASSWORD FOR '아이디'@'호스트명' = '새비밀번호';
SET PASSWORD FOR 'community_admin'@'%' = 'admin123';

# 사용자 삭제
# DROP USER '아이디'@'호스트명';
DROP USER 'community_admin'@'%';

CREATE USER 'community_admin'@'%' IDENTIFIED BY 'admin';

# 권한 부여 
#   - 사용자에 특정 DB에 대한 권한을 부여. 테이블 추가/수정/삭제, 데이터 추가/수정/삭제/조회 등 
#   - SELECT/INSERT/UPDATE/DELETE/CREATE/ALTER/DROP/REFERENCES/ALL PRIVILEGES(모든 권한) 
# GRANT 권한 ON DB명.테이블명 TO '아이디'@'호스트명';
GRANT SELECT ON COMMUNITY.* TO 'community_admin'@'%';
GRANT ALL PRIVILEGES ON COMMUNITY.* TO 'community_admin'@'%';

# 권한 제거 
# REVOKE 권한 ON DB명.테이블명 FROM '아이디'@'호스트명'; 
REVOKE INSERT ON COMMUNITY.* FROM 'community_admin'@'%';












