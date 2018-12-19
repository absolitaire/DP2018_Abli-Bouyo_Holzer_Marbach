package view;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import model.Board;
import model.ImageLoader;
import model.Square;

public class OpponentView extends JPanel implements Observer{
	
	private static final long serialVersionUID = 1L;

	private ImageLoader imgfac; 

	private Board b;

	public OpponentView(Board b, ImageLoader imgfac) {
		this.b = b;
		this.imgfac = imgfac;

		
	}
	@Override
	public void update(Observable o, Object arg) {
		repaint();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Square[][] tab = this.b.getSquares();
		Font aine = new Font("Arial", Font.BOLD, 25);
		g.setFont(aine);
		for(int i = 0; i < tab.length; i++){
			for(int j = 0; j < tab[0].length; j++){

				if(tab[i][j].getBoat() == null){
					if(tab[i][j].isShooted()){
						g.setColor(Color.BLUE);
					}else{
						g.setColor(Color.CYAN);
					}

				}else{
					if(tab[i][j].isShooted()){
						if(tab[i][j].getBoat().hasSunk()){
							g.setColor(Color.RED);
						}else{
							g.setColor(Color.ORANGE);
						}
						
						
							
					}else{
						//g.setColor(Color.GRAY);
						g.setColor(Color.CYAN);
					}

				}
				g.fillRect(i*Window.TAILLE_CASES, j*Window.TAILLE_CASES, Window.TAILLE_CASES, Window.TAILLE_CASES);

				g.setColor(Color.BLACK);
				g.drawRect(i*Window.TAILLE_CASES, j*Window.TAILLE_CASES, Window.TAILLE_CASES, Window.TAILLE_CASES);

			}
		}
	}

	public void setBoard(Board b){
		this.b = b;
	}
}
