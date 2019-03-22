package Thread;

import javafx.animation.AnimationTimer;
import model.Game;
import model.Pacman;
import userInterface.PacmanController;

public class PacmanThread extends Thread {

	private Game pacmanGame;
	private boolean moving;
	private PacmanController pacmanContr;

	public PacmanThread(Game pacmanGame, PacmanController pacmanContr) {
		this.pacmanGame = pacmanGame;
		this.pacmanContr = pacmanContr;
		moving = true;
	}

	public void run() {
		AnimationTimer animationBall = new AnimationTimer() {
			@Override
			public void handle(long now) {
				int totalRebounds=0;
				System.out.println(pacmanGame.getArrayPac().size());
				for (int i = 0; i < pacmanGame.getArrayPac().size(); i++) {

					Pacman pc = pacmanGame.getArrayPac().get(i);
					pc.setWidth(600);
					pc.setHeight(400);
					pc.moveX();
					pc.moveY();
					int pacCenterX = (int) pc.getX();
					int pacCenterY = (int) pc.getY();
					pacmanContr.getPacmanOpen().get(i).setCenterX(pacCenterX);
					pacmanContr.getPacmanOpen().get(i).setCenterY(pacCenterY);
					totalRebounds+=pc.getRebound();
					if(pc.getRebound()>0) {
						pc.randomColor();
						pacmanContr.changeColor(i, pc.getColor());
					}
				}
				pacmanContr.setLabelResultsRebounds(""+totalRebounds);
			};
		};
		animationBall.start();
	}

	public void setMoving(boolean move) {
		moving = move;
	}
}