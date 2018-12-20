package model;

import java.io.Serializable;
import java.util.HashMap;

@SuppressWarnings("serial")
public class Boat implements Serializable{
	protected HashMap<Square, Integer> health;
	protected int size, healthbySquare;
	protected String name;
	protected boolean hasSunk;
	//0-2 = horizontal    3-5 = vertical
	private int[] images;

	public Boat(String n, int h, int t, int[] img) {
		name = n;
		health = new HashMap<Square, Integer>();
		hasSunk = false;
		size = t;
		this.healthbySquare = h;
		this.images = img;
	}


	/*
	public HashMap<Square, Integer> getHealth() {
		return health;
	}*/

	public void setSquare(Square sq){
		this.health.put(sq, healthbySquare);
	}
	public int getSize() {
		return size;
	}

	public String getName() {
		return name;
	}

	public boolean hasSunk() {
		return hasSunk;
	}

	public boolean hit(Square sq){
		if(!hasSunk){
			if(health.containsKey(sq)){
				Integer pv = health.get(sq);
				if(pv > 0){
					pv--;
					health.put(sq, pv);

					Log.getInstance().addLog("                > Touche "+sq.getPosX()+","+sq.getPosY(), true);
					if(pv == 0){
						boolean verif = true;
						for(Integer i : health.values()){

							if(i>0){
								verif = false;
								break;
							}
						}
						if(verif){
							hasSunk = verif;

							Log.getInstance().addLog("                > Coule "+sq.getPosX()+","+sq.getPosY(), true);
							return true;
						}

					}
				}

			}
		}
		return false;
	}

	public int[] getImages(){
		return images;
	}
}
