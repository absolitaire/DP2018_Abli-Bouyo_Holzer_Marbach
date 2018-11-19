package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import model.Game;
import view.Window;

public class OpponentController implements MouseListener{

	private Game g;


	public OpponentController(Game g) {
		this.g= g;
	}

	@Override
	public void mouseReleased(MouseEvent e) {}
	@Override
	public void mousePressed(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseClicked(MouseEvent e) {
		if(g.getJoueurEnCours() == 1) {
			int a = e.getX(), o = e.getY();
			if(a >= 0){
				if(a <= Window.TAILLE_CASES*10){
					if(o >= 0){
						if(o <= Window.TAILLE_CASES*10){

							int i = a / Window.TAILLE_CASES;
							int j = o / Window.TAILLE_CASES;

							//System.out.println(i+"  "+j);
							//g.tirer(0, i, j);
							g.shoot((g.getJoueurEnCours() == 0 ? 1 : 0), i, j);

						}
					}	
				}
			}
		}
	}
}
