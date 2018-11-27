package model;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MultiplayerClientInterface extends Remote{

	
	public void update() throws RemoteException;
	
}
