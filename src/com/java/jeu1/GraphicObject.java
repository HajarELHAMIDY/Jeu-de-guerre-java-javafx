package com.java.jeu1;

import javafx.scene.Node;
import javafx.scene.image.Image;

public class GraphicObject {
	
	protected Image image;
	protected Node corps; 
	
	private boolean alive = true;

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	public Node getCorps() {
		return corps;
	}

	public void setCorps(Node corps) {
		this.corps = corps;
	}

	public boolean touch(GraphicObject obj) {
		return corps.getBoundsInParent().intersects(obj.getCorps().getBoundsInParent());
        
	}

	public boolean isDead() {
		return !alive;
	}

	

}
