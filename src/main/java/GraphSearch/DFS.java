package GraphSearch;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DFS {
    public static void dfs(int[][] arr, int point, List<Integer> result,boolean[] visited){
        if (result.size()==arr.length){
            System.out.println("找完了");
            return ;
        }
        for (int i = 0;i<arr.length;i++){
            if (arr[point][i]==1&&!visited[i]){
                result.add(i);
                visited[i] = true;
                dfs(arr,i,result,visited);
            }
        }
    }

    @Test
    public void testdfs(){
        int[][] arr = {
                {0,1,0,0,0,0,1,1,0,1},
                {1,0,1,0,0,0,0,1,0,0},
                {0,1,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,1,1,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,1,0,0,1,0,0,0},
                {1,0,0,1,0,1,0,0,0,0},
                {1,1,0,0,0,0,0,0,1,0},
                {0,0,0,0,0,0,0,1,0,0},
                {1,0,0,0,0,0,0,0,0,0}
        };
        List<Integer> result = new ArrayList<Integer>();
        boolean[] visited = new boolean[arr.length];
        for (int i =0;i<arr.length;i++){
            visited[i] = false;
        }
        for (int j = 0;j<arr.length;j++){
            if (!visited[j]){
                visited[j] = true;
                result.add(j);
                dfs(arr,j,result,visited);
            }
        }
        for (int i=0;i<result.size();i++){
            System.out.println(result.get(i)+1);
        }
    }

    // 非递归的栈
//    public static List dfs2(int[][] arr,int point,boolean[] visited,Stack<Integer> stack,List<Integer> result){
////        stack.push(point);
////        visited[point]=true;
////        result.add(point);
//        while (!stack.empty()){
//            int now = stack.pop();
//            for (int i = 0;i<arr.length;i++){
//                if (arr[now][i]==1&&!visited[i]){
//                    visited[i] = true;
//                    stack.push(i);
//                    result.add(i);
//                }
//            }
//        }
//        return result;
//    }

    public static void exist(int[][] arr,boolean[] visited,int now){

    }

    @Test
    public void testdfs2(){
        int[][] arr = {
                {0,1,0,0,0,0,1,1,0,1},
                {1,0,1,0,0,0,0,1,0,0},
                {0,1,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,1,1,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,1,0,0,1,0,0,0},
                {1,0,0,1,0,1,0,0,0,0},
                {1,1,0,0,0,0,0,0,1,0},
                {0,0,0,0,0,0,0,1,0,0},
                {1,0,0,0,0,0,0,0,0,0}
        };
        List<Integer> result = new ArrayList<Integer>();
        Stack<Integer> stack = new Stack<Integer>();
        boolean[] visited = new boolean[arr.length];
        for (int i =0;i<arr.length;i++){
            visited[i] = false;
        }
        for (int j = 0;j<arr.length;j++){
            if (!visited[j]){
                stack.push(j);
                visited[j] = true;
                result.add(j);
                while (!stack.empty()){
                    int now = stack.peek();
                    // 如果有相连的，就压栈，如果没有，则出栈。todo
                    for (int i = 0;i<arr.length;i++){
                        if (arr[now][i]==1&&!visited[i]){
                            visited[i] = true;
                            stack.push(i);
                            result.add(i);
                        }
                    }
                }
            }
        }
        for (int i=0;i<result.size();i++){
            System.out.println(result.get(i)+1);
        }
    }
}
