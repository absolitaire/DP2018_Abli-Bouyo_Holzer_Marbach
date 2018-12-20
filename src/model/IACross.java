package model;

import java.util.ArrayList;
import java.util.Stack;

@SuppressWarnings("serial")
public class IACross implements Strategy {
	private Game g;
	private Board b;
	private int idOpponent;
	private Square focus;
	private Stack<Square> nextTargets;
	private boolean changementQuadrillage;

	public IACross(Game g, int opponent) {
		this.g = g;
		this.b = g.getBoard(opponent);
		this.idOpponent = opponent;
		nextTargets = new Stack<Square>();
		changementQuadrillage = false;
	}
	@Override
	public void shoot() {

		int a, o;
		if(focus != null && !nextTargets.isEmpty()) {
			Square sq = nextTargets.pop();
			a = sq.getPosX();
			o = sq.getPosY();
			g.shoot(idOpponent, a, o );
			if(sq.getBoat()!= null) {
				if(sq.getBoat().hasSunk()) {
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
					if(a<Board.BOARD_SIZE-1) {
						if(!b.getSquares()[a+1][o].isShooted())
							nextTargets.add(b.getSquares()[a+1][o]);
					}
					if(o<Board.BOARD_SIZE-1) {
						if(!b.getSquares()[a][o+1].isShooted())
							nextTargets.add(b.getSquares()[a][o+1]);
					}
					
					ArrayList<Square> priority = new ArrayList<Square>();
					if(sq.getPosX()==focus.getPosX()) {
						for(Square s : nextTargets) {
							if(s.getPosX() == sq.getPosX()) {
								priority.add(s);
							}
						}
					}if(sq.getPosY()==focus.getPosY()) {
						for(Square s : nextTargets) {
							if(s.getPosY() == sq.getPosY()) {
								priority.add(s);
							}
						}
					}
					for(Square s : priority) {
						nextTargets.remove(s);
						nextTargets.push(s);
					}


				}
			}
		}else {
			int tries = 0;
			while(true) {
				tries ++;
				a = 2*(int)(Board.BOARD_SIZE/2*Math.random());
				o = 2*(int)(Board.BOARD_SIZE/2*Math.random());
				if(Math.random()<0.5) {
					if(changementQuadrillage) {
						a++;
					}else {
						a++;
						o++;
					}

				}else {
					if(changementQuadrillage) {
						o++;
					}
				}
				//System.out.println(a+" "+o+b);
				if(!b.getSquares()[a][o].isShooted()) {

					g.shoot(idOpponent, a, o);
					if(b.getSquares()[a][o].getBoat()!= null) {
						if(!b.getSquares()[a][o].getBoat().hasSunk()) {
							focus = b.getSquares()[a][o];
							if(a>0) {
								if(!b.getSquares()[a-1][o].isShooted())
									nextTargets.add(b.getSquares()[a-1][o]);
							}
							if(o>0) {
								if(!b.getSquares()[a][o-1].isShooted())
									nextTargets.add(b.getSquares()[a][o-1]);
							}
							if(a<Board.BOARD_SIZE-1) {
								if(!b.getSquares()[a+1][o].isShooted())
									nextTargets.add(b.getSquares()[a+1][o]);
							}
							if(o<Board.BOARD_SIZE-1) {
								if(!b.getSquares()[a][o+1].isShooted())
									nextTargets.add(b.getSquares()[a][o+1]);
							}

						}
					}
					break;
				}

				if(tries > (Board.BOARD_SIZE * Board.BOARD_SIZE / 2)) {
					changementQuadrillage = !changementQuadrillage;
				}
			}
		}

	}

}
