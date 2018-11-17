package model;

import java.util.Observable;

public class Log extends Observable{
	//private ArrayList<String> logs;
	private StringBuffer logs;
	
	private static Log instance = new Log();
	private Log() {
		//logs = new ArrayList<String>();
		logs = new StringBuffer();
	}
	public static Log getInstance() {
		return instance;
	}
	//public ArrayList<String> getLogs() {
	public String getLogs() {
		return logs.toString();
	}
	public void addLog(String s) {
		//this.logs.add(s);
		logs.append("\n");
		logs.append(s);
		setChanged();
		notifyObservers();
	}
	
}
