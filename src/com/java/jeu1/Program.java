package com.java.jeu1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Program extends Application {

	private Stage window;
	private double widthWindow = 1000;
	private double heightWindow = 600;
	private Scene scene1, scene2, scene3, scene4;
	private Image image, home, gameOver;
	private Pane container2;
	private VBox container1;
	private Pane container3;
	private Pane container4;
	private HBox barreHbox;
	private Zone zone1;
	private Player player;
	private List<Monstre> monstres;
	private List<Balle> balles;
	private List<Bombe> bombes;
	private List<BombeF> bombesF;
	private List<Explosion> explosions;
	private List<Coeurs> coeurs;
	private String musicFile;
	private Media sound;
	private String musicBack = "m2.mp3";
	Media soundback = new Media(new File(musicBack).toURI().toString());
	MediaPlayer mediaback = new MediaPlayer(soundback);
	private String gameO;
	private MonstreF monstreF;
	private Media soundgameO;
	private MediaPlayer mediagameO;
	private Label scoreLabel;
	private AnimationTimer animation1;
	private AnimationTimer animation2;
	private EventHandler<KeyEvent> event;
	private EventHandler<KeyEvent> event2;

	public void initPane() {
		container2 = new Pane();
		container1 = new VBox(20);
		container3 = new Pane();
		container4 = new Pane();
		barreHbox = new HBox(15);
		zone1 = new Zone(0, 30, widthWindow - 50, 200 - 50);
		player = new Player();
		monstres = new ArrayList<Monstre>();
		balles = new ArrayList<Balle>();

		bombes = new ArrayList<Bombe>();
		bombesF = new ArrayList<BombeF>();
		explosions = new ArrayList<>();
		coeurs = player.getCoeurs();
		musicFile = "1023.mp3";
		sound = new Media(new File(musicFile).toURI().toString());
		
		
		gameO = "gameOver.mp3";
		monstreF = new MonstreF(zone1);
		soundgameO = new Media(new File(gameO).toURI().toString());
		mediagameO = new MediaPlayer(soundgameO);
		scoreLabel = new Label("Score : " + player.getScore());
		if (animation1 == null) {
			animation1 = new AnimationTimer() {

				@Override
				public void handle(long now) {
					refreshContent();
					if (Math.random() < 0.008) {
						for (Monstre monstre : monstres) {
							Bombe bombe = new Bombe(monstre);
							container2.getChildren().add(bombe.getCorps());
							bombes.add(bombe);
						}
					}

				}
			};
		}
		if (animation2 == null) {
			animation2 = new AnimationTimer() {

				@Override
				public void handle(long now) {
					refreshContent2();

					if (Math.random() < 0.009) {
						BombeF bombe = new BombeF(monstreF);
						container4.getChildren().add(bombe.getCorps());
					    bombesF.add(bombe);
					}
				}
			};
		}
		event = new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {

				if (event.getCode() == KeyCode.SPACE) {
					if (coeurs.size() != 0) {
						Balle balle = new Balle(player);
						container2.getChildren().add(balle.getCorps());
						balles.add(balle);
					}

				}

				if (event.getCode() == KeyCode.LEFT) {

					player.getCorps().setTranslateX(player.getCorps().getTranslateX() - 7);

				}
				if (event.getCode() == KeyCode.RIGHT) {

					player.getCorps().setTranslateX(player.getCorps().getTranslateX() + 7);

				}
				if (event.getCode() == KeyCode.UP) {
					if (player.getCorps().getTranslateY() > 300) {
						player.getCorps().setTranslateY(player.getCorps().getTranslateY() - 5);

					}

				}
				if (event.getCode() == KeyCode.DOWN) {
					player.getCorps().setTranslateY(player.getCorps().getTranslateY() + 5);

				}
			}

		};
		event2 = new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {

				if (event.getCode() == KeyCode.SPACE) {
					if (coeurs.size() != 0) {
						Balle balle = new Balle(player);
						container4.getChildren().add(balle.getCorps());
						balles.add(balle);
					}

				}

				if (event.getCode() == KeyCode.LEFT) {

					player.getCorps().setTranslateX(player.getCorps().getTranslateX() - 7);

				}
				if (event.getCode() == KeyCode.RIGHT) {

					player.getCorps().setTranslateX(player.getCorps().getTranslateX() + 7);

				}
				if (event.getCode() == KeyCode.UP) {
					if (player.getCorps().getTranslateY() > 300) {
						player.getCorps().setTranslateY(player.getCorps().getTranslateY() - 5);

					}

				}
				if (event.getCode() == KeyCode.DOWN) {
					player.getCorps().setTranslateY(player.getCorps().getTranslateY() + 5);

				}
			}

		};

	}
	
