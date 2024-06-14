package ver2;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class QuizRepositoryTest1 {

	public static void main(String[] args) {

		// 메서드 호출해서 실행 확인 디버깅 확인 테스트 하기
		// QuizRepository 구현 클래스 테스트
		QuizRepositoryImpl quizRepositoryImpl = new QuizRepositoryImpl();

		// for 문 전부 돌아서 id 8번까지 지문 전체 출력됨.
		try {
//			List<QuizDTO> quizDTOs = quizRepositoryImpl.viewQuizQuestion();
//			for (QuizDTO quizDTO : quizDTOs) {
//				System.out.println(quizDTO);
//			}

			Scanner sc = new Scanner(System.in);
			// 한 줄 출력됨.
			QuizDTO dto = quizRepositoryImpl.playquizGame();
			//System.out.println(dto); // 주소값이 담겨서 출력됨.

			System.out.println(dto.getQuestion());
			String userInput = sc.nextLine();
			if (dto.getAnswer().equalsIgnoreCase(userInput)) {
				System.out.println("정답");
			} else {
				System.out.println("오답");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		// 실행의 흐름

	}

}
