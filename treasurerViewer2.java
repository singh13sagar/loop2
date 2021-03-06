
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import java.awt.List;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class treasurerViewer2 extends JFrame {
	private MemberList m;
	private JTextArea area;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public treasurerViewer2(MemberList m) {
		this.m = m;
		setTitle("Treasurer Managment");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		area = new JTextArea();
		area.setBounds(82, 10, 500, 181);
		contentPane.add(area);
		area.setText(m.printList());
		JButton button = new JButton("<-");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						new treasurerViewer(m).setVisible(true);
						setVisible(false);
			}
		});
		button.setBounds(12, 10, 58, 36);
		contentPane.add(button);
		
		Button button_1 = new Button("Sort by Times Paid");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				m.sortList();
				area.setText(m.printList());
			}
		});
		button_1.setBounds(80, 199, 150, 36);
		contentPane.add(button_1);
		
		Button button_2 = new Button("Sort by Amount paid");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				m.paySort();
				area.setText(m.printList());
			}
		});
		button_2.setBounds(230, 199, 150, 36);
		contentPane.add(button_2);
		
		Button button_3= new Button("Sort by Amount Not paid");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				m.unpaidSort();
				area.setText(m.printList());
			}
		});
		button_3.setBounds(380, 199, 160, 36);
		contentPane.add(button_3);
	}
}
