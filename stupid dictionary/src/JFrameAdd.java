import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;
import java.awt.Font;

public class JFrameAdd extends JFrame {

	private JPanel contentPane;
	private JTextField textWord;
	private JTextArea textMean;
	
	/**
	 * Create the frame.
	 */
	public JFrameAdd(DictionaryManagement dm) {
		
		setTitle("Add");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(500, 300, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(231,221,196));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Enter a word:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel.setBounds(34, 20, 237, 14);
		
		textWord = new JTextField();
		textWord.setBounds(34, 40, 372, 30);
		textWord.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Meaning:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_1.setBounds(34, 95, 146, 14);
		
		JButton btnNewButton = new JButton("Add");

		btnNewButton.setBackground(new Color(230, 230, 250));
		btnNewButton.setBounds(260, 204, 70, 25);
		
		textMean = new JTextArea();
		textMean.setBounds(34, 120, 372, 70);
		textMean.setColumns(10);
		contentPane.setLayout(null);
		contentPane.add(lblNewLabel);
		contentPane.add(textWord);
		contentPane.add(lblNewLabel_1);
		contentPane.add(btnNewButton);
		contentPane.add(textMean);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textWord.getText().equals("") && textMean.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Error!");
				}
				else {
					if(dm.addtoList(textWord.getText(), textMean.getText()) == true){
						JOptionPane.showMessageDialog(null, "Add done!");
					}
					else {
						JOptionPane.showMessageDialog(null, "this word was exist!");
					}

				}
			}
		});
		
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
