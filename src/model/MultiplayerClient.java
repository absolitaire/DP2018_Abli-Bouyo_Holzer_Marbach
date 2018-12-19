package model;

import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Observable;
import java.util.Observer;

import javax.naming.NamingException;

import view.Window;

@SuppressWarnings("serial")
public class MultiplayerClient extends UnicastRemoteObject implements MultiplayerClientInterface, Observer{
	private MultiplayerServerInterface srv;
	private Window w;

	public MultiplayerClient (Window w, String ip) throws  NamingException, RemoteException, NotBoundException{

		//System.out.println(ip);
		if(ip==null) {
			ip = "192.168.0.1";
			//technique qui permet d'obtenir l'adresse IP de la carte reseau active
			try{
				final DatagramSocket socket = new DatagramSocket();
				socket.connect(InetAddress.getByName("8.8.8.8"), 10002);
				ip = socket.getLocalAddress().getHostAddress();
			}catch(Exception exc) {
				exc.printStackTrace();
			}
		}

		try {
			srv = (MultiplayerServerInterface) Naming.lookup("rmi://"+ip+":8080/multiplayer_server");

			srv.logToServer("Un joueur s'est connecte !");
			Log.getInstance().addLog("Connexion reussie !", false);
			w.newGamePlayersSwapped(srv.getGame());

			this.w = w;
			w.getGame().addObserver(this);
			Log.getInstance().addObserver(this);
			
		} catch (Exception e) {
			e.printStackTrace();
			Log.getInstance().addLog("Echec de la connexion", false);
		}


	}

	@Override
	public void updateClient() throws RemoteException {

		w.getGame().deleteObservers();
		w.newGamePlayersSwapped(srv.getGame());
		w.getGame().addObserver(this);
	}

	public Game getGame() {
		return w.getGame();
	}

	public void bindToServer() {
		try {
			srv.setClient(this);
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

	public MultiplayerServerInterface getSrv() {
		return srv;
	}

	public void logToClient(String s) {
		Log.getInstance().addLog(s, false);
	}

	@Override
	public void update(Observable o, Object arg) {
		if(srv!=null) {
			try{
				if(o instanceof Log) {
					if(Log.getInstance().getLastLogIsLocal()) {
						// Le changement vient de la classe Log
						srv.logToServer(Log.getInstance().getLastLogAdded());
					}
				}else {
					// Le changement vient de la classe Game
					srv.updateServer();
				}

			}catch(Exception e) {
				e.printStackTrace();
			}
		}


	}

}
