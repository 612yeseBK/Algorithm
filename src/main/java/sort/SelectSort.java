package sort;

import org.junit.Test;

public class SelectSort {
    public void selectSort(){
        int[] arr = RandomArray.creatArray(10);
        int temp ;
        System.out.print("选择排序后的数组：");
        /**
         * 将遍历未排序数组找到最小的一个放在已排序部分的合适位置
         */
        for (int i = 0;i<arr.length;i++){
            for(int k=i;k<arr.length;k++){
                if (arr[k]<arr[i]){
                    temp = arr[i];
                    arr[i]=arr[k];
                    arr[k]=temp;
                }
            }
            System.out.print(arr[i]+" ");
        }

    }

    @Test
    public void testBubble(){
        SelectSort selectSort = new SelectSort();
        selectSort.selectSort();
    }
}
