package model;

import java.util.ArrayList;
import java.util.List;

public class Board {

	public static final int TAILLE = 10;

	private Player player;
	private ArrayList<Boat> boats;
	private ArrayList<Boat> boatsToPlace;
	private Square[][] squares;
	private BoatFactory bf;

	//0-2 = horizontal    3-5 = vertical
	private int[] images;

	public Board(BoatFactory b){
		//this.joueur = joueur;
		this.images = b.obtenirImages();
		boats = new ArrayList<Boat>();
		squares = new Square[TAILLE][TAILLE];
		for(int i = 0; i < TAILLE; i++){
			for(int j = 0; j < TAILLE; j++){
				squares[i][j] = new Square(i,j);
			}
		}
		bf = b;
		boatsToPlace = bf.creerBateaux();

	}

	public void automaticArrangement(){
		
		while(boatsToPlace.size()> 0){
			placeBoat((int) Math.floor(Math.random()*TAILLE),
					(int) Math.floor(Math.random()*TAILLE),
					Math.random() < 0.5);
		}
/*
		int taille, x, y, xOrig, yOrig;
		boolean place, echec, direction;
		for(Boat boat : boatsToPlace){
			boats.add(boat);
			place = false;

			while(!place) {
				taille = boat.getTaille();
				xOrig = (int) (Math.random()*(TAILLE - 2));
				yOrig = (int) (Math.random()*(TAILLE - 2));
				x = xOrig;
				y = yOrig;
				direction = Math.random() < 0.5;
				echec = false;

				while(taille > 0 && !echec){
					if(x<TAILLE && y<TAILLE) {
						if(squares[x][y].getBoat()== null) {
							if(direction) {
								x++;
							}else {
								y++;
							}
							taille--;

						}else {
							echec = true;//System.out.println("echc");
						}
					}else{
						echec = true;//System.out.println("echc");
					}

				}
				if(!echec) {
					place = true;
					taille = boat.getTaille();
					x = xOrig;
					y = yOrig;
					squares[x][y].setBoat(boat);
					boat.setSquare(squares[x][y]);
					if(direction) {
						squares[x][y].setIdImage(images[0]);
						x++;
					}else {
						squares[x][y].setIdImage(images[3]);
						y++;
					}
					taille--;
					while(taille > 1){
						//System.out.println(x+"  "+y);
						squares[x][y].setBoat(boat);
						boat.setSquare(squares[x][y]);
						if(direction) {
							squares[x][y].setIdImage(images[1]);
							x++;
						}else {
							squares[x][y].setIdImage(images[4]);
							y++;
						}
						taille--;
					}
					squares[x][y].setBoat(boat);
					boat.setSquare(squares[x][y]);
					if(direction) {
						squares[x][y].setIdImage(images[2]);
						x++;
					}else {
						squares[x][y].setIdImage(images[5]);
						y++;
					}
				}
			}
		}*/
	}
	
	public boolean placeBoat(int a, int o, boolean horizontal) {
		Boat boat = boatsToPlace.get(0);
		int taille = boat.getTaille();
		int x = a;
		int y = o;
		boolean echec = false;

		while(taille > 0 && !echec){
			if(x<TAILLE && y<TAILLE) {
				if(squares[x][y].getBoat()== null) {
					if(horizontal) {
						x++;
					}else {
						y++;
					}
					taille--;

				}else {
					echec = true;//System.out.println("echc");
				}
			}else{
				echec = true;//System.out.println("echc");
			}

		}
		if(!echec) {
			taille = boat.getTaille();
			x = a;
			y = o;
			squares[x][y].setBoat(boat);
			boat.setSquare(squares[x][y]);
			if(horizontal) {
				squares[x][y].setIdImage(images[0]);
				x++;
			}else {
				squares[x][y].setIdImage(images[3]);
				y++;
			}
			taille--;
			while(taille > 1){
				//System.out.println(x+"  "+y);
				squares[x][y].setBoat(boat);
				boat.setSquare(squares[x][y]);
				if(horizontal) {
					squares[x][y].setIdImage(images[1]);
					x++;
				}else {
					squares[x][y].setIdImage(images[4]);
					y++;
				}
				taille--;
			}
			squares[x][y].setBoat(boat);
			boat.setSquare(squares[x][y]);
			if(horizontal) {
				squares[x][y].setIdImage(images[2]);
				x++;
			}else {
				squares[x][y].setIdImage(images[5]);
				y++;
			}
			boats.add(boat);
			boatsToPlace.remove(boat);
			return true;
		}
		return false;
	}
	
	public boolean areBoatsAllPlaced(){
		return boatsToPlace.size() == 0;
	}
	
	
	public int sizeOfTheNextBoatToPlace(){
		if( boatsToPlace.size() == 0 )return -1;
		return boatsToPlace.get(0).getTaille();
	}
	
	public void logPlaceNextBoat(){
		if(boatsToPlace.size()>0){
			Log.getInstance().addLog("Bateau à placer: "+boatsToPlace.get(0).getNom()+ " ("+boatsToPlace.get(0).getTaille()+")");
		}
	}
	
	public Square[][] getSquares() {
		return squares;
	}

	public void setJoueur(Player joueur) {
		this.player = joueur;
	}

	public List<Boat> getBateaux() {
		return boats;
	}




}
