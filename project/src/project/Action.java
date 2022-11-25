package project;

import login.*;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


// Class for Action 
class Action extends JFrame implements ActionListener{
	frame f; // 메인 윈도우 관련 객체 
	bpanel bp;
	test t; // DB 관련 객체
	JTextField search_field; // 검색 텍스트 필드
	JTextField bookID, name, author, publisher, date; // 추가 텍스트 필드
	JTextField userID; // 사용자 ID 텍스트 필드
	
	
	Calendar borrowedDate, returnDate; ////
	
	
	// 도서 대여 및 반납 버튼 
	public Action(frame f)
	{
		
	}
	
	// panel 1 (도서 추가 관련)에서 객체 생성
	public Action(frame f, test t, JTextField bookID, JTextField name, JTextField author, JTextField publisher, JTextField date) {
		this.f = f;
		this.t = t;
		this.bookID = bookID;
		this.name = name;
		this.author = author;
		this.publisher = publisher;
		this.date = date;
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
	
	// panel 4 (도서 대여 관련)에서 객체 생성
	public Action(bpanel bp, test t, JTextField bookID, JTextField name, JTextField userID) {
		this.bp = bp;
		this.t = t;
		this.bookID = bookID;
		this.name = name;
		this.userID = userID;		
	}
	
	
	// (도서 추가 관련) 이벤트 처리
	public void func1() {
		// 조건 만족 시 SQL문 실행 
		try {
			String i = bookID.getText();
			String n = name.getText();
			String a = author.getText();
			String p = publisher.getText();
			String d = date.getText();
			
			
			
			// 입력 안 들어옴
			if (n.equals("")||i.equals("")||n.equals("")||a.equals("")||p.equals("")||d.equals("")) {
				f.error_label.setText("입력 없음! ");
				f.error_label.setForeground(Color.RED);
			}
			// 입력 들어옴
			else {
				// SQL문 실행
				t.stmt.executeUpdate("insert into book values('" + i + "', '" + n + " ', '" + a +"' ,  ' " + p +"', '" + d+"');");
				f.error_label.setText("저장 완료!! (전체 목록을 눌러서 확인!!)");
				f.error_label.setForeground(Color.BLUE);
				// 입력 초기화
				bookID.setText(null);
				name.setText(null);
				author.setText(null);
				publisher.setText(null);
				date.setText(null);
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
			ResultSet rs = t.stmt.executeQuery("SELECT * FROM bookquantity;");
			// 데이터 확인
			int rows = 0;
			if (rs.last()) {
			    rows = rs.getRow(); // rows는 book 테이블의 행의 수(레코드 개수)를 저장
			    rs.beforeFirst(); // 처음 행의 위치로
			}
			// 데이터 존재
			if(rows>0) {
				// 데이터를 2차원 배열에 담아서 리턴 
				String[][] contents = new String[rows][6]; //
				
				int idx=0;
				
				while(rs.next()) {
					contents[idx][0]=rs.getString("name");
					contents[idx][1]=rs.getString("author");
					contents[idx][2]=rs.getString("publisher");
					contents[idx][3]=rs.getString("date");
					contents[idx][4]=rs.getString("quantity");
					contents[idx][5]=rs.getString("rquantity");
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
				
				String[][] contents = new String[1][6];
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
				rs = t.stmt.executeQuery("select * from bookquantity where name like '%" + search + "%' or publisher like '%" + search + "' or author like '%" + search + "%';");
				
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
					String[][] contents=new String[rows][6];
					int idx=0;
					while(rs.next()) {
						contents[idx][0]=rs.getString("name");
						contents[idx][1]=rs.getString("author");
						contents[idx][2]=rs.getString("publisher");
						contents[idx][3]=rs.getString("date");
						contents[idx][4]=rs.getString("quantity");
						contents[idx][5]=rs.getString("rquantity");
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
	// (도서 대여 관련) 이벤트 처리
	public void func4() {
		// 조건 만족 시 SQL문 실행 
		try {
			
	        SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd"); // 포맷팅 정의
	        Date now = new Date(); // 현재 날짜
	        Calendar cal = Calendar.getInstance(); // 날짜 계산을 위해 Calendar 추상 클래스 선언
	        cal.setTime(now);
	        cal.add(Calendar.DATE, 7); // 7일 더하기
	        
	        
	        
			String b = bookID.getText();
			String n = name.getText();
			String u = userID.getText();
	        
			String bd = formatter.format(now); // 빌린 날짜
			String rd = formatter.format(cal.getTime()); // 반납예정 날짜
		
			 ///////////////////////////////////////
			
			
			// 입력 안 들어옴
			if (b.equals("")||n.equals("")||u.equals("")||bd.equals("")||rd.equals("")) {
				bp.error_label.setText("입력 없음! ");
				bp.error_label.setForeground(Color.RED);
				
			}
			// 입력 들어옴
			else {
				
				// 코드 추가(수정)
				ResultSet rs = t.stmt.executeQuery("select exists(select * from book where bookID = '"+ b + "' and name like '%" + n +"%') as success");
				
				if(rs.next() ) { // 다음 행이 존재하면
					String success = rs.getString("success"); // 입력한 bookID와 name이 book 테이블에 존재하면 = 1 아니면 0
					System.out.println(success);
					
					ResultSet rs1 = t.stmt.executeQuery("select exists(select * from user_info where userID = '"+ u +"') as success");
					
					if(rs1.next()) {
						String success1 = rs1.getString("success");
						System.out.println(success1);

					
					if(success.equals("1") && success1.equals("1")) { // bookID, name, userID가 모두 일치할때
						System.out.println(b);
						System.out.println(n);
						System.out.println(u);
						System.out.println(bd);
						System.out.println(rd);
						
						// SQL문 실행
						t.stmt.executeUpdate("insert into status values('" + b + "', '" + n + " ', '" + u +"', '"+ bd+"', '" + rd + "');");
						bp.error_label.setText("도서 대여 완료!");
						bp.error_label.setForeground(Color.BLUE);
						// 입력 초기화
						bookID.setText(null);
						name.setText(null);
						userID.setText(null);
					}
					else if(!success.equals("1") && success1.equals("1")) { // bookID 또는 name가 일치하지 않을 때
						bp.error_label.setText("도서 번호: " + b + " 또는 " + "도서 이름: " + n + "가 존재 하지 않습니다.");
						bp.error_label.setForeground(Color.RED);
					}
					else if(success.equals("1") && !success1.equals("1")) { // userID가 일치하지 않을 때
						bp.error_label.setText("사용자 Id: " + u + "가 존재 하지 않습니다.");
						bp.error_label.setForeground(Color.RED);
					}
					else { // bookID, name, userID가 모두 일치하지 않을 때
						bp.error_label.setText("도서 번호: " + b + ", 도서 이름: " + n + ", 사용자 Id: "+ u +"가 존재 하지 않습니다.");
						bp.error_label.setForeground(Color.RED);
						
						
					}
				
					}
				}
			}				
								
		
		} 
		// DB Error 
		catch (SQLException e1) {
			// TODO Auto-generated catch block
			bp.error_label.setText("DB Error");
			bp.error_label.setForeground(Color.RED);
			e1.printStackTrace();
			
		
		}	
	}
	
	// (도서 반납 관련) 이벤트 처리
	public void func5() {
		// 조건 만족 시 SQL문 실행 
					try { 
				        
						String b = bookID.getText();
						String n = name.getText();
						String u = userID.getText();
				       						
						
						// 입력 안 들어옴
						if (b.equals("")||n.equals("")||u.equals("")) {
							bp.error_label.setText("입력 없음!");
							bp.error_label.setForeground(Color.RED);
						}
						// 입력 들어옴
						else {
							
							System.out.println(b);
							System.out.println(n);
							System.out.println(u);
							
							 ResultSet rs = t.stmt.executeQuery("select exists(select * from status where bookID = '" + b +"' and name like '%"+ n +"%' and userID = '" + u +"') as success");
							
							if(rs.next()) {
								String success = rs.getString("success"); // 입력한 bookID와 name이 book 테이블에 존재하면 = 1 아니면 0
								System.out.println(success);
								
								if(success.equals("1")) { // 반납할 bookID, name, userID가 존재 하면 -> 반납완료
								// SQL문 실행
								t.stmt.executeUpdate("delete from status where bookID ='" + b + "' and name like '%"+ n +"%' and userID = '" + u +"';");
								bp.error_label.setText("반납 완료!");
								bp.error_label.setForeground(Color.BLUE);
								// 입력 초기화
								bookID.setText(null);
								name.setText(null);
								userID.setText(null);
								}
								else {
									bp.error_label.setText("반납 불가!");
									bp.error_label.setForeground(Color.RED);
								}
							}
						}
					} 
					// DB Error 
					catch (SQLException e1) {
						// TODO Auto-generated catch block
						bp.error_label.setText("DB Error");
						bp.error_label.setForeground(Color.RED);
						e1.printStackTrace();
						
					
					}	
	}
	
	// (도서 대여 현황 관련) 이벤트 처리
		public String[][] func6() { 
			// SQL문 실행
			try {
				ResultSet rs = t.stmt.executeQuery("SELECT * FROM status;");
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
						contents[idx][0]=rs.getString("bookID");
						contents[idx][1]=rs.getString("name");
						contents[idx][2]=rs.getString("userID");
						contents[idx][3]=rs.getString("borrowedDate");
						contents[idx][4]=rs.getString("returnDate");
						idx++;
					}
					
					f.error_label.setText("대여 현황 조회 완료!!");
					f.error_label.setForeground(Color.BLUE);
					return contents;
				}
				// 데이터 존재 X
				else {
					// 빈 2차원 배열 리턴 
					f.error_label.setText("데이터 없음!");
					f.error_label.setForeground(Color.RED);
					
					String[][] contents = new String[1][5];
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
		    	setSize(625,200);
	    		setTitle("전체 목록 조회");
	    		setLocation(5,360);
	    		
	    		// table setting
	    		String[] header= {"이름", "저자", "출판사", "출판일", "재고", "남은 재고"};
	    		String[][] contents = func2(); // 도서 조회 이벤트 처리 핵심 -> 전체 도서 목록이 담긴 2차원 배열 반환 
	    		if(contents != null) {
		    		JTable table = new JTable(contents, header);
		    		JScrollPane scrollpane=new JScrollPane(table);
		    		
		    		table.setBackground(Color.YELLOW);
		    		
		    		add(scrollpane);
		    		setVisible(true);
	    		}
	    		break;
	    		
	    	case "도서 대여 현황":
	    		getContentPane().removeAll();
	    		setSize(600,200);
	    		setTitle("도서 대여 현황");
	    		setLocation(620, 205);
	    		
	    		String[] header3 = {"도서 번호", "도서 이름", "사용자", "대여 날짜", "반납 날짜"};
	    		String[][] contents3 = func6();
	    		if(contents3 != null) { //////////////////////////
	    			JTable table3 = new JTable(contents3, header3);
	    			JScrollPane scrollpane3 = new JScrollPane(table3);
	    			
	    			table3.setBackground(Color.YELLOW);
	    			
		    		add(scrollpane3);
		    		setVisible(true);
	    		}  		
	    		
	    		break;
	    	case "검색":
	    		// mini-window size, title, location
		    	getContentPane().removeAll(); // 기존 윈도우 삭제되고 새로운 윈도우 생성하는데 기존에 안 사라진게 있을 수 있어서 지움
		    	setSize(600,200);
	    		setTitle("도서 검색");
	    		setLocation(620,400);
	    		// table setting
	    		String[] header2= {"이름", "저자", "출판사", "출판일", "재고", "남은 재고"};
	    		String[][] contents2=func3(); // 도서 검색 이벤트 처리 핵심 -> 도서 검색한 목록이 담긴 2차원 배열 반환
	    		if(contents2 != null) {
		    		JTable table2 = new JTable(contents2, header2);
		    		JScrollPane scrollpane2 = new JScrollPane(table2);
		    		
		    		table2.setBackground(Color.YELLOW);
		    		
		    		add(scrollpane2);
		    		setVisible(true);
	    		}
	    		break;
	    	case "도서대여 및 반납":
	    		getContentPane().removeAll();
	    		bpanel bp = new bpanel(t);
	    		setSize(600,200);
	    		setTitle("도서 대여");
	    		setLocation(620, 10);
	    		setLayout(new GridLayout(1,2));	
	    		this.add(bp);
	    		setVisible(true);
	    		break;
	    	
	    	case "대여":
	    		func4();
	    		break;
	    	case "반납":
	    		func5();
	    		break;
	    }

    }


// class for DB Connection (DB 연결 객체)
	public static void main(String[] args) {
		LoginProject lp = new LoginProject();
		lp.setFrame(lp);
		test t = new test(); // DB 연결 및 윈도우 생성
	}
}