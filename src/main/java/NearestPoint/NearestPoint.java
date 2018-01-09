package NearestPoint;

import org.junit.Test;

import java.util.Collections;
import java.util.List;

public class NearestPoint {
    // 用以保存两个最近点对
    public static Point p1;
    public static Point p2;
    // 计算两个点之间的距离
    public double cdistance(Point a, Point b){
        return Math.sqrt(Math.pow(a.x-b.x,2)+Math.pow(a.y-b.y,2));
    }

    // 返回左右集合合并之后的最近值
    public double merge(double dis,float midPlace,List<Point> left,List<Point> right){
        double min = dis;
        double temp;
        for (int i = 0;i<left.size();i++){
            if (left.get(i).x-midPlace<dis){
                for (int j = 0;j<right.size();j++){
                    if((right.get(j).x-left.get(i).x<dis) && (right.get(j).y-left.get(i).y<dis)){
                        temp = cdistance(right.get(j),left.get(i));
                        if (temp<min){
                            NearestPoint.p1 = right.get(j);
                            NearestPoint.p2 = left.get(i);
                            min = temp;
                        }
                    }
                }
            }
        }
        return min;
    }
    /**
     * 计算最近点距离
     * @param points
     */
    public double findNearestPoint(List<Point> points){
        double dis;
        int len = points.size();
        if (len==1) {
            dis = 999999;
            return dis;
        }
        if (len==2){
            NearestPoint.p1 = points.get(0);
            NearestPoint.p2 = points.get(1);
            dis = cdistance(points.get(0),points.get(1));
            return dis;
        }
        Collections.sort(points);
        float midPlace = points.get(len/2).x;
        List<Point> left = points.subList(0,len/2);
        List<Point> right = points.subList(len/2,len);
        double disL = findNearestPoint(left);
        double disR = findNearestPoint(right);
        dis = disL<disR?disL:disR;
        dis = merge(dis,midPlace,left,right);
        System.out.println(dis);
        return dis;
    }

    @Test
    public void testNearestPoint(){
        List<Point> points = Point.randomPoint(20);
        NearestPoint nearestPoint = new NearestPoint();
        double dis = nearestPoint.findNearestPoint(points);
        System.out.println("最近点为"+NearestPoint.p1+"和"+NearestPoint.p2);
        System.out.println("距离为："+ dis);
    }

}
