package NearestPoint;

import java.util.ArrayList;
import java.util.List;

public class Point implements Comparable<Point>{
    public float x;
    public float y;
    public Point(){};
    public Point(float x, float y){
        this.x = x;
        this.y = y;
    }

    public static List<Point> randomPoint(int num){
        List<Point> points = new ArrayList<Point>();
        for(int i = 0;i<num;i++){
            points.add(new Point((float)Math.random()*10,(float)Math.random()*10));
        }
        return points;
    }

    @Override
    public String toString() {
        return "("+this.x+","+this.y+")";
    }

    public int compareTo(Point point) {
        return this.x - point.x>0?1:-1;
    }
}
