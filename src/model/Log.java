package model;

import java.util.Observable;

public class Log extends Observable{

	private StringBuffer logs;
	private String temporaryMessage;
	private String lastLogAdded;
	private boolean lastLogIsLocal;

	private static Log instance = new Log();
	
	private Log() {
		logs = new StringBuffer();
		temporaryMessage = "";
		lastLogAdded = "";
		lastLogIsLocal = true;
	}
	public static Log getInstance() {
		return instance;
	}
	
	public String getLogs() {
		return logs.toString();
	}
	public void addLog(String s, boolean isLocal) {
		//System.out.println(s);
		lastLogAdded = s;
		logs.append("\n");
		logs.append(s);
		lastLogIsLocal = isLocal;
		setChanged();
		notifyObservers();
	}

	public void clear(){
		logs = new StringBuffer();
		temporaryMessage = "";
		lastLogAdded = "";
		setChanged();
		notifyObservers();
	}

	public String getTemporaryMessage() {
		return temporaryMessage;
	}
	public void setTemporaryMessage(String temporaryMessage) {
		this.temporaryMessage = temporaryMessage;
	}
	public String getLastLogAdded() {
		return lastLogAdded;
	}
	public boolean getLastLogIsLocal() {
		return lastLogIsLocal;
	}


}
