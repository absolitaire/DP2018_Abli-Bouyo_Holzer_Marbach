package model;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MultiplayerServerInterface extends Remote{

	
	public Game getGame() throws RemoteException ;
	public void logToServer(String s) throws RemoteException;
	public void setClient(MultiplayerClientInterface cl) throws RemoteException ;
	public void updateServer() throws RemoteException;
}
