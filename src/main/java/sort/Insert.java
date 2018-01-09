package sort;

import org.junit.Test;

public class Insert {
    public void insertSort(){
        int[] arr = RandomArray.creatArray(10);
        int temp ;
        System.out.print("有序数组：");
        for (int i = 0;i<arr.length;i++){
            for(int j=0;j<=i;j++){
                if(arr[i]<arr[j]){
                    temp=arr[i];
                    // 将k到i个数组后移
                    for (int k=i;k>j;k--){
                        arr[k]=arr[k-1];
                    }
                    arr[j]=temp;
                }
            }
        }
        for (int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }

    }

    @Test
    public void testInsert(){
        Insert insert = new Insert();
        insert.insertSort();
    }
}
