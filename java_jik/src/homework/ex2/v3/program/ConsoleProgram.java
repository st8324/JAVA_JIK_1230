package homework.ex2.v3.program;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

public interface ConsoleProgram {
	
	void run();

	void printMenu();
	
	void runMenu(int menu);
	
	default public Object load(String fileName) {
		try(FileInputStream fis = new FileInputStream(fileName);
			ObjectInputStream ois = new ObjectInputStream(fis)){
			
			Object tmp = ois.readObject();
			
			System.out.println("---------------------");
			System.out.println("[불러오기 성공]");
			System.out.println("---------------------");
			return tmp;
		} catch (Exception e) {
			System.out.println("---------------------");
			System.out.println("[불러오기 실패]");
			System.out.println("---------------------");
		}
		return null;
	}
	
	default void save(String fileName, Object obj) {
		try(FileOutputStream fos = new FileOutputStream(fileName);
			ObjectOutputStream oos = new ObjectOutputStream(fos)){
			
			oos.writeObject(obj);
			System.out.println("---------------------");
			System.out.println("[저장하기 성공]");
			System.out.println("---------------------");
		} catch (Exception e) {
			System.out.println("---------------------");
			System.out.println("[저장하기 실패]");
			System.out.println("---------------------");
			e.printStackTrace();
		}
		
	}
	
	default void removeBuffer() {
		
	}
	
	//윈도우의 다운로드 폴더 경로를 가져오는 메소드
	default String getDownloadPath() {
		// 환경 변수 USERPROFILE 가져오기
        String userProfile = System.getenv("USERPROFILE");

        if (userProfile != null) {
            // 다운로드 폴더 경로 생성
            Path downloadPath = Paths.get(userProfile, "Downloads");
            return downloadPath.toString();
        } 

		return null;
	}
}
