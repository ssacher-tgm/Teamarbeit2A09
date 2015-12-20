package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import view.GUI_View;

/**
 * Hier sind die ActionListener und die Main
 * @author Sebastian Sacher
 *
 */
public class Main_Controller implements ActionListener {

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		GUI_View v = new GUI_View();
	}

	int a;
	int b;
	boolean c = true;
	public static int counterV = 0;
	public static JButton[][] buttons = GUI_View.buttons;
	public static int gC = 1;

	/**
	 * Hier werden die Buttons behandelt und bei Erfold eine Nachricht ausgegeben(JOptionPane)
	 * @author Sebastian Sacher
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i=0;i<buttons.length;i++){
			for(int j=0;j<buttons.length;j++){
				if(e.getSource().equals(GUI_View.buttons[i][j])){
					GUI_View.setColor(i,j,gC);
					counterV++;
					GUI_View.counter.setText(counterV + ". Zug");
					//System.out.println(gC);
					if(gC==0){
						JOptionPane.showMessageDialog(null, "Glückwunsch! \n Sie haben Lights Out mit " + counterV + " Zügen geschafft!");
						GUI_View.reset();
						break;
					}
				}
			}
		}
		if(e.getSource().equals(GUI_View.newGame)){
			GUI_View.reset();
		}
	}
}