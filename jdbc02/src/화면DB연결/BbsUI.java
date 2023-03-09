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

import 자바DB연결.BbsDAO;

public class BbsUI {

	public static void main(String[] args) {
		JFrame f = new JFrame("게시판");
		f.setSize(420, 700);
		f.getContentPane().setBackground(new Color(0X03c75a));
		f.setLayout(new FlowLayout());
		Font font = new Font("맑은 고딕", Font.BOLD, 32);
		
		JLabel l1 = new JLabel("<< 나의 게시판 >>");
		l1.setFont(font);
		l1.setForeground(Color.white);
		
		JLabel l2 = new JLabel("게시판 번호");
		l2.setFont(font);
		
		JLabel l3 = new JLabel("제목");
		l3.setFont(font);
		
		JLabel l4 = new JLabel("내용");
		l4.setFont(font);
		
		JLabel l5 = new JLabel("작성자");
		l5.setFont(font);
		
		JTextField t1 = new JTextField(12);
		t1.setFont(font);
		
		JTextField t2 = new JTextField(12);
		t2.setFont(font);
		
		JTextField t3 = new JTextField(12);
		t3.setFont(font);
		
		JTextField t4 = new JTextField(12);
		t4.setFont(font);
		
		Font font2 = new Font("맑은 고딕", Font.BOLD, 25);
		
		JButton b1 = new JButton("게시물 작성 완료");
		b1.setFont(font2);
		b1.setBackground(Color.yellow);
		
		JButton b2 = new JButton("게시물 삭제 완료");
		b2.setFont(font2);
		b2.setBackground(Color.yellow);
		
		JButton b3 = new JButton("게시물 수정 완료");
		b3.setFont(font2);
		b3.setBackground(Color.yellow);
		
		JButton b4 = new JButton("게시물 검색 완료");
		b4.setFont(font2);
		b4.setBackground(Color.yellow);
		
		b4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String no = t1.getText();
				
				BbsDAO dao = new BbsDAO();
				BbsVO bag = dao.one(no);
				if (bag != null) {
					t2.setText(bag.getTitle());
					t3.setText(bag.getContent());
					t4.setText(bag.getWriter());
				} else {
					t2.setText("");
					t3.setText("");
					t4.setText("");
					JOptionPane.showMessageDialog(f, "검색결과 없음");
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
