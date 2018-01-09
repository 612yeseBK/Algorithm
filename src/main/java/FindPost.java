import org.junit.Test;
import sort.RandomArray;

import java.util.HashMap;
import java.util.Map;

public class FindPost {
    /**
     * 假设 x1<x2<…<xn是实数，它们分别代表坐落在一条直线上的 n 个村庄。我们需要在其中一个村庄建一所邮局。
     * （1）设计一个高效的算法，用来求出邮局的位置，使得各村庄和该邮局之间的平均距离最小。
     * （2）设计一个高效的算法，求出邮局的位置，使得各村庄和该邮局之间的最大距离最小
     */
    public void findAverageMin(int[] arr){
        int min = 99999999;
        int[] len = new int[arr.length];
        int point = 9999999;
        Map map = new HashMap();
        for (int i =0;i<arr.length;i++){
            int sum = 0;
            for (int j = 0;j<arr.length;j++){
                sum +=Math.abs(arr[i]-arr[j]);
            }
            len[i] = sum;
            System.out.println("第"+(i+1)+"个点，总距离:"+sum);
            if (min>sum) {
                min=sum;
                point = i;
            }
        }
        System.out.println("最终结果：第"+(point+1)+"个点，总距离"+len[point]);
    }

    public void findMaxMin(int[] arr){
        int minInMax = 99999999;
        int[] len = new int[arr.length];
        int point = 9999999;
        for (int i =0;i<arr.length;i++){
            int max = 0;
            for (int j = 0;j<arr.length;j++){
                if(Math.abs(arr[i]-arr[j])>max){
                    max = Math.abs(arr[i]-arr[j]);
                }
            }
            len[i] = max;
            System.out.println("第"+(i+1)+"个点，最大距离:"+max);
            if(max<minInMax){
                point = i;
                minInMax = max;
            }
        }
        System.out.println("最终结果：第"+(point+1)+"个点，最短的最大距离为"+len[point]);
    }


    @Test
    public void testAverage(){
        FindPost findPost = new FindPost();
        int[] arr = RandomArray.creatArray(5);
        findPost.findAverageMin(arr);
    }
    @Test
    public void testMinInMax(){
        FindPost findPost = new FindPost();
        int[] arr = RandomArray.creatArray(5);
        findPost.findMaxMin(arr);
    }


}
