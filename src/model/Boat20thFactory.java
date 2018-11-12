package model;

import java.util.ArrayList;

public class Boat20thFactory implements BoatFactory {
	@Override
	public ArrayList<Boat> creerBateaux() {
		ArrayList<Boat> a = new ArrayList<Boat>();
		a.add(new Boat("Porte-Avions", 1, 1, 5));
		a.add(new Boat("Croiseur", 1, 1, 4));
		a.add(new Boat("Contre-Torpilleur", 1, 1, 3));
		a.add(new Boat("Sous-Marin", 1, 1, 3));
		a.add(new Boat("Torpilleur", 1, 1, 2));
		return a;
	}
}
