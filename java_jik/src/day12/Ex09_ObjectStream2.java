package day12;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import lombok.AllArgsConstructor;
import lombok.Data;

public class Ex09_ObjectStream2 {

	/* 다음 기능을 갖는 프로그램을 작성하세요.
	 * 단, 저장기능과 불러오기 기능을 추가
	 * - 저장은 프로그램 종료하기 전
	 * - 불러오기는 프로그램 시작 전
	 * 
	 * 1. 자동차 추가
	 * 2. 자동차 조회(전체)
	 * 3. 종료
	 * 
	 * 힌트
	 * ArrayList 클래스도 Serializable 인터페이스를 구현한 구현 클래스이다.
	 * */
	static List<Car> list = new ArrayList<Car>();
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		int menu;
		final int EXIT = 3;
		String fileName = "src/day12/car.txt";
		
		load(fileName, list);
		
		do {
			printMenu();
			
			menu = scan.nextInt();
			scan.nextLine();
			
			runMenu(menu);
			
		}while(menu != EXIT);

		save(fileName, list);
		
	}

	private static void load(String fileName, List<Car> list) {
		try(FileInputStream fis = new FileInputStream(fileName);
			ObjectInputStream ois = new ObjectInputStream(fis)){
			
			List<Car> tmp = (ArrayList<Car>) ois.readObject();
			list.addAll(tmp);
		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다.");
		} catch (IOException e) {
			System.out.println("IO 예외 발생");
		} catch (ClassNotFoundException e) {
			System.out.println("클래스를 찾을 수 없습니다.");
		}
	}

	private static void save(String fileName, List<Car> list) {
		
		try(FileOutputStream fos = new FileOutputStream(fileName);
			ObjectOutputStream oos = new ObjectOutputStream(fos)){
			
			oos.writeObject(list);
			
		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("IO 예외 발생");
		}
		
	}

	private static void printMenu() {
		System.out.print(
			"---------------\n" + 
			"1. 자동차 추가\n" + 
			"2. 자동차 조회\n" + 
			"3. 종료\n" + 
			"---------------\n" + 
			"메뉴 선택 : ");
			
	}

	private static void runMenu(int menu) {
		switch(menu) {
		case 1:
			insertCar();
			break;
		case 2:
			printCar();
			break;
		case 3:
			System.out.println("프로그램을 종료합니다.");
			break;
		default:
			System.out.println("올바른 메뉴가 아닙니다.");
		}
	}

	private static void insertCar() {
		//이름, 브랜드를 입력
		System.out.print("브랜드 : ");
		String brand = scan.nextLine();
		
		System.out.print("이름 : ");
		String name = scan.nextLine();
		
		//객체 생성과 추가
		list.add(new Car(name, brand));
	}

	private static void printCar() {
		
		//정렬
		list.sort((o1, o2)->{
			//브랜드를 비교하여 다르면 사전순으로 정렬
			if(!o1.getBrand().equals(o2.getBrand())) {
				return o1.getBrand().compareTo(o2.getBrand());
			}
			//이름을 사전순으로 정렬
			return o1.getName().compareTo(o2.getName());
		});
		
		for(Car car : list) {
			System.out.println(car);
		}
	}

}
@Data
@AllArgsConstructor
class Car implements Serializable {
	
	private static final long serialVersionUID = 1455289863100321662L;
	
	private String name;
	private String brand;
	@Override
	public String toString() {
		return brand + " : " + name;
	}
	
	
}




