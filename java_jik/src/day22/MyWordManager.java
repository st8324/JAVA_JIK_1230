package day22;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MyWordManager {

	private Map<String, List<Word>> myWords;
	
	public MyWordManager(Map<String, List<Word>> myWords) {
		this.myWords = myWords;
	}

	public void add(String id, Word word) {
		
		List<Word> list = myWords.get(id);
		//단어 검색어를 처음 등록할 때
		if(list == null) {
			list = new ArrayList<Word>();
			list.add(word);
			myWords.put(id, list);
			return;
		}
		
		list.remove(word); //혹시 기존에 일치하는 검색어가 있으면 삭제하기 위해
		list.add(word);
		
	}
	
	public void print(String id) {
		List<Word> list = myWords.get(id);
		//단어 검색어가 없는 경우
		if(list == null) {
			System.out.println("[검색 기록이 없습니다.]");
			return;
		}
		list.stream().forEach(w->System.out.println(w));
	}

}
