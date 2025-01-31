package day20;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex01_Client {

	/* 쇼핑몰을 구현하세요.
	 * - 제품 관리
	 *  - 관리자가 관리
	 *  - 관리자는 admin/admin으로 고정
	 *  - 제품 추가, 수정, 삭제, 제품 입고
	 *	- 제품 추가
	 *	  - 제품 코드(6자리. ABC001), 분류, 제품명, 옵션, 가격을 등록
	 *	  - ABC001, 문구, 볼펜, 빨강, 1000
	 *	  - DEF001, 의류, 셔츠, XL, 30000
	 *	  - XYZ001, 식품, 우유 1L, 딸기, 2000
	 *	  - XYZ002, 식품, 딸기 우유, 1L, 2000
	 *	  - XYZ003, 식품, 딸기 우유, 2L, 3000
	 *	  - 분류는 문구, 의류, 식품, 가전, 기타로 고정
	 *	  - 각 분류마다 분류코드가 지정
	 *	    - 문구 : ABC, 의류 : DEF, 식품 : XYZ, 가전 : ELC, 기타 : ETC
	 *	  - 제품 코드는 분규 코드에 등록된 순서 3자리를 만들어서 총 6자리로 고정  
	 *	제품 입고
	 *	  - 제품 코드, 수량을 입력해서 제품을 입고    
	 * - 제품 구매
	 * 	- 등록된 제품을 선택 후 수량을 선택해서 구매
	 * 	- 로그인한 사용자가 제품을 구매할 수 있음. 
	 *  - 로그인하지 않으면 제품을 조회 및 구매할 수 없음
	 *  - 수량이 있는 제품만 구매 가능
	 *  - 제품 코드와 수량을 선택해서 구매
	 *  - 결제 과정은 없음(생략)
	 * - 제품 조회
	 *  - 분류를 이용하여 조회
	 *    - 문구, 의류, 식품, 가전, 기타, 전체
	 *  - 제품 코드, 제품명, 옵션, 수량, 가격이 조회
	 * - 회원가입
	 *  - 아이디, 비번, 비번확인을 입력해서 회원 가입
	 * - 로그인
	 *  - 아이디, 비번을 입력하여 회원이면 제품 조회로, 아니면 메인으로 돌아감
	 *  - 관리자이면 관리자 메뉴로 이동
	 * */
	/* 메인 메뉴
	 * 1. 로그인
	 * 2. 회원가입
	 * 3. 종료
	 * 
	 * 관리자 메뉴(로그인 시 관리자인 경우)
	 * 1. 제품 등록
	 * 2. 제품 수정
	 * 3. 제품 삭제
	 * 4. 제품 입고
	 * 5. 로그아웃
	 * 
	 * 사용자 메뉴(로그인 시 사용자인 경우)
	 * 1. 제품 조회
	 * 2. 로그 아웃
	 * 
	 * 제품 조회 메뉴
	 * 1. 문구 조회
	 * 2. 의류 조회
	 * 3. 식품 조회
	 * 4. 가전 조회
	 * 5. 기타 조회
	 * 6. 전체 조회
	 * 7. 이전으로
	 * 
	 * 제품 상세 
	 * 제품 정보를 출력
	 * 1. 제품 구매
	 * 2. 이전으로
	 * */
	private static List<Product> list = new ArrayList<Product>();
	private static List<Member> members = new ArrayList<Member>();
	
	private static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		/*
		List<Product1> list = new ArrayList<Product1>();
		list.add(new StationeryProduct());
		list.add(new ClothingProduct());
		*/
		//관라지 샘플 데이터
		members.add(new Member("admin", "admin", "관리자"));
		
		int menu;
		do {
			printMainMenu();
			menu = scan.nextInt();
			
			runMainMenu(menu);
			
		}while(menu != 3);
	}

	private static void printMainMenu() {
		System.out.println("------------------");
		System.out.println("1. 로그인");
		System.out.println("2. 회원가입");
		System.out.println("3. 종료");
		System.out.println("------------------");
		System.out.print("메뉴 선택 : ");
		
	}

	private static void printUserMenu() {
		System.out.println("------------------");
		System.out.println("1. 제품 조회");
		System.out.println("2. 로그 아웃");
		System.out.println("------------------");
		System.out.print("메뉴 선택 : ");
		
	}

	private static void printAdminMenu() {
		System.out.println("------------------");
		System.out.println("1. 제품 등록");
		System.out.println("2. 제품 수정");
		System.out.println("3. 제품 삭제");
		System.out.println("4. 제품 입고");
		System.out.println("5. 로그 아웃");
		System.out.println("------------------");
		System.out.print("메뉴 선택 : ");
		
	}

	private static void printCheckMenu() {
		System.out.println("------------------");
		System.out.println("1. 문구 조회");
		System.out.println("2. 의류 조회");
		System.out.println("3. 식품 조회");
		System.out.println("4. 가전 조회");
		System.out.println("5. 기타 조회");
		System.out.println("6. 전체 조회");
		System.out.println("7. 이전으로");
		System.out.println("------------------");
		System.out.print("메뉴 선택 : ");
		
	}

	private static void printCheckDetailMenu() {
		System.out.println("------------------");
		System.out.println("1. 제품 구매");
		System.out.println("2. 이전으로");
		System.out.println("------------------");
		System.out.print("메뉴 선택 : ");
		
		
	}

	private static void runMainMenu(int menu) {
		System.out.println("------------------");
		switch (menu) {
		case 1: 
			login();
			break;
		case 2:
			signup();
			break;
		case 3:
			System.out.println("[프로그램을 종료합니다.]");
			break;
		default:
			System.out.println("[잘못된 메뉴입니다.]");
		}
		System.out.println("------------------");
		
	}

	private static void runUserMenu(int menu) {
		System.out.println("------------------");
		switch(menu) {
		case 1:
			checkProduct();
			break;
		case 2:
			System.out.println("[이전으로 돌아갑니다.]");
			break;
		default:
			System.out.println("[잘못된 메뉴입니다.]");
		}
		System.out.println("------------------");
	}

	private static void runAdminMenu(int menu) {
		// TODO Auto-generated method stub
		
	}

	private static void runCheckDetailMenu(int menu) {
		
		switch (menu) {
		case 1:
			break;
		case 2:
			System.out.println("[이전으로 돌아갑니다.]");
			break;
		default:
			System.out.println("[잘못된 메뉴입니다.]");
		}
	}

	private static void runCheckMenu(int menu) {
		
		switch (menu) {
		case 1,2,3,4,5:
			check(menu);
			break;
		case 6:
			check();
			break;
		case 7:
			System.out.println("[이전으로 돌아갑니다.]");
			break;
		default:
			System.out.println("[잘못된 메뉴입니다.]");
		}
		
	}

	private static void check() {
		//제품 목록 조회
		
		//제품을 선택
		
		//선택된 제품을 출력(예외 처리)
		
		int menu;
		do {
			printCheckDetailMenu();
			menu = scan.nextInt();
			
			runCheckDetailMenu(menu);
			
		}while(menu != 2);
		
	}

	private static void check(int categoryNum) {
		//제품 목록 조회
		
		//제품을 선택
		
		//선택된 제품을 출력(예외 처리)
		
		int menu;
		do {
			printCheckDetailMenu();
			menu = scan.nextInt();
			
			runCheckDetailMenu(menu);
			
		}while(menu != 2);
		
	}
	

	private static void checkProduct() {
		System.out.println("[제품을 조회합니다.]");
		
		int menu;
		do {
			printCheckMenu();
			menu = scan.nextInt();
			
			runCheckMenu(menu);
			
		}while(menu != 7);
	}

	private static void login() {
		//로그인 기능
		//아이디, 비번을 입력 받음
		
		//객체를 생성
		
		//객체 정보와 일치하는 회원 정보(아이디,비번)가 있는지 확인해서 있으면 회원 정보를 가져옴
		
		Member member = new Member(null, null);
		
		//가져온 회원 정보가 없으면 안내문구 출력 후 종료 : 아이디 or 비번이 틀림
		
		
		String authority = member.getAuthority();
		
		switch(authority) {
		case "사용자":
			runUser();
			break;
		case "관리자":
			runAdmin();
			break;
		default:
			System.out.println("[로그인을 실패 했습니다.]");
		}
		
	}

	private static void runUser() {

		int menu;
		do {
			printUserMenu();
			menu = scan.nextInt();
			
			runUserMenu(menu);
			
		}while(menu != 2);
		
	}

	private static void runAdmin() {
		int menu;
		do {
			printAdminMenu();
			menu = scan.nextInt();
			
			runAdminMenu(menu);
			
		}while(menu != 5);
		
	}

	private static void signup() {
		//회원 가입 정보를 입력(아이디, 비번, 비번확인)
		System.out.print("아이디 : ");
		String id = scan.next();
		
		System.out.print("비번 : ");
		String pw = scan.next();
		
		System.out.print("비번 확인: ");
		String pw2 = scan.next();
		
		//비번과 비번 확인이 일치하지 않으면 알림 후 종료
		if(!pw.equals(pw2)) {
			System.out.println("[비번과 비번 확인이 일치하지 않습니다.]");
			return;
		}
		//입력받은 정보를 이용하여 객체를 생성
		Member member = new Member(id, pw);
		
		//생성한 객체가 등록되었는지 확인 후 없으면 추가 후 알림
		if(!members.contains(member)) {
			members.add(member);
			System.out.println("[회원 가입이 완료됐습니다.]");
			return;
		}
		
		//있으면 알림
		System.out.println("[이미 가입된 아이디입니다.]");
	}

}
