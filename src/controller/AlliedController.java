package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import model.Game;
import view.AlliedView;
import view.Window;

public class AlliedController implements MouseListener, MouseMotionListener, KeyListener{

	private Game g;
	private AlliedView al;
	private boolean previsualisation;
	private boolean horizontal;



	public AlliedController(Game g, AlliedView al) {
		this.g = g;
		horizontal = true;
		previsualisation = false;
		this.al = al;
	}

	@Override
	public void mouseReleased(MouseEvent e) {}
	@Override
	public void mousePressed(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {
		//System.out.println("sortie");
		previsualisation = false;
		al.disablePrv();
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		//System.out.println("entree");
		if(!g.getBoatsAreAllPlaced()){
			previsualisation = true;

			//int taille = g.getBoard(1).sizeOfTheNextBoatToPlace();
			//ArrayList<Integer> list = new ArrayList<Integer>();
			/*	if(horizontal) {
				squares[x][y].setIdImage(images[0]);
			}else {
				squares[x][y].setIdImage(images[3]);
			}
			taille--;
			while(taille > 1){
				//System.out.println(x+"  "+y);
				squares[x][y].setBoat(boat);
				boat.setSquare(squares[x][y]);
				if(horizontal) {
					squares[x][y].setIdImage(images[1]);
				}else {
					squares[x][y].setIdImage(images[4]);
				}
				taille--;
			}
			squares[x][y].setBoat(boat);
			boat.setSquare(squares[x][y]);
			if(horizontal) {
				squares[x][y].setIdImage(images[2]);
			}else {
				squares[x][y].setIdImage(images[5]);
			}
			 */
			al.enablePrv(horizontal);
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		if(!g.getBoatsAreAllPlaced()) {
			if(e.getButton() == MouseEvent.BUTTON1) {
				int a = e.getX(), o = e.getY();
				if(a >= 0){
					if(a <= Window.TAILLE_CASES*10){
						if(o >= 0){
							if(o <= Window.TAILLE_CASES*10){

								int i = a / Window.TAILLE_CASES;
								int j = o / Window.TAILLE_CASES;

								//System.out.println(i+"  "+j);
								//g.tirer(0, i, j);
								g.placeBoat(i, j, horizontal);

							}
						}	
					}
				}
			}else {
				if(e.getButton() == MouseEvent.BUTTON3) {
					horizontal = !horizontal;
					if(previsualisation){
						al.enablePrv(horizontal);
						al.repaint();
					}
				}
			}

		}
	}
	@Override
	public void keyTyped(KeyEvent e) {


	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(!g.getBoatsAreAllPlaced()) {
			horizontal = !horizontal;
			if(previsualisation){
				al.enablePrv(horizontal);
				al.repaint();
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		if(!g.getBoatsAreAllPlaced()){
			int a = e.getX() / Window.TAILLE_CASES;
			int o = e.getY() / Window.TAILLE_CASES;
			int taille = g.getBoard(1).sizeOfTheNextBoatToPlace();
			al.previsualisation(a, o, taille);
		}
		//System.out.println("ayy");
	}
}
