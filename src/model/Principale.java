package model;

import view.*;

public class Principale {

	public static void main(String[] args) {
		Game g = new Game(0);
		new Window(g);
		g.boucle();
	}

}
