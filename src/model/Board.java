package model;

import java.util.ArrayList;
import java.util.List;

public class Board {

	public static final int TAILLE = 10;

	private Player joueur;
	private List<Boat> bateaux;
	private Square[][] squares;

	public Board(BoatFactory b){
		//this.joueur = joueur;
		bateaux = new ArrayList<Boat>();
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
				bateaux.add(boat);
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
			/*int taille, x, y, xOrig, yOrig;
			boolean place, echec, direction;
			for(Boat boat : list){
				bateaux.add(boat);
				place = false;

				while(!place) {
					taille = boat.getTaille();
					xOrig = (int) (Math.random()*(TAILLE - 2));
					yOrig = (int) (Math.random()*(TAILLE - 2));////////SSSSSSSSSSSSSSSSSSSSSSSDDDDDDDDDDDDDDDEGFZEGGEGREGetheiher
					x = xOrig;
					y = yOrig;
					direction = Math.random() < 0.5;
					echec = false;

					while(taille > 0 && !echec){
						if(x<TAILLE && y<TAILLE) {
							if(squares[x][y].getBoat()== null) {
								if(direction) {
									x++;
								}else {
									y++;
								}
								taille--;
								break;
							}
						}
						echec = true;System.out.println("echc");
					}
					if(!echec) {
						taille = boat.getTaille();
						x = xOrig;
						y = yOrig;
						while(taille > 0){
							System.out.println(x+"  "+y);
							squares[x][y].setBoat(boat);
							boat.setSquare(squares[x][y]);
							if(direction) {
								x++;
							}else {
								y++;
							}
							taille--;
						}
					}

				}


			}*/
		}
	}

	public Square[][] getSquares() {
		return squares;
	}

	public void setJoueur(Player joueur) {
		this.joueur = joueur;
	}

	public List<Boat> getBateaux() {
		return bateaux;
	}


}
