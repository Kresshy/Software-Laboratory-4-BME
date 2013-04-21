package hu.miracle.workers;

public class Point {
	
	int x,y;
	
	public Point() {
		x = 0;
		y = 0;
	}
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int distance(Point p) {
		return (int) Math.sqrt( Math.pow(p.x - x, 2) + Math.pow(p.y - y, 2) );
		
	}
	
	public boolean validateHexPoints(Point p){
		
		return true;
	}

}
