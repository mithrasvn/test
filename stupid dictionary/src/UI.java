import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;
import java.awt.ScrollPane;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.LinkedList;
import java.awt.event.ActionEvent;
import javax.swing.DropMode;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Window.Type;

public class UI extends JFrame {
	
	DictionaryManagement dm = new DictionaryManagement();
	DefaultListModel<String> mod = new DefaultListModel<String>();
	
	private JPanel contentPane;
	 //add three frame : add, remove, delete
	JFrameAdd jfa = new JFrameAdd(dm);
	JFrameDelete jfd = new JFrameDelete(dm);
	JFrameEdit jfr = new JFrameEdit(dm);
	JFrameTranslate jft = new JFrameTranslate();
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI frame = new UI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UI() {
		setAlwaysOnTop(true);
		setForeground(new Color(0, 102, 102));
		setBackground(Color.PINK);
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 250, 650, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(231,221,196));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lblNewLabel = new JLabel("DICTIONARY");
		lblNewLabel.setForeground(new Color(127,171,148));
		lblNewLabel.setFont(new Font("000 Comic Sans TB", Font.BOLD, 46));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(70, 15, 457, 68);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("000 Comic Sans TB", Font.BOLD, 18));
		
		textField.setBounds(155, 94, 193, 35);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.setForeground(new Color(209,102,57));
		JButton SearchButton = new JButton("Translate");
		SearchButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
	
		SearchButton.setBackground(new Color(250, 235, 215));
		SearchButton.setBounds(358, 94, 94, 35);
		contentPane.add(SearchButton);		
		//show add frame
		JLabel addLabel = new JLabel("");
		addLabel.setHorizontalAlignment(SwingConstants.CENTER);
		addLabel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				jfa.setVisible(true);
				
			}
		});
		addLabel.setBackground(new Color(255, 255, 255));
		addLabel.setBounds(5, 94, 45, 45);
		contentPane.add(addLabel);
		ImageIcon add_icon = new ImageIcon("add.png");
		Image i = add_icon.getImage();
		add_icon = new ImageIcon(i.getScaledInstance(30, 30, Image.SCALE_SMOOTH));
		addLabel.setIcon(add_icon);
		addLabel.setToolTipText("add");
		
		//show replace Frame
		JLabel editLabel = new JLabel("");
		editLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				jfr.setVisible(true);
				
			}
		});
		editLabel.setHorizontalAlignment(SwingConstants.CENTER);
		editLabel.setBounds(45, 94, 45, 45);
		contentPane.add(editLabel);
		ImageIcon replace_icon = new ImageIcon("replace.png");
		Image j = replace_icon.getImage();
		replace_icon = new ImageIcon(j.getScaledInstance(30, 30, Image.SCALE_SMOOTH));
		editLabel.setIcon(replace_icon);
		editLabel.setToolTipText("edit");
		
		
		//show remove frame
		JLabel deleteLabel = new JLabel("");
		deleteLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				jfd.setVisible(true);
				
			}
		});
		deleteLabel.setHorizontalAlignment(SwingConstants.CENTER);
		deleteLabel.setBounds(100, 94, 45, 45);
		contentPane.add(deleteLabel);
		ImageIcon remove_icon = new ImageIcon("remove.png");
		Image z = remove_icon.getImage();
		remove_icon = new ImageIcon(z.getScaledInstance(30, 30, Image.SCALE_SMOOTH));
		deleteLabel.setIcon(remove_icon);
		deleteLabel.setToolTipText("delete");
		
		//show translate frame
		JLabel translateLabel = new JLabel("");
		translateLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				jft.setVisible(true);
			}
		});
		
		
		translateLabel.setHorizontalAlignment(SwingConstants.CENTER);
		translateLabel.setBounds(529, 94, 45, 45);
		contentPane.add(translateLabel);
		ImageIcon translate_icon = new ImageIcon("translate.png");
		Image t = translate_icon.getImage();
		translate_icon = new ImageIcon(t.getScaledInstance(30, 30, Image.SCALE_SMOOTH));
		translateLabel.setIcon(translate_icon);
		translateLabel.setToolTipText("surfgg");
		
		//creat a button using Jlabel, click to exit
		JLabel exitButton = new JLabel("");
		exitButton.setForeground(Color.CYAN);
		exitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		exitButton.setHorizontalAlignment(SwingConstants.CENTER);
		exitButton.setBounds(5, 15, 45, 45);
		contentPane.add(exitButton);
		ImageIcon exit_icon = new ImageIcon("exit.png");
		Image e = exit_icon.getImage();
		exit_icon = new ImageIcon(e.getScaledInstance(30, 30, Image.SCALE_SMOOTH));
		exitButton.setIcon(exit_icon);
		exitButton.setToolTipText("Exit");		
		JTextArea textWord = new JTextArea();
		textWord.setForeground(new Color(209,102,57));
		textWord.setBackground(Color.WHITE);
		textWord.setFont(new Font("000 Comic Sans TB", Font.BOLD, 24));
		textWord.setBounds(336, 163, 290, 70);
		contentPane.add(textWord);
		textWord.setEditable(false);
		
		JTextArea textExplain = new JTextArea();
		textExplain.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		textExplain.setForeground(new Color(52,45,38));
		textExplain.setBounds(336, 233, 290, 120);
		contentPane.add(textExplain);
		textExplain.setEditable(false);
		
		JLabel speakerButton = new JLabel("");
		speakerButton.setBackground(new Color(255, 255, 255));
		speakerButton.setForeground(new Color(255, 255, 255));
		speakerButton.setBounds(584, 94, 45, 45);
		contentPane.add(speakerButton);
		
		ImageIcon speaker_icon = new ImageIcon("speaker.png");
		Image r = speaker_icon.getImage();
		speaker_icon = new ImageIcon(r.getScaledInstance(30, 30, Image.SCALE_SMOOTH));
		speakerButton.setIcon(speaker_icon);
		speakerButton.setToolTipText("Speech");
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(12, 163, 290, 190);
		contentPane.add(scrollPane_1);
		
		JList list = new JList();
		scrollPane_1.setViewportView(list);
		list.setSelectedIndex(0);
		list.setBackground(new Color(255, 255, 255));
		list.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		//Enter to textField, Suggest new word in a list
		textField.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyTyped(java.awt.event.KeyEvent evt) {
				ArrayList<Word> temp = new ArrayList<Word>();
				String text = textField.getText();
				if ((int) evt.getKeyChar() == 8 && text.length() >= 1) {
					text = text.substring(0, text.length());
				} else {
					text+=evt.getKeyChar();
				}
			
				text= text.toLowerCase();
				mod = new DefaultListModel<>();

				temp = dm.dictionarySearcher(text);
				for(Word w : temp) {
					mod.addElement(w.getWord_target());
				}
				list.setModel(mod);
			}
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					String s = textField.getText();
					 textExplain.setText(dm.dictionaryLookup(s));
					  textWord.setText("\n" + " " + s);
				}
			}
		});
		SearchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if(textField.getText().equals("") == true) {
		            	JOptionPane.showMessageDialog( null,"Error!");
		            	} else {
		            		textExplain.setText(dm.dictionaryLookup(textField.getText()));
		    				textWord.setText( "\n" + " " + textField.getText());
		            	}
				
			} 
		});
		
		
		
		speakerButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
		        Voice voice = VoiceManager.getInstance().getVoice("kevin16");
		        if(voice!=null){
		            voice.allocate();
		            if(textField.getText().equals("") == true) {
		            	JOptionPane.showMessageDialog(null, "Error!!");
		            }
		            voice.speak(textWord.getText());
		        }
			}
		});
		
		
	}
}
