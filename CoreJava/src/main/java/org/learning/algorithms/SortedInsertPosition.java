package org.learning.algorithms;

import java.util.Arrays;
import java.util.Scanner;

public class SortedInsertPosition {

    static int getPositionInSortedArray(int[] arr, int key){

        int low = 0;
        int high = arr.length-1;

        while(low<=high){
            int mid = low + (high-low)/2;
            if(arr[mid]>key){
                high = mid-1;
            }else if(arr[mid]<key){
                low = mid+1;
            }
        }
        return high+1;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{2,4,6,7,20};
        Arrays.stream(arr).forEach(n -> System.out.print(n+" "));
        System.out.println();

        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the number which you want to insert into this sorted array");
        int key = sc.nextInt();

        System.out.println("The position where this key would be inserted is "+getPositionInSortedArray(arr,key));
    }
}
