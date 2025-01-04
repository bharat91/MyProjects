package org.learning.algorithms;

import java.util.Arrays;
import java.util.Scanner;

public class KthSmallestElementInArray {

    static int count = 0;
    static class MinProps{
        int ind;
        int val;

        public MinProps(int ind, int val) {
            this.ind = ind;
            this.val = val;
        }

        public int getInd() {
            return ind;
        }

        public void setInd(int ind) {
            this.ind = ind;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }
    }
    static MinProps findMin(int[] arr, int indexToStartFrom){
        int min = Integer.MAX_VALUE;
        count++;
        int indexOfMin = -1;
        for(int i=indexToStartFrom;i<arr.length;i++){
            if(arr[i]<min){
                min = arr[i];
                indexOfMin = i;
            }
        }
        return new MinProps(indexOfMin,min);
    }

    static void swap(int[] arr, int originalIndex, int minIndex){
        int temp = arr[minIndex];
        arr[minIndex] = arr[originalIndex];
        arr[originalIndex] = temp;
    }
    static int findKth(int[] arr, int k){

        for(int i=0;i<arr.length;i++){
            MinProps m = findMin(arr,i);
            swap(arr,i,m.getInd());
            if(count==k)
                return m.getVal();
        }
        return 0;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{5,7,2,4,9,10,1,13};
        Arrays.stream(arr).forEach(n -> System.out.print(n+" "));
        System.out.println();
        System.out.println("Please enter the value of k to find the kth smallest number in the above array");
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        if(k>arr.length || k<1){
            throw new IllegalArgumentException("Please enter a valid K");
        }
        System.out.println("Kth smallest number in this array is "+findKth(arr,k));
    }
}
