package day22;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class WordManager {

	private List<Word> list;

	public boolean insert(Word word) {
		if(	word == null || 
			word.getWord() == null || 
			word.getPartsOfSpeech() == null || 
			word.getMeaning() == null) {
			return false;
		}
		
		//품사 체크
		switch(word.getPartsOfSpeech()) {
		case "명", "대", "동", "형", "부", "전", "접", "관":
			break;
		default:
			return false;
		}
		
		//단어, 뜻 체크
		if(	word.getWord().trim().isEmpty() ||
			word.getMeaning().trim().isEmpty()) {
			return false;
		}
		//완전하게 동일한 단어가 있는 경우
		if(list.contains(word)) {
			return false;
		}
		list.add(word);
		return true;
	}

	public List<Word> getWordList(String word) {
		return list.stream()
				.filter(w->w.getWord().equals(word))
				.collect(Collectors.toList());
	}

	public void print(List<Word> tmpList) {

		if(tmpList == null || tmpList.isEmpty()) {
			System.out.println("[일치하는 단어가 없습니다.]");
			return;
		}
		
		for(int i = 0; i<tmpList.size(); i++) {
			System.out.println(i+1 +". " + tmpList.get(i));
		}
		
	}

	public boolean update(Word word, Word wordObj) {
		if(word == null || wordObj == null) {
			return false;
		}
		word.update(wordObj);
		return true;
	}

	public boolean delete(Word word) {
		return list.remove(word);
	}

	public void print() {

		System.out.println(list);
		
	}

	public void sort() {

		list.sort((o1, o2)->{
			return o1.getWord().compareTo(o2.getWord());
		});
	}

	public void print(String word) {

		List<Word> tmpList = 
			list.stream()
				.filter(w->w.getWord().contains(word))
				.collect(Collectors.toList());
		if(tmpList.isEmpty()) {
			System.out.println("[일치하는 단어가 없습니다.]");
			return;
		}
		tmpList.stream().forEach(w->System.out.println(w));
	}
	
	
}
