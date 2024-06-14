package ver2;

import java.sql.SQLException;
import java.util.List;

public interface QuizRepository {

	// 기능
	int addQuizQuestion(String question, String answer) throws SQLException; // 리턴타입 void -> int

	// todo - 추상 클래스로 수정 예정
	List<QuizDTO> viewQuizQuestion() throws SQLException;

	// ResultSet을 반환하지만 List로 선언
	// 노란색 경고등 = (위험할 수 있는 코드)
	// QuizDTO로 자료구조에 담음
	QuizDTO playquizGame() throws SQLException; // QuizDTO 하나로 처리할 수 있음.

	// 구현 클래스로 만들어야 함.

}
