package org.learning.algorithms;

import java.util.Arrays;

public class InversionCountInArray {

    static int getInversionCount(int[] arr,int start,int end, int mod){

        int count = 0;
        for(int i=0;i<arr.length-1;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]>arr[j]){
                    count = (count+1)%mod;
                }
            }
        }

        while(start<end){
            if(arr[end]<arr[start]) count = (count+1)%mod;
            end--;
        }

        return count;
    }
    public static void main(String[] args) {

        int mod = 1000000007;
        int[] arr = new int[]{3, 4, 1, 2};
        Arrays.stream(arr).forEach(n -> System.out.print(n+" "));
        System.out.println();

        int ans = getInversionCount(arr,0,arr.length-1,mod);
        System.out.println("Inversion Count is "+ans);
    }
}
