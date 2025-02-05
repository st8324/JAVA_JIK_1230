package day23;

import java.io.FileReader;
import java.io.FileWriter;

public class Ex16_IOStream {

	public static void main(String[] args) {
		
		String fileName = "src/day23/ex16.txt";
		/* FileWriter(파일명) : 기존 파일을 지우고 새로 만듬
		 * FileWriter(파일명, boolean) : true이면 이어쓰기, false이면 새로 만듬
		 * */
		try(FileWriter fw = new FileWriter(fileName)){
			fw.write("안녕하세요\n");
			fw.write("제 이름은 홍길동입니다.\n");
			fw.flush();
		}catch (Exception e) {

		}
		
		try(FileReader fr = new FileReader(fileName)){
			while(fr.ready()) {
				char ch = (char)fr.read();
				System.out.print(ch);
			}
		}catch (Exception e) {

		}

	}

}
