package Interface;
/**
 * The {@code UIinterface} class using java swing provides an Interface for user
 * 
 * @author Bowen Yuan
 * Date Revised: 01/04/2017
 */
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import search.SearchKeyword;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextArea;

public class UIinterface extends JFrame {

	private JPanel contentPane;

	private String str="";

	/**
	 * Create an interface and Launch the application.
	 */
	public static void main(String[] args) {
		/*
		 * try { UIManager.setLookAndFeel(UIManager.
		 * getCrossPlatformLookAndFeelClassName()); } catch
		 * (ClassNotFoundException | InstantiationException |
		 * IllegalAccessException | UnsupportedLookAndFeelException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIinterface frame = new UIinterface();
					frame.setTitle("LyricsByU");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * get the string user input
	 * @return get the string that the user input
	 */
	public String getStr() {
		return str;
	}

	/**
	 * Create the frame.
	 */
	public UIinterface() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 620, 380);
		contentPane = new JPanel() {
			protected void paintComponent(Graphics g) {
				ImageIcon icon = new ImageIcon("data/background.jpg");
				Image img = icon.getImage();
				g.drawImage(img, 0, 0, contentPane.getWidth(), contentPane.getHeight(), icon.getImageObserver());

			}
		};

		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("LyricsByU");
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 65));
		lblNewLabel.setForeground(new Color(65, 105, 225));
		lblNewLabel.setBounds(138, 27, 366, 116);
		contentPane.add(lblNewLabel);

		JButton createSong = new JButton("I want to create a song");
		createSong.setFont(new Font("Cambria", Font.BOLD, 24));
		createSong.setForeground(new Color(0, 0, 0));
		createSong.setBounds(162, 163, 285, 56);
		contentPane.add(createSong);

		TextArea textArea = new TextArea();
		textArea.setBounds(51, 27, 489, 235);
		contentPane.add(textArea);
		textArea.setVisible(false);

		JButton playagain = new JButton("Play again");
		playagain.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		playagain.setBounds(192, 277, 215, 35);
		contentPane.add(playagain);
		playagain.setVisible(false);

		JButton exit = new JButton("Exit");
		exit.setFont(new Font("Comic Sans MS", exit.getFont().getStyle(), exit.getFont().getSize()));
		exit.setBounds(518, 309, 63, 23);
		contentPane.add(exit);

		JButton getLine = new JButton("I want to get one line");
		getLine.setFont(new Font("Cambria", Font.BOLD, 24));
		getLine.setForeground(new Color(0, 0, 0));
		getLine.setBounds(162, 256, 285, 56);
		contentPane.add(getLine);

		//button for users to go back to menu and make a new song/line
		playagain.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				createSong.setVisible(true);
				getLine.setVisible(true);
				lblNewLabel.setVisible(true);
				textArea.setText("");
				textArea.setVisible(false);
				playagain.setVisible(false);
			}

		});

		//button for users to exit the program
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int n = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "LyricsByU",
						JOptionPane.YES_NO_OPTION);
				if (n == JOptionPane.YES_OPTION) {
					System.exit(0);
				} else if (n == JOptionPane.NO_OPTION) {

				}
			}

		});

		//Button for users to create a song
		createSong.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				str = JOptionPane.showInputDialog(null, "Input a word you like", "LyricsByU",
						JOptionPane.INFORMATION_MESSAGE);
				if (!(str==null)) {
					createSong.setVisible(false);
					getLine.setVisible(false);
					lblNewLabel.setVisible(false);
					textArea.setVisible(true);
					playagain.setVisible(true);
					try {
						textArea.setText(SearchKeyword.createSong(str));
					} catch (Exception e) {
						textArea.setText("");
						JOptionPane.showMessageDialog(null, "Oops, please input again");
					}
				}

			}

		});

		//Button for users to input genre
		getLine.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Object[] possibleValues = { "Country", "Electronic", "Folk", "Hip-Hop", "Indie", "Jazz", "Metal",
						"Other", "Pop", "Rock" }; 
				Object selectedValue = JOptionPane.showInputDialog(null, "Choose the genre", "LyricsByU",
						JOptionPane.INFORMATION_MESSAGE, null, possibleValues, possibleValues[0]);
				if (!(((String)selectedValue)==null)) {
					str = JOptionPane.showInputDialog(null, "Input a word you like", "LyricsByU",
							JOptionPane.INFORMATION_MESSAGE);
					if (!(str==null)) {
						createSong.setVisible(false);
						getLine.setVisible(false);
						lblNewLabel.setVisible(false);
						textArea.setVisible(true);
						playagain.setVisible(true);
						try {
							textArea.setText(SearchKeyword.search(str,(String)selectedValue));
						} catch (Exception ee) {
							textArea.setText("");
							JOptionPane.showMessageDialog(null, "Oops, please input again");
						}
					}
				}
			}

		});

	}
}
