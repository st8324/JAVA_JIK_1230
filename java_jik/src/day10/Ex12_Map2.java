package day10;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Ex12_Map2 {

	public static void main(String[] args) {
		
		/* 반복문을 이용하여 Map에 있는 값들을 확인 예제 */
		HashMap<String, String> user = new HashMap<String, String>();
		
		user.put("abc123", "123123");
		user.put("qwe123", "qwe123");
		
		/* keySet()을 이용
		 * - key값들을 하나의 Set으로 만들어서 반환
		 * */
		Set<String> keySet = user.keySet();
		
		for(String id : keySet) {
			String pw = user.get(id);
			System.out.println(id + " : " + pw);
		}
		System.out.println("--------------------");
		Iterator<String> it = keySet.iterator();
		while(it.hasNext()) {
			String id = it.next();
			String pw = user.get(id);
			System.out.println(id + " : " + pw);
		}
		
		System.out.println("--------------------");
		Set<Map.Entry<String, String>> entrySet = user.entrySet();
		for(Map.Entry<String, String> entry : entrySet) {
			String id = entry.getKey();
			String pw = entry.getValue();
			System.out.println(id + " : " + pw);
		}
		System.out.println("--------------------");
		Iterator<Map.Entry<String, String>> it2 = entrySet.iterator();
		while(it2.hasNext()) {
			Map.Entry<String, String> entry = it2.next();
			String id = entry.getKey();
			String pw = entry.getValue();
			System.out.println(id + " : " + pw);
		}
	}

}





