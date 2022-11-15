package project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


// Class for Action 
class Action extends JFrame implements ActionListener{
	frame f; // 메인 윈도우 관련 객체 
	test t; // DB 관련 객체
	JTextField search_field; // 검색 텍스트 필드
	JTextField name, author, publisher, date, quantity; // 추가 텍스트 필드 
	
	// panel 1 (도서 추가 관련)에서 객체 생성
	public Action(frame f, test t, JTextField name, JTextField author, JTextField publisher, JTextField date, JTextField quantity) {
		this.f = f;
		this.t = t;
		this.name = name;
		this.author = author;
		this.publisher = publisher;
		this.date = date;
		this.quantity = quantity;
	}
	
	// panel 2 (도서 조회 관련)에서 객체 생성
	public Action(frame f, test t) {
		this.f=f;
		this.t=t;
	}
	
	// panel 3 (도서 검색 관련)에서 객체 생성
	public Action(frame f, test t,JTextField search_field) {
		this.f=f;
		this.t=t;
		this.search_field=search_field;
	}
	
	// (도서 추가 관련) 이벤트 처리
	public void func1() {
		// 조건 만족 시 SQL문 실행 
		try {
			String n = name.getText();
			String a = author.getText();
			String p = publisher.getText();
			String d = date.getText();
			String q = quantity.getText();
			
			
			
			// 입력 안 들어옴
			if (n.equals("")||a.equals("")||p.equals("")||d.equals("")||q.equals("")) {
				f.error_label.setText("입력 없음! ");
				f.error_label.setForeground(Color.RED);
			}
			// 입력 들어옴
			else {
				// SQL문 실행
				t.stmt.executeUpdate("insert into book values('" + n + "', '" + a + " ', '" + p+"' ,  ' " + d +"', '" + q+"');");
				f.error_label.setText("저장 완료!! (전체 목록을 눌러서 확인!!)");
				f.error_label.setForeground(Color.BLUE);
				// 입력 초기화
				name.setText(null);
				author.setText(null);
				publisher.setText(null);
				date.setText(null);
				quantity.setText(null);
			}
		} 
		// DB Error 
		catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			f.error_label.setText("SQL 실행 에러");
			f.error_label.setForeground(Color.RED);
		}	
	}
	
	// (도서 조회 관련) 이벤트 처리
	public String[][] func2() {
		// SQL문 실행
		try {
			ResultSet rs = t.stmt.executeQuery("select * from book;");
			// 데이터 확인
			int rows = 0;
			if (rs.last()) {
			    rows = rs.getRow(); // rows는 book 테이블의 행의 수(레코드 개수)를 저장
			    rs.beforeFirst(); // 처음 행의 위치로
			}
			// 데이터 존재
			if(rows>0) {
				// 데이터를 2차원 배열에 담아서 리턴 
				String[][] contents = new String[rows][5]; //
				
				int idx=0;
				
				while(rs.next()) {
					contents[idx][0]=rs.getString("name");
					contents[idx][1]=rs.getString("author");
					contents[idx][2]=rs.getString("publisher");
					contents[idx][3]=rs.getString("date");
					contents[idx][4]=rs.getString("quantity");
					idx++;
				}
				
				f.error_label.setText("조회 완료!!");
				f.error_label.setForeground(Color.BLUE);
				return contents;
			}
			// 데이터 존재 X
			else {
				// 빈 2차원 배열 리턴 
				f.error_label.setText("데이터 없음!");
				f.error_label.setForeground(Color.RED);
				
				String[][] contents = new String[1][3];
				return contents;
			}
		}
		// DB Error 
		catch (SQLException e1) {
			e1.printStackTrace();
			f.error_label.setText("SQL 실행 에러");
			f.error_label.setForeground(Color.RED);
			return null;
		}
	}
	
	// (도서 검색 관련) 이벤트 처리
	public String[][] func3() {
		// 조건 만족 시 SQL문 실행 
		try {
			ResultSet rs;
			String search = search_field.getText();
			// 입력 들어옴
			if (!search.equals("")) { // 검색란 입력이 공백이 아니면
				rs = t.stmt.executeQuery("select * from book where name like '%" + search + "%' or publisher like '%" + search + "' or author like '%" + search + "%';");
				
				// 입력 초기화
				search_field.setText(null);
				
				// 데이터 확인
				int rows = 0;
				if (rs.last()) {
				    rows = rs.getRow();
				    rs.beforeFirst();
				}
				
				// 데이터 존재
				if(rows>0) {
					// 데이터를 2차원 배열에 담아서 리턴 
					String[][] contents=new String[rows][5];
					int idx=0;
					while(rs.next()) {
						contents[idx][0]=rs.getString("name");
						contents[idx][1]=rs.getString("author");
						contents[idx][2]=rs.getString("publisher");
						contents[idx][3]=rs.getString("date");
						contents[idx][4]=rs.getString("quantity");
						idx++;
					}	
					f.error_label.setText("("+search+") 검색 완료!!");
					f.error_label.setForeground(Color.BLUE);
					return contents;
				}
				// 데이터 존재 X
				else {
					// 빈 2차원 배열 리턴 
					f.error_label.setText("데이터 없음!");
					f.error_label.setForeground(Color.RED);
					String[][] contents=new String[1][5];
					return contents;
				}
			}
			// 입력 안 들어옴
			else {
				f.error_label.setText("입력 데이터 없음!");
				f.error_label.setForeground(Color.RED);
				return null;
			}
		}
		// DB Error 
		catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			f.error_label.setText("DB Error");
			f.error_label.setForeground(Color.RED);
			return null;
		}
	}
	
	@Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
		JButton act=(JButton) e.getSource(); // 활동하는 버튼 
	    String actname = act.getText(); // 활동하는 버튼의 텍스트
	    	
	    switch(actname) {
	    	case "추가":
	    		func1(); // 도서 추가 이벤트 처리 핵심 -> 테이블에 입력한 도서 추가 
	    		break;
	    		
	    	case "전체 목록":
	    		// mini-window size, title, location
		    	getContentPane().removeAll(); // 기존 윈도우 삭제되고 새로운 윈도우 생성 하는데 기존에 안 사라진게 있을 수 있어서 지움
	    		setSize(400,200);
	    		setTitle("전체 목록 조회");
	    		setLocation(1190,300);
	    		
	    		// table setting
	    		String[] header= {"이름", "저자", "출판사","출판일", "재고"};
	    		String[][] contents=func2(); // 도서 조회 이벤트 처리 핵심 -> 전체 도서 목록이 담긴 2차원 배열 반환 
	    		if(contents != null) {
		    		JTable table = new JTable(contents, header);
		    		JScrollPane scrollpane=new JScrollPane(table);
		    		add(scrollpane);
		    		setVisible(true);
	    		}
	    		break;
	    	
	    	case "검색":
	    		// mini-window size, title, location
		    	getContentPane().removeAll(); // 기존 윈도우 삭제되고 새로운 윈도우 생성하는데 기존에 안 사라진게 있을 수 있어서 지움
	    		setSize(400,200);
	    		setTitle("도서 검색");
	    		setLocation(1190,500);
	    		// table setting
	    		String[] header2= {"이름", "저자", "출판사", "출판일", "재고"};
	    		String[][] contents2=func3(); // 도서 검색 이벤트 처리 핵심 -> 도서 검색한 목록이 담긴 2차원 배열 반환
	    		if(contents2 != null) {
		    		JTable table2 = new JTable(contents2, header2);
		    		JScrollPane scrollpane2=new JScrollPane(table2);
		    		add(scrollpane2);
		    		setVisible(true);
	    		}
	    		break;
	    }

    }


// class for DB Connection (DB 연결 객체)
	public static void main(String[] args) {
		test t = new test(); // DB 연결 및 윈도우 생성
	}
}