////////////////////////////////////////////////////////////////////////////////////////////////
	@SuppressWarnings("unlikely-arg-type")

	private void refreshContent() {

		for (Balle balle : balles) {
			for (Monstre monstre : monstres) {
				if (balle.touch(monstre)) {
					player.setScore(player.getScore() + 1);
					scoreLabel.setText("Score : " + player.getScore());
					MediaPlayer mediaPlayer = new MediaPlayer(sound);
					mediaPlayer.play();
					Explosion explosion = new Explosion(monstre);
					container2.getChildren().removeAll(balle.getCorps(), monstre.getCorps(), monstre.getSortie());

					balle.setAlive(false);
					monstre.setAlive(false);
					explosion.setAlive(false);
					explosions.add(explosion);
					

					new Thread(() -> {
						Platform.runLater(() -> {
							container2.getChildren().add(explosion.getCorps());
						});
						try {
							Thread.sleep(800);
						} catch (InterruptedException e) {
						}
						Platform.runLater(() -> {
							container2.getChildren().remove(explosion.getCorps());
						});

					}).start();
					
					if (player.getScore()>=10) {

						initPane();
						animation1.stop();
						createContent4();
						scene4 = new Scene(container4);
						animation2.start();

						scene4.setOnKeyPressed(event2);
						window.setScene(scene4);
					}

				}
			}
		}
		for (Balle balle : balles) {
			balle.update();
		}
		for (Balle balle : balles) {
			for (Bombe monstre : bombes) {
				if (balle.touch(monstre)) {
					player.setScore(player.getScore() + 1);
					scoreLabel.setText("Score : " + player.getScore());
					MediaPlayer mediaPlayer = new MediaPlayer(sound);
					mediaPlayer.play();
					Explosion explosion = new Explosion(monstre);
					container2.getChildren().removeAll(balle.getCorps(), monstre.getCorps());

					balle.setAlive(false);
					monstre.setAlive(false);
					explosion.setAlive(false);
					explosions.add(explosion);
					

					new Thread(() -> {
						Platform.runLater(() -> {
							container2.getChildren().add(explosion.getCorps());
						});
						try {
							Thread.sleep(800);
						} catch (InterruptedException e) {
						}
						Platform.runLater(() -> {
							container2.getChildren().remove(explosion.getCorps());
						});

					}).start();

				}
			}
		}
		for (Bombe bombe : bombes) {
			bombe.update();
		}
		explosions.removeIf(GraphicObject::isDead);
		monstres.removeIf(GraphicObject::isDead);
		balles.removeIf(GraphicObject::isDead);

		for (Bombe bombe : bombes) {
			if (bombe.touch(player)) {
				 
				//	player.setScore(player.getScore() + 1);
					Coeurs c = coeurs.get(coeurs.size() - 1);
					container2.getChildren().remove(bombe.getCorps());
					container2.getChildren().remove(barreHbox.getChildren().remove(c.corps));
					bombe.setAlive(false);
					coeurs.get(coeurs.size() - 1).setAlive(false);
					coeurs.removeIf(GraphicObject::isDead);

					if (coeurs.size() == 0){/*****************************/

					container2.getChildren().remove(player.getCorps());
					mediaback.stop();
					mediagameO.play();
					Label scoreFinal = new Label("Your score :   " + player.getScore());
					scoreFinal.setTranslateX(350);
					scoreFinal.setTranslateY(10);
					scoreFinal.setFont(new Font(36));
					scoreFinal.setTextFill(Color.WHITE);
					initPane();
					animation1.stop();
					createContent3();
					container3.getChildren().add(scoreFinal);
					scene3.setRoot(container3);
					window.setScene(scene3);

				}

			}
		}
		bombes.removeIf(GraphicObject::isDead);

		if (Math.random() < 0.01) {
			Monstre monstre = new Monstre(zone1);
			monstres.add(monstre);
			container2.getChildren().add(monstre.corps);
			container2.getChildren().add(monstre.getSortie());

		}

		for (Monstre monstre : monstres) {
			monstre.move();

		}

	}
