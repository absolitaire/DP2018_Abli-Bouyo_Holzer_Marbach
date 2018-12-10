package model;

import java.util.ArrayList;

public class Boat30thFactory implements BoatFactory {
	
	@Override
	public ArrayList<Boat> creerBateaux() {
		ArrayList<Boat> a = new ArrayList<Boat>();
		int[] images = {0,0,2,3,0,0};
		int[] images2 = {0,0,2,0,4,5};
		int[] imagesSM = {10,0,12,0,8,9};
		int[] imagesCR = {13,0,15,0,0,18};
		a.add(new Boat20th("Porte-Avions", 1, 5, images));
		a.add(new Boat20th("Croiseur", 1, 4, imagesCR));
		a.add(new Boat20th("Contre-Torpilleur", 1, 3, images2));
		a.add(new Boat20th("Sous-Marin", 1, 3, imagesSM));
		a.add(new Boat20th("Torpilleur", 1, 2, images2));
		return a;
	}
	
	/*
	public int[] obtenirImages() {
		int[] images = {0,1,2,3,4,5};
		return images;
	}
	*/
}
