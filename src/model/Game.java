package model;

import java.util.Observable;

public class Game extends Observable{
	private Player[] joueurs;
	private Board[] boards;
	private int joueurEnCours;

	public Game(int choixEpoque){
		joueurs = new Player[2];
		boards = new Board[2];
		joueurs[0] = new Player(0, new IARandom());
		boards[0] = new Board(new Boat20thFactory(), joueurs[0]);
		joueurs[1] = new Player(1, new Human());
		boards[1] = new Board(new Boat20thFactory(), joueurs[1]);
		joueurEnCours = 0;
		
		
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
		boards[0].getSquares()[a][o].tirer();
		setChanged();
		notifyObservers();
	}
	
}
