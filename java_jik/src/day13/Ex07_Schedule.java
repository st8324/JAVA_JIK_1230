package day13;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import lombok.Data;

public class Ex07_Schedule {

	/* 다음 기능을 실행하는 프로그램을 작성하세요.
	 * 
	 * 1. 스케쥴 등록
	 * 	- 날짜, 시작시간, 할일을 입력하여 등록
	 * 2. 스케쥴 수정
	 * 	- 날짜를 입력
	 * 	- 해당 날짜에 등록된 스케쥴을 출력
	 * 	- 수정할 스케쥴을 선택
	 * 	- 날짜, 시작시간, 할일을 입력하여 수정
	 * 3. 스케쥴 삭제
	 * 	- 날짜를 입력
	 * 	- 해당 날짜에 등록된 스케쥴을 출력
	 * 	- 삭제할 스케쥴을 선택하여 삭제
	 * 4. 스케쥴 조회
	 * 	- 월 조회
	 * 		- 년과 월을 입력받아 스케쥴을 조회
	 * 	- 일 조회 
	 * 		- 년, 월, 일을 입력받아 스케쥴을 조회
	 * - 저장, 로딩을 구현
	 * */
	
	static Scanner scan = new Scanner(System.in);
	static List<Schedule> list = new ArrayList<Schedule>();
	
	public static void main(String[] args) {
		
		int menu = 0;
		final int EXIT = 5;
		String fileName = "src/day13/schedule.txt";
		
		load(fileName, list);
		
		do {
			
			printMenu();
			
			try {
				menu = scan.nextInt();
				scan.nextLine();
				
				runMenu(menu);
			}
			catch(InputMismatchException e) {
				System.out.println("올바른 메뉴를 선택하세요. ");
				scan.nextLine();
			}
			
		}while(menu != EXIT);
		
		save(fileName, list);
		
	}

	private static void load(String fileName, List<Schedule> list) {
		try(FileInputStream fis = new FileInputStream(fileName);
			ObjectInputStream ois = new ObjectInputStream(fis)){
			
			List<Schedule> tmp = (ArrayList<Schedule>) ois.readObject();
			list.addAll(tmp);
		} catch (Exception e) {
			System.out.println("[불러오기 실패]");
		}
	}

	private static void save(String fileName, List<Schedule> list) {
		try(FileOutputStream fos = new FileOutputStream(fileName);
			ObjectOutputStream oos = new ObjectOutputStream(fos)){
			
			oos.writeObject(list);
			
		} catch (Exception e) {
			System.out.println("[저장하기 실패]");
		}
		
	}

	private static void printMenu() {
		System.out.print(
			"------------------\n" + 
			"1. 스케쥴 등록\n" +
			"2. 스케쥴 수정\n" + 
			"3. 스케쥴 삭제\n" + 
			"4. 스케쥴 조회\n" +
			"5. 종료\n" + 
			"------------------\n" + 
			"메뉴 선택 : ");
		
	}

	private static void runMenu(int menu) {
		
		switch(menu) {
		case 1:
			insertSchedule();
			break;
		case 2:
			updateSchedule();
			break;
		case 3:
			deleteSchedule();
			break;
		case 4:
			searchSchedule();
			break;
		case 5:
			System.out.println("프로그램을 종료합니다.");
			break;
		default:
			System.out.println("올바른 메뉴가 아닙니다.");
		}
		
	}

	private static void insertSchedule() {
		try {
			//객체를 생성
			Schedule schedule = inputSchedule();
			//객체를 생성했으면 리스트에 추가
			list.add(schedule);
			System.out.println("스케쥴을 등록했습니다.");
		} catch (ParseException e) {
			System.out.println("날짜와 시간을 잘못 입력했습니다.");
		} 
	}

	private static Schedule inputSchedule() throws ParseException {
		//날짜
		System.out.print("날짜(yyyy-MM-dd) : ");
		String date = scan.nextLine();
		
		//시간
		System.out.print("시간(HH:mm) : ");
		String time = scan.nextLine();
		
		//할일
		System.out.print("할일 : ");
		String todo = scan.nextLine();
		
		return new Schedule(date + " " + time, todo);
	}
	
