package day13;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

public class Ex01_Transient {

	public static void main(String[] args) {
		/* transient 
		 *  - 직렬화, 역직렬화가 되는 과정에서 직렬화/역직렬화를 하고 싶지 않은
		 *    객체에 사용
		 * */
		Point p = new Point(1, 2, 3);
		
		String fileName = "src/day13/point.txt";
		
		try(ObjectInputStream ois 
			= new ObjectInputStream(new FileInputStream(fileName))){
			p = (Point)ois.readObject();
		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다.");
		} catch (IOException e) {
			System.out.println("IO 예외 발생");
		} catch (ClassNotFoundException e) {
			System.out.println("클래스를 찾을 수 없습니다.");
		}
		
		System.out.println(p);

		try(ObjectOutputStream oos 
				= new ObjectOutputStream(new FileOutputStream(fileName))){
			oos.writeObject(p);
		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다.");
		} catch (IOException e) {
			System.out.println("IO 예외 발생");
		}
	}

}

@Data
@AllArgsConstructor
class Point implements Serializable{
	
	private static final long serialVersionUID = -5564626764405437214L;

	private int x, y;
	
	private transient int z;
	
}






