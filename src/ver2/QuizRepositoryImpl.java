package ver2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tenco.quiz.DBConnectionManager;

public class QuizRepositoryImpl implements QuizRepository {

	public static final String ADD_QUIZ = " insert into quiz(question, answer) values(?, ?) ";
	public static final String VIEW_QUIZ = " select * from quiz ";
	public static final String RANDOM_QUIZ = " select * from quiz order by rand() limit 1 ";

	@Override
	public int addQuizQuestion(String question, String answer) throws SQLException {

		int resultRowCount = 0; // 초기화해주는 습관이 좋다.

		try (Connection conn = DBConnectionManager.getConnection()) {
			PreparedStatement pstmt = conn.prepareStatement(ADD_QUIZ);
			// 트랜잭션 처리도 가능 - 수동 모드 커밋 사용 가능
			pstmt.setString(1, question);
			pstmt.setString(2, answer);
			pstmt.executeUpdate(); // 실행

		}

		return resultRowCount;
	}

	@Override
	public List<QuizDTO> viewQuizQuestion() throws SQLException {

		List<QuizDTO> list = new ArrayList<>(); // 자료구조 자체를 만듦.
		// (퀴즈라는 오브젝트를 만드는 메모리 공간 자체를 만듬) 객체 생성 X

		try (Connection conn = DBConnectionManager.getConnection()) {
			PreparedStatement pstmt = conn.prepareStatement(VIEW_QUIZ);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String question = rs.getString("question");
				String answer = rs.getString("answer");
				list.add(new QuizDTO(id, question, answer)); // list의 add 기능에 익명 클래스를 넣음
			}
		}
		return list;
	}

	@Override
	public QuizDTO playquizGame() throws SQLException {

		QuizDTO quizDTO = null;

		try (Connection conn = DBConnectionManager.getConnection()) {
			PreparedStatement pstmt = conn.prepareStatement(RANDOM_QUIZ);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				int id = rs.getInt("id");
				String question = rs.getString("question");
				String answer = rs.getString("answer");
				quizDTO = new QuizDTO(id, question, answer);
			}
		}
		return quizDTO;
	}
}