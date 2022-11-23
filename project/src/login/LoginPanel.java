package login;

import java.awt.*;
import javax.swing.*;

import project.*;

import java.sql.*;
import java.awt.event.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class LoginPanel extends JPanel implements ActionListener {

	JPanel mainPanel;
	JTextField idTextField;
	JPasswordField passTextField;

	String userMode = "일반";
	String admin = "admin";
	LoginProject lp;
	Font font = new Font("회원가입", Font.BOLD, 40);
	
	public LoginPanel(LoginProject lp) {
		this.lp = lp;
		
		mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(5, 1));

		JPanel centerPanel = new JPanel();
		JLabel loginLabel = new JLabel("로그인 화면");
		loginLabel.setFont(font);
		centerPanel.add(loginLabel);

		
		
		JPanel userPanel = new JPanel();
		
		JPanel gridBagidInfo = new JPanel(new GridBagLayout());
		gridBagidInfo.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));
		GridBagConstraints c = new GridBagConstraints();

		JLabel idLabel = new JLabel(" 아이디 : ");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		gridBagidInfo.add(idLabel, c);

		idTextField = new JTextField(15);
		c.insets = new Insets(0, 5, 0, 0);
		c.gridx = 1;
		c.gridy = 0;
		gridBagidInfo.add(idTextField, c);

		JLabel passLabel = new JLabel(" 비밀번호 : ");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 1;
		c.insets = new Insets(20, 0, 0, 0);
		gridBagidInfo.add(passLabel, c);

		passTextField = new JPasswordField(15);
		c.insets = new Insets(20, 5, 0, 0);
		c.gridx = 1;
		c.gridy = 1;
		gridBagidInfo.add(passTextField, c);

		JPanel loginPanel = new JPanel();
		JButton loginButton = new JButton("로그인");
		loginPanel.add(loginButton);

		JPanel signupPanel = new JPanel();
		JButton signupButton = new JButton("회원가입");
		loginPanel.add(signupButton);

		mainPanel.add(centerPanel);
		mainPanel.add(userPanel);
		mainPanel.add(gridBagidInfo);
		mainPanel.add(loginPanel);
		mainPanel.add(signupPanel);


		loginButton.addActionListener(this);

		signupButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				lp.card.next(lp.cardPanel);
			}
		});

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton jb = (JButton) e.getSource();

		switch (e.getActionCommand()) {

		case "일반":
			userMode = "일반";
			break;

		case "관리자":
			userMode = "관리자";
			break;

		case "로그인":
			String id = idTextField.getText();
			String pass = passTextField.getText();
			try {
				String sql_query = String.format("SELECT password FROM user_info WHERE userID = '%s' AND password ='%s'",
						id, pass);

				Connection conn = lp.getConnection();
				Statement stmt = conn.createStatement();
				
				
				ResultSet rset = stmt.executeQuery(sql_query);
				rset.next();
				
				if (pass.equals(rset.getString(1)) && idTextField.getText().equals(admin)) {
					JOptionPane.showMessageDialog(this, "Login Success", "로그인 성공", 1);
					lp.card.show(lp.cardPanel, "Admin Page");
					
					System.out.println("관리자 로그인");
					test t = new test(); //////////////////// 관리자로 로그인 했을때 도서 시스템 생성
					
				}
				else if (pass.equals(rset.getString(1))) {
					JOptionPane.showMessageDialog(this, "Login Success", "로그인 성공", 1);
					lp.setid(idTextField.getText()); // 로그인하고 로그인 아이디 정보 가질 수 있게.
					lp.card.show(lp.cardPanel, "My Page");

				} else
					JOptionPane.showMessageDialog(this, "Login Failed", "로그인 실패", 1);

			} catch (SQLException ex) {
				JOptionPane.showMessageDialog(this, "Login Failed", "로그인 실패", 1);
				System.out.println("SQLException" + ex);
			}

			break;

		}
	}

} // class LoginPanel
