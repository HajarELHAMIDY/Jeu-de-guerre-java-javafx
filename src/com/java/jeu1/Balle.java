package com.java.jeu1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Balle extends GraphicObject {

	private Point2D direction = new Point2D(0, 0);// va présenter la direction
	

	public Balle(Player player) {
		
		try {
			image = new Image(new FileInputStream("photosJeu/p2-c-2.png"));

		} catch (FileNotFoundException e) {}
		corps = new ImageView(image);
		corps.setTranslateX(player.corps.getTranslateX() + 5);
		corps.setTranslateY(player.corps.getTranslateY()-40);
		
		updateDirection();
	}

	private void updateDirection() {

		Point2D p;
		double x = 0;
		double y = -1;
		p = new Point2D(x, y);
		direction = p.normalize().multiply(7);
	}

	public void update() {

		corps.setTranslateX(corps.getTranslateX() + direction.getX());
		corps.setTranslateY(corps.getTranslateY() + direction.getY());
	}

}
