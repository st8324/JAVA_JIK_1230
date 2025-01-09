package day08;

import java.util.Scanner;

public class Ex01_AccountBook2 {

	static Scanner scan = new Scanner(System.in);
	
	/* 가계부에 필요한 클래스를 선언하세요.
	 * 메뉴
	 * 1. 가게부 등록
	 * 2. 가계부 수정
	 * 3. 가계부 삭제
	 * 4. 가계부 조회
	 * 5. 종료
	 * 메뉴 선택 : 1
	 * ---------------------
	 * 수입/지출 : 수입
	 * 분류 : 월급
	 * 내용 : 1월 월급
	 * 금액 : 1000000
	 * 일시 : 2025-01-08
	 * ---------------------
	 * 가계부 등록이 완료됐습니다.
	 * ---------------------
	 * 메뉴
	 * 1. 가게부 등록
	 * 2. 가계부 수정
	 * 3. 가계부 삭제
	 * 4. 가계부 조회
	 * 5. 종료
	 * 메뉴 선택 : 2
	 * ---------------------
	 * 1. 수입/월급/1월 월급/1000000/2025-01-08
	 * 수정할 내역의 번호를 선택하세요 : 1
	 * 금액 : 2000000
	 * ---------------------
	 * 수정이 완료됐습니다.
	 * --------------------- 
	 * 메뉴
	 * 1. 가게부 등록
	 * 2. 가계부 수정
	 * 3. 가계부 삭제
	 * 4. 가계부 조회
	 * 5. 종료
	 * 메뉴 선택 : 4
	 * ---------------------
	 * 1. 수입/월급/1월 월급/2000000/2025-01-08
	 * ---------------------
	 * 메뉴
	 * 1. 가게부 등록
	 * 2. 가계부 수정
	 * 3. 가계부 삭제
	 * 4. 가계부 조회
	 * 5. 종료
	 * 메뉴 선택 : 3
	 * ---------------------
	 * 1. 수입/월급/1월 월급/2000000/2025-01-08
	 * 삭제할 내역의 번호를 선택하세요 : 1
	 * ---------------------
	 * 삭제가 완료됐습니다.
	 * --------------------- 
	 * 메뉴
	 * 1. 가게부 등록
	 * 2. 가계부 수정
	 * 3. 가계부 삭제
	 * 4. 가계부 조회
	 * 5. 종료
	 * 메뉴 선택 : 5
	 * ---------------------
	 * 프로그램을 종료합니다.
	 * ---------------------
	 * */
	public static void main(String[] args) {
		
		int menu, count = 0;
		Item [] list = new Item[10];
		
		list[count++] = new Item("수입", "월급", "1월 월급", 1000000, "2025-01-08");
		
		//반복 : 종료를 선택하기 전까지
		do {
			//메뉴 출력
			printMenu("가계부 등록","가계부 수정","가계부 삭제","가계부 조회",	"종료");
			//메뉴 선택
			menu = scan.nextInt();
			printBar('-', 15);
			//선택한 메뉴에 따른 기능 실행
			count = runMenu(menu, list, count);
			printBar('-', 15);
		}while(menu != 5);
	}
	
	public static void printBar(char bar, int count) {
		for(int i = 1; i<= count; i++) {
			System.out.print(bar);
		}
		System.out.println();
	}
	
	public static void printMenu(String ... menus ) {
		printBar('-', 15);
		//메뉴가 없는 경우
		if(menus.length == 0) {
			System.out.println("메뉴 없음");
			return;
		}
		//메뉴들을 숫자를 붙여서 출력
		for(int i = 0; i < menus.length; i++) {
			String menu = menus[i];
			System.out.println(i+1 + ". " + menu);
		}
		printBar('-', 15);
		System.out.print("메뉴 선택 : ");
	}
	
	public static int runMenu(int menu, Item [] list, int count) {
		switch(menu) {
		case 1:
			//내역 정보를 입력 받아서 내역 리스트에 추가
			list[count++] = inputItem();
			break;
		case 2:{
			updateItemList(list, count);
			break;
		}
		case 3:{
			count = deleteItemList(list, count);
			break;
		}
		case 4:
			printItems(list, count);
			break;
		case 5:
			System.out.println("프로그램을 종료합니다.");
			break;
		default:
			System.out.println("올바른 메뉴가 아닙니다.");
		}
		return count;
	}
	public static boolean printItems(Item[] list, int count) {
		if(count == 0 || list == null) {
			System.out.println("등록된 내역이 없습니다.");
			return false;
		}
		//반복문을 이용하여 저장된 내역들을 숫자와 함께 출력. 숫자는 1부터 시작
		for(int i = 0; i < count; i++) {
			list[i].print(i+1);
		}
		return true;
	}
	public static Item inputItem() {
		//내역 정보들을 입력
		System.out.print("수입/지출 : ");
		String income = scan.next();
		System.out.print("분류 : ");
		String type = scan.next(); 
		System.out.print("내용 : ");
		scan.nextLine();//next()에서 입력한 엔터를 처리
		String content = scan.nextLine();
		System.out.print("금액 : ");
		int money = scan.nextInt();
		System.out.print("일시 : ");
		String date = scan.next();
		
		Item item = new Item(income, type, content, money, date);
		return item;
	}
	public static boolean checkIndex(int index, int count) {
		return index >= 0 && index < count;
	}
	public static void updateItemList(Item[] list, int count) {
		if(!printItems(list, count)) {
			return;
		}
		//수정할 내역의 숫자를 입력
		System.out.print("수정할 내역의 번호를 선택하세요 : ");
		int index = scan.nextInt() - 1;
		
		//입력한 번호가 올바른 번호인지를 확인
		if(!checkIndex(index, count)) {
			System.out.println("잘못된 번호를 선택했습니다.");
			return;
		}
		//금액을 입력
		System.out.print("금액 : ");
		int money = scan.nextInt();
		//입력받은 숫자 - 1번지에 있는 금액을 수정
		list[index].setMoney(money);
		System.out.println("내역이 수정되었습니다.");
	}
	public static void deleteItem(Item[] list, int count, int index) {
		for(int i = index + 1; i < count; i++) {
			list[i-1] = list[i];
		}
	}
	public static int deleteItemList(Item[] list, int count) {
		if(!printItems(list, count)) {
			return count;
		}
		//삭제할 내역의 숫자를 입력
		System.out.print("삭제할 내역의 번호를 선택하세요 : ");
		int index = scan.nextInt() - 1;
		
		if(!checkIndex(index, count)) {
			System.out.println("잘못된 번호를 선택했습니다.");
			return count;
		}
		//입력받은 숫자 번지+1부터 앞으로 한칸씩 당김
		
		deleteItem(list, count, index);
		//개수를 1감소
		count--;
		System.out.println("내역을 삭제했습니다.");
		return count;
	}
}

class Item{
	String income;
	String type;
	String content;
	int money;
	String date;
	
	public void print() {
		//수입/월급/1월 월급/2000000/2025-01-08
		System.out.println(income + "/" + type + "/" + content + "/" + money + "/" + date);
	}
	public void print(int num) {
		System.out.print(num + ". ");
		print();
	}
	
	public void setMoney(int money) {
		this.money = money;
	}
	public Item(String income, String type, String content, int money, String date) {
		this.income = income;
		this.type = type;
		this.content = content;
		this.money = money;
		this.date = date;
	}
	
	
}
