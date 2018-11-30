package model;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MultiplayerServerInterface extends Remote{

	
	//public void update(Observable arg0, Object arg1);
	public Game getGame() throws RemoteException ;
	public void msgToLog(String s) throws RemoteException ;
	public void setClient(MultiplayerClientInterface cl) throws RemoteException ;
	public void updateServer() throws RemoteException;
}