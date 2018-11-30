package model;

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

	public MultiplayerServer
	(/*Game g*/ Window w) 
			throws RemoteException,NamingException, AlreadyBoundException {
		//this.game = g;
		this.w = w;	

		System.out.println("binding server impl to registry");
		Registry registry = LocateRegistry.getRegistry();



		registry.rebind("multiplayer_server", this);
		System.out.println("waiting for invocations");

		w.getGame().addObserver(this);

	}
	@Override
	public void update(Observable arg0, Object arg1) {

		if(cl!=null) {
			try{

				System.out.println("pdate");
				cl.updateClient();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	public Game getGame() {
		return w.getGame();
	}

	public void msgToLog(String s) {
		Log.getInstance().addLog(s);
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
