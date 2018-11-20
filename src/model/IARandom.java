package model;

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
	public void tirer() {
		//System.out.println("ia");
		int a, o;
		while(true) {
			a = (int)(Board.TAILLE*Math.random());
			o = (int)(Board.TAILLE*Math.random());
			//System.out.println(a+" "+o+b);
			if(!b.getSquares()[a][o].isShooted()) {
				
				g.shoot(idOpponent, a, o);
				break;
			}
		}
		//System.out.println("fin ia");
	}

}
