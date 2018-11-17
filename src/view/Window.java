package view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import controller.OpponentController;
import model.Game;
import model.ImageLoader;

public class Window extends JFrame {
	
	private static final long serialVersionUID = 1L;

	public static int TAILLE_CASES = 30;
	
	public Window(Game g){
		super("Bataille Navale");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
		
		ImageLoader imgfac = new ImageLoader();
		
		
		OpponentView op = new OpponentView(g.getBoard(0), imgfac);
		op.setPreferredSize(new  Dimension (350,350));
		this.add(op, BorderLayout.EAST);
		op.addMouseListener(new OpponentController(g));
		g.addObserver(op);
		
		AlliedView al = new AlliedView(g.getBoard(1),imgfac);
		al.setPreferredSize(new  Dimension (350,350));
		this.add(al, BorderLayout.WEST);
		g.addObserver(al);
		
		Logger lg = new Logger();
		//lg.setPreferredSize(new  Dimension (500,350));
		this.add(lg, BorderLayout.CENTER);
		JScrollPane jsc = new JScrollPane(lg);
		jsc.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		jsc.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		lg.setJsc(jsc);
		this.add(jsc);
		
		/*OpponentView op2 = new OpponentView(g.getBoard(1));
		op2.setPreferredSize(new  Dimension (500,500));
		this.add(op2, BorderLayout.WEST);
		op2.addMouseListener(new OpponentController(g));
		g.addObserver(op2);*/
		
		
		this.setPreferredSize(new  Dimension (1200,350));
		this.pack ();
		this.setVisible(true);
		
		this.requestFocus();
	}
}
