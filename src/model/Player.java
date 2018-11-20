package model;

public class Player {

	private int id;
	private int nbTirsReussis;
	private int nbTirsRates;
	private Strategy strategy;
	
	public Player(int id, Strategy s){
		this. id = id;
		this.nbTirsRates = 0;
		this.nbTirsReussis = 0;
		this.strategy = s;
	}
	
	public void tirer(){
		strategy.tirer();
	}
	
}
