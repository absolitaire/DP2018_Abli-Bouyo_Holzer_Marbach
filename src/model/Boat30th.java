package model;

@SuppressWarnings("serial")
public class Boat30th extends Boat {

	public Boat30th(String n, int pvParCase, int t, int[] img) {
		super(n, pvParCase, t, img);
	}

	@Override
	public boolean hit(Square sq){
		if(!hasSunk){
			if(health.containsKey(sq)){
				for(Square sqTmp: health.keySet()){
					health.put(sqTmp, 0);
				}
				
				hasSunk = true;
				
				Log.getInstance().addLog("                > Coule "+sq.getPosX()+","+sq.getPosY(), true);
				return true;
			}

		}
		return false;
	}
}
