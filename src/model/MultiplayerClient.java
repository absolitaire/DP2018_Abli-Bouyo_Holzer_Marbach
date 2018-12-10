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

public class MultiplayerClient extends UnicastRemoteObject implements MultiplayerClientInterface, Observer{
	private MultiplayerServerInterface srv;
	private Window w;
	private boolean ignoreNextLog;

	public MultiplayerClient (Window w, String ip) throws  NamingException, RemoteException, NotBoundException{
		//Registry registry = LocateRegistry.getRegistry();
		System.out.println(ip);
		if(ip==null) {
			ip = "192.168.0.1";
			try{
				final DatagramSocket socket = new DatagramSocket();
				socket.connect(InetAddress.getByName("8.8.8.8"), 10002);
				ip = socket.getLocalAddress().getHostAddress();
			}catch(Exception exc) {
				exc.printStackTrace();
			}
		}
		System.out.println("rmi://"+ip+"/multiplayer_server");
		try {
			srv = (MultiplayerServerInterface)
			Naming.lookup("rmi://"+ip+"/multiplayer_server");
		} catch (MalformedURLException e1) {
			System.out.println("vomerlépédé");
			e1.printStackTrace();
		}
		System.out.println("nttlfglfl");

		Registry registry = LocateRegistry.getRegistry(ip, 8080, null);

		ignoreNextLog = false;

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
		srv.logToServer("Un joueur s'est connecte!");
		w.newGamePlayersSwapped(srv.getGame());

		//UnicastRemoteObject.exportObject(this, 8080);
		this.w = w;
		w.getGame().addObserver(this);
		Log.getInstance().addObserver(this);
	}

	@Override
	public void updateClient() throws RemoteException {
		//System.out.println("charge");

		w.getGame().deleteObservers();
		w.newGamePlayersSwapped(srv.getGame());
		w.getGame().addObserver(this);
	}

	public Game getGame() {
		return w.getGame();
	}

	public void bindToServer() {
		System.out.println("bondage");
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
		ignoreNextLog = true;
		Log.getInstance().addLog(s, false);
	}

	@Override
	public void update(Observable o, Object arg) {
		if(srv!=null) {
			try{
				if(o instanceof Log) {
					if(!Log.getInstance().getLastLogIsLocal()) {
						//System.out.println("ignored cl");
						//ignoreNextLog = false;
					}else {
						//System.out.println("ayy");
						srv.logToServer(Log.getInstance().getLastLogAdded());
					}
				}else {
					System.out.println("update server");
					srv.updateServer();
				}

			}catch(Exception e) {
				e.printStackTrace();
			}
		}


	}

}
