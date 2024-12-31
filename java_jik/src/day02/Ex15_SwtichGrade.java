package day02;

public class Ex15_SwtichGrade {

	public static void main(String[] args) {
		/* 주어진 성적에 맞는 학점을 출력하세요.
		 * A : 90~109
		 * B : 80~89
		 * C : 70~79
		 * D : 60~69
		 * F : -9~59
		 * 잘못된 성적 : 110이상, -9 미만
		 * */
		int score = -10;
		
		switch(score / 10) {
		case 10, 9:
			System.out.println(score + "는 A");
			break;
		case 8:
			System.out.println(score + "는 B");
			break;
		case 7:
			System.out.println(score + "는 C");
			break;
		case 6:
			System.out.println(score + "는 D");
			break;
		case 0,1,2,3,4,5:
			System.out.println(score + "는 F");
			break;
		default:
			System.out.println(score + "는 잘못된 성적");
		}
	}

}
