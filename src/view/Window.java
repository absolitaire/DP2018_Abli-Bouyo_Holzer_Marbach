package view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import controller.AlliedController;
import controller.OpponentController;
import model.Board;
import model.Game;
import model.ImageLoader;
import model.Log;

public class Window extends JFrame {
	
	private static final long serialVersionUID = 1L;

	public static int TAILLE_CASES = 30;
	private OpponentView op;
	private AlliedView al;
	private OpponentController oc;
	private AlliedController ac;
	private Game game;
	
	
	
	public Window(Game g){
		super("Bataille Navale");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
		this.setResizable(false);
		this.requestFocus();
		
		this.game = g;
		
		ImageLoader imgfac = new ImageLoader();
		
		Menu m = new Menu(this);
		this.add(m, BorderLayout.NORTH);
		
		op = new OpponentView(g.getBoard(0), imgfac);
		op.setPreferredSize(new  Dimension (Board.BOARD_SIZE*TAILLE_CASES+1,Board.BOARD_SIZE*TAILLE_CASES+1));
		this.add(op, BorderLayout.EAST);
		oc = new OpponentController(g);
		op.addMouseListener(oc);
		g.addObserver(op);
		
		al = new AlliedView(g.getBoard(1),imgfac);
		al.setPreferredSize(new  Dimension (Board.BOARD_SIZE*TAILLE_CASES+1,Board.BOARD_SIZE*TAILLE_CASES+1));
		this.add(al, BorderLayout.WEST);
		ac = new AlliedController(g, al);
		al.addMouseListener(ac);
		al.addMouseMotionListener(ac);
		this.addKeyListener(ac);
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
		
		
		this.setPreferredSize(new  Dimension (2*Board.BOARD_SIZE*TAILLE_CASES + 402,Board.BOARD_SIZE*TAILLE_CASES+53));
		this.pack ();
		this.setVisible(true);
		
		this.requestFocus();
	}
	
	public void newGame(Game g){
		this.game = g;
		
		op.setBoard(g.getBoard(0));
		op.removeMouseListener(oc);
		oc = new OpponentController(g);
		op.addMouseListener(oc);
		op.repaint();
		g.addObserver(op);
		
		
		al.setBoard(g.getBoard(1));
		al.removeMouseListener(ac);
		al.removeMouseMotionListener(ac);
		this.removeKeyListener(ac);
		ac = new AlliedController(g, al);
		al.addMouseListener(ac);
		al.addMouseMotionListener(ac);
		this.addKeyListener(ac);
		g.addObserver(al);
		
		repaint();
	}
	
	public void newGamePlayersSwapped(Game g) {
		g.swapPlayers();
		newGame(g);
	}

	public Game getGame() {
		return game;
	}
	
	
}
