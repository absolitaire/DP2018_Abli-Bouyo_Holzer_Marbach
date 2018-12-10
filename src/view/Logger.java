package view;

import java.io.UnsupportedEncodingException;
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
		String s3 = null;
		try {
			s3 = new String(Log.getInstance().getLogs().getBytes("UTF-8"),"windows-1252" );
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.setText(s3);
		jsc.revalidate();
	}
}
