package day22;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public interface ConsoleProgram {
	
	void run();

	default void printMenu() {}
	
	default void runMenu(int menu) {}
	
	default Object load(String fileName) {
		try(FileInputStream fis = new FileInputStream(fileName);
			ObjectInputStream ois = new ObjectInputStream(fis)){
			
			return ois.readObject();
			
		} catch (Exception e) {
			
		}
		return null;
	}
	
	default void save(String fileName, Object obj) {
		try(FileOutputStream fos = new FileOutputStream(fileName);
			ObjectOutputStream oos = new ObjectOutputStream(fos)){
			
			oos.writeObject(obj);
			
		} catch (Exception e) {
			
		}
	}
}
