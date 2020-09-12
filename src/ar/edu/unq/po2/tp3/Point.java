package ar.edu.unq.po2.tp3;

public class Point {

	private int x, y;
	
	public Point(int x, int y) {
		setX(x);
		setY(y);
	}
	
	public Point() {
		setX(0);
		setY(0);
	}
	
	public void moverPunto(int x, int y) {
		setX(x);
		setY(y);
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public Point sumarPunto(Point unPunto) {
		
		int x = (unPunto.getX() + this.getX());
		int y = (unPunto.getY() + this.getY());
		
		return (new Point(x, y));
		
	}
	
}
