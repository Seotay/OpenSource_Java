import javax.swing.*;
import java.awt.*;

public class ex_5 extends JFrame{
	
	public ex_5() {
		setTitle("4x4 Color Frame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new GridLayout(4, 4));
		
		Color[] color = {Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.CYAN,
				Color.BLUE, Color.MAGENTA, Color.GRAY, Color.PINK, Color.LIGHT_GRAY,
				Color.WHITE, Color.BLACK, Color.BLACK, Color.ORANGE, Color.BLUE, Color.MAGENTA};
		
		for(int i=0; i<16; i++) {
			JLabel jl = new JLabel(Integer.toString(i));
			jl.setBackground(color[i]);
			jl.setOpaque(true);
			c.add(jl);
		}
		setSize(600, 400);
		setVisible(true);
		
	}
	public static void main(String[] args) {
		
		ex_5 mf = new ex_5();

	}

}
