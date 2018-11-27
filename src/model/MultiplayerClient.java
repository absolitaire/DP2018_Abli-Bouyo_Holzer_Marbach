package model;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import javax.naming.NamingException;

import view.Window;

public class MultiplayerClient implements MultiplayerClientInterface {
	private MultiplayerServerInterface srv;
	private Window w;
	
	public MultiplayerClient (Window w) throws  NamingException, RemoteException, NotBoundException{
		Registry registry = LocateRegistry.getRegistry();

		System.out.println("Rmi regisrty bindings");

		String[] e = registry.list();

		for(int i = 0; i < e.length; i++) {
			System.out.println(e[i]);
		}
		
		String remoteObjectName = "multiplayer_server";
		System.out.println(registry.lookup(remoteObjectName).getClass());
		srv = (MultiplayerServerInterface)
				registry.lookup(remoteObjectName);
		
		System.out.println(srv.getGame().getGameIsRunning());
		srv.msgToLog("ayylmao");
		w.newGame(srv.getGame());
		
		
	}
	
	@Override
	public void update() throws RemoteException {
		
		w.newGame(srv.getGame());
		
	}
	
	public void bindToServer() {
		System.out.println("bondage");
	}
}
