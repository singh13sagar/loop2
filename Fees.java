
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Fees extends JFrame {

	private JPanel contentPane;
	private Member mainMember;
	private JTextField ammountField;
	private JLabel lblPrice;
	private MemberList mList;
	private int index;
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fees frame = new Fees();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public Fees(MemberList mem, int i) {
		//mainMember=mem;
		mList=mem;
		index=i;
		mainMember=mList.getMember(i);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lbl1 = new JLabel("Your outstanding balance is:");
		lbl1.setBounds(29, 65, 233, 15);
		contentPane.add(lbl1);
		
		String temp = Integer.toString(mainMember.getDuefee());
		lblPrice = new JLabel(temp);
		lblPrice.setBounds(248, 65, 70, 15);
		contentPane.add(lblPrice);

		ActionListener payIt = new payListener();

		JButton btnNewButton_1 = new JButton("Pay");
		btnNewButton_1.addActionListener(payIt);
		btnNewButton_1.setBounds(275, 60, 79, 25);
		contentPane.add(btnNewButton_1);
		
		



		ammountField = new JTextField();
		ammountField.setBounds(365, 60, 79, 25);
		contentPane.add(ammountField);


		JButton btnNewButton_2 = new JButton("<--");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				memberViewer temp = new memberViewer(mList,i);
				temp.setVisible(true);
				//new memberViewer("Try for now").setVisible(true);
				setVisible(false);

			}
			
		});
		btnNewButton_2.setBounds(382, 12, 54, 25);
		contentPane.add(btnNewButton_2);

		
	}
	class payListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) {
			
			mainMember.deposit(Integer.parseInt(ammountField.getText()));
			//lblPrice.setText(Integer.toString(mainMember.getDuefee()));
			//Fees temp = new Fees(mainMember);
			Fees temp = new Fees(mList,index);
			temp.setVisible(true);
			//new memberViewer("Try for now").setVisible(true);
			setVisible(false);

		}
	}
}
