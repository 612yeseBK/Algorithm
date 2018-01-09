package GraphSearch;

import BlackAndWhite.Line;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {
    public static List bfs (int[][] arr, int start) {
        int len = arr.length;
        List<Integer> result=new ArrayList<Integer>(); //
        boolean[] visited = new boolean[len];
        for (int i = 0;i<len;i++){
            visited[i] = false;
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(start);
        result.add(start);
        visited[start] = true;
        while (!queue.isEmpty()){
            int now = queue.poll();
            for (int i = 0;i<len;i++){
                if (arr[now][i]==1&&!visited[i]){
                    queue.add(i);
                    visited[i] = true;
                    result.add(i);
                }
            }
        }
        return result;
    }

    public void dfsRecursion(){

    }

    @Test
    public void testbfs(){
        int[][] arr = {
                {0,1,1,0,0,0,0,0,0},
                {1,0,1,0,0,0,0,0,0},
                {1,1,0,1,0,0,0,0,0},
                {0,0,1,0,1,1,0,1,0},
                {0,0,0,1,0,0,0,0,0},
                {0,0,0,1,0,0,1,1,0},
                {0,0,0,0,0,1,0,0,0},
                {0,0,0,1,0,1,0,0,1},
                {0,0,0,0,0,0,0,1,0}
        };
        List<Integer> list = bfs(arr,4);
        for (int i=0;i<list.size();i++){
            System.out.println(list.get(i)+1);
        }
    }
}
