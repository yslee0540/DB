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
import 자바DB연결.StarDao;
import 자바DB연결.StarVO;

public class PageDEL {

	
	public void open() {
		JFrame f = new JFrame();
		FlowLayout flow = new FlowLayout();
		f.setTitle("회원 탈퇴 화면");
		f.setSize(200, 250);
		f.setLayout(flow);

		JTextField idField = new JTextField(10);
		JTextField pwField = new JTextField(10);
		JLabel idLabel = new JLabel("id");
		JLabel pwLabel = new JLabel("pw");
		Font font = new Font("바탕", Font.PLAIN, 20);

		JButton delete = new JButton("탈퇴하기");
		delete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("회원탈퇴처리");
				String id = idField.getText();
				String pw = pwField.getText();
				PageDAO dao = new PageDAO();
				PageVO bag = new PageVO();
				bag.setID(id);
				bag.setPW(pw);
				
				StarDao dao2 = new StarDao();
				StarVO bag2 = new StarVO();
				bag2.setId(id);
				
				dao2.delete(bag2);
				int result = dao.delete(bag);
				
				if(result >= 1) {
					JOptionPane.showMessageDialog(f, "회원탈퇴 성공");
				}else {
					JOptionPane.showMessageDialog(f, "회원탈퇴 실패, 재입력해주세요.");
				}
			}
		});
		JButton exit = new JButton("나가기");
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				f.dispose();
			}
		});


		f.add(idLabel);
		f.add(idField);
		f.add(pwLabel);
		f.add(pwField);
		f.add(delete);
		f.add(exit);
		idLabel.setFont(font);
		idField.setFont(font);
		pwLabel.setFont(font);
		pwField.setFont(font);
		delete.setFont(font);
		exit.setFont(font);
	
		f.setVisible(true);
	}


}