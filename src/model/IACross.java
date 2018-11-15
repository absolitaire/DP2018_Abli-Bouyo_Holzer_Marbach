package model;

import java.util.Stack;

public class IACross implements Strategy {
	private Game g;
	private Board b;
	private int idOpponent;
	private Square focus;
	private Stack<Square> nextTargets;

	public IACross(Game g, int opponent) {
		this.g = g;
		this.b = g.getBoard(opponent);
		this.idOpponent = opponent;
		nextTargets = new Stack<Square>();
	}
	@Override
	public void tirer() {

		int a, o;
		if(focus != null) {
			Square sq = nextTargets.pop();
			a = sq.getPosX();
			o = sq.getPosY();
			g.tirer(idOpponent, a, o );
			if(sq.getBoat()!= null) {
				if(sq.getBoat().isCoule()) {
					nextTargets.removeAllElements();
					focus = null;
				}else {

					if(a>0) {
						if(!b.getSquares()[a-1][o].isShooted())
							nextTargets.add(b.getSquares()[a-1][o]);
					}
					if(o>0) {
						if(!b.getSquares()[a][o-1].isShooted())
							nextTargets.add(b.getSquares()[a][o-1]);
					}
					if(a<Board.TAILLE) {
						if(!b.getSquares()[a+1][o].isShooted())
							nextTargets.add(b.getSquares()[a+1][o]);
					}
					if(o>Board.TAILLE) {
						if(!b.getSquares()[a][o+1].isShooted())
							nextTargets.add(b.getSquares()[a][o+1]);
					}


					/*ArrayList<Square> rm = new ArrayList<Square>();
					if(sq.getPosX()==focus.getPosX()) {
						for(Square s : nextTargets) {
							if(s.getPosX() != sq.getPosX()) {
								rm.add(s);
							}
						}
					}else {
						for(Square s : nextTargets) {
							if(s.getPosY() != sq.getPosY()) {
								rm.add(s);
							}
						}
					}

					for(Square s : rm) {
						nextTargets.remove(s);
					}*/
				}
			}
		}else {
			while(true) {
				a = 2*(int)(Board.TAILLE/2*Math.random());
				o = 2*(int)(Board.TAILLE/2*Math.random());
				if(Math.random()<0.5) {
					a++;
					o++;
				}
				//System.out.println(a+" "+o+b);
				if(!b.getSquares()[a][o].isShooted()) {

					g.tirer(idOpponent, a, o);
					if(b.getSquares()[a][o].getBoat()!= null) {
						if(!b.getSquares()[a][o].getBoat().isCoule()) {
							focus = b.getSquares()[a][o];
							if(a>0) {
								if(!b.getSquares()[a-1][o].isShooted())
									nextTargets.add(b.getSquares()[a-1][o]);
							}
							if(o>0) {
								if(!b.getSquares()[a][o-1].isShooted())
									nextTargets.add(b.getSquares()[a][o-1]);
							}
							if(a<Board.TAILLE) {
								if(!b.getSquares()[a+1][o].isShooted())
									nextTargets.add(b.getSquares()[a+1][o]);
							}
							if(o>Board.TAILLE) {
								if(!b.getSquares()[a][o+1].isShooted())
									nextTargets.add(b.getSquares()[a][o+1]);
							}

						}
					}
					break;
				}
			}
		}

	}

}
