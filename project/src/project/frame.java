package project;

import javax.swing.*;

import project.Action;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


//Class for Window
class frame extends JFrame{
	JLabel error_label;
	public frame(test t) {		
		// 윈도우 창 설정
		setSize(500,200);
		setLocation(700,300);
		setTitle("도서관");
		setLayout(new GridLayout(5,1));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	    // panel 객체 배열 생성
	    JPanel pns[]=new JPanel[5];
	    for(int i=0; i<4; i++) {
	    	pns[i]=new JPanel();
	    	pns[i].setLayout(new GridLayout(0,7));
	    }
 	pns[4]=new JPanel();
 	pns[4].setLayout(new GridLayout(1,2));
	    
	    // panel 0 (소개 관련)
	    JLabel[] lbs=new JLabel[6]; // Labels
	    String[] strs= {"[도서 관리 앱]","[이름]","[출판사]","[저자]","[출판일]" ,"[재고]"};
	    for(int i=0; i<strs.length; i++) {
	    	lbs[i]=new JLabel(strs[i]);
	    	pns[0].add(lbs[i]);
	    }
	    
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
	    pns[1].add(bt1);
	    
	    // panel 2 (도서 조회 과련) 
	    JLabel lb2=new JLabel("도서 목록 조회"); // Label
	    JButton bt2=new JButton("전체 목록"); // Button
	    Cursor cursor = bt2.getCursor();
	    bt2.addActionListener(new Action(this,t));
	    pns[2].add(lb2);
	    pns[2].add(bt2);
	    
	    // panel 3 (도서 검색 관련) 
	    JLabel lb3=new JLabel("도서 찾기"); // Label
	    JTextField search_field=new JTextField(); // TextField
	    JButton bt3=new JButton("검색"); // Button
	    bt3.addActionListener(new Action(this,t,search_field));
	    pns[3].add(lb3);
	    pns[3].add(search_field);
	    pns[3].add(bt3);
	    
	    // panel 4 (에러 관련)
	    JLabel lb4=new JLabel("메세지:"); // Label
	    pns[4].add(lb4);
	    error_label=new JLabel("DB 연결 완료!"); // Label
	    pns[4].add(error_label);

	    
	    // 컴포넌트 배치 및 활성화  
	    for (int i=0; i<5; i++) {
	    	add(pns[i]);
	    }
		setVisible(true);
	} 
}