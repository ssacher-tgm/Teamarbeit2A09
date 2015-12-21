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

/**
 * Hier wird das Visuelle und die Logik dahinter erzeugt
 * @author Sebastian Sacher und Mario Ottomaier
 *
 */
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

	/**
	 * HIER wird das visuelle erzeugt
	 * @author Sebastian Sacher und Mario Ottomaier und Felix Wöls
	 */
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
		counter.setText("0. Zug");
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
		
		//Erste grüne Fläche
		int a = 2;
		int b = 2;
		buttons[a][b].setBackground(Color.GREEN);
		
		this.setBackground(Color.BLACK);
		this.setResizable(false);
		this.pack();
		this.setLocation(DEF_X_POS, DEF_Y_POS);
		this.setSize(new Dimension(X_DIM, Y_DIM));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	/**
	 * Eine Hilfsmethode die die Farbe setzt
	 * @author Sebastian Sacher
	 * @param i Die Y-Koordinate
	 * @param j Die X-Koordinate
	 * @param gC zählt wie viele grüne Flächen noch da sind (Bei null wird eine Nachricht im Controller ausgegeben)
	 */
	public static void setColor(int i, int j, int gC) {
		int greenCounter = gC;
		try{
			if(buttons[i][j].getBackground()==Color.BLACK){
				buttons[i][j].setBackground(Color.GREEN);
				greenCounter++;
			} else {
				buttons[i][j].setBackground(Color.BLACK);
				greenCounter--;
			}
		} catch (ArrayIndexOutOfBoundsException e){
		}
		try{	
			if(buttons[i+1][j].getBackground()==Color.BLACK){
				buttons[i+1][j].setBackground(Color.GREEN);
				greenCounter++;
			} else {
				buttons[i+1][j].setBackground(Color.BLACK);
				greenCounter--;
			}
		} catch (ArrayIndexOutOfBoundsException e){
		}
		try{
			if(buttons[i-1][j].getBackground()==Color.BLACK){
				buttons[i-1][j].setBackground(Color.GREEN);
				greenCounter++;
			} else {
				buttons[i-1][j].setBackground(Color.BLACK);
				greenCounter--;
			}
		} catch (ArrayIndexOutOfBoundsException e){
		}
		try{
			if(buttons[i][j+1].getBackground()==Color.BLACK){
				buttons[i][j+1].setBackground(Color.GREEN);
				greenCounter++;
			} else {
				buttons[i][j+1].setBackground(Color.BLACK);
				greenCounter--;
			}
		} catch (ArrayIndexOutOfBoundsException e){
		}
		try{
			if(buttons[i][j-1].getBackground()==Color.BLACK){
				buttons[i][j-1].setBackground(Color.GREEN);
				greenCounter++;
			} else {
				buttons[i][j-1].setBackground(Color.BLACK);
				greenCounter--;
			}
		} catch (ArrayIndexOutOfBoundsException e){
		}
		//System.out.println(greenCounter);
		Main_Controller.gC = greenCounter;
	}
	
	/**
	 * Eine Hilfsmethode die das Spielfeld zurücksetzt
	 * @author Sebastian Sacher
	 */
	public static void reset(){
		for(int i=0;i<buttons.length;i++){
			for(int j=0;j<buttons.length;j++){
				buttons[i][j].setBackground(Color.BLACK);
			}
		}
		buttons[(int)(Math.random()*5)][(int)(Math.random()*5)].setBackground(Color.GREEN);
		Main_Controller.counterV = 0;
		counter.setText(Main_Controller.counterV + ". Zug");
	}
}