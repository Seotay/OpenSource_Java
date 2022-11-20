package login;

import project.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;

class userMyPage extends JPanel implements ActionListener {

	JPanel mainPanel;
	JPanel centerPanel;
	JPanel downPanel;
	JButton logoutButton;
	JButton unregisterButton;
	LoginProject lp;
	Font font = new Font("회원가입", Font.BOLD, 40);

	JTextField changepassTF;
	JTextField changephoneTF;

	JButton changepassButton;
	JButton changephoneButton;

	public userMyPage(LoginProject lp) {

		this.lp = lp;

		mainPanel = new JPanel();
		mainPanel.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

		// top
		JLabel mypageLabel = new JLabel("내 정보");
		mypageLabel.setFont(font);
		mypageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

		// center

		centerPanel = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		changepassTF = new JTextField(13);
		changephoneTF = new JTextField(12);
		changepassButton = new JButton("비밀번호 바꾸기");
		changephoneButton = new JButton("전화번호 바꾸기");

		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(5, 5, 0, 0);

		c.gridx = 0;
		c.gridy = 0;
		centerPanel.add(changephoneTF, c);

		c.gridx = 1;
		c.gridy = 0;
		centerPanel.add(changephoneButton, c);

		c.gridx = 0;
		c.gridy = 1;
		centerPanel.add(changepassTF, c);

		c.gridx = 1;
		c.gridy = 1;
		centerPanel.add(changepassButton, c);

		// down
		downPanel = new JPanel();
		logoutButton = new JButton("로그아웃");
		unregisterButton = new JButton("탈퇴");
		downPanel.add(logoutButton);
		downPanel.add(unregisterButton);

		mainPanel.add(mypageLabel);
		mainPanel.add(centerPanel);
		mainPanel.add(downPanel);

		logoutButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				lp.card.first(lp.cardPanel);
			}
		});

		changephoneButton.addActionListener(this);
		changepassButton.addActionListener(this);
		unregisterButton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		Connection conn = null;
		PreparedStatement pstmt = null;
		// System.out.println(lp.id);

		try {
			conn = lp.getConnection();

			switch (e.getActionCommand()) {

			case "전화번호 바꾸기":
				String SQL = "update user_info set phoneNumber=? where id=?";
				pstmt = conn.prepareStatement(SQL);

				pstmt.setString(1, changephoneTF.getText());
				pstmt.setString(2, lp.id);

				int r = pstmt.executeUpdate();
				System.out.println("변경된 row : " + r);

				break;

			case "비밀번호 바꾸기":
				String SQL1 = "update user_info set password=? where id=?";
				pstmt = conn.prepareStatement(SQL1);

				pstmt.setString(1, changepassTF.getText());
				pstmt.setString(2, lp.id);

				int r1 = pstmt.executeUpdate();
				System.out.println("변경된 row : " + r1);
				break;

			case "탈퇴":

				String SQL2 = "delete from user_info where id=?";
				pstmt = conn.prepareStatement(SQL2);

				int result = JOptionPane.showConfirmDialog(null, "정말로 탈퇴하시겠습니까?", "Confirm message",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (result == JOptionPane.YES_OPTION) {
					pstmt.setString(1, lp.id);
					int r2 = pstmt.executeUpdate();
					System.out.println("변경된 row: " + r2);
					lp.card.first(lp.cardPanel);
				} else
					break;

				break;

			default:
				break;
			}

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

}// userinfo 클래스