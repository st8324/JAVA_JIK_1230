package day10;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public class Ex13_Phone {

	/* 전화번호를 관리하는 프로그램을 작성하세요.
	 * 1. 전화번호 추가
	 * 	- 이름과 전화번호를 입력받아 추가
	 *  - 동명이인이 있을 수 있기 때문에 중복되도 추가
	 * 2. 전화번호 수정
	 * 	- 이름을 입력
	 * 	- 이름과 일치하는 목록을 출력
	 * 	- 수정하려는 전화번호를 선택
	 * 	- 새 전화번호를 입력받아 수정
	 * 3. 전화번호 삭제
	 * 	- 이름을 입력
	 * 	- 이름과 일치하는 목록을 출력
	 * 	- 삭제하려는 전화번호를 선택
	 * 	- 선택한 전화번호를 삭제
	 * 4. 전화번호 조회
	 * 	- 이름을 입력
	 * 	- 이름이 포함된 전화번호를 출력
	 * */
	
	static Scanner scan = new Scanner(System.in);
	static ArrayList<PhoneNumber> list = new ArrayList<PhoneNumber>();
	
	public static void main(String[] args) {
		
		int menu;
		
		do {
			//메뉴 출력
			printMenu();
			//메뉴 선택
			menu = scan.nextInt();
			scan.nextLine();
			//선택한 메뉴 실행
			runMenu(menu);
		}while(menu != 5);
		
	}

	private static void printMenu() {
		System.out.print(
			"----------------\r\n" + 
			"1. 전화번호 추가\r\n" + 
			"2. 전화번호 수정\r\n" + 
			"3. 전화번호 삭제\r\n" + 
			"4. 전화번호 조회\r\n" + 
			"5. 프로그램 종료\r\n" +
			"----------------\r\n" +
			"메뉴 선택 : ");
	}

	private static void runMenu(int menu) {
		switch(menu) {
		case 1:
			insertPhoneNumber();
			break;
		case 2:
			updatePhoneNumber();
			break;
		case 3:
			deletePhoneNumber();
			break;
		case 4:
			searchPhoneNumber();
			break;
		case 5:
			System.out.println("프로그램을 종료합니다.");
			break;
		default:
			System.out.println("올바른 메뉴가 아닙니다.");
		}
		
	}

	private static void insertPhoneNumber() {
		//이름과 전화번호를 입력받아 추가
		System.out.print("이름 : ");
		String name = scan.nextLine();
		System.out.print("번호(예:010-1234-5678) : ");
		String phoneNumber = scan.nextLine();
		
		//정규표현식 체크 : 000-0000-0000
		String regex = "^\\d{2,3}(-\\d{4}){2}$";
		if(!Pattern.matches(regex, phoneNumber)) {
			System.out.println("올바른 전화번호가 아닙니다.");
			return;
		}
		
		PhoneNumber pn = new PhoneNumber(name, phoneNumber);
		list.add(pn);
		System.out.println("전화번호를 등록했습니다.");
	}

	private static void updatePhoneNumber() {
		
		
	}

	private static void deletePhoneNumber() {
		//이름을 입력 받음
		System.out.print("이름 : ");
		//이름과 일치하는 전화번호 목록을 숫자와 함께 출력
		//이름과 일치하는 전화번호 리스트를 가져옴
		
		//새로 만든 리스트를 이용하여 출력
		
		//삭제할 번호를 입력
		
		//선택한 전화번호를 삭제
		//선택한 번호-1번지에 있는 객체를 새로운 리스트에서 가져옴
		
		//가져온 객체를 기존 리스트에서 제거
		
	}

	private static void searchPhoneNumber() {
		System.out.print("이름 : ");
		String name = scan.nextLine();
		
		for(PhoneNumber pn : list) {
			if(pn.getName().contains(name)) {
				System.out.println(pn);
			}
		}
		
	}
}
@Getter
@Setter
@AllArgsConstructor
class PhoneNumber{
	
	private String name;
	private String phoneNumber;
	
	@Override
	public String toString() {
		return name + " : " + phoneNumber;
	}
	
	
}



