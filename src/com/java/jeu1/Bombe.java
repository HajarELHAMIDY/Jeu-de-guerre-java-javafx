package com.java.jeu1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Bombe extends GraphicObject {

	private Point2D direction = new Point2D(0, 0);// va présenter la direction

	public Bombe(Monstre monstre) {
		
		try {
			image = new Image(new FileInputStream("photosJeu/feu-c.png"));
		} catch (FileNotFoundException e) {}	
		corps = new ImageView(image);
		corps.setTranslateX(monstre.corps.getTranslateX() + 40);
		corps.setTranslateY(monstre.corps.getTranslateY() + 50);
		updateDirection();
	}

	private void updateDirection() {

		Point2D p;
		double x = 0;
		double y = 1;
		p = new Point2D(x, y);
		direction = p.normalize().multiply(3);
	}

	public void update() {
		
		 corps.setTranslateX(corps.getTranslateX()+direction.getX());
		 corps.setTranslateY(corps.getTranslateY()+direction.getY());
	}

}
