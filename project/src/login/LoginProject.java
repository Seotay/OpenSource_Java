package login;
//https://siloam72761.tistory.com/entry/Java-DB-%ED%9A%8C%EC%9B%90%EA%B0%80%EC%9E%85-%EB%A1%9C%EA%B7%B8%EC%9D%B8-%EC%8B%9C%EC%8A%A4%ED%85%9C-%EB%A7%8C%EB%93%A4%EA%B8%B0
import project.*;

import java.awt.*;
import javax.swing.*;
import java.sql.*;


public class LoginProject {

	JPanel cardPanel;
	LoginProject lp;
	CardLayout card;
	String id = null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LoginProject lp = new LoginProject();
		lp.setFrame(lp);
	}

	public void setFrame(LoginProject lpro) {

		JFrame jf = new JFrame();
		LoginPanel lp = new LoginPanel(lpro);
		signupPanel sp = new signupPanel(lpro);
		userMyPage ump = new userMyPage(lpro);
		adminUser au = new adminUser(lpro);

		card = new CardLayout();

		cardPanel = new JPanel(card);
		cardPanel.add(lp.mainPanel, "Login");
		cardPanel.add(sp.mainPanel, "Register");
		cardPanel.add(ump.mainPanel, "My Page");
		cardPanel.add(au.mainPanel, "Admin Page");
		
		jf.add(cardPanel);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setSize(500, 700);
		jf.setVisible(true);
	}

	public Connection getConnection() throws SQLException {
		Connection conn = null;

		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","0366");

		return conn;
	}
	
	public void setid(String id) {
		this.id = id;
	}

}