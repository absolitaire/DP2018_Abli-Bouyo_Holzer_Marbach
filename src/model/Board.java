package model;

import java.util.ArrayList;
import java.util.List;

public class Board {
	
	public static final int TAILLE = 10;

	private Player joueur;
	private List<Boat> bateaux;
	private Square[][] squares;
	
	public Board(BoatFactory b, Player joueur){
		this.joueur = joueur;
		squares = new Square[TAILLE][TAILLE];
		for(int i = 0; i < TAILLE; i++){
			for(int j = 0; j < TAILLE; j++){
				squares[i][j] = new Square(i,j);
			}
		}
		if(b != null){
			//System.out.println("lé bato");
			ArrayList<Boat> list = b.creerBateaux();
			//TODO changer ici
			int taille, x, y, codageNickelTKT = 0;
			for(Boat boat : list){
				codageNickelTKT ++;
				taille = boat.getTaille();
				x =(int) (Math.random()*(TAILLE - 1 - taille));
				y = codageNickelTKT;
				while(taille > 0){
					squares[x][y].setBoat(boat);
					boat.setSquare(squares[x][y]);
					x++;
					taille--;
				}
			}
		}
	}

	public Square[][] getSquares() {
		return squares;
	}
	
	
}
