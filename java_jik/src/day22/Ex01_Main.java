package day22;

public class Ex01_Main {
	
	/* 단어장 프로그램을 구현하세요.
	 * - 관리자
	 * 	- 단어 등록
	 * 	- 단어 수정
	 * 	- 단어 삭제
	 * - 사용자
	 * 	- 단어 검색
	 * 	  - 검색할 단어를 입력 후, 조회된 단어 중 하나를 선택
	 * 	- 내 검색 단어 보기
	 * 	  - 단어 검색에서 선택한 단어를 출력
	 * 
	 * - 주의사항
	 * 	- 중복된 단어 허용
	 * 	- 단어는 단어, 품사, 뜻으로 구성
	 * 	- 사용자는 아이디로만 구분. 중복된 아이디는 없음
	 * 	- 사용자는 회원가입을 따로 하지 않음
	 *  - 관리자는 admin으로 고정
	 *  - 저장과 불러오기 필수
	 *  
	 * 시작전
	 * 아이디 : admin
	 * 관리자 메뉴 출력
	 * 메뉴 선택 : 
	 * 
	 * 아이디 : abc
	 * 사용자 메뉴 출력
	 * 메뉴 선택 : 
	 * 
	 * */
	public static void main(String[] args) {

		WordNoteProgram program = new WordNoteProgram();
		program.run();

	}

}
