package model;

import java.util.ArrayList;

public class Boat30thFactory implements BoatFactory {
	
	@Override
	public ArrayList<Boat> createBoats() {
		ArrayList<Boat> a = new ArrayList<Boat>();
		int[] images = {26,27,28,23,24,25};
		a.add(new Boat30th("Vaisseau mere", 1, 6, images));
		a.add(new Boat30th("Porte-Vaisseaux", 1, 5, images));
		a.add(new Boat30th("Hydrocroiseur", 1, 4, images));
		a.add(new Boat30th("Contre-Torpilleur gamma", 1, 3, images));
		a.add(new Boat30th("Sous-Marin a plasma", 1, 3, images));
		a.add(new Boat30th("Torpilleur laser", 1, 2, images));
		return a;
	}
	
	/*
	public int[] obtenirImages() {
		int[] images = {0,1,2,3,4,5};
		return images;
	}
	*/
}
