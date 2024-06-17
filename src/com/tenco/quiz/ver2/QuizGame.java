package com.tenco.quiz.ver2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.tenco.quiz.DBConnectionManager;

public class QuizGame{

	// 테스트 용도
	public static void main(String[] args) {

		// Define.UPDATE_QUIZ1; => 수정된 코드를 여기 클래스에서 묶어서 조작할 수 있음.

		try (Connection conn = DBConnectionManager.getConnection(); 
				Scanner scanner = new Scanner(System.in)) {

			// CRUD
			while (true) {
				printMenu(); // while문 -> ctrl + 1 눌러서 메서드 생성 후
				// 메서드명 바꾸면 밑에도 메서드 생성되고 메서드명이 변경되어있음

				int choice = scanner.nextInt();
				// while문 계속 돌지만 한 번 돌고 블로킹됨.
				// 다시 while 문 돌고 대기함.

				if (choice == 1) {
					// 퀴즈 문제 추가 --> 함수로 만들기
					//addQuizQuestion(conn, scanner);
					// 블록잡아서 shift + alt + m : 메서드 생성

				} else if (choice == 2) {
					// 퀴즈 문제 조회 --> 함수로 만들기
					//viewQuizQuestion(conn);
					// ctrl + 1번 => 더 간편함.

				} else if (choice == 3) {
					// 퀴즈 게임 시작 --> 함수로 만들기
					//playquizGame(conn, scanner);

				} else if (choice == 4) {
					System.out.println("프로그램을 종료합니다");
					break;
				} else {
					System.out.println("잘못된 선택입니다. 다시 시도하세요.");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}// end of main

	private static void printMenu() {
		System.out.println();
		System.out.println("------------------------------------");
		System.out.println("1. 퀴즈 문제 추가");
		System.out.println("2. 퀴즈 문제 조회");
		System.out.println("3. 퀴즈 게임 시작");
		System.out.println("4. 종료");
		System.out.print("옵션을 선택 하세요: ");
	}

//	private static void playquizGame(Connection conn, Scanner scanner) {
//
//		try (PreparedStatement pstmt = conn.prepareStatement(RANDOM_QUIZ)) {
//			ResultSet rs = pstmt.executeQuery(); // select 구문이라 ResultSet 데이터 타입
//
//			// 방어적 코드
//			if (rs.next()) {
//				String question = rs.getString("question");
//				String answer = rs.getString("answer");
//				System.out.println("퀴즈문제 : " + question);
//				
//				// 버그 처리
//				scanner.nextLine(); // nextLine = \n (enter)(띄어쓰기)
//				System.out.print("당신의 답 : ");
//				
//				String userAnswer = scanner.nextLine();
//
//				if (userAnswer.equalsIgnoreCase(answer)) { // 대소문자 관련 없이
//					System.out.println("정답입니다! 점수를 얻었습니다.");
//				} else {
//					System.out.println("오답입니다!");
//					System.out.println("퀴즈정답 --> " + answer);
//				}
//			} else {
//				System.out.println("죄송합니다. 아직 퀴즈 문제를 만들고 있습니다.");
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}

//	private static void viewQuizQuestion(Connection conn) {
//		try (PreparedStatement pstmt = conn.prepareStatement(VIEW_QUIZ)) { // 자원 열고 닫기
//			ResultSet resultSet = pstmt.executeQuery();
//			while (resultSet.next()) { // next(): 다음 요소가 있는지 없는지 true, false 반환
//				System.out.println("문제 ID : " + resultSet.getInt("id")); // 키 값 = id
//				System.out.println("문제 : " + resultSet.getString("question"));
//				System.out.println("정답 : " + resultSet.getString("answer"));
//				if (!resultSet.isLast()) {
//					System.out.println("--------------------------------------");
//				}
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}

//	private static void addQuizQuestion(Connection conn, Scanner scanner) {
//		System.out.println("퀴즈 문제를 입력하세요: ");
//		scanner.nextLine();
//		String question = scanner.nextLine();
//		System.out.println("퀴즈 정답을 입력하세요: ");
//		String answer = scanner.nextLine();
//
//		// 핵심 기능
//		try (PreparedStatement pstmt = conn.prepareStatement(ADD_QUIZ)) {
//			pstmt.setString(1, question);
//			pstmt.setString(2, answer);
//			int rowsInsertedCount = pstmt.executeUpdate();
//			System.out.println("추가된 행의 수 : " + rowsInsertedCount);
//
//		} catch (SQLException e) { // 쿼리를 잘못 만들 수도 있기 때문에 예외 발생 가능
//			e.printStackTrace();
//		}
//	}
	// 퀴즈를 추가하는 함수 만들기
	// 사용자한테 퀴즈와 답을 입력 받아야 함.
	// 데이터를 받았다면 Mysql에 접근해서 쿼리를 던져야 함.
	// Connection을 활용해서 query를 날려야 한다.
	// Connection과 Scanner 객체 사용
}
// 공백 제거 String 클래스 --> replace() 메서드로 사이 공백? -> 무공백으로 변경 가능
