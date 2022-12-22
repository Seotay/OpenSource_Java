package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



//class for DB Connection (DB 연결 객체)
public class test { 
	Connection conn;
	Statement stmt;
	ResultSet rs;
	
	public test() { 
		// DB Connection 
		try {
			// Connection을 위해 필요한 DB Driver 로드�
			Class.forName("com.mysql.jdbc.Driver"); 
			// DB Connection 
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","0366");
			System.out.println("DB 연결 완료");
			
			// Statement 객체 생성 (Java -> DB로 SQL문 전송하는 역할, DB -> JAVA 처리 결과 전송할 때 받는 역할)
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);		
			
			// 윈도우 생성 
			frame f = new frame(this); 
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("JDBC 드라이버 로드 에러");
		}
		catch(SQLException se) {
			se.printStackTrace();
			System.out.println("SQL 실행 에러");
		}
	}


}
