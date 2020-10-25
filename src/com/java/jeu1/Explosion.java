package com.java.jeu1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Explosion extends GraphicObject {

	public Explosion(GraphicObject monstre) {
		try {
			image = new Image(new FileInputStream("photosJeu/explosion.gif"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		corps = new ImageView(image);
		corps.setTranslateX(monstre.getCorps().getTranslateX());
		corps.setTranslateY(monstre.getCorps().getTranslateY()-50);
	}

	

}