	private static void updateSchedule() {
		//날짜를 입력
		System.out.print("날짜(yyyy-MM-dd) : ");
		String date = scan.nextLine();
		
		//날짜와 일치하는 일정들을 가져와서 리스트에 저장
		List<Schedule> tmpList = 
			list.stream()
				.filter(s->s.checkDate(date))
				.collect(Collectors.toList());
		
		//출력
		if(tmpList.size() == 0) {
			System.out.println("검색 결과가 없습니다.");
			return;
		}
		for(int i = 0; i<tmpList.size(); i++) {
			System.out.println(i+1 + ". " + tmpList.get(i));
		}
		
		//수정할 일정을 선택
		System.out.print("수정할 일정 : ");
		int index = scan.nextInt() - 1;
		scan.nextLine();
		
		if(index < 0 || index >= tmpList.size()) {
			System.out.println("잘못된 일정을 선택했습니다.");
			return;
		}
		
		//수정할 정보를 입력
		try {
			Schedule schedule = inputSchedule();
			
			//수정
			tmpList.get(index).update(schedule);
			
			System.out.println("스케쥴을 수정했습니다.");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static void deleteSchedule() {
		//날짜를 입력
		System.out.print("날짜(yyyy-MM-dd) : ");
		String date = scan.nextLine();
		
		//날짜와 일치하는 일정들을 가져와서 리스트에 저장
		List<Schedule> tmpList = 
			list.stream()
				.filter(s->s.checkDate(date))
				.collect(Collectors.toList());
		
		//출력
		if(tmpList.size() == 0) {
			System.out.println("검색 결과가 없습니다.");
			return;
		}
		for(int i = 0; i<tmpList.size(); i++) {
			System.out.println(i+1 + ". " + tmpList.get(i));
		}
		
		//삭제할 일정을 선택
		System.out.print("삭제할 일정 : ");
		int index = scan.nextInt() - 1;
		scan.nextLine();
		
		if(index < 0 || index >= tmpList.size()) {
			System.out.println("잘못된 일정을 선택했습니다.");
			return;
		}
		
			
		//삭제할 객체를 가져옴
		Schedule tmp = tmpList.get(index);
		
		//리스트에서 삭제
		list.remove(tmp);
		
		System.out.println("스케쥴을 삭제했습니다.");
		
	}

	private static void searchSchedule() {
		
		printSearchMenu();
		
		int menu = scan.nextInt();
		scan.nextLine();
		
		runSearchMenu(menu);
		
	}

	private static void printSearchMenu() {
		System.out.print(
				"------------------\n" + 
				"1. 월 조회\n" +
				"2. 일 조회\n" +
				"------------------\n" + 
				"메뉴 선택 : ");
	}

	private static void runSearchMenu(int menu) {
		switch(menu) {
		case 1:
			searchMonth();
			break;
		case 2:
			searchDay();
			break;
		default:
			System.out.println("올바른 메뉴가 아닙니다.");
		}
	}

	private static void searchMonth() {
		//날짜
		System.out.print("날짜(yyyy-MM) : ");
		String date = scan.nextLine();
		
		List<Schedule> tmpList = 
				list.stream()
				.filter(s->s.getDateStr().substring(0, 7).equals(date))
				.collect(Collectors.toList());
		
		if(tmpList.size() == 0) {
			System.out.println("검색 결과가 없습니다.");
			return;
		}
		
		tmpList.stream().forEach(s->System.out.println(s));
		
	}

	private static void searchDay() {
		//날짜
		System.out.print("날짜(yyyy-MM-dd) : ");
		String date = scan.nextLine();
		
		List<Schedule> tmpList = 
				list.stream()
				.filter(s->s.getDateStr().substring(0, 10).equals(date))
				.collect(Collectors.toList());
		
		if(tmpList.size() == 0) {
			System.out.println("검색 결과가 없습니다.");
			return;
		}
		
		tmpList.stream().forEach(s->System.out.println(s));
		
	}

}

@Data
class Schedule implements Serializable{
	
	private static final long serialVersionUID = 5104803882544585350L;

	private Date date;
	private String toDo;
	
	//"2025-01-01 12:00"
	public void setDate(String dateTime) throws ParseException {
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		
		this.date = format.parse(dateTime);
	}
	
	public Schedule(String dateTime, String toDo) throws ParseException {
		this.toDo = toDo;
		setDate(dateTime);
	}
	
	public boolean checkDate(String date) {
		if(date == null || this.date == null) {
			return false;
		}
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String tmpDate = format.format(this.date);
		return tmpDate.equals(date);
	}
	public void update(Schedule schedule) {
		
		if(schedule == null) {
			return;
		}
		this.date = schedule.date;
		this.toDo = schedule.toDo;
		
	}
	public String getDateStr() {
		
		if(date == null) {
			return null;
		}
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		return format.format(date);
	}

	@Override
	public String toString() {
		return "[" + getDateStr() + "]" + toDo;
	}
	
	
}









