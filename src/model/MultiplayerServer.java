package model;

import java.net.DatagramSocket;
import java.net.InetAddress;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Observable;
import java.util.Observer;

import javax.naming.NamingException;

import view.Window;

@SuppressWarnings("serial")
public class MultiplayerServer extends UnicastRemoteObject implements Observer, MultiplayerServerInterface{

	private MultiplayerClientInterface cl;
	private Window w;

	public MultiplayerServer(Window w) throws RemoteException,NamingException, AlreadyBoundException {
		this.w = w;	

		String ip = "";
		try{
			Registry registry = LocateRegistry.createRegistry(8080);
			
			//technique qui permet d'obtenir l'adresse IP de la carte reseau active
			final DatagramSocket socket = new DatagramSocket();
			socket.connect(InetAddress.getByName("8.8.8.8"), 10002);
			ip = socket.getLocalAddress().getHostAddress();

			registry.rebind("multiplayer_server", this);

			//System.out.println(ip);	

			Log.getInstance().addLog("Hebergement d'une partie - en attente d'une connexion", false);
			Log.getInstance().addLog("Votre adresse IP est "+ip, false);

			w.getGame().addObserver(this);
			Log.getInstance().addObserver(this);
		}catch(Exception exc) {
			exc.printStackTrace();

			Log.getInstance().addLog("Echec de l'hebergement de partie", false);
		}

	}
	
	@Override
	public void update(Observable o, Object arg) {

		if(cl!=null) {
			try{
				if(o instanceof Log) {
					// Le changement vient de la classe Log
					if(Log.getInstance().getLastLogIsLocal()) {
						cl.logToClient(Log.getInstance().getLastLogAdded());
					}

				}else {
					// Le changement vient de la classe Game
					cl.updateClient();
				}


			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public Game getGame() {
		return w.getGame();
	}

	public void logToServer(String s) {
		Log.getInstance().addLog(s, false);


	}

	public void setClient(MultiplayerClientInterface cl) {
		
		this.cl = cl;
	}

	@Override
	public void updateServer() throws RemoteException {
		w.getGame().deleteObservers();
		w.newGamePlayersSwapped(cl.getGame());
		w.getGame().addObserver(this);

	}
}
