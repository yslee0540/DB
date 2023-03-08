package 화면DB연결;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import 자바DB연결.MemberDAO3;

public class MemberUI2 {

	public static void main(String[] args) {
		JFrame f = new JFrame("회원가입");
		f.setSize(420, 650);
		f.getContentPane().setBackground(new Color(0X03c75a));
		f.setLayout(new FlowLayout());
		Font font = new Font("맑은 고딕", Font.BOLD, 32);
		
		JLabel l1 = new JLabel("<< 회원가입화면 >>");
		l1.setFont(font);
		l1.setForeground(Color.white);
		
		JLabel l2 = new JLabel("아이디");
		l2.setFont(font);
		
		JLabel l3 = new JLabel("패스워드");
		l3.setFont(font);
		
		JLabel l4 = new JLabel("이름");
		l4.setFont(font);
		
		JLabel l5 = new JLabel("전화번호");
		l5.setFont(font);
		
		JTextField t1 = new JTextField(12);
		t1.setFont(font);
		t1.setHorizontalAlignment(JTextField.CENTER);
		
		JTextField t2 = new JTextField(12);
		t2.setFont(font);
		t2.setHorizontalAlignment(JTextField.CENTER);
		
		JTextField t3 = new JTextField(12);
		t3.setFont(font);
		t3.setHorizontalAlignment(JTextField.CENTER);
		
		JTextField t4 = new JTextField(12);
		t4.setFont(font);
		t4.setHorizontalAlignment(JTextField.CENTER);
		
		Font font2 = new Font("맑은 고딕", Font.BOLD, 25);
		
		JButton b1 = new JButton("회원가입 처리");
		b1.setFont(font2);
		b1.setBackground(Color.yellow);
		
		JButton b2 = new JButton("회원탈퇴 처리");
		b2.setFont(font2);
		b2.setBackground(Color.yellow);
		
		JButton b3 = new JButton("회원수정 처리");
		b3.setFont(font2);
		b3.setBackground(Color.yellow);
		
		JButton b4 = new JButton("회원검색 처리");
		b4.setFont(font2);
		b4.setBackground(Color.yellow);
		
		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("<회원가입>");
				String id = t1.getText();
				String pw = t2.getText();
				String name = t3.getText();
				String tel = t4.getText();
				
				if (id.equals("")) {
					JOptionPane.showMessageDialog(f, "id는 필수입력항목입니다.");
				} else {
					MemberDAO3 dao = new MemberDAO3();
					
					//1. 가방 만들기
					MemberVO bag = new MemberVO();
					//2. 가방에 값들 넣기
					bag.setId(id);
					bag.setPw(pw);
					bag.setName(name);
					bag.setTel(tel);
					//3. 값들이 들어있는 가방을 전달
					int result = dao.insert(bag);
					
					if (result == 1) {
						JOptionPane.showMessageDialog(f, "회원가입 성공");
					} else {
						JOptionPane.showMessageDialog(f, "회원가입 실패");
					}
				}
			}
		});
		
		b2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("<회원탈퇴>");
				String id = t1.getText();
				
				MemberDAO3 dao = new MemberDAO3();
				int result = dao.delete(id);
				if (result >= 1) {
					JOptionPane.showMessageDialog(f, "회원탈퇴 성공");
				} else {
					JOptionPane.showMessageDialog(f, "회원탈퇴 실패");
				}
			}
		});
		
		b3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("<회원수정>");
				String id = t1.getText();
				String tel = t4.getText();
				
				MemberDAO3 dao = new MemberDAO3();
				MemberVO bag = new MemberVO();
				bag.setId(id);
				bag.setTel(tel);
				int result = dao.update(bag);
				
				if (result >= 1) {
					JOptionPane.showMessageDialog(f, "회원수정 성공");
				} else {
					JOptionPane.showMessageDialog(f, "회원수정 실패");
				}
			}
		});
		
		f.add(l1);
		f.add(l2); f.add(t1);
		f.add(l3); f.add(t2);
		f.add(l4); f.add(t3);
		f.add(l5); f.add(t4);
		f.add(b1);
		f.add(b2);
		f.add(b3);
		f.add(b4);
		
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
