package sort;

import org.junit.Test;

public class QickSork {
    public int[] qickSort1(int[] arr,int left,int right){
        if(left<right) {
            int temp;
            int lefto = left;
            int righto = right;
            int pointval = arr[left];
            while (left < right) {
                while (arr[right] >= pointval && left < right) {
                    right--;
                }
                temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                while (arr[left] <= pointval && left < right) {
                    left++;
                }
                temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }

            qickSort1(arr, lefto, left - 1);
            qickSort1(arr, left + 1, righto);
        }
        return arr;


    }

    public int[] qickSort2(int[] arr,int left,int right){
        if(left<right) {
            int temp;
            int lefto = left;
            int righto = right;
            int pointval = arr[left];
            while (left < right) {
                /**
                 * 考虑几种特殊情况：
                 * 当中轴点是最小点时，right会跑到lefto的位置，而left会跑到righto的位置，这时候可以正常进行划分，返回的划分点是lefto
                 * 当中轴点是最大点时，right会留在righto的位置，而left会跑到lefto的位置，这时候可以正常进行划分，返回的划分点是righto
                 * 当交汇位置在中间且arr中只有一个pointval时，就可以right就会在左右两半中小区间最右侧，left会在大区间最左侧，交换right和lefto的值就把pointval放到了划分的位置
                 * 当交汇位置在中间且中间是多个pointval的连续排列，这时候right就会在连续pointval的最左侧过去一个，这也是小区间最右侧的位置，可以满足划分的要求
                 * 当整个数组全是一个值的时候，right会在lefto的位置，left会在righto的位置，这时候可以正常划分
                 */
                while (arr[right] >= pointval && right > lefto) {
                    right--;
                }
                while (arr[left] <= pointval && left < righto) {
                    left++;
                }
                /**
                 * 将左右找到的值进行交换，不过会导致交界处最后一次不需要的交换，所以需要改回来
                 */
                temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
            // 当right<=left时，退出循环前做了一次不需要的交换，所以这里需要再换回来
            temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            /**
             * 将right下标对应的值与初始值交换，把pointval放到一个合适的位置
              */
            temp = arr[lefto];
            arr[lefto] = arr[right];
            arr[right] = temp;
            /**
             * 接下来以right为分界线对左右两边使用快排
             * 由上述分析：
             * right的位置是lefto会出现这种情况，这时候根本不存在左半区间
             * 同时也会出现区分点在right-1的位置，n那么右半区间只有一个元素，就不要排序了
             * 所以只有left<right才需要进行排序
              */
            qickSort2(arr, lefto, right - 1);
            qickSort2(arr, right + 1, righto);
        }
        return arr;


    }

    @Test
    public void testQick1(){
        int[] arr = RandomArray.creatArray(10);
        QickSork qickSork = new QickSork();
        arr = qickSork.qickSort1(arr,0,arr.length-1);
        System.out.print("快速排序算法1得到的数组：");
        for (int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }

    @Test
    public void testQick2(){
        int[] arr = RandomArray.creatArray(10);
        QickSork qickSork = new QickSork();
        arr = qickSork.qickSort2(arr,0,arr.length-1);
        System.out.print("快速排序算法2得到的数组：");
        for (int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
