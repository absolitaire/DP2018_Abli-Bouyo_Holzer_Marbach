package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

import model.Game;
import model.Log;



public class Menu extends JMenuBar{

	private static final long serialVersionUID = 1L;

	/*private Window w;
	private Game g;*/

	public Menu(final Window w/*, Game g*/) {
		/*this.w = w;
		this.g)*/

		JMenu jm1= new JMenu("Nouvelle Partie");
		this.add(jm1);
		//new JSeparator("dd");
		JMenuItem jmi;
		//jmi = 
		jmi = new JMenuItem("Contre IA avec placement automatique");
		jm1.add(jmi);
		jmi.addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						//g.setGameIsRunning(false);
						System.out.println(e.getActionCommand());
						Log.getInstance().clear();
						w.newGame(new Game(0, true));
					}
				}
				);
		jmi = new JMenuItem("Contre IA avec placement manuel");
		jm1.add(jmi);
		jmi.addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						//g.setGameIsRunning(false);
						Log.getInstance().clear();
						w.newGame(new Game(0, false));
					}
				}
				);

	}


}
