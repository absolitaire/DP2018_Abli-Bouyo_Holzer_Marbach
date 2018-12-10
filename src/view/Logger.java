package view;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.text.DefaultCaret;

import model.Log;

public class Logger extends JTextArea implements Observer{
	
	private JScrollPane jsc;

	private static final long serialVersionUID = 1L;

	public Logger() {
		Log.getInstance().addObserver(this);
		setEditable(false);
		DefaultCaret caret = (DefaultCaret) this.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		
	}
	
	
	
	public void setJsc(JScrollPane jsc) {
		this.jsc = jsc;
	}



	@Override
	public void update(Observable o, Object arg) {
		this.setText(Log.getInstance().getLogs());
		jsc.revalidate();
	}
}
