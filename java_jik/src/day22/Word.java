package day22;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Word implements Serializable {

	private static final long serialVersionUID = 1L;

	private String word;
	private String partsOfSpeech;
	private String meaning;
	
	@Override
	public String toString() {
		return word + " [" + partsOfSpeech + "] " + meaning;
	}

	public void update(Word word) {

		this.word = word.word;
		this.partsOfSpeech = word.partsOfSpeech;
		this.meaning = word.meaning;
		
	}
	
	
}
