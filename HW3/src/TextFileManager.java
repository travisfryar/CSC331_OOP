/**
 * PROGRAM:........... Text File Manager
 * AUTHOR:............ Travis Fryar
 * COURSE:............ CSC 331 
 * TERM:.............. Fall 2020
 * DATE:.............. 10/13/2020
 */

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

public class TextFileManager {
	private JFrame frame;
	private JTextField txtTypeSearchText;
	private JPanel panel, panel2;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private JLabel lblFileLabel;
	private JButton btnDisplayFile, btnDisplayWords, btnClearDisplay, btnSearchFile;
	private JMenuItem mntmOpen, mntmAscending, mntmDescending;
	private File file;
	private String filename;
	private ArrayList<String> fullLines;
	private int fileSize;

	public TextFileManager() throws FileNotFoundException {
		setupFrame();
	}

	public void setupFrame() {
		// Initial frame setup
		this.frame = new JFrame("Text File Manager");
		this.frame.getContentPane().setBackground(Color.GRAY);
		this.frame.setVisible(true);
		this.frame.setSize(700, 640);
		this.frame.setLocation(550, 50);
		this.frame.getContentPane().setLayout(null);
		this.frame.setResizable(false);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addMenu();

		// Add text area to frame
		this.textArea = new JTextArea();
		this.textArea.setFont(new Font("Calibri", Font.PLAIN, 12));
		this.textArea.setBorder(new BevelBorder(BevelBorder.LOWERED));
		this.textArea.setText("[File -> Open] to load a file");
		this.textArea.setEditable(false);
		scrollPane = new JScrollPane();
		scrollPane.setViewportView(this.textArea);
		scrollPane.setBounds(65, 80, 550, 385);
		this.frame.getContentPane().add(scrollPane);

		// Add panels to frame
		// 1
		this.panel = new JPanel();
		this.panel.setBackground(Color.GRAY);
		this.panel.setBounds(0, 0, 685, 55);
		this.panel.setLayout(new FlowLayout(FlowLayout.CENTER, 8, 20));
		this.frame.getContentPane().add(this.panel);
		addPanel1components();
		// 2
		this.panel2 = new JPanel();
		this.panel2.setBackground(Color.GRAY);
		this.panel2.setBounds(0, 460, 685, 115);
		this.panel2.setLayout(null);
		this.frame.getContentPane().add(this.panel2);
		addPanel2components();
	}

	public void addMenu() {
		// Add menu and components to frame
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorder(new BevelBorder(BevelBorder.RAISED));
		menuBar.setPreferredSize(new Dimension(0, 25));
		this.frame.setJMenuBar(menuBar);
		JMenu mnFileMenu = new JMenu("File");
		mnFileMenu.setFont(new Font("Consolas", Font.PLAIN, 12));
		menuBar.add(mnFileMenu);
		this.mntmOpen = new JMenuItem("Open");
		this.mntmOpen.setFont(new Font("Consolas", Font.PLAIN, 12));
		mnFileMenu.add(this.mntmOpen);
		JMenu mnSortMenu = new JMenu("Sort");
		mnSortMenu.setFont(new Font("Consolas", Font.PLAIN, 12));
		menuBar.add(mnSortMenu);
		this.mntmAscending = new JMenuItem("Ascending");
		this.mntmAscending.setFont(new Font("Consolas", Font.PLAIN, 12));
		mnSortMenu.add(this.mntmAscending);
		this.mntmDescending = new JMenuItem("Descending");
		this.mntmDescending.setFont(new Font("Consolas", Font.PLAIN, 12));
		mnSortMenu.add(this.mntmDescending);
		this.mntmOpen.addActionListener(new MenuListener());
		this.mntmAscending.addActionListener(new MenuListener());
		this.mntmDescending.addActionListener(new MenuListener());
	}

	public void addPanel1components() {
		// Add components to panel1
		this.btnDisplayFile = new JButton("Display File");
		this.btnDisplayFile.setPreferredSize(new Dimension(130, 30));
		this.btnDisplayFile.setFont(new Font("Consolas", Font.PLAIN, 12));
		this.panel.add(this.btnDisplayFile);
		this.btnDisplayWords = new JButton("Display Words");
		this.btnDisplayWords.setPreferredSize(new Dimension(130, 30));
		this.btnDisplayWords.setFont(new Font("Consolas", Font.PLAIN, 12));
		this.panel.add(this.btnDisplayWords);
		this.btnClearDisplay = new JButton("Clear Display");
		this.btnClearDisplay.setPreferredSize(new Dimension(130, 30));
		this.btnClearDisplay.setFont(new Font("Consolas", Font.PLAIN, 12));
		this.panel.add(this.btnClearDisplay);
		// Add listeners to buttons
		this.btnDisplayFile.addActionListener(new ButtonListener());
		this.btnDisplayWords.addActionListener(new ButtonListener());
		this.btnClearDisplay.addActionListener(new ButtonListener());
	}

