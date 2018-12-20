package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class Board implements Serializable {

	public static final int BOARD_SIZE = 10;

	//private transient Player player;
	private ArrayList<Boat> boats;
	private ArrayList<Boat> boatsToPlace;
	private Square[][] squares;
	private transient BoatFactory bf;

	public Board(BoatFactory b){

		//this.images = b.obtenirImages();
		boats = new ArrayList<Boat>();
		squares = new Square[BOARD_SIZE][BOARD_SIZE];
		for(int i = 0; i < BOARD_SIZE; i++){
			for(int j = 0; j < BOARD_SIZE; j++){
				squares[i][j] = new Square(i,j);
			}
		}
		bf = b;
		boatsToPlace = bf.createBoats();

	}

	public void automaticArrangement(){
		while(boatsToPlace.size()> 0){
			placeBoat((int) Math.floor(Math.random()*BOARD_SIZE),
					(int) Math.floor(Math.random()*BOARD_SIZE),
					Math.random() < 0.5);
		}
	}

	public boolean placeBoat(int a, int o, boolean horizontal) {
		if(boatsToPlace.size() > 0){
			Boat boat = boatsToPlace.get(0);
			int taille = boat.getSize();
			int x = a;
			int y = o;
			boolean echec = false;

			while(taille > 0 && !echec){
				if(x<BOARD_SIZE && y<BOARD_SIZE) {
					if(squares[x][y].getBoat()== null) {
						if(horizontal) {
							x++;
						}else {
							y++;
						}
						taille--;

					}else {
						echec = true;
					}
				}else{
					echec = true;
				}

			}
			if(!echec) {
				taille = boat.getSize();
				x = a;
				y = o;
				squares[x][y].setBoat(boat);
				boat.setSquare(squares[x][y]);
				if(horizontal) {
					squares[x][y].setIdImage(boat.getImages()[0]);
					x++;
				}else {
					squares[x][y].setIdImage(boat.getImages()[3]);
					y++;
				}
				taille--;
				while(taille > 1){
					//System.out.println(x+"  "+y);
					squares[x][y].setBoat(boat);
					boat.setSquare(squares[x][y]);
					if(horizontal) {
						squares[x][y].setIdImage(boat.getImages()[1]);
						x++;
					}else {
						squares[x][y].setIdImage(boat.getImages()[4]);
						y++;
					}
					taille--;
				}
				squares[x][y].setBoat(boat);
				boat.setSquare(squares[x][y]);
				if(horizontal) {
					squares[x][y].setIdImage(boat.getImages()[2]);
					x++;
				}else {
					squares[x][y].setIdImage(boat.getImages()[5]);
					y++;
				}
				boats.add(boat);
				boatsToPlace.remove(boat);
				return true;
			}
		}

		return false;
	}

	public boolean areBoatsAllPlaced(){
		return boatsToPlace.size() == 0;
	}


	public int sizeOfTheNextBoatToPlace(){
		if( boatsToPlace.size() == 0 )return -1;
		return boatsToPlace.get(0).getSize();
	}

	public void logPlaceNextBoat(){
		if(boatsToPlace.size()>0){
			Log.getInstance().addLog("Bateau a placer: "+boatsToPlace.get(0).getName()+ " ("+boatsToPlace.get(0).getSize()+")", false);
		}
	}

	public Square[][] getSquares() {
		return squares;
	}

	/*
	public void setJoueur(Player joueur) {
		this.player = joueur;
	}*/

	public List<Boat> getBateaux() {
		return boats;
	}




}
