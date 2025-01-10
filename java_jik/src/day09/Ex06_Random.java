package day09;

import java.util.Random;

public class Ex06_Random {

	public static void main(String[] args) {
		
		//시드값이 같으면 랜덤 수가 매번 동일하게 나옴
		Random random = new Random(1);
		int min = 1, max = 10;

		for(int i = 0; i<10; i++) {
			int r = random.nextInt(max - min + 1) + min;
			System.out.println(r);
		}
	}

}
