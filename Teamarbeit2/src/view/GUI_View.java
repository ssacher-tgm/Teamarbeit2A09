package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.Main_Controller;

@SuppressWarnings("serial")
public class GUI_View extends JFrame{

	private static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private static int DEF_X_POS = (int) screenSize.getWidth() / 4 + 250;
	private static int DEF_Y_POS = (int) screenSize.getHeight() / 4;
	private static int X_DIM = 500;
	private static int Y_DIM = 500;
	
	private JPanel mainPanel;
	private JPanel middlePanel;
	private JPanel topPanel;
	
	public static JButton[][] buttons = new JButton[5][5];
	
	private Main_Controller mC = new Main_Controller();
	
	public static JButton newGame = new JButton("NEUES SPIEL");

	public static JLabel counter = new JLabel();

	public GUI_View() {
		super("Lights Out (5x5)");
		mainPanel = new JPanel(new BorderLayout());
		middlePanel = new JPanel(new GridLayout(5, 5));
		topPanel = new JPanel(new GridLayout(1, 2));
		this.getContentPane().add(mainPanel);

		mainPanel.add(middlePanel, BorderLayout.CENTER);
		mainPanel.add(topPanel, BorderLayout.NORTH);

		newGame.setBackground(Color.BLACK);
		newGame.setForeground(Color.WHITE);
		newGame.addActionListener(mC);
		topPanel.add(newGame, BorderLayout.NORTH);
		
		counter.setBackground(Color.BLACK);
		counter.setForeground(Color.WHITE);
		counter.setOpaque(true);
		counter.setText("Spielzug 0");
		counter.setHorizontalAlignment(JLabel.CENTER);
		topPanel.add(counter, BorderLayout.NORTH);
		
		//System.out.println(buttons.length);
		for(int i=0;i<buttons.length;i++){
			for(int j=0;j<buttons.length;j++){
				buttons[i][j]=new JButton();
				middlePanel.add(buttons[i][j]);
				buttons[i][j].addActionListener(mC);
				buttons[i][j].setBackground(Color.BLACK);
			}
		}
		
		this.setBackground(Color.BLACK);
		this.setResizable(false);
		this.pack();
		this.setLocation(DEF_X_POS, DEF_Y_POS);
		this.setSize(new Dimension(X_DIM, Y_DIM));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}