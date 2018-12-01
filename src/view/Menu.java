package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import model.Game;
import model.Log;
import model.MultiplayerClient;
import model.MultiplayerServer;



public class Menu extends JMenuBar{

	private static final long serialVersionUID = 1L;

	private Window w;
	//private Game g;

	public Menu(final Window w/*, Game g*/) {
		/*this.w = w;)*/
		//this.g = g;

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
						w.newGame(new Game(0, true, false));
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
						w.newGame(new Game(0, false, false));
					}
				}
				);
		jmi = new JMenuItem("Héberger une partie multijoueur (Serveur)");
		jm1.add(jmi);
		jmi.addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						try {
							Log.getInstance().clear();
							w.newGame(new Game(0, true, true));
							new MultiplayerServer(w);
						}catch(Exception exc) {
							exc.printStackTrace();
						}
					}
				}
				);
		jmi = new JMenuItem("Rejoindre une partie multijoueur (Client local)");
		jm1.add(jmi);
		jmi.addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						try {
							Log.getInstance().clear();
							MultiplayerClient mc = new MultiplayerClient(w, null);
									//mc.bindToServer();
							mc.getSrv().setClient(mc);
							
							
							
						}catch(Exception exc) {
							exc.printStackTrace();
						}
					}
				}
				);
		jmi = new JMenuItem("Rejoindre une partie multijoueur (Client non local)");
		jm1.add(jmi);
		jmi.addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						
						try {
							String ip = JOptionPane.showInputDialog(this,"Adresse IP");
							Log.getInstance().clear();
							MultiplayerClient mc = new MultiplayerClient(w, ip);
									//mc.bindToServer();
							mc.getSrv().setClient(mc);
							
							
							
						}catch(Exception exc) {
							exc.printStackTrace();
						}
					}
				}
				);
	}


}
