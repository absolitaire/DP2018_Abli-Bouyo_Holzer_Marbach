package model;

import view.*;

public class Principale {

	public static void main(String[] args) {
		Game g = new Game(0, true);
		new Window(g);
		//g.boucle();
	}

}
