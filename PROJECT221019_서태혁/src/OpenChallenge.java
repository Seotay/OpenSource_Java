import javax.swing.*;
import java.awt.*;

public class OpenChallenge extends JFrame{
	
	OpenChallenge(){
		setTitle("Open Challenge 9");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		c.add(new NorthPanel(), BorderLayout.NORTH);
		c.add(new CenterPanel(), BorderLayout.CENTER);
		setSize(400, 400);
		setVisible(true);
	}
	
	class NorthPanel extends JPanel{
		NorthPanel(){
			setBackground(Color.GRAY);
			setLayout(new FlowLayout());
			add(new JButton("Open"));
			add(new JButton("Read"));
			add(new JButton("Close"));
		}
	}
	
	class CenterPanel extends JPanel{
		CenterPanel(){
			String text[] = {"Hello", "Java", "Love"};
			setBackground(Color.lightGray);
			setLayout(null);
			
			int x, y;
			for(int i = 0; i< text.length; i++) {
				x = (int)(Math.random()*200);
				y = (int)(Math.random()*250);
				
				JLabel label = new JLabel(text[i]);
				label.setSize(50,10);
				label.setLocation(x,y);
				add(label);
			}
	}
	
	}	
	
	public static void main(String[] args) {
		new OpenChallenge();
	}

}
