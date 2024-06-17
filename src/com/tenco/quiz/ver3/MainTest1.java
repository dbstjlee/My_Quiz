package com.tenco.quiz.ver3;

import java.sql.SQLException;
import java.util.List;

public class MainTest1 {

	public static void main(String[] args) {

		QuizRepositoryImpl quizRepositoryImpl = new QuizRepositoryImpl();
		try {
			List<QuizDTO> quizDtos = quizRepositoryImpl.viewQuizQuestion();
			for (QuizDTO quizDTO : quizDtos) {
				System.out.println(quizDTO);
			}

			QuizDTO dto = quizRepositoryImpl.playquizGame(); // 주소값이 담김
			System.out.println(dto);

			System.out.println("정답을 맞추시오");
			System.out.println(dto.getQuestion());
			String userInput = "한국";
			if (dto.getAnswer().equalsIgnoreCase(userInput)) {
				System.out.println("정답");
			} else {
				System.out.println("오답");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}// end of main

}
