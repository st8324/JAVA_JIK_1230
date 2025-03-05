package db.ex2.model.vo;

import java.io.Serializable;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class SubjectScore implements Serializable {

	private static final long serialVersionUID = 5589823857268140091L;
	private int num;//sc_num
	@NonNull
	private Subject subject;
	@NonNull
	private int score;//sc_score
	
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