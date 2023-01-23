public class Point {
	private int x, y;

	public Point(int x, int y){
		setX(x);
		setY(y);
	}

	public double distance(Point p){
		return Math.sqrt(Math.pow(x - p.x, 2) + Math.pow(y - p.y, 2));
	}

	@Override
	public String toString(){
		return "x: " + x + ", y: " + y;
	}

	/**
	 * Getters / Setters
	 * */
	 public void setX(int x){
	 	this.x = x;
	 }
	 public void setY(int y){
	 	this.y = y;
	 }
	 public int getX(){
	 	return x;
	 }
	 public int getY(){
	 	return y;
	 }
}