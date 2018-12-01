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

public class MultiplayerServer extends UnicastRemoteObject implements Observer, MultiplayerServerInterface{

	//private Game game;
	private MultiplayerClientInterface cl;
	private Window w;
	private boolean ignoreNextLog;

	public MultiplayerServer
	(/*Game g*/ Window w) 
			throws RemoteException,NamingException, AlreadyBoundException {
		//this.game = g;
		this.w = w;	
		ignoreNextLog = false;

		System.out.println("binding server impl to registry");
		//Registry registry = LocateRegistry.getRegistry();

		//LocateRegistry.
		Registry registry = LocateRegistry.createRegistry(8080);

		String ip = "";
		try{
			final DatagramSocket socket = new DatagramSocket();
			socket.connect(InetAddress.getByName("8.8.8.8"), 10002);
			ip = socket.getLocalAddress().getHostAddress();
		}catch(Exception exc) {
			exc.printStackTrace();
		}
		System.out.println(ip);

		registry.rebind("multiplayer_server", this);
		System.out.println("waiting for invocations");

		w.getGame().addObserver(this);
		Log.getInstance().addObserver(this);

	}
	@Override
	public void update(Observable o, Object arg) {

		if(cl!=null) {
			try{
				if(o instanceof Log) {
					if(!Log.getInstance().getLastLogIsLocal()) {
						System.out.println("ignored srv");
						ignoreNextLog = false;
					}else {
						cl.logToClient(Log.getInstance().getLastLogAdded());
					}

				}else {
					System.out.println("pdate");
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
		ignoreNextLog = true;
		Log.getInstance().addLog(s, false);


	}

	public void setClient(MultiplayerClientInterface cl) {
		System.out.println("link fait");
		this.cl = cl;
	}

	@Override
	public void updateServer() throws RemoteException {
		//System.out.println("charge");
		w.getGame().deleteObservers();
		w.newGamePlayersSwapped(cl.getGame());
		w.getGame().addObserver(this);

	}
}
