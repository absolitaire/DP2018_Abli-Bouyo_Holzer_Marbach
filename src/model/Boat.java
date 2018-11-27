package model;

import java.io.Serializable;
import java.util.HashMap;

public class Boat  implements Serializable{
	private HashMap<Square, Integer> ptsVie;
	private int taille, pvParCase;
	private String nom;
	private boolean coule;
	//0-2 = horizontal    3-5 = vertical
	private int[] images;

	public Boat(String n, int pvParCase, int t, int[] img) {
		nom = n;
		ptsVie = new HashMap<Square, Integer>();
		coule = false;
		taille = t;
		this.pvParCase = pvParCase;
		this.images = img;
	}

	public HashMap<Square, Integer> getPtsVie() {
		return ptsVie;
	}

	public void setSquare(Square sq){
		this.ptsVie.put(sq, pvParCase);
	}
	public int getTaille() {
		return taille;
	}

	public String getNom() {
		return nom;
	}

	public boolean isCoule() {
		return coule;
	}

	public boolean toucher(Square sq){
		if(!coule){
			if(ptsVie.containsKey(sq)){
				Integer pv = ptsVie.get(sq);
				if(pv > 0){
					pv--;
					ptsVie.put(sq, pv);
					//System.out.println("Touch� "+sq.getPosX()+","+sq.getPosY());
					Log.getInstance().addLog("                > Touch� "+sq.getPosX()+","+sq.getPosY());
					if(pv == 0){
						boolean verif = true;
						for(Integer i :ptsVie.values()){
							//System.out.println(i);
							if(i>0){
								verif = false;
								break;
							}
						}
						if(verif){
							coule = verif;
							//System.out.println("Coul� "+sq.getPosX()+","+sq.getPosY());
							Log.getInstance().addLog("                > Coul� "+sq.getPosX()+","+sq.getPosY());
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