	public void addPanel2components() {
		// Add components to panel2
		this.txtTypeSearchText = new JTextField();
		txtTypeSearchText.setBorder(new BevelBorder(BevelBorder.LOWERED));
		this.txtTypeSearchText.setBounds(175, 35, 185, 30);
		this.txtTypeSearchText.setPreferredSize(new Dimension(140, 30));
		this.txtTypeSearchText.setFont(new Font("Consolas", Font.PLAIN, 12));
		this.txtTypeSearchText.setText("Type search text here");
		this.panel2.add(this.txtTypeSearchText);
		this.btnSearchFile = new JButton("Search File");
		this.btnSearchFile.setPreferredSize(new Dimension(130, 30));
		this.btnSearchFile.setFont(new Font("Consolas", Font.PLAIN, 12));
		this.btnSearchFile.setBounds(370, 35, 130, 30);
		this.panel2.add(this.btnSearchFile);
		this.lblFileLabel = new JLabel("");
		this.panel2.add(lblFileLabel);
		this.lblFileLabel.setForeground(Color.BLUE);
		this.lblFileLabel.setHorizontalAlignment(SwingConstants.CENTER);
		this.lblFileLabel.setFont(new Font("Consolas", Font.ITALIC, 12));
		this.lblFileLabel.setBounds(65, 75, 550, 25);
		this.lblFileLabel.setText("[File -> Open] to load a file");
		this.btnSearchFile.addActionListener(new ButtonListener());
	}

	public void setLabel(String filename) {
		this.lblFileLabel.setText("File loaded: " + filename);
		this.textArea.setText("File loaded: " + filename);
	}

	public void openFile() throws FileNotFoundException {
		JFileChooser fileChooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter(".txt files", "txt");
		fileChooser.setFileFilter(filter);
		int result = fileChooser.showOpenDialog(null);
		if (result == JFileChooser.APPROVE_OPTION) {
			this.file = fileChooser.getSelectedFile();
			this.filename = this.file.getName();
			processFile();
			setLabel(this.filename);

		}

	}

	public void setFileSize() throws FileNotFoundException {
		Scanner scanFile = new Scanner(this.file);
		while (scanFile.hasNextLine()) {
			scanFile.nextLine();
			this.fileSize++;
		}
		scanFile.close();
	}

	private boolean initializeArray() {
		if (this.fileSize != 0) {
			this.fullLines = new ArrayList<String>();
			return true;
		}
		return false;
	}

	public void storeValues(String line, int index) {
		this.fullLines.add(line);
	}

	public void processFile() throws FileNotFoundException {
		this.setFileSize();
		boolean fileReady = this.initializeArray();
		if (fileReady) {
			Scanner scanFile = new Scanner(this.file);
			int index = 0;
			while (scanFile.hasNextLine()) {
				String line = scanFile.nextLine();
				if (line.isBlank() == false) {
					this.storeValues(line, index);
					index++;
				}
			}
			scanFile.close();
		}
	}

	class ButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent ae) {
			if (ae.getSource() == btnDisplayFile) {
				textArea.setText("");
				for (String line : fullLines) {
					int position = textArea.getCaretPosition();
					textArea.append(line + "\n");
					textArea.setCaretPosition(position);
				}
			} else if (ae.getSource() == btnDisplayWords) {
				textArea.setText("");
				for (String line : fullLines) {
					String[] wordsArr = line.split("[^\\w']+");

					for (String word : wordsArr) {
						int position = textArea.getCaretPosition();
						textArea.append(word + "\n");
						textArea.setCaretPosition(position);
					}
				}
			} else if (ae.getSource() == btnClearDisplay) {
				textArea.setText("");
			} else if (ae.getSource() == btnSearchFile) {
				int counter = 0;
				for (String line : fullLines) {
					if (line.contains(txtTypeSearchText.getText())) {
						counter++;
					}
				}
				if (counter == 0) {
					JOptionPane.showMessageDialog(frame,
							"Search did not find this string in the file!");
				} else {
					JOptionPane.showMessageDialog(frame,
							"Search found " + counter + " lines which contain this string in the file!");
				}

			}
		}
	}

	class MenuListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent ae) {
			if (ae.getSource() == mntmOpen) {
				try {
					openFile();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if (ae.getSource() == mntmAscending) {
				String[] sortArr = textArea.getText().split("\\n");
				Arrays.sort(sortArr);
				textArea.setText("");
				for (String ele : sortArr) {
					int position = textArea.getCaretPosition();
					textArea.append(ele + "\n");
					textArea.setCaretPosition(position);
				}

			} else if (ae.getSource() == mntmDescending) {
				String[] sortArr = textArea.getText().split("\\n");
				Arrays.sort(sortArr, Collections.reverseOrder());
				textArea.setText("");
				for (String ele : sortArr) {
					int position = textArea.getCaretPosition();
					textArea.append(ele + "\n");
					textArea.setCaretPosition(position);
				}
			}
		}
	}// end of inner class

	// main
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					new TextFileManager();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
			}
		});
	}
}
