package model;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MultiplayerClientInterface extends Remote{


	public void updateClient() throws RemoteException;
	public Game getGame() throws RemoteException ;
	public MultiplayerServerInterface getSrv()  throws RemoteException ;

}
