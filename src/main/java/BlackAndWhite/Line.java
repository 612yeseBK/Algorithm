package BlackAndWhite;

public class Line {
    public Point left;
    public Point right;

    public Line(){}
    public Line(Point left,Point right){
        this.left = left;
        this.right = right;
    }
    /** 由于本题中任意三点不共线，所以这个判断只针对这个前提
     * 这里只需要判断线段的端点在另一条线段所在直线的两侧就好了
     * @param line1
     * @param line2
     * @return
     */
    public static boolean crossed(Line line1, Line line2){
        // line1 所在的直线(y-line1.a.y)*(line1.a.x-line1.b.x)-(x-line1.a.x)*(line1.a.y-line1.b.y)=0
        // line2 所在的直线(y-line2.a.y)*(line2.a.x-line2.b.x)-(x-line2.a.x)*(line2.a.y-line2.b.y)=0

        double f2a = (line2.left.y-line1.left.y)*(line1.left.x-line1.right.x)-(line2.left.x-line1.left.x)*(line1.left.y-line1.right.y);
        double f2b = (line2.right.y-line1.left.y)*(line1.left.x-line1.right.x)-(line2.right.x-line1.left.x)*(line1.left.y-line1.right.y);
        // f2a*f2b>0表示line2.a与line2.b在line1所在直线的同一侧
        if (f2a*f2b>0) return false;
        // 如果不在同一侧在验证另一条线段的端点
        double f1a = (line1.left.y-line2.left.y)*(line2.left.x-line2.right.x)-(line1.left.x-line2.left.x)*(line2.left.y-line2.right.y);
        double f1b = (line1.right.y-line2.left.y)*(line2.left.x-line2.right.x)-(line1.right.x-line2.left.x)*(line2.left.y-line2.right.y);
        if (f1a*f1b>0) return false;
        // 都不在同一侧就表示两条线段相交，返回true
        return true;
    }
}
