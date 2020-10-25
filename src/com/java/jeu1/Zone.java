package com.java.jeu1;

public class Zone {
	private double  debutX ;
	private double  debutY ;
	private double  finX ;
	private double finY ;
	public Zone(double debutX, double debutY, double finX, double finY) {
		this.debutX = debutX;
		this.debutY = debutY;
		this.finX = finX;
		this.finY = finY;
	}

	public double getDebutX() {
		return debutX;
	}
	public void setDebutX(double debutX) {
		this.debutX = debutX;
	}
	public double getDebutY() {
		return debutY;
	}
	public void setDebutY(double debutY) {
		this.debutY = debutY;
	}
	public double getFinX() {
		return finX;
	}
	public void setFinX(double finX) {
		this.finX = finX;
	}
	public double getFinY() {
		return finY;
	}
	public void setFinY(double finY) {
		this.finY = finY;
	}
	
	

}
