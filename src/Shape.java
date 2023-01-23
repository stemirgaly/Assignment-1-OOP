import java.util.ArrayList;

public class Shape {
	private ArrayList<Point> points;

	public Shape(){
		points = new ArrayList<>();
	}

	public void addPoint(Point p){
			points.add(p);
	}
	public void addPoint(int x, int y){
			points.add(new Point(x, y));
	}
	public void addPoints(Point ... points){
		for(Point p: points)
			this.points.add(p);
	}
	public void addPoints(ArrayList<Point> points){
		for(Point p: points)
			this.points.add(p);
	}
	public void addPoints(Shape shape){
		ArrayList<Point> ps = shape.getPoints();
		for(Point p: ps)
			this.points.add(p);
	}


	
	public ArrayList<Double> getSides(){
		ArrayList<Double> sides = new ArrayList<>();
		for(int i=0; i<points.size()-1; i++)
			sides.add(points.get(i).distance(points.get(i+1)));
		if(sides.size() > 2) // Если это не линия
			sides.add(points.get(0).distance(points.get(points.size()-1)));
		return sides;
	}

	public double calculatePerimeter(){
		ArrayList<Double> sides = getSides();
		double sum = 0;
		for(int i=0; i<sides.size(); i++)
			sum += sides.get(i);
		return sum;
	}

	public double getLongestSide(){
		if(points.size() < 2)
			return 0;

		ArrayList<Double> sides = getSides();

		double max = sides.get(0);

		for(int i=0; i<sides.size(); i++)
			max = Math.max(max, sides.get(i));
		
		return max;
	}
	
	public double getAverageLength(){	
		return calculatePerimeter() / points.size();
	}

	@Override
	public String toString(){
		StringBuffer sb = new StringBuffer();
		for(Point p: points)
			sb.append("x: ").append(p.getX()).append(", y: ").append(p.getY()).append("\n");
		return sb.toString();
	}

	public ArrayList<Point> getPoints(){
		return points;
	}
}