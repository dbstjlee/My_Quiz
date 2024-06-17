package com.tenco.quiz.ver3;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// MySql의 한 줄에 해당하는 데이터를 담는 용도로 사용

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class QuizDTO {

	private int id;
	private String question;
	private String answer;

}
