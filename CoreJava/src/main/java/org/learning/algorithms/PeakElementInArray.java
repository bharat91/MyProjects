package org.learning.algorithms;

import java.util.Arrays;

public class PeakElementInArray {

    static int getPeakElement(int[] arr){
        int low=0;
        int high = arr.length-1;

        while(low<=high){

            int mid = low + (high-low)/2;

            if(mid==high) return arr[mid];
            if(mid==0){
                if(arr[mid]<arr[mid+1]){
                    low = mid+1;
                }else{
                    return arr[mid];
                }
            }

            if(mid<arr.length && arr[mid]>arr[mid-1] && arr[mid]>arr[mid+1]){
                return arr[mid];
            }
            if(arr[mid]>arr[mid-1]){
                low = mid+1;
            }else {
                high = mid-1;
            }
        }
        return arr[high];
    }
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5};
                            //0, 1, 2, 3
        Arrays.stream(arr).forEach(n -> System.out.print(n+" "));
        System.out.println();

        System.out.println("The peak element for this array is "+getPeakElement(arr));
    }
}
