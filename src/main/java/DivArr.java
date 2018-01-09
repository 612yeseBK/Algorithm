import org.junit.Test;

public class DivArr {
    // 将一个数组分割成两个互不相交但是和相等的子集
    public void divArr(int[] arr){
        int len = arr.length;
        int sum = 0;
        int[] temp= new int[len];
        boolean[] visited = new boolean[len];
        for (int i = 0;i<len;i++){ // 初始化所求子集合元素为0
            temp[i]=0;
            visited[i]=false;
        }
        temp[0] = arr[0];
        visited[0] = true;//初始化子集的第一个元素为输入集合的第一个元素
        for (int i = 0; i<len ;i++){
            sum +=arr[i];
        }
        if (sum%2 == 1) {
            System.out.println("集合为奇数，无法完成分割");
        } else {
            dfs(arr,sum,temp,visited,1);
        }
    }

    public void dfs(int[] arr,int sum,int[] temp,boolean[] visited,int step){
        int tempsum = 0;
        for (int i=0;i<temp.length;i++){
            tempsum +=temp[i];
        }
        if (tempsum==sum/2){
            System.out.print("找到的集合为：{ ");
            for (int j = 0; j < step; j++) {
                System.out.print(temp[j] + " ");
            }
            System.out.print("}");
            System.out.print(",{ ");
        for (int i = 0;i<arr.length;i++) { // 找到除了所求集合的另一个子集合
            if (!check(temp,arr[i])){
                System.out.print(arr[i]+" ");
            }
        }
            System.out.println("}");
        } else if (tempsum>sum/2){
//            System.out.println("退出此次迭代");
        } else {
            for (int i = 0;i<arr.length;i++){
                if (!visited[i]){
                    visited[i]=true;
                    temp[step] = arr[i];
                    dfs(arr,sum,temp,visited,step+1);
                    visited[i]=false;
                    temp[step] = 0;
                }
            }
        }
    }

    public boolean check(int[] arr,int ck){
        for (int i : arr){
            if (i==ck){
                return true;
            }
        }
        return false;
    }
    @Test
    public void testDivArr(){
        int[] arr = new int[]{1,5,2,4};
        DivArr divArr = new DivArr();
        divArr.divArr(arr);
    }
}
