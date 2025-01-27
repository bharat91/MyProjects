package org.learning.algorithms;

public class Sixlets_Recursion {

    /*
    Recursion with approach: step into recursion and accumulate answer
     */
    static int generateSubsequenceSumApproach1(int[] arr, int index, int sum, int currSize, int finalSize){

        if(sum>1000) return 0;
        if(currSize == finalSize) return 1;
        if(index >= arr.length) return 0;

        int not_taken = generateSubsequenceSumApproach1(arr,index+1, sum, currSize,finalSize);

        int taken = generateSubsequenceSumApproach1(arr,index+1,sum+arr[index], currSize+1,finalSize);

        return not_taken+taken;
    }

    /*
    Recursion with approach: step into recursion and solve together
     */
    static int generateSubsequenceSumApproach2(int[] arr, int index, int sum, int currentSize, int finalSize){
        if(index == arr.length){
            if(sum<=1000 && currentSize == finalSize){
                return 1;
            }else{
                return 0;
            }
        }
        int element = arr[index];
        sum += element;
        int taken = generateSubsequenceSumApproach2(arr, index+1, sum,currentSize+1,finalSize);
        sum -= element;
        int not_taken = generateSubsequenceSumApproach2(arr,index+1,sum, currentSize, finalSize);

        return taken+not_taken;

    }

    public static void main(String[] args) {
        int[] arr = new int[]{5, 17, 1000, 11};
        //System.out.println("The number of subsequences of this array of size 2 having sum <= 1000 is "+generateSubsequenceSumApproach1(arr,0,0, 0, 2));
        System.out.println("The number of subsequences of this array of size 2 having sum <= 1000 is "+generateSubsequenceSumApproach2(arr,0,0, 0, 4));
    }
}
