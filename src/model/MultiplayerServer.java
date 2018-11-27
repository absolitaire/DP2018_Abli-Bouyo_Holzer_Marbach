package model;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Observable;
import java.util.Observer;

import javax.naming.NamingException;

public class MultiplayerServer extends UnicastRemoteObject implements Observer, MultiplayerServerInterface{

	private Game game;

	public MultiplayerServer
	(Game g) 
			throws RemoteException,NamingException, AlreadyBoundException {
		this.game = g;
		
		System.out.println("binding server impl to registry");
		Registry registry = LocateRegistry.getRegistry();
		
		
		
		registry.rebind("multiplayer_server", this);
		System.out.println("waiting for invocations");
		
	}
	@Override
	public void update(Observable arg0, Object arg1) {
		

	}
	public Game getGame() {
		return game;
	}
	
	
}
