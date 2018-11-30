package model;

import java.util.Observable;

public class Log extends Observable{
	//private ArrayList<String> logs;
	private StringBuffer logs;
	private String temporaryMessage;
	private String lastLogAdded;
	private boolean lastLogIsLocal;
	
	private static Log instance = new Log();
	private Log() {
		//logs = new ArrayList<String>();
		logs = new StringBuffer();
		temporaryMessage = "";
		lastLogAdded = "";
		lastLogIsLocal = true;
	}
	public static Log getInstance() {
		return instance;
	}
	//public ArrayList<String> getLogs() {
	public String getLogs() {
		return logs.toString();
	}
	public void addLog(String s, boolean local) {
		//this.logs.add(s);
		System.out.println(s);
		lastLogAdded = s;
		logs.append("\n");
		logs.append(s);
		lastLogIsLocal = local;
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
