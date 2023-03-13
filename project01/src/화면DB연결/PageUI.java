package 화면DB연결;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import 자바DB연결.PageDAO;
import 자바DB연결.PageVO;



public class PageUI {
	
	public void open() {
		JFrame f = new JFrame();
		FlowLayout flow = new FlowLayout();
		f.setTitle("내 정보 수정");
		f.setSize(200, 350);
		f.setLayout(flow);

		JTextField idField = new JTextField(10);
		JTextField nickField = new JTextField(10);
		JTextField letField = new JTextField(10);
		JLabel idLabel = new JLabel("id");
		JLabel nickLabel = new JLabel("닉네임");
		JLabel letLabel = new JLabel("소개글");
		Font font = new Font("바탕", Font.PLAIN, 20);

		JButton updateButton = new JButton("변경하기");
		updateButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = idField.getText();
				String nick = nickField.getText();
				String let = letField.getText();
				PageDAO dao = new PageDAO();
				PageVO bag = new PageVO();
				bag.setID(id);
				bag.setNICKNAME(nick);
				bag.setLET(let);
				
				System.out.println("회원정보수정");
				int result = dao.update(bag);
				if(result == 1) {
					JOptionPane.showMessageDialog(f, "회원정보 수정 성공");
				}else {
					JOptionPane.showMessageDialog(f, "회원정보 수정 실패, 재입력해주세요.");
				}
			}
		});
		JButton exitButton = new JButton("나가기");
		exitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				f.dispose();
			}
		});

		f.add(idLabel);
		f.add(idField);
		f.add(nickLabel);
		f.add(nickField);
		f.add(letLabel);
		f.add(letField);
		f.add(updateButton);
		f.add(exitButton);
		idLabel.setFont(font);
		idField.setFont(font);
		nickLabel.setFont(font);
		nickField.setFont(font);
		letLabel.setFont(font);
		letField.setFont(font);
		updateButton.setFont(font);
		exitButton.setFont(font);
	
		f.setVisible(true);
	}


}