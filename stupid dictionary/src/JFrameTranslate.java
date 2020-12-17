import java.awt.BorderLayout;
import com.darkprograms.speech.translator.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.ScrollPane;
import javax.swing.JMenu;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JComboBox;
import javax.management.loading.PrivateClassLoader;
import javax.swing.DefaultComboBoxModel;
import java.awt.Window.Type;
import javax.swing.SwingConstants;

public class JFrameTranslate extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Create the frame.
	 */
	public JFrameTranslate() {
		setType(Type.UTILITY);
		setTitle("Translate");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(500, 300, 500, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(231,221,196));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JButton translateButton = new JButton("Translate");
		
		translateButton.setBackground(new Color(230, 230, 250));
		translateButton.setBounds(190, 31, 89, 23);
		contentPane.add(translateButton);
		
		JComboBox langTarget = new JComboBox();

		langTarget.setModel(new DefaultComboBoxModel(new String[] {"en", "vi"}));
		langTarget.setBounds(311, 32, 59, 20);
		contentPane.add(langTarget);
		
		JComboBox langTranslate = new JComboBox();

		langTranslate.setModel(new DefaultComboBoxModel(new String[] {"vi", "en"}));
		langTranslate.setBounds(85, 32, 59, 20);
		contentPane.add(langTranslate);
		
		JTextArea textTranslate = new JTextArea();
		contentPane.add(textTranslate);
		textTranslate.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		textTranslate.setBounds(10, 65, 224, 174);
		textTranslate.setEditable(false);
		
		
		JTextArea textEnter = new JTextArea();
		contentPane.add(textEnter);
		textEnter.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		textEnter.setBounds(250, 65, 224, 174);
		
		translateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					textTranslate.setText(GoogleTranslate.translate((String) langTarget.getSelectedItem(),(String) langTranslate.getSelectedItem(), textEnter.getText()));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(rootPane, "Internet connect error!!");
				}
				
			}
			
		});
	}
}
