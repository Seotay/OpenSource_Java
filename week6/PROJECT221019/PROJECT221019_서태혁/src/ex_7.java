import javax.swing.*;
import java.awt.*;

public class ex_7 extends JFrame{
	public ex_7() {
		setTitle("계산기 프레임");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		
		c.add(p1, BorderLayout.NORTH);
		c.add(p2, BorderLayout.CENTER);
		c.add(p3, BorderLayout.SOUTH);
		
		p1.setBackground(Color.LIGHT_GRAY);
		JLabel jl1 = new JLabel("수식입력");
		JTextField tf1 = new JTextField(20);
		
		p1.add(jl1);
		p1.add(tf1);
		
		p2.setLayout(new GridLayout(4,4));
		for(int i = 0; i<10; i++) {
			JButton jb = new JButton(Integer.toString(i));
			p2.add(jb);
		}
		String[] str = {"CE", "계산", "+", "-", "*", "/" };
		for(int i = 0; i<6; i++) {
			JButton j = new JButton();
			j.setText(str[i]);
			
			if(i>1) {
				j.setBackground(Color.CYAN);
				j.setOpaque(true);
			}
			p2.add(j);
		}
		
		p3.setBackground(Color.YELLOW);
		JLabel jl2 = new JLabel("계산 결과");
		JTextField tf2 = new JTextField(20);
		p3.add(jl2);
		p3.add(tf2);
		
		setSize(400, 400);
		setVisible(true);
	}
	
	
	
	public static void main(String[] args) {
		new ex_7();
	}
	
	
}
