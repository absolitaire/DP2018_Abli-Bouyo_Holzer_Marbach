package model;

import java.util.ArrayList;

public class Boat20thFactory implements BoatFactory {
	
	@Override
	public ArrayList<Boat> creerBateaux() {
		ArrayList<Boat> a = new ArrayList<Boat>();
		int[] images = {0,1,2,3,4,5};
		a.add(new Boat20th("Porte-Avions", 1, 5, images));
		a.add(new Boat20th("Croiseur", 1, 4, images));
		a.add(new Boat20th("Contre-Torpilleur", 1, 3, images));
		a.add(new Boat20th("Sous-Marin", 1, 3, images));
		a.add(new Boat20th("Torpilleur", 1, 2, images));
		return a;
	}
	
	/*
	public int[] obtenirImages() {
		int[] images = {0,1,2,3,4,5};
		return images;
	}
	*/
}
