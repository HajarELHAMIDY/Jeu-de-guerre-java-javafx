package com.java.jeu1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Coeurs extends GraphicObject {

	public Coeurs() {

		try {
			image = new Image(new FileInputStream("photosJeu/h-c.png"));
		} catch (FileNotFoundException e) {}
		
		corps = new ImageView(image);
		

	}

}
