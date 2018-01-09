package sort;

import org.junit.Test;

public class MergeSort {
    public void merge(int[] a,int[] b,int[] arr){
        int i = 0;
        int j = 0;
        int k = 0;
        /**
         * 比较a和b中的两个元素，将它们中较小的放入arr中，同时该指针后移
         */
        while (i <= a.length-1 && j <= b.length-1){
            if (a[i]<=b[j]) {
                arr[k++] = a[i];
                i++;
            } else {
                arr[k++] = b[j];
                j++;
            }
        }
        if (i > a.length-1) {
            for (;j <= b.length-1;j++){
                arr[k++] = b[j];
            }
        }
        if (j >b.length-1) {
            for (;i <= a.length-1;i++){
                arr[k++] = a[i];
            }
        }
    }
    public void mergeSort(int[] arr){
        int len = arr.length;
        /**
         * 当传入的数组长度只有一个时候，该数组不做改变，不需要再排序
         */
        if (len > 1) {
            int mid = len / 2; // 向下取整,mid指的a数组的长度
            int[] a = new int[mid];
            int[] b = new int[len - mid];
            int i;
            /**
             * 将数组前mid个拷贝给a数组，后len-mid个拷给b数组
             */
            for (i = 0; i <= mid - 1; i++) {
                a[i] = arr[i];
            }
            for (i = mid; i <= len - 1; i++) {
                b[i - mid] = arr[i];
            }
            /**
             * 对a和b数组进行排序，由于传入的是指针，数组也会改变，不用设置返回值
             */
            mergeSort(a);
            mergeSort(b);
            /**
             *对a和b数组进行合并，合并完成之后赋给原arr数组
             */
            merge(a, b, arr);
        }
    }

    @Test
    public void testMerge(){
        int[] arr = RandomArray.creatArray(10);
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(arr);
        System.out.print("归并排序得到的数组：");
        for (int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
