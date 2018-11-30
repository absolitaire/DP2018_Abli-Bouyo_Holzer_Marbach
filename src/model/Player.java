package model;

import java.io.Serializable;

public class Player implements Serializable {

	private int id;
	private int nbTirsReussis;
	private int nbTirsRates;
	private Strategy strategy;
	private String name;
	
	public Player(int id, String name, Strategy s){
		this. id = id;
		this.nbTirsRates = 0;
		this.nbTirsReussis = 0;
		this.strategy = s;
		this.name = name;
	}
	
	public void tirer(){
		strategy.tirer();
	}
	
	public String getName() {
		return name;
	}
}
