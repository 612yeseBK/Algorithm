package BlackAndWhite;


import java.util.*;

/**
 * 给定平面上有 n 个白点和 n 个黑点，任意三点不共线，
 * 试实现一个分治算法将每个白点与一个黑点相连，使所有连线互不相交。
 */
public class BlkAndWht {
    // 返回连接好的不相交的线段和没有参与连接的点
    public Map findPointPairs(List<Point> points){
        Map map = new HashMap();
        List<Line> lines = new ArrayList<Line>();
        List<Point> unPoints = new ArrayList<Point>();
        int len = points.size();
        if (len==1) {
            map.put("lines",lines);
            map.put("unPoints",unPoints);
            return map;
        }
        if (len==2){
            // 两个点颜色不同就返回两个点的连线，否则，返回这两个点
            if (points.get(0).color!=points.get(1).color) {
                lines.add(new Line(points.get(0),points.get(1)));
                map.put("lines",lines);
                map.put("unPoints",unPoints);
                return map;
            } else{
                unPoints.add(points.get(0));
                unPoints.add(points.get(1));
                map.put("lines",lines);
                map.put("unPoints",unPoints);
                return map;
            }
        }
        // 将点集按x大小排列
        Collections.sort(points, new Comparator<Point>() {
            public int compare(Point o1, Point o2) {
                return o1.x>=o2.x?1:-1;
            }
        });
        // 如果分区的大小大于2的情况下，继续划分成两部分
        List<Point> left = points.subList(0,len/2);
        List<Point> right = points.subList(len/2,len);
        Map leftMap = findPointPairs(left);
        Map rightMap = findPointPairs(right);
        // 对两组结果进行合并
        map = merge(leftMap,rightMap);
        return map;
    }

    /**
     * 返回之后进行合并，
     * 合并时，先将两边的点按照y轴坐标进行排序，按照y轴的大小依次连接，这样这几条连线肯定不会和各自相交，
     * 但是有可能会和其他已经连好的线相交，如果某条线和其余的相交，那么对这些线段的点按照y值大小重新连接，
     * 这样新形成的线段之间绝对不会相交，但这时候新线段有可能会和原来的线段相交，所以需要做一下判断，
     * 如果有相交的就继续按照之前y值大小连接规则将这些相交的线段重新排列，
     * 最终一定会形成互不相交的线段簇~吧
     * （我感觉最终结果一定会收敛，但是不知道怎么证明，就当他收敛吧）。
     * leftMap 和 rightMap 包含了左右两个区间里面所有已连接的线和未连接的点，也就是包含了所有的点，信息足够了
     * @param leftMap
     * @param rightMap
     * @return
     */
    public Map merge(Map leftMap,Map rightMap){
        Map map = new HashMap();
        List<Point> unPoints = new ArrayList<Point>();
        List<Line> lines = new ArrayList<Line>();
        List<Point> lefUnPoints = (List)leftMap.get("unPoints");
        List<Point> rigUnPoints = (List)rightMap.get("unPoints");
        List<Line> lefLines = (List)leftMap.get("lines");
        List<Line> rigLines = (List)rightMap.get("lines");
        Comparator ycomparator = new Comparator<Point>() {
            public int compare(Point o1, Point o2) {
                return o1.y>=o2.y?1:-1;
            }
        };
        // 将左右两边未连接的点按照y大小进行排序
        Collections.sort(lefUnPoints,ycomparator);
        Collections.sort(rigUnPoints,ycomparator);
        lines.addAll(lefLines);
        lines.addAll(rigLines);
        unPoints.addAll(lefUnPoints);
        unPoints.addAll(rigUnPoints);
        // 如果有某一边没有未连接的点(unPoints)时，就将合并后的结果返回
        if (lefUnPoints.size()==0||rigUnPoints.size()==0){
            map.put("lines",lines);
            map.put("unPoints",unPoints);
            return map;
        }
        // 由于lefUnPoints和rigUnPoints已经经过了排序，所以这里的连接会按照从低到高逐次配对
        for (int i = 0;i<lefUnPoints.size();i++){
            for (int j = 0;j<rigUnPoints.size();j++){
                if (lefUnPoints.get(i).color!=rigUnPoints.get(j).color){
                    Line temp = new Line(lefUnPoints.get(i),rigUnPoints.get(j));
                    // 判断这条线是否和已经有的线段相交，如果相交就将所有相交的线段进行重排
                    // (重排后可能会与之前没有相交的线段再次相交，这个可以举例出来)
                    for (int k =0;k<lines.size();k++){
                        // 如果该条线段和已有的线段相交，就将这些线段记录下来，为以后重排做准备
                        if (Line.crossed(temp,lines.get(k))){
                            // TODO: 2018/1/3 我挂了，太难实现了，合并方法不好，对不起各位乡亲父老
                        }
                    }

                }
            }
        }

        return map;
    }
}
