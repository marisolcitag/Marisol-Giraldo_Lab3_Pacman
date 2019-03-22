package model;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;
import java.security.SecureRandom;
import org.junit.jupiter.api.Test;
import model.Pacman;

public class PacmanTest {

	private Pacman pacman;
	private SecureRandom sr;
	
	public void setupScenary1() {
		sr = new SecureRandom();
		pacman = null;
	}
	
	@Test
	public void testCreatePacman() {
		setupScenary1();
		int radius = sr.nextInt();
		int posX = sr.nextInt();
		int posY = sr.nextInt();
		int waitingTime = sr.nextInt();
		String direction = sr.toString();
		int bounces = sr.nextInt();
		boolean caught = sr.nextBoolean();
		pacman = new Pacman(radius, posX, posY, waitingTime, direction, bounces, caught);
		assertTrue("The radius was not assigned correctly", radius == pacman.getRadius());
		assertTrue("The posX was not assigned correctly", posX == pacman.getX());
		assertTrue("The posY was not assigned correctly", posY == pacman.getY());
		assertTrue("The waitTime was not assigned correctly", waitingTime == pacman.getWaitTime());
		assertTrue("The way was not assigned correctly", direction.equals(pacman.getWay()));
		assertTrue("The rebounds were not assigned correctly", bounces == pacman.getRebound());
		;
	}

}
