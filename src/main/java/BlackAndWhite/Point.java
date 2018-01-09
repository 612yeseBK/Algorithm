package BlackAndWhite;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Point {
    public float x;
    public float y;
    // true代表白；false代表黑
    public boolean color;
    public int num;
    public Point(){}
    public Point(float x, float y,boolean color,int num){
        this.x = x;
        this.y = y;
        this.color = color;
        this.num = num;
    }

//    public static List<Point> randomPoint(int num){
//        List<Point> points = new ArrayList<Point>();
//        Random random = new Random();
//        for(int i = 0;i<num;i++){
//            points.add(new Point((float)Math.random()*10,(float)Math.random()*10, random.nextBoolean(),i));
//        }
//        return points;
//    }
    public String toString() {
        return color?"white":"black "+"("+this.x+","+this.y+")";
    }
}
