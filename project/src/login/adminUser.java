package login;
import project.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;

import java.util.List;
import java.util.ArrayList;

class adminUser implements ActionListener {

	JPanel mainPanel;
	Font font = new Font("회원가입", Font.BOLD, 40);
	LoginProject lp;
	String unregisterID;

	public adminUser(LoginProject lp) {

		this.lp = lp;

		List<String> idList = new ArrayList<String>(getIDs());

		JLabel adminpageLabel = new JLabel("관리자 모드");
		adminpageLabel.setFont(font);
		adminpageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		JComboBox<String> idComboBox = new JComboBox<String>(idList.toArray(new String[idList.size()]));
		JButton logoutButton = new JButton("로그아웃");
		JButton unregisterButton = new JButton("강제탈퇴");

		JPanel centerPanel = new JPanel();
		centerPanel.add(idComboBox);
		centerPanel.add(unregisterButton);

		mainPanel = new JPanel();
		mainPanel.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		mainPanel.add(adminpageLabel);
		mainPanel.add(centerPanel);
		mainPanel.add(logoutButton);

		idComboBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JComboBox<String> idBox = (JComboBox) e.getSource();
				unregisterID = idBox.getSelectedItem().toString();
			}
		}); // idComboBox 이벤트 처리

		logoutButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				lp.card.first(lp.cardPanel);
			}
		}); // 로그아웃 이벤트 처리

		unregisterButton.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		try {
			Connection conn = lp.getConnection();
			String SQL2 = "delete from user_info where id=?";
			PreparedStatement pstmt = conn.prepareStatement(SQL2);

			if (unregisterID.equals("admin")) {
				JOptionPane.showMessageDialog(null, "관리자 계정은 지울수 없습니다.", "삭제 실패", 1);
			} else {
				int result = JOptionPane.showConfirmDialog(null, "정말로 탈퇴하시겠습니까?", "Confirm message",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (result == JOptionPane.YES_OPTION) {
					pstmt.setString(1, unregisterID);
					int r2 = pstmt.executeUpdate();
					System.out.println("변경된 row: " + r2);
				}

			}
		

		} catch (SQLException e5) {
			e5.printStackTrace();
		}
	}//회원탈퇴
	
	public List<String> getIDs() {
		List<String> list = new ArrayList<String>();
		
		try {
			Connection conn = lp.getConnection();
			String SQL = "SELECT ID FROM user_info";
			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(SQL);

			while (rs.next()) {
				list.add(rs.getString("id"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}