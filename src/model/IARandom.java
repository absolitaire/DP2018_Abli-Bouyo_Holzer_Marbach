package model;

@SuppressWarnings("serial")
public class IARandom implements Strategy {
	private Game g;
	private Board b;
	private int idOpponent;
	
	public IARandom(Game g, int opponent) {
		this.g = g;
		this.b = g.getBoard(opponent);
		this.idOpponent = opponent;
	}
	@Override
	public void shoot() {
		int a, o;
		while(true) {
			a = (int)(Board.BOARD_SIZE*Math.random());
			o = (int)(Board.BOARD_SIZE*Math.random());
			if(!b.getSquares()[a][o].isShooted()) {
				
				g.shoot(idOpponent, a, o);
				break;
			}
		}
	}

}
