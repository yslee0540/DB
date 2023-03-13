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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import 자바DB연결.StarDao;
import 자바DB연결.StarVO;
public class StarUI {
	public void open(StarVO bag) {
		// System.out.println(id);
		JFrame f = new JFrame();
		f.setSize(600, 480);
		FlowLayout flow = new FlowLayout();
		f.getContentPane().setBackground(new Color(204, 229, 255));
		f.setLayout(flow);
		JLabel l1 = new JLabel("<<<<  평가하기   >>>>");
		JLabel l2 = new JLabel("별점");
		JLabel l3 = new JLabel("코멘트");
		JLabel l4 = new JLabel("          ");
		JLabel l5 = new JLabel("          ");
		JTextField t1 = new JTextField("1~5");
		JTextArea t2 = new JTextArea(5, 15);
		t2.setLineWrap(true);
		JButton b1 = new JButton();
		JButton b2 = new JButton("찜하기");
		JButton b3 = new JButton("평가하기");
		JButton b4 = new JButton("수정하기");
		
		
		StarDao dao = new StarDao();
		
		int read = dao.one(bag);
		System.out.println(read);
		if (read == 0) {
			b1.setText(" 읽기 ");
		} else {
			b1.setText("읽는 중");
		}
		
		
		//읽는 중
		b1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int no = bag.getNo();
				String id = bag.getId();
				StarDao dao = new StarDao();
				StarVO bag = new StarVO();
				bag.setNo(no);
				bag.setId(id);
				int read = dao.one(bag);
				System.out.println(read);
				if (read == 0) {
					dao.updateRead(bag);
					b1.setText("읽는 중");
				} else {
					dao.deleteRead(bag);
					b1.setText(" 읽기 ");
				}
			}
		});
		
		b2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int no = bag.getNo();
				String id = bag.getId();
				StarDao dao = new StarDao();
				StarVO bag = new StarVO();
				bag.setNo(no);
				bag.setId(id);
				dao.updateStar(bag);
			}
		});
		
		b3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int no = bag.getNo();
				int star = Integer.parseInt(t1.getText());
				String comment = t2.getText();
				StarDao dao = new StarDao();
				StarVO bag = new StarVO();
				// bag.setNo(no);
				bag.setNo(no);
				bag.setStar(star);
				bag.setComment(comment);
				// bag.setId(id);
				int result = dao.update(bag);
				if (result == 1) {
					JOptionPane.showMessageDialog(f, "평가 완료!");
				}
			}// action
		});// b1
		b4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int no = bag.getNo();
				int star = Integer.parseInt(t1.getText());
				String comment = t2.getText();
				StarDao dao = new StarDao();
				StarVO bag = new StarVO();
				bag.setNo(no);
				bag.setStar(star);
				bag.setComment(comment);
				// bag.setId(id);
				int result = dao.update(bag);
				if (result == 1) {
					JOptionPane.showMessageDialog(f, "수정 완료!");
				}
			}// action
		});// b1
		Font font1 = new Font("바탕", Font.BOLD, 45);
		Font font2 = new Font("바탕", Font.BOLD, 35);
		Font font3 = new Font("바탕", Font.BOLD, 25);
		l1.setFont(font1);
		l2.setFont(font2);
		l3.setFont(font2);
		l4.setFont(font2);
		l5.setFont(font2);
		b1.setFont(font3);
		b2.setFont(font3);
		b3.setFont(font3);
		b4.setFont(font3);
		t1.setFont(font2);
		t2.setFont(font2);
		f.add(l1);
		f.add(l5);
		f.add(b1);
		f.add(b2);
		f.add(l4);
		f.add(l2);
		f.add(t1);
		f.add(l3);
		f.add(t2);
		f.add(b3);
		f.add(b4);
		f.setVisible(true);
	}
}