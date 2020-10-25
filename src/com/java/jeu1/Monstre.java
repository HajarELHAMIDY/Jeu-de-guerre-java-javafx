package com.java.jeu1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Monstre extends GraphicObject {

	private Circle sortie = new Circle(0, 0, 5);
	private double x;
	private double y;
	private boolean toLeft;
	private boolean toBottom;
	private Zone zone;
	public Monstre(Zone zone) {
		this.zone = zone;
		x = zone.getDebutX() + (zone.getFinX() - zone.getDebutX()) * Math.random();
		y = zone.getDebutY() + (zone.getFinY() - zone.getDebutY()) * Math.random() + 80;

		try {
			image = new Image(new FileInputStream("photosJeu/enemy-c.png"));

		} catch (FileNotFoundException e) {}
		
		corps = new ImageView(image);
		corps.setTranslateX(x);
		corps.setTranslateY(y);
		sortie.setFill(Color.YELLOW);
		updateSortie();

	}
	public void updateSortie() {
		sortie.setTranslateX(corps.getTranslateX()+40);
		sortie.setTranslateY(corps.getTranslateY()+50);

	}
	  public void move(){

	        double startX = zone.getDebutX();
	        double startY = zone.getDebutY();
	        double endX = zone.getFinX() ;
	        double endY = zone.getFinY() ;
	        int speed = 1;

	        double x = corps.getTranslateX();
	        double y = corps.getTranslateY();

	        if(toLeft){
	            if(x-startX > speed){
	                x -= speed;
	            }else{
	                toLeft = false;
	            }
	        }else {
	            if(endX-x > speed){
	                x += speed;
	            }else{
	                toLeft = true;
	            }
	        }

	        if(toBottom){
	            if(endY-y > speed){
	                y += speed;
	            }else{
	                toBottom = false;
	            }
	        }else {
	            if(y-startY > speed){
	                y -= speed;
	            }else{
	                toBottom = true;
	            }
	        }

	        corps.setTranslateX(x);
	        corps.setTranslateY(y);
	        
	        updateSortie();


	    }
	public Circle getSortie() {
		return sortie;
	}

	public void setSortie(Circle sortie) {
		this.sortie = sortie;
	}
	


}
