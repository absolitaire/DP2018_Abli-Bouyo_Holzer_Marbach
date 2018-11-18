package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import model.Game;



public class Menu extends JMenuBar{

	private static final long serialVersionUID = 1L;

	/*private Window w;
	private Game g;*/

	public Menu(Window w, Game g) {
		/*this.w = w;
		this.g)*/

		JMenu jm1= new JMenu("Menu");
		this.add(jm1);
		JMenuItem jmi;
		jmi = new JMenuItem("Nouvelle Partie");
		jm1.add(jmi);
		jmi.addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						g.setGameIsRunning(false);
						w.newGame(new Game(0));
					}
				}
				);


	}


}
