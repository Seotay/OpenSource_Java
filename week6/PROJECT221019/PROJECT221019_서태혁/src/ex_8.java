import javax.swing.*;
import java.awt.*;

public class ex_8 extends JFrame{
	public ex_8() {
		setTitle("여러 개의 패널을 가진 프레임");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		
		c.add(p1, BorderLayout.NORTH);
		c.add(p2, BorderLayout.CENTER);
		c.add(p3, BorderLayout.SOUTH);
		
		p1.setBackground(Color.LIGHT_GRAY);
		p1.add(new JButton("열기"));
		p1.add(new JButton("닫기"));
		p1.add(new JButton("나가기"));
		
		p2.setLayout(null);
		p2.setBackground(Color.WHITE);
		
		for(int i = 0; i<10; i++) {
			int x = (int)(Math.random()*200)+50;
			int y = (int)(Math.random()*200)+50;
			
			JLabel jl = new JLabel("*");
			jl.setBackground(Color.WHITE);
			jl.setForeground(Color.RED);
			jl.setOpaque(true);
			jl.setLocation(x,y);
			jl.setSize(20,20);
			p2.add(jl);
		}
		
		p3.setBackground(Color.YELLOW);
		JButton jl2 = new JButton("Word Input");
		JTextField tf2 = new JTextField(20);
		
		p3.add(jl2);
		p3.add(tf2);
		
		setSize(400,400);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new ex_8();
	}

}
