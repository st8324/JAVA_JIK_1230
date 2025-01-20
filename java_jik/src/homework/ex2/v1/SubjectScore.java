package homework.ex2.v1;

import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SubjectScore {

	private Subject subject;
	private int score;
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SubjectScore other = (SubjectScore) obj;
		return Objects.equals(subject, other.subject);
	}

	@Override
	public String toString() {
		return subject + " " + score + "점";
	}
	
	
}
