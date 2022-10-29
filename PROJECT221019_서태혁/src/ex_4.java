import javax.swing.*;
import java.awt.*;

public class ex_4 extends JFrame{
	
	public ex_4() {
		setTitle("Ten Color Buttons Frame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		GridLayout gird = new GridLayout(1,10);
		Container c = getContentPane();
		c.setLayout(gird);
		
		Color[] colors = new Color[] {Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, 
				Color.CYAN, Color.BLUE, Color.MAGENTA, Color.GRAY, Color.PINK, Color.LIGHT_GRAY	};
		
		for(int i = 0; i<10; i++) {
			JButton jb = new JButton(Integer.toString(i));
			jb.setBackground(colors[i]);
			c.add(jb);
		}
		
		setSize(500, 300);
		setVisible(true);
	}

	public static void main(String[] args) {
		ex_4 mf = new ex_4();
	}

}
