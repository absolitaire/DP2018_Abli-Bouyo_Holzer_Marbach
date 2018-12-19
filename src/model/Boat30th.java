package model;

public class Boat30th extends Boat {

	public Boat30th(String n, int pvParCase, int t, int[] img) {
		super(n, pvParCase, t, img);
	}

	@Override
	public boolean toucher(Square sq){
		if(!coule){
			if(ptsVie.containsKey(sq)){
				for(Square sqTmp: ptsVie.keySet()){
					ptsVie.put(sq, 0);
				}
				//System.out.println("Touch� "+sq.getPosX()+","+sq.getPosY());
				/*Log.getInstance().addLog("                > Touche "+sq.getPosX()+","+sq.getPosY(), true);
					if(pv == 0){
						boolean verif = true;
						for(Integer i :ptsVie.values()){
							//System.out.println(i);
							if(i>0){
								verif = false;
								break;
							}
						}
						if(verif){   */
				coule = true;
				//System.out.println("Coul� "+sq.getPosX()+","+sq.getPosY());
				Log.getInstance().addLog("                > Coule "+sq.getPosX()+","+sq.getPosY(), true);
				return true;
			}

		}
		return false;
	}
}
