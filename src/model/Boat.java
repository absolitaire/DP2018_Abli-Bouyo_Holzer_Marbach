package model;

import java.util.HashMap;

public class Boat {
	private HashMap<Square, Integer> ptsVie;
	private int taille, pvParCase;
	private String nom;
	private boolean coule;
	private int idImage;

	public Boat(String n, int idImage, int pvParCase, int t) {
		nom = n;
		this.idImage = idImage;
		ptsVie = new HashMap<Square, Integer>();
		coule = false;
		taille = t;
		this.pvParCase = pvParCase;

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

	public int getIdImage() {
		return idImage;
	}

	public void toucher(Square sq){
		if(!coule){
			if(ptsVie.containsKey(sq)){
				Integer pv = ptsVie.get(sq);
				if(pv > 0){
					pv--;
					ptsVie.put(sq, pv);
					System.out.println("Touché "+sq.getPosX()+","+sq.getPosY());
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
							System.out.println("Coulé "+sq.getPosX()+","+sq.getPosY());
						}

					}
				}

			}
		}

	}
}
