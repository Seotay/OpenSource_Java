import javax.swing.*;
import java.awt.*;


public class ex_6 extends JFrame{
	public ex_6() {
		setTitle("Random Labels");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(null);
		
		for(int i =0; i< 20; i++) {
			int x = (int)(Math.random()*200) + 50; // 50 ~ 250
			int y = (int)(Math.random()*200) + 50; // 50 ~ 250
			
			JLabel jl = new JLabel();
			jl.setBackground(Color.BLUE);
			jl.setOpaque(true);
			jl.setLocation(x, y);
			jl.setSize(10, 10);
			c.add(jl);
		}
		setSize(300,300);
		setVisible(true);
	}

	public static void main(String[] args) {
		new ex_6();
	}

}
