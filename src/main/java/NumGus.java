import org.junit.Test;

/**
 * gyw
 * 2017/12/22
 */
public class NumGus {
    // 给出字母表达的等式，求出各字母所代表的数字
    public void numGus(){
        int[] arr = new int[]{0,0,0,0}; // 四个数字分别表示A.B.C.D
        boolean[] visited = new boolean[10];
        for (int i=0;i<10;i++){
            visited[i] = false;//初始化所有数字没有被访问过
        }
        dfs(arr,visited,0);

    }

    public void dfs(int[] arr,boolean[] visited,int step){
        if (step==4){
            check(arr);
        } else if(step<4){
            for (int i = 0;i<10;i++){
                if(!visited[i]){
                    visited[i]=true;
                    arr[step] = i;
                    dfs(arr,visited,step+1);
                    visited[i]=false;
                    arr[step]= 0;
                }
            }
        }
    }
    public void check(int[] arr){// 检查ABCD四个值是否满足所给的等式，ABCAB*A=DDDDDD
        int DDDDDD = arr[3]*111111;
        int A = arr[0];
        int ABCAB = arr[1]+arr[0]*10+arr[2]*100+arr[1]*1000+arr[0]*10000;
        if(A*ABCAB==DDDDDD){
            System.out.println("ABCAB = "+ABCAB+",DDDDDD = "+DDDDDD+",A = "+arr[0]);
            System.out.println(ABCAB+" * "+A+" = "+DDDDDD);
        }
    }

    @Test
    public void testNumGus(){
        NumGus numGus = new NumGus();
        numGus.numGus();
    }
}
