import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.awt.ScrollPane;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Window.Type;

public class JFrameEdit extends JFrame {

	private JPanel contentPane;
	private JTextField textWord;
	private JTextArea textMean;

	/**
	 * Create the frame.
	 */
	public JFrameEdit(DictionaryManagement dm) {
		setType(Type.UTILITY);
		setTitle("Edit");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(500, 300, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(231, 221, 196));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textWord = new JTextField();
		textWord.setBounds(34, 40, 372, 30);
		contentPane.add(textWord);
		textWord.setColumns(10);
		
		textMean = new JTextArea();
		textMean.setBounds(34, 120, 372, 70);
		contentPane.add(textMean);
		textMean.setColumns(10);
		
		JButton btnNewButton = new JButton("Edit");
		btnNewButton.setBackground(new Color(230, 230, 250));
		btnNewButton.setBounds(260, 204, 70, 25);
	
	
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textWord.getText().equals("") ||  textWord.getText().equals("")){
					JOptionPane.showMessageDialog(rootPane, "Error!!");
				}
				else {
					if(dm.edit(textWord.getText(), textMean.getText()) == true){
						JOptionPane.showMessageDialog(rootPane, "fix done!");
					}
					else {
						JOptionPane.showMessageDialog(rootPane, "Not found!!");
					}
	
				}
			}
		});
		
		JLabel lblNewLabel = new JLabel("Enter a word");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel.setBounds(34, 20, 237, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Meaning");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_1.setBackground(new Color(255, 228, 225));
		lblNewLabel_1.setBounds(34, 100, 146, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("Exit");
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CLoseFrame();
			}
		});
		btnNewButton_1.setBounds(336, 204, 70, 25);
		contentPane.add(btnNewButton_1);
	}

	protected void CLoseFrame() {
		// TODO Auto-generated method stub
		super.dispose();
	}

}
