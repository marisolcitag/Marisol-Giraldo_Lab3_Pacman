package model;

import java.io.Serializable;
import java.util.Random;

import javafx.scene.paint.Color;

public class Pacman implements Serializable {

	//Radio
	private double radius;

	//posX
	private double x;

	//posY
	private double y;

	//Wait Time
	private double waitTime;

	//Way
	private String way;

	//Rebound
	private int rebound;

	//Is Stopped
	private boolean isStopped;

	//Width Window
	private double width;

	//Heigth Window
	private double height;
	
	private Color color;

	//CONSTRUCTOR
	public Pacman(double radius, double x, double y, double waitTime, String way, int rebound, boolean isStopped) {
		super();
		this.radius = radius;
		this.x = x;
		this.y = y;
		this.waitTime = waitTime;
		this.way = way;
		this.rebound = rebound;
		this.isStopped = isStopped;
		setColor(Color.YELLOW);
	}	

	//METHODS GETTERS & SETTERS
	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getWaitTime() {
		return waitTime;
	}

	public void setWaitTime(double waitTime) {
		this.waitTime = waitTime;
	}

	public String getWay() {
		return way;
	}

	public void setWay(String way) {
		this.way = way;
	}

	public int getRebound() {
		return rebound;
	}

	public void setRebound(int rebound) {
		this.rebound = rebound;
	}

	public boolean isStopped() {
		return isStopped;
	}

	public void setStopped(boolean isStopped) {
		this.isStopped = isStopped;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}
	
	public void moveX() {
		if(x>=width) {
			way = "LEFT";
			rebound++;
		}else if(x<=1) {
			way = "RIGHT";
			rebound++;
		}


		if(way.equals("LEFT")) {
			x= x-waitTime;
		}else if (way.equals("RIGHT")){
			x+=waitTime;
			System.out.println("x: "+x+" "+way);
		}
//		System.out.println("Voy "+way+ " estoy en "+x +" y avanzo" +waitTime);
	}


	public void moveY() {
		if(y>=height) {
			way = "UP";
			rebound++;
		}else if(y<=5) {
			way = "DOWN";
			rebound++;
			
		}

		if(way.equals("UP")) {
			y= y-waitTime;
			System.out.println("y:" +y+" "+way);
		}else if(way.equals("DOWN")){
			y=y+waitTime;
		}
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	public void randomColor() {
		double r= Math.random();
		double g= Math.random();
		double b= Math.random();
		int i = 1;
		color = new Color(r,g,b,i);
	
	}
}
