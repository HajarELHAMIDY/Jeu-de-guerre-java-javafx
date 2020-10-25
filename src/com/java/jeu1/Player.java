package com.java.jeu1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Player extends GraphicObject {

	private int score = 0;
	private List<Coeurs> coeurs;

	public Player() {
		coeurs = new ArrayList<>();
		for (int i = 0; i < 5; i++)
			coeurs.add(new Coeurs());

		try {
			image = new Image(new FileInputStream("photosJeu/p1-c.png"));

		} catch (FileNotFoundException e) {}
		
		corps = new ImageView(image);
		corps.setTranslateX(500);
		corps.setTranslateY(350);

	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public List<Coeurs> getCoeurs() {
		return coeurs;
	}

	public void setCoeurs(List<Coeurs> coeurs) {
		this.coeurs = coeurs;
	}

}
