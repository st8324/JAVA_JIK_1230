package day07;

public class Ex06_AccountBook {

	public static void main(String[] args) {
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
