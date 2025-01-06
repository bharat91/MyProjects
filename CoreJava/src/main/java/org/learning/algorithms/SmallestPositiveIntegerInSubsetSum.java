package org.learning.algorithms;

import java.util.Arrays;

public class SmallestPositiveIntegerInSubsetSum {

    static int smallestNotASubsetSum(int[] arr){

        Arrays.sort(arr);
        int smallest = 1;
        for(int i=0;i<arr.length;i++){
            if(smallest < arr[i]) return smallest;
            smallest += arr[i];
        }

        return smallest;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{5,7,2,4,9,10,1,13};
        Arrays.stream(arr).forEach(n -> System.out.print(n+" "));
        System.out.println();

        System.out.println("Smallest positive integer not a sum of any subset in the above array is "+smallestNotASubsetSum(arr));
    }
}
