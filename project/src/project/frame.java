package project;

import project.Action;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


//Class for Window
class frame extends JFrame{
	JLabel error_label;
	public frame(test t) {		
		// 윈도우 창 설정
		setSize(625,350);
		setLocation(5,10);
		setTitle("도서관");
		setLayout(new GridLayout(7,7));  //***
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
	    // panel 객체 배열 생성
	    JPanel pns[]=new JPanel[7]; //***
	    for(int i=0; i<4; i++) {
	    	pns[i]=new JPanel();
	    	pns[i].setLayout(new GridLayout(0,7));
	    }
	pns[4] = new JPanel();
	pns[4].setLayout(new GridLayout(0,2));
	
	pns[5] = new JPanel();
	pns[5].setLayout(new GridLayout(0,2));
	
 	pns[6]=new JPanel();
 	pns[6].setLayout(new GridLayout(0,2));
	    
 	
	    // panel 0 (소개 관련)
	    JLabel[] lbs=new JLabel[6]; // Labels
	    String[] strs= {"[도서 관리 앱]","[책 번호]","[이름]","[저자]","[출판사]" ,"[출판일]"};
	    for(int i=0; i<strs.length; i++) {
	    	lbs[i]=new JLabel(strs[i]);
	    	
	    	// 색지정
	    	lbs[i].setFont(new Font("Serif", Font.BOLD, 11));
	    	lbs[i].setForeground(Color.white);
	    	lbs[i].setBackground(Color.black);
	    	lbs[i].setOpaque(true);
	    	
	    	pns[0].add(lbs[i]);
	    }
	    pns[0].setBackground(Color.BLACK);
	    
	    
	    // panel 1 (도서 추가 관련) 
	    JLabel lb1=new JLabel("도서 추가"); // Label
	    pns[1].add(lb1);
	    JTextField[] fields=new JTextField[5]; // TextFields
	    for(int i=0; i<fields.length; i++) {
	    	fields[i]=new JTextField();
	    	pns[1].add(fields[i]);
	    }
	    JButton bt1=new JButton("추가"); // Button
	    bt1.addActionListener(new Action(this,t,fields[0],fields[1],fields[2], fields[3], fields[4]));
	    
	    // 색 지정
	    lb1.setFont(new Font("Serif", Font.BOLD, 11));
	    lb1.setBackground(Color.LIGHT_GRAY);
	    lb1.setOpaque(true);
	    bt1.setBackground(Color.ORANGE);
	    pns[1].setBackground(Color.LIGHT_GRAY); ////////
	    
	    pns[1].add(bt1);
	    
	    
	    // panel 2 (도서 조회 과련) 
	    JLabel lb2=new JLabel("도서 목록 조회"); // Label
	    JButton bt2=new JButton("전체 목록"); // Button
	    Cursor cursor = bt2.getCursor();
	    bt2.addActionListener(new Action(this,t));
	    
	    // 색 지정
	    lb2.setFont(new Font("Serif", Font.BOLD, 11));
	    lb2.setBackground(Color.LIGHT_GRAY);
	    lb2.setOpaque(true);
	    bt2.setBackground(Color.ORANGE);
	    
	    pns[2].setBackground(Color.LIGHT_GRAY); ////////
	    pns[2].add(lb2);
	    pns[2].add(bt2);
	    
	    
	    // panel 3 (도서 검색 관련) 
	    JLabel lb3=new JLabel("도서 찾기"); // Label
	    JTextField search_field=new JTextField(); // TextField
	    JButton bt3=new JButton("검색"); // Button
	    bt3.addActionListener(new Action(this,t,search_field));
	    
	    // 색 지정
	    lb3.setBackground(Color.LIGHT_GRAY);
	    lb3.setOpaque(true);
	    bt3.setBackground(Color.ORANGE);
	    
	    lb3.setFont(new Font("Serif", Font.BOLD, 11));
	    pns[3].setBackground(Color.LIGHT_GRAY); ////////
	    pns[3].add(lb3);
	    pns[3].add(search_field);
	    pns[3].add(bt3);
	    
	    
	    // panel 4 (도서 대여 관련)
	    JLabel lb4 = new JLabel("도서대여 및 반납"); // Label
	    JButton bt4 = new JButton("도서대여 및 반납");
	    bt4.addActionListener(new Action(this, t));
	    
	    // 색 지정
	    lb4.setFont(new Font("Serif", Font.BOLD, 11));
	    lb4.setBackground(Color.LIGHT_GRAY);
	    lb4.setOpaque(true);
	    bt4.setBackground(Color.ORANGE);
	    
	    pns[4].setBackground(Color.LIGHT_GRAY); ////////
	    
	    pns[5].add(lb4);
	    pns[5].add(bt4);
	    
	    // panel 5 (도서 대여 현황 관련)
	    JLabel lb5 = new JLabel("도서 대여 현황"); // Label
	    JButton bt5 = new JButton("도서 대여 현황");
	    Cursor cursor2 = bt5.getCursor();
	    bt5.addActionListener(new Action(this, t));
	    
	 // 색 지정
	    lb5.setFont(new Font("Serif", Font.BOLD, 11));
	    lb5.setBackground(Color.LIGHT_GRAY);
	    lb5.setOpaque(true);
	    bt5.setBackground(Color.ORANGE);
	    
	    pns[5].setBackground(Color.LIGHT_GRAY); ////////
	    pns[5].add(lb5);
	    pns[5].add(bt5);
	    
	    // panel 4
	    pns[4].setBackground(Color.GRAY); ////////
	    
	    // panel 6 (에러 관련)
	    JLabel lb6=new JLabel("메세지:"); // Label
	    
	    lb6.setFont(new Font("궁서체", Font.BOLD, 11));
	    
	    pns[6].add(lb6);
	    error_label=new JLabel("DB 연결 완료!"); // Label
	    pns[6].add(error_label);

	    
	    
	    // 컴포넌트 배치 및 활성화  
	    for (int i=0; i<pns.length; i++) {
	    	add(pns[i]);
	    }
		setVisible(true);
	} 
}