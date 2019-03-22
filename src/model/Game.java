package model;

import java.util.ArrayList;

public class Game {
	
	private ArrayList<Pacman> arrayPac;

	public Game(int level) {
		initialize();
	}
	
	public void initialize() {
		arrayPac = new ArrayList<Pacman>();
	}

	public ArrayList<Pacman> getArrayPac() {
		return arrayPac;
	}

	public void setArrayPac(ArrayList<Pacman> arrayPac) {
		this.arrayPac = arrayPac;
	}
}