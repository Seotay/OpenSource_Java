package jdbc_9;

import java.io.*;
import java.sql.*;

public class JDBC_Ex3 {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb", "root", "0366");
			System.out.println("DB 연결 완료");
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("insert into student (name, id, dept) values ('아무개', '0893012', '컴퓨터공학')");
			printTable(stmt);
			
			stmt.executeUpdate("update student set id ='089011' where name = '아무개'");
			printTable(stmt);
			
			stmt.executeUpdate("delete from student where name = '아무개'");
			printTable(stmt);
		}catch(ClassNotFoundException e) {
			System.out.println("JDBC 드라이버 로드 에러");
		}catch(SQLException e) {
			System.out.println("SQL 실행 에러");
		}
	}

	private static void printTable(Statement stmt) throws SQLException{
		ResultSet srs = stmt.executeQuery("select * from student");
		while(srs.next()) {
			System.out.print(srs.getString("name"));
			System.out.print("\t|\t" + srs.getString("id"));
			System.out.println("\t|\t" + srs.getString("dept"));
		}
		System.out.println();
	}
}
