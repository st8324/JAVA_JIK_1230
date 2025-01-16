package day13;

public class Ex04_Thread {

	public static void main(String[] args) {
		
		MyThread1 th1 = new MyThread1();
		th1.start();
		//th1.run();

		//Runable 인터페이스를 구현한 구현 클래스를 이용
		Thread th2 = new Thread(new MyThread2());
		th2.start();
		//th2.run();
		
		//Runable 인터페이스를 구현한 익명 클래스를 이용(람다식)
		Thread th3 = new Thread(()->{
			for(int i = 0; i<10000; i++) {
				System.out.print("*");
			}
		});
		th3.start();
		
		for(int i = 0; i<10000; i++) {
			System.out.print("|");
		}
	}

}

class MyThread1 extends Thread{
	
	@Override
	public void run() {
		for(int i = 0; i<10000; i++) {
			System.out.print("-");
		}
	}
}

class MyThread2 implements Runnable{

	@Override
	public void run() {
		for(int i = 0; i<10000; i++) {
			System.out.print("+");
		}	
	}
	
}