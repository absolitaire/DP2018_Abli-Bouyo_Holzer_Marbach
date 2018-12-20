package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;

import model.Game;
import model.Log;
import model.MultiplayerClient;
import model.MultiplayerServer;



public class Menu extends JMenuBar{

	private static final long serialVersionUID = 1L;

	private Window w;

	public Menu(final Window w) {

		JMenu jmenu= new JMenu("Nouvelle Partie solo");
		this.add(jmenu);

		JMenuItem jmi;
		JMenuItem jmibis;

		jmi = new JMenu("Contre IA avec placement automatique");
		jmenu.add(jmi);
		jmibis = new JMenuItem("XXeme siecle");
		jmi.add(jmibis);
		jmibis.addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						//System.out.println(e.getActionCommand());
						Log.getInstance().clear();
						w.newGame(new Game(0, true, false));
					}
				}
				);
		jmibis = new JMenuItem("XXXeme siecle");
		jmi.add(jmibis);
		jmibis.addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						//System.out.println(e.getActionCommand());
						Log.getInstance().clear();
						w.newGame(new Game(1, true, false));
					}
				}
				);
		
		jmi = new JMenu("Contre IA avec placement manuel");
		jmenu.add(jmi);
		jmibis = new JMenuItem("XXeme siecle");
		jmi.add(jmibis);
		jmibis.addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						//g.setGameIsRunning(false);
						Log.getInstance().clear();
						w.newGame(new Game(0, false, false));
					}
				}
				);
		jmibis = new JMenuItem("XXXeme siecle");
		jmi.add(jmibis);
		jmibis.addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						//g.setGameIsRunning(false);
						Log.getInstance().clear();
						w.newGame(new Game(1, false, false));
					}
				}
				);
		
		jmenu= new JMenu("Nouvelle partie multi");
		this.add(jmenu);
		
		jmi = new JMenu("Heberger une partie multijoueur (Serveur)");
		jmenu.add(jmi);
		jmibis = new JMenuItem("XXeme siecle (placement automatique)");
		jmi.add(jmibis);
		jmibis.addActionListener(
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
		

		jmibis = new JMenuItem("XXeme siecle (placement manuel)");
		jmi.add(jmibis);
		jmibis.addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						try {
							Log.getInstance().clear();
							w.newGame(new Game(0, false, true));
							new MultiplayerServer(w);
						}catch(Exception exc) {
							exc.printStackTrace();
						}
					}
				}
				);
		jmibis = new JMenuItem("XXXeme siecle (placement automatique)");
		jmi.add(jmibis);
		jmibis.addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						try {
							Log.getInstance().clear();
							w.newGame(new Game(1, true, true));
							new MultiplayerServer(w);
						}catch(Exception exc) {
							exc.printStackTrace();
						}
					}
				}
				);
		jmibis = new JMenuItem("XXXeme siecle (placement manuel)");
		jmi.add(jmibis);
		jmibis.addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						try {
							Log.getInstance().clear();
							w.newGame(new Game(1, false, true));
							new MultiplayerServer(w);
						}catch(Exception exc) {
							exc.printStackTrace();
						}
					}
				}
				);
		
		
		
		jmi = new JMenuItem("Rejoindre une partie multijoueur (Client local)");
		jmenu.add(jmi);
		jmi.addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						try {
							Log.getInstance().clear();
							MultiplayerClient mc = new MultiplayerClient(w, null);
							mc.getSrv().setClient(mc);
							
							
							
						}catch(Exception exc) {
							exc.printStackTrace();
						}
					}
				}
				);
		jmi = new JMenuItem("Rejoindre une partie multijoueur (Client non local)");
		jmenu.add(jmi);
		jmi.addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						
						try {
							String ip = JOptionPane.showInputDialog(this,"Adresse IP");
							Log.getInstance().clear();
							MultiplayerClient mc = new MultiplayerClient(w, ip);
							mc.getSrv().setClient(mc);
							
							
							
						}catch(Exception exc) {
							exc.printStackTrace();
						}
					}
				}
				);

	}


}
