package view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

import controller.OpponentController;
import model.Game;
import model.ImageFactory;

public class Window extends JFrame {

	public static int TAILLE_CASES = 30;
	
	public Window(Game g){
		super("Bataille Navale");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
		
		ImageFactory imgfac = new ImageFactory();
		
		
		OpponentView op = new OpponentView(g.getBoard(0), imgfac);
		op.setPreferredSize(new  Dimension (500,500));
		this.add(op, BorderLayout.EAST);
		op.addMouseListener(new OpponentController(g));
		g.addObserver(op);
		
		AlliedView al = new AlliedView(g.getBoard(1),imgfac);
		al.setPreferredSize(new  Dimension (500,500));
		this.add(al, BorderLayout.WEST);
		g.addObserver(al);
		
		/*OpponentView op2 = new OpponentView(g.getBoard(1));
		op2.setPreferredSize(new  Dimension (500,500));
		this.add(op2, BorderLayout.WEST);
		op2.addMouseListener(new OpponentController(g));
		g.addObserver(op2);*/
		
		
		this.setPreferredSize(new  Dimension (1100,500));
		this.pack ();
		this.setVisible(true);
		
		this.requestFocus();
	}
}
