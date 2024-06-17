package com.tenco.quiz.ver3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

/**
 * 커넥션 풀을 활용하는 예제로 수정해보자. HikariCP-5.1.0.jar lib 설정
 */

// DBHelper, DBClient 로 이름 짓기도 함.
public class DBConnectionManager {

	private static HikariDataSource dataSource;

	private static final String URL = "jdbc:mysql://localhost:3306/quizdb?serverTimezone=Asia/Seoul";
	private static final String USER = "root";
	private static final String PASSWORD = "asd123";

	// static {} 블록 - 정적 초기화 블록
	// 특징 : 클래스가 처음 컴파일(로드)될 때 딱 한 번 실행됩니다.
	// 정적 변수의 초기화나 복잡한 초기화 작업을 수행할 때 사용
	// static {} 블록 안에 예외를 던질 수도 있다.
	static {
		// HikariCP를 사용하기 위한 설정이 필요하다.
		// Hikariconfig 라는 객체를 만들어 제공해줘서
		// 이 클래스를 활용해서 설정을 상세히 할 수 있다.
		// 보조 스트림 붙이듯이 설정하는 객체(Hikariconfig)를 꽂아서 사용한다.
		HikariConfig config = new HikariConfig();
		config.setJdbcUrl(URL);
		config.setUsername(USER);
		config.setPassword(PASSWORD);
		config.setMaximumPoolSize(10); // 최대 연결 수 설정 10개(10개로 가졌다가 쓰고 함(기본값))

		// 메모리에 띄우기
		// 기본 객체 생성
		dataSource = new HikariDataSource(config);

	}

	public static Connection getConnection() throws SQLException {
		System.out.println("HikariCP를 사용한 Data Source 활용");
		return dataSource.getConnection(); // Hikari....데이터 타입이 리턴됨.
	}

	// 테스트 코드 확인
	public static void main(String[] args) {

		// dataSource의 getConnection()을 conn에 담아야 함.
		try {
			Connection conn = DBConnectionManager.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// NoClassDefFoundError 에러 발생 : org/slf4j(라이브러리)/LoggerFactory 를 연결해야 함.
		// 추가적인 라이브러리 설정 필요
		// slf4j - 로그를 찍어주는 라이브러리(Maven repository)에 검색
		//

	}// end of main

	// 정적 메서드(함수) 커넥션 객체를 리턴하는 함수를 만들어 보자
	// 기본 JDBC 드라이버 사용 버전
//	public static Connection getConnection() throws SQLException {
//		return DriverManager.getConnection(URL, USER, PASSWORD);
//	}

} // end of class
