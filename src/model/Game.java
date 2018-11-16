package model;

import java.util.Observable;

public class Game extends Observable{
	private Player[] joueurs;
	private Board[] boards;
	private int joueurEnCours;

	public Game(int choixEpoque){
		joueurs = new Player[2];
		boards = new Board[2];
		boards[1] = new Board(new Boat20thFactory());
		joueurs[1] = new Player(1, new Human());
		boards[1].setJoueur(joueurs[1]);
		boards[0] = new Board(new Boat20thFactory());
		//joueurs[0] = new Player(0, new IARandom(this, 1));
		joueurs[0] = new Player(0, new IACross(this, 1));
		//joueurs[0] = new Player(0, new Human());
		boards[0].setJoueur(joueurs[0]);
		joueurEnCours = 1;
		
		
	}

	public Player getJoueur(int id) {
		return joueurs[id];
	}

	public Board getBoard(int id) {
		return boards[id];
	}

	public int getJoueurEnCours() {
		return joueurEnCours;
	}

	public void setJoueurEnCours(int joueurEnCours) {
		this.joueurEnCours = joueurEnCours;
	}
	
	public void tirer(int joueur, int a, int o){
		System.out.println("Tir en "+a+","+o);
		if(boards[joueur].getSquares()[a][o].tirer() == true) {
			boolean verif = false;
			//System.out.println(boards[joueur].getBateaux());
			for(Boat boat : boards[joueur].getBateaux()) {
				//System.out.println(boat+" "+boat.isCoule());
				if(!boat.isCoule()) {
					verif = true; 
					break;
				}
			}
			//System.out.println("final "+verif);
			if(verif == false) {
				System.out.println("Le joueur "+joueur+" a perdu");
			}
		}else {
			
		}
		joueurEnCours = (joueurEnCours == 0 ? 1 : 0);
		setChanged();
		notifyObservers();
	}
	
	public void boucle() {
		while(true) {
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			joueurs[joueurEnCours].tirer();
		}
	}
}
