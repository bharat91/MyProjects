package org.learning.algorithms;

import java.util.Arrays;

public class SingleElementInASortedArray {

    static int getSingleElementFromSortedArray(int[] arr){

        int low = 0;
        int high = arr.length-1;

        while(low<=high){
            int mid = low + (high-low)/2;
            if(mid>0 && arr[mid-1]==arr[mid]){
                mid--;
            }
            if(mid%2==0){
                low = mid+2;
            }else{
                high = mid-1;
            }
        }

        return arr[high];
    }
    public static void main(String[] args) {
        int[] arr = new int[]{2,2,4,4,6,7,7,8,8,20,20};
        Arrays.stream(arr).forEach(n -> System.out.print(n+" "));
        System.out.println();

        System.out.println("The single element which is present in this sorted array of elements repeated twice is "+getSingleElementFromSortedArray(arr));
    }
}
