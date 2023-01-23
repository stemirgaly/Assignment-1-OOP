import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.lang.Integer;

public class Main {
	public static void main(String[] args){
		new Main().run();
	}

	public void run(){
		Shape shape = new Shape();
		
		shape.addPoints(readPoints("dir\\file1.txt", ", "));
		shape.addPoints(readPoints("dir\\file2.txt", ", "));

		System.out.println(shape);
	}

	public Point[] readPoints(String dir, String split){
		ArrayList<Point> points = new ArrayList<>();
		try (Scanner sc = new Scanner(new File(dir))) {
			while(sc.hasNextLine()){
				String[] ps = sc.nextLine().split(split);
				int x = Integer.parseInt(ps[0]);
				int y = Integer.parseInt(ps[1]);
				points.add(new Point(x, y));
			}
		} catch(Exception e){
			e.printStackTrace();
		}
		return points.toArray(new Point[points.size()]);
	}
}