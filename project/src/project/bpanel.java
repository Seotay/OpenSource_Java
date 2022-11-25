package project;

import project.Action;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class bpanel extends JPanel{
	JLabel error_label;
	
	public bpanel(test t){
		
	
	setSize(500,200);	
	setLayout(new GridLayout(4,4));
	
	// panel0 (소개 관련)
	JPanel pns0 = new JPanel();
	pns0.setLayout(new GridLayout(0,5));
	JLabel[] lb = new JLabel[6];
	String[] strs = {"[대여 및 반납]","[도서 번호]","[도서 이름]","[사용자ID]"};
	for(int i = 0; i<strs.length; i++) {
		lb[i] = new JLabel(strs[i]);
		
		// 색지정
		lb[i].setFont(new Font("Serif", Font.BOLD, 11));
    	lb[i].setForeground(Color.white);
    	lb[i].setBackground(Color.black);
    	lb[i].setOpaque(true);
		
		pns0.add(lb[i]);
	}
	pns0.setBackground(Color.BLACK);
	add(pns0);
	
	
	// panel1 (도서 대여 관련)	
	JPanel pns1 = new JPanel();
	
	pns1.setLayout(new GridLayout(0,5));
	JLabel jl = new JLabel("도서 대여");
	pns1.add(jl);
	
	JTextField[] fields = new JTextField[3];
	for(int i=0; i<fields.length; i++) {
		fields[i] = new JTextField();
		pns1.add(fields[i]);
	}
	JButton bt = new JButton("대여");
	bt.addActionListener(new Action(this, t, fields[0], fields[1], fields[2]));
	
	// 색 지정
	jl.setFont(new Font("Serif", Font.BOLD, 11));
	jl.setBackground(Color.LIGHT_GRAY);
	jl.setOpaque(true);
    bt.setBackground(Color.ORANGE);
    pns1.setBackground(Color.LIGHT_GRAY); ////////
	
    pns1.add(bt);
	
	add(pns1);
	
	// panel2 (도서 반납 관련)
	JPanel pns2 = new JPanel();
	pns2.setLayout(new GridLayout(0,5));
	
	JLabel j1 = new JLabel("도서 반납");
	pns2.add(j1);
	JTextField[] fields1 = new JTextField[3];
	for(int i=0; i<fields1.length; i++) {
		fields1[i] = new JTextField();
		pns2.add(fields1[i]);
	}
	JButton bt1 = new JButton("반납");
	bt1.addActionListener(new Action(this, t, fields1[0], fields1[1], fields1[2]));
	
	j1.setFont(new Font("Serif", Font.BOLD, 11));
	j1.setBackground(Color.LIGHT_GRAY);
	j1.setOpaque(true);
    bt1.setBackground(Color.ORANGE);
    pns1.setBackground(Color.LIGHT_GRAY); ////////
	
    pns2.add(bt1);
	add(pns2);
	
	
	JPanel pns3 = new JPanel();
	pns3.setLayout(new GridLayout(0,2));
	JLabel j2 = new JLabel("메세지:");
	
	j2.setFont(new Font("궁서체", Font.BOLD, 11));
	
	error_label = new JLabel("도서 대여 및 반납");;
	pns3.add(j2);
	pns3.add(error_label);
	
	add(pns3);
	
	
	
	}

	
	
	
	
	
	
	
}