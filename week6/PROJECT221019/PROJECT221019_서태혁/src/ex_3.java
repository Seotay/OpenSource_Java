import javax.swing.*;
import java.awt.*;

public class ex_3 extends JFrame{
	public ex_3(){
		setTitle("Ten Color Buttons Frame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		Container c = getContentPane();
		c.setLayout( new GridLayout(1,10));
		
		for(int i = 0; i<10; i++) {
			c.add(new JButton(Integer.toString(i)));
		}
		
		setSize(500, 300);
		setVisible(true);
		
	}
	public static void main(String[] args) {
		
		ex_3 mf = new ex_3();

	}

}
