package day13;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ex03_IOStream {

	public static void main(String[] args) {

		
		//불러오기
		try(FileReader fr = new FileReader("src/day13/string.txt");
			BufferedReader br = new BufferedReader(fr)){
			String line;
			while( (line = br.readLine()) != null) {
				System.out.println(line);
			}
		} catch (FileNotFoundException e1) {
			System.out.println("파일을 찾을 수 없습니다.");
		} catch (IOException e1) {
			System.out.println("불러오기 도중 IO 예외 발생");
			e1.printStackTrace();
		}
		

		
		//저장하기
		/* FileWriter에서 이어쓰기를 하려면 생성자에 파일명과 true를 순서대로 넣어주면 됨
		 * */
		try(FileWriter fw = new FileWriter("src/day13/string.txt",true)){
			fw.write("안녕하세요.\n");
			fw.write("제이름은 홍길동입니다.\n");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

