package sort;

import java.util.Random;

public class RandomArray {
    public static int[] creatArray(int alength){
        Random random = new Random();
        int[] arr = new int[alength];
        System.out.print("无序数组：");
        for(int i=0; i<arr.length;i++) {
            arr[i] = random.nextInt(100);
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        return arr;
    }

}
