import javax.swing.*;
import java.awt.*;


public class ex_2 extends JFrame{
	public ex_2() {
		setTitle("BorderLayout");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		
		c.setLayout(new BorderLayout(5,7));
		
		c.add(new JButton("Center"), BorderLayout.CENTER);
		c.add(new JButton("North"), BorderLayout.NORTH);
		c.add(new JButton("South"), BorderLayout.SOUTH);
		c.add(new JButton("West"), BorderLayout.WEST);
		
		setSize(400, 200);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		
		ex_2 mf = new ex_2();
	

	}

}
