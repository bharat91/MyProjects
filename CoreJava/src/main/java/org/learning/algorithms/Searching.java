package org.learning.algorithms;

import java.util.Arrays;

public class Searching {

    static int getPositionByLinearSearch(int[] arr, int elementToFind){
        int index = -1;

        for(int i=0;i<arr.length;i++){
            if(elementToFind == arr[i]){
                index = i;
                return index;
            }
        }

        return index;
    }

    static int getPositionByBinarySearch(int[] arr, int elementToFind){
        Arrays.sort(arr);

        int left = 0;
        int right = arr.length-1;

        int mid = -1;

        while(left<=right){
            mid = (left+right)/2;
            if(arr[mid] > elementToFind){
                right = mid-1;
            }else if(arr[mid] < elementToFind){
                left = mid+1;
            }else if(arr[mid] == elementToFind){
                return mid;
            }
        }

        return -1;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{5,7,2,4,9,10,1,13};
        Arrays.stream(arr).forEach(n -> System.out.print(n+" "));
        System.out.println();

        //System.out.println("The element that you are searching for is in this array at the index "+getPositionByLinearSearch(arr,10));
        System.out.println("The element that you are searching for is in this array at the index "+getPositionByBinarySearch(arr,10));
    }
}
