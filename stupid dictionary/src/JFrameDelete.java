import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class JFrameDelete extends JFrame {

	private JPanel contentPane;
	private JTextField textDelete;


	/**
	 * Create the frame.
	 * @return 
	 */
	public JFrameDelete(DictionaryManagement dm) {
		setTitle("Delete");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(500, 300, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(231,221,196));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textDelete = new JTextField();
		textDelete.setBounds(34, 100, 372, 30);
		contentPane.add(textDelete);
		textDelete.setColumns(10);
		
		JButton btnNewButton = new JButton("Delete");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(textDelete.getText().equals("")){
					JOptionPane.showMessageDialog(rootPane, "Error!");
				}
				else {
					if(dm.delete(textDelete.getText())== true){
						JOptionPane.showMessageDialog(rootPane, "Deleted!");
					}
					else if(dm.delete(textDelete.getText())==false){
						JOptionPane.showMessageDialog(rootPane, "Not found!");
					}
				}
			}
		});
		btnNewButton.setBackground(new Color(230, 230, 250));
		btnNewButton.setBounds(260, 204, 70, 25);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Enter word:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel.setBounds(34, 75, 126, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("Exit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CloseFrame();
			}
		});
		btnNewButton_1.setBounds(336, 204, 70, 25);
		contentPane.add(btnNewButton_1);
	}


	protected void CloseFrame() {
		// TODO Auto-generated method stub
		super.dispose();
		
	}





}