////////////////////////////////////////////////////////////////////////////////////////////////////////
	private void refreshContent2() {

		for (Balle balle : balles) {

			if (balle.touch(monstreF)) {
				balle.setAlive(false);
				container4.getChildren().removeAll(balle.getCorps());

				player.setScore(player.getScore() + 1);
				scoreLabel.setText("Score : " + player.getScore());
				MediaPlayer mediaPlayer = new MediaPlayer(sound);
				mediaPlayer.play();
				if (player.getScore() == 10) {
					Explosion explosion = new Explosion(monstreF);
					container4.getChildren().removeAll(balle.getCorps(), monstreF.getCorps());
					balle.setAlive(false);
					monstreF.setAlive(false);
					explosion.setAlive(false);
					explosions.add(explosion);

					new Thread(() -> {
						Platform.runLater(() -> {
							container4.getChildren().add(explosion.getCorps());
						});
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
						}
						Platform.runLater(() -> {
							container4.getChildren().remove(explosion.getCorps());
						});

					}).start();
					
					container4.getChildren().remove(player.getCorps());

					
					initPane();
					animation2.stop();
				 
					
                  
					createContent5();
					   mediaback.stop();
					scene3.setRoot(container3);
					window.setScene(scene3);

				}
			}
		}

		for (Balle balle : balles) {
			balle.update();
		}

		explosions.removeIf(GraphicObject::isDead);
		balles.removeIf(GraphicObject::isDead);
		
		
		for (BombeF bombe : bombesF) {
			if (bombe.touch(player)) {

				
					
					
					Coeurs c = coeurs.get(coeurs.size() - 1);
					container4.getChildren().remove(bombe.getCorps());
					container4.getChildren().remove(barreHbox.getChildren().remove(c.corps));
					
					bombe.setAlive(false);
					coeurs.get(coeurs.size() - 1).setAlive(false);
					coeurs.removeIf(GraphicObject::isDead);
					
					if (coeurs.size() == 0) {

						container4.getChildren().remove(player.getCorps());
						mediaback.stop();
						mediagameO.play();
						Label scoreFinal = new Label("Your score :   " + player.getScore());
						scoreFinal.setTranslateX(350);
						scoreFinal.setTranslateY(10);
						scoreFinal.setFont(new Font(36));
						scoreFinal.setTextFill(Color.WHITE);
						initPane();
						animation2.stop();
						createContent3();
						 mediaback.stop();
						container3.getChildren().add(scoreFinal);
						scene3.setRoot(container3);
						window.setScene(scene3);

					

				}

			}
		}
		for (BombeF bombe : bombesF) {
			bombe.update();
		}
		bombes.removeIf(GraphicObject::isDead);
		monstreF.move();
	}
