package 화면DB연결;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import 자바DB연결.BookDAO;
import 자바DB연결.BookVO;
import 자바DB연결.MemberVO;
import 자바DB연결.PageDAO;
import 자바DB연결.PageVO;
import 자바DB연결.StarDao;
import 자바DB연결.StarVO;

public class MyPage {
	int x = 0;

	// public static void main(String[] args) {
	public void open(MemberVO bag1) {
		JFrame f = new JFrame();
		f.setTitle("마이페이지");
		f.setSize(1000, 800);
		f.getContentPane().setBackground(new Color(204, 229, 255));

		Font font = new Font("굴림", Font.BOLD, 20);

		JLabel id1 = new JLabel("아이디");
		JTextField id2 = new JTextField(10);
		JLabel l1 = new JLabel("닉네임");
		JLabel n1 = new JLabel();
		JLabel l2 = new JLabel("소개글");
		JLabel n2 = new JLabel();
		JLabel l3 = new JLabel("찜한책");

		id2.setText(bag1.getId());

		JButton b5 = new JButton("회원탈퇴");
		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PageDEL del = new PageDEL();
				del.open();
			}
		});
		JButton b6 = new JButton("회원정보수정");
		b6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PageUI update = new PageUI();
				update.open();
			}
		});
		JButton b7 = new JButton("회원정보가져오기");
		b7.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = id2.getText();
				PageDAO dao = new PageDAO();
				PageVO result = dao.one(id);
				System.out.println(result.getNICKNAME());
				n1.setText(result.getNICKNAME());
				n2.setText(result.getLET());
			}
		});

		id1.setFont(font);
		id2.setFont(font);
		l1.setFont(font);
		l2.setFont(font);
		l3.setFont(font);
		b5.setFont(font);
		b6.setFont(font);
		b7.setFont(font);

		f.add(id1);
		f.add(id2);
		f.add(l1);
		f.add(n1);
		f.add(l2);
		f.add(n2);
		f.add(b5);
		f.add(b6);
		f.add(b7);
		f.add(l3);

		StarDao dao = new StarDao();
		ArrayList<StarVO> list = dao.list(bag1.getId());
		BookDAO dao2 = new BookDAO();

		if (list.size() == 0) {
			System.out.println("검색결과 없음");
		} else {
			System.out.println("검색결과는 전체 " + list.size() + "개");
			for (int i = 0; i < list.size(); i++) {
				x = i;
				BookVO bag2 = dao2.one(list.get(i).getNo());
				JLabel l = new JLabel(new ImageIcon(bag2.getImg()));
				f.add(l);
				JButton b = new JButton("찜 삭제");
				f.add(b);

				b.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						StarVO bag = new StarVO();
						BookVO bag2 = dao2.one(list.get(x).getNo());
						bag.setId(bag1.getId());
						bag.setNo(bag2.getNo());
						dao.star(bag);
						l.setVisible(false);
						b.setVisible(false);

					}
				});
			}
		}

		FlowLayout flow = new FlowLayout();
		f.setLayout(flow);
		f.setVisible(true);
	}
}
