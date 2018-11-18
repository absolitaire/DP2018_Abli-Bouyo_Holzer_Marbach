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

public class AlliedView extends JPanel implements Observer{
	
	private static final long serialVersionUID = 1L;
	
	private ImageLoader imgfac;
	
	private Board b;

	public AlliedView(Board b, ImageLoader imgfc) {
		this.b = b;
		this.imgfac = imgfc;

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
		Color col = null;
		for(int i = 0; i < tab.length; i++){
			for(int j = 0; j < tab[0].length; j++){
				if(tab[i][j].getBoat() == null){
					if(tab[i][j].isShooted()){
						//g.setColor(Color.BLUE);
						col = Color.BLUE;
					}else{
						//g.setColor(Color.CYAN);
						col = Color.CYAN;
					}

				}else{
					g.drawImage(imgfac.getTableauPng()[tab[i][j].getIdImage()],	i*Window.TAILLE_CASES, j*Window.TAILLE_CASES, null);
					if(tab[i][j].isShooted()){
						if(tab[i][j].getBoat().isCoule()){
							//g.setColor(Color.RED);
							col = new Color(255,0,0,125);
						}else{
							//g.setColor(Color.ORANGE);
							col = new Color(150,150,0,125);
						}
					}else{
						//g.setColor(Color.GRAY);
						col = new Color(0,0,0,0);
					}

				}
				g.setColor(col);
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
