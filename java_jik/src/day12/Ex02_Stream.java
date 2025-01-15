package day12;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lombok.AllArgsConstructor;
import lombok.Data;

public class Ex02_Stream {

	public static void main(String[] args) {
		
		List<Person2> list = new ArrayList<Person2>();
		
		list.add(new Person2("홍길동", 20, "남"));
		list.add(new Person2("하니", 20, "여"));
		list.add(new Person2("산타", 80, "남"));
		list.add(new Person2("또치", 75, "여"));
		
		//남자들의 정보만 출력
		Stream<Person2> stream = list.stream();
		stream
			.filter(p -> p.getGender().equals("남")) //남자들만 남도록
			.forEach(p-> System.out.println(p));//정보를 출력
		
		System.out.println("---------------------");
		
		//나이가 30미만인 여자들의 정보만 출력
		stream = list.stream();
		stream
			.filter( p -> p.getAge() < 30)
			.filter( p -> p.getGender().equals("여"))
			.forEach( p -> System.out.println(p));
		
		System.out.println("---------------------");
		
		//여자들의 수
		stream = list.stream();
		long count = stream
						.filter( p -> p.getGender().equals("여"))
						.count();
		System.out.println("여자들의 수 : " + count);
		
		System.out.println("---------------------");
		
		//사람들의 평균 나이를 계산
		/* map()은 Person2를 R로 리턴
		 * mapToIn()는 Person2를 Integer로 리턴
		 * average()는 평균을 구하는데, 스트림에 아무것도 없어서 평균을 구할 수 없는 경우가
		 * 발생할 수 있다. 그래서 OptionalDouble로 리턴
		 * OptionalDouble에는 isPresent() 메소드를 통해 평균이 있는지 없는지 확인할 수 있다
		 * */
		stream = list.stream();
		OptionalDouble avg = stream.mapToInt(Person2::getAge).average();
		//OptionalDouble avg = stream.mapToInt(p->p.getAge()).average();
		
		if(avg.isPresent()) {
			System.out.println("평균 나이 : " + avg.getAsDouble());
		}else {
			System.out.println("일치하는 사람이 없습니다.");
		}
		
		System.out.println("---------------------");
		
		/* orElse는 OptionalDouble에서 제공하는 메소드로 평균이 있으면 평균을,
		 * 없으면 매개변수 값을 double로 반환 */
		stream = list.stream();
		double avg2 = stream.mapToInt(Person2::getAge).average().orElse(0);
		System.out.println("평균 나이 : " + avg2);
		
		System.out.println("---------------------");
		
		/* 스트림을 객체로 변환
		 * */
		stream = list.stream();
		int num = 30;
		List<Person2> list2 
			= stream
				.filter(p->p.getAge()>num)
				.collect(Collectors.toList());
		System.out.println(list2);
		
		System.out.println("---------------------");
		//숫자와 함께 출력
		stream = list.stream();
		//숫자를 1씩 증가하기 위한 클래스 객체를 생성
		AtomicInteger index = new AtomicInteger(0);
		
		stream.forEach( p ->{
			int curIndex = index.getAndIncrement();//현제 번지를 가져오고 1증가
			System.out.println(curIndex + 1 + ". " + p);
		});
	}

}

class A{
	int num;
	public A(int num) {
		this.num = num;
	}
	public void increase() {
		num++;
	}
	public int get() {
		return num;
	}
}

@Data
@AllArgsConstructor
class Person2{
	private String name;
	private int age;
	private String gender;
}





