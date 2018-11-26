package model;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import javax.naming.NamingException;

public class MultiplayerClient {
	public MultiplayerClient () throws  NamingException, RemoteException, NotBoundException{
		Registry registry = LocateRegistry.getRegistry();

		System.out.println("Rmi regisrty bindings");

		String[] e = registry.list();

		for(int i = 0; i < e.length; i++) {
			System.out.println(e[i]);
		}
		
		String remoteObjectName = "multiplayer_server";
		System.out.println(registry.lookup(remoteObjectName).getClass());
		MultiplayerServerInterface srv = (MultiplayerServerInterface)
				registry.lookup(remoteObjectName);
		
		System.out.println(srv.getGame().getGameIsRunning());
	}
}