/////////////////////////////////////////////////////////////////////////////////////////
	public void createContent2() {
		try {
			image = new Image(new FileInputStream("photosJeu/2.gif"));
		} catch (FileNotFoundException e) {
		}

		Label labelVie = new Label("Coeurs : ");
		labelVie.setTextFill(Color.web("#FFFFFF"));
		labelVie.setFont(new Font("Arial", 17));
		scoreLabel.setTextFill(Color.web("#FFFFFF"));
		scoreLabel.setFont(new Font("Arial", 17));
		barreHbox.getChildren().addAll(scoreLabel, labelVie);

		for (Coeurs item : coeurs) {
			barreHbox.getChildren().add(item.corps);
		}
		Label level = new Label("Level 1 ");
		level.setFont(new Font("Arial", 50));
		level.setTextFill(Color.web("#FFFFFF"));
		level.setTranslateX(450);
		level.setTranslateY(200);
		
        
	
		new Thread(() -> {
			Platform.runLater(() -> {
				container2.getChildren().add(level);
			});
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
			}
			Platform.runLater(() -> {
				container2.getChildren().remove(level);
			});

		}).start();

		barreHbox.setPadding(new Insets(10));
		container2.getChildren().addAll(barreHbox, player.corps);
		container2.setBackground(new Background(new BackgroundImage(image, BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
				new BackgroundSize(widthWindow, heightWindow, false, false, false, false))));
	}

	public void createContent4() {
		try {
			image = new Image(new FileInputStream("photosJeu/s2.gif"));
		} catch (FileNotFoundException e) {
		}

		Label labelVie = new Label("Coeurs : ");
		labelVie.setTextFill(Color.web("#FFFFFF"));
		labelVie.setFont(new Font("Arial", 17));
		scoreLabel.setTextFill(Color.web("#FFFFFF"));
		scoreLabel.setFont(new Font("Arial", 17));
		barreHbox.getChildren().addAll(scoreLabel);
		Label level = new Label("Level 2 ");
		level.setFont(new Font("Arial", 50));
		level.setTextFill(Color.web("#FFFFFF"));
		level.setTranslateX(450);
		level.setTranslateY(200);
		
        
	
		new Thread(() -> {
			Platform.runLater(() -> {
				container4.getChildren().add(level);
			});
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
			}
			Platform.runLater(() -> {
				container4.getChildren().remove(level);
			});

		}).start();
		barreHbox.setPadding(new Insets(10));
		container4.getChildren().addAll(barreHbox, player.corps);
		container4.getChildren().add(monstreF.getCorps());
		container4.setBackground(new Background(new BackgroundImage(image, BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
				new BackgroundSize(widthWindow, heightWindow, false, false, false, false))));
	}

	public void createContent1() {

		Button btn1 = new Button("Play");
		Label titre = new Label("Welcome, Start Now !!! ");
		titre.setFont(new Font("Arial", 36));
		HBox footer = new HBox();
		Label c = new Label("Created By Hajar EL-HAMIDY ENSET-M 2019-2020");
		c.setFont(new Font("Arial", 14));
		c.setTextFill(Color.WHITE);
		footer.getChildren().add(c);
		footer.setAlignment(Pos.BOTTOM_CENTER);
		footer.setPadding(new Insets(100));

		btn1.setPrefWidth(250);
		btn1.setStyle("-fx-background-color: \r\n" + "        linear-gradient(#ffd65b, #e68400),\r\n"
				+ "        linear-gradient(#ffef84, #f2ba44),\r\n" + "        linear-gradient(#ffea6a, #efaa22),\r\n"
				+ "        linear-gradient(#ffe657 0%, #f8c202 50%, #eea10b 100%),\r\n"
				+ "        linear-gradient(from 0% 0% to 15% 50%, rgba(255,255,255,0.9), rgba(255,255,255,0));\r\n"
				+ "    -fx-background-radius: 30;\r\n" + "    -fx-background-insets: 0,1,2,3,0;\r\n"
				+ "    -fx-text-fill: #654b00;\r\n" + "    -fx-font-weight: bold;\r\n" + "    -fx-font-size: 25px;\r\n"
				+ "    -fx-padding: 10 20 10 20;");
		Button btn2 = new Button("Exit");

		btn2.setPrefWidth(250);
		btn2.setStyle("-fx-background-color: \r\n" + "        linear-gradient(#ffd65b, #e68400),\r\n"
				+ "        linear-gradient(#ffef84, #f2ba44),\r\n" + "        linear-gradient(#ffea6a, #efaa22),\r\n"
				+ "        linear-gradient(#ffe657 0%, #f8c202 50%, #eea10b 100%),\r\n"
				+ "        linear-gradient(from 0% 0% to 15% 50%, rgba(255,255,255,0.9), rgba(255,255,255,0));\r\n"
				+ "    -fx-background-radius: 30;\r\n" + "    -fx-background-insets: 0,1,2,3,0;\r\n"
				+ "    -fx-text-fill: #654b00;\r\n" + "    -fx-font-weight: bold;\r\n" + "    -fx-font-size: 25px;\r\n"
				+ "    -fx-padding: 10 20 10 20;");
		container1.getChildren().addAll(titre, btn1, btn2, footer);

		container1.setAlignment(Pos.TOP_CENTER);
		container1.setPadding(new Insets(100));
		try {
			home = new Image(new FileInputStream("photosJeu/home.jpg"));
		} catch (FileNotFoundException e) {
		}

		container1.setBackground(new Background(new BackgroundImage(home, BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
				new BackgroundSize(widthWindow, heightWindow, false, false, false, false))));

		btn1.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				mediaback.play();
				scene2 = new Scene(container2);
				createContent2();
				animation1.start();
				scene2.setOnKeyPressed(event);
				window.setScene(scene2);

			}
		});
		btn2.setOnAction(e -> window.close());

	}

	public void createContent3() {
		Button btn1 = new Button("Replay");
		btn1.setPrefWidth(200);
		btn1.setTranslateX(400);
		btn1.setTranslateY(490);
		btn1.setStyle("-fx-background-color: \r\n" + "        linear-gradient(#ffd65b, #e68400),\r\n"
				+ "        linear-gradient(#ffef84, #f2ba44),\r\n" + "        linear-gradient(#ffea6a, #efaa22),\r\n"
				+ "        linear-gradient(#ffe657 0%, #f8c202 50%, #eea10b 100%),\r\n"
				+ "        linear-gradient(from 0% 0% to 15% 50%, rgba(255,255,255,0.9), rgba(255,255,255,0));\r\n"
				+ "    -fx-background-radius: 30;\r\n" + "    -fx-background-insets: 0,1,2,3,0;\r\n"
				+ "    -fx-text-fill: #654b00;\r\n" + "    -fx-font-weight: bold;\r\n" + "    -fx-font-size: 25px;\r\n"
				+ "    -fx-padding: 10 20 10 20;");
		try {
			gameOver = new Image(new FileInputStream("photosJeu/game2.jpg"));
		} catch (FileNotFoundException e) {
		}
		container3.getChildren().add(btn1);

		container3.setBackground(new Background(new BackgroundImage(gameOver, BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
				new BackgroundSize(widthWindow, heightWindow, false, false, false, false))));
		mediaback.stop();
		btn1.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				mediaback.play();
				initPane();
				createContent2();
				animation1.start();
				scene2.setRoot(container2);
				scene2.setOnKeyPressed(event);
				window.setScene(scene2);

			}
		});

	}

	public void createContent5() {
		Button btn1 = new Button("Replay");
		btn1.setPrefWidth(200);
		btn1.setTranslateX(400);
		btn1.setTranslateY(490);
		btn1.setStyle("-fx-background-color: \r\n" + "        linear-gradient(#ffd65b, #e68400),\r\n"
				+ "        linear-gradient(#ffef84, #f2ba44),\r\n" + "        linear-gradient(#ffea6a, #efaa22),\r\n"
				+ "        linear-gradient(#ffe657 0%, #f8c202 50%, #eea10b 100%),\r\n"
				+ "        linear-gradient(from 0% 0% to 15% 50%, rgba(255,255,255,0.9), rgba(255,255,255,0));\r\n"
				+ "    -fx-background-radius: 30;\r\n" + "    -fx-background-insets: 0,1,2,3,0;\r\n"
				+ "    -fx-text-fill: #654b00;\r\n" + "    -fx-font-weight: bold;\r\n" + "    -fx-font-size: 25px;\r\n"
				+ "    -fx-padding: 10 20 10 20;");
		try {
			gameOver = new Image(new FileInputStream("photosJeu/win.jpg"));
			System.out.println("existe yes ");
		} catch (FileNotFoundException e) {
		}
		container3.getChildren().add(btn1);

		container3.setBackground(new Background(new BackgroundImage(gameOver, BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
				new BackgroundSize(widthWindow, heightWindow, false, false, false, false))));
		 mediaback.stop();
		btn1.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				mediaback.play();
				initPane();
				createContent2();
				animation1.start();
				scene2.setRoot(container2);
				scene2.setOnKeyPressed(event);
				window.setScene(scene2);

			}
		});

	}

	@Override
	public void start(Stage window) throws Exception {
		this.window = window;
		window.setWidth(widthWindow);
		window.setHeight(heightWindow);
		window.setTitle("Jeu de guerre");
		initPane();
		scene1 = new Scene(container1);
		createContent1();

		scene3 = new Scene(container3);

		window.setScene(scene1);
		window.show();
	}

	public static void main(String[] args) {

		launch(args);

	}

}
