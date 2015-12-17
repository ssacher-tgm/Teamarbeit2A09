package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import view.GUI_View;

public class Main_Controller implements ActionListener {

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		GUI_View v = new GUI_View();
	}

	int a;
	int b;
	boolean c = true;
	public int counterV = 0;
	public static JButton[][] buttons = GUI_View.buttons;

	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i=0;i<buttons.length;i++){
			for(int j=0;j<buttons.length;j++){
				if(e.getSource().equals(buttons[i][j])){
					if(buttons[i][j].getBackground()==Color.BLACK){
						buttons[i][j].setBackground(Color.GREEN);
					} else buttons[i][j].setBackground(Color.BLACK);
					
					if(i<5/**ränder und ecken**/){
						if(buttons[i][j].getBackground()==Color.BLACK){
							buttons[i][j].setBackground(Color.GREEN);
						} else buttons[i][j].setBackground(Color.BLACK);
					}
					
					if(buttons[i-1][j].getBackground()==Color.BLACK){
						buttons[i-1][j].setBackground(Color.GREEN);
					} else buttons[i-1][j].setBackground(Color.BLACK);
					
					if(buttons[i][j+1].getBackground()==Color.BLACK){
						buttons[i][j+1].setBackground(Color.GREEN);
					} else buttons[i][j+1].setBackground(Color.BLACK);
					
					if(buttons[i][j-1].getBackground()==Color.BLACK){
						buttons[i][j-1].setBackground(Color.GREEN);
					} else buttons[i][j-1].setBackground(Color.BLACK);
				}
			}
		}
		if(e.getSource().equals(GUI_View.newGame)){
			for(int i=0;i<buttons.length;i++){
				for(int j=0;j<buttons.length;j++){
					buttons[i][j].setBackground(Color.BLACK);
				}
			}
		}
	}
}