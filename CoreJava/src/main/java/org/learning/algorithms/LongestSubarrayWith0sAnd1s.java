package org.learning.algorithms;

import java.util.HashMap;
import java.util.Map;

public class LongestSubarrayWith0sAnd1s {


    static int findLongestSubarray(int[] arr){
        Map<Integer,Integer> lengthMap = new HashMap<>();
        int[] prefixSum = new int[arr.length];
        for(int i=0;i<arr.length;i++){
            if(arr[i]==0){
                arr[i] = -1;
            }
        }
        int maxLength = 0;
        lengthMap.put(0,-1);
        prefixSum[0] = arr[0];
        lengthMap.put(prefixSum[0],0);
        for(int i=1;i<arr.length;i++){
            prefixSum[i] = prefixSum[i-1] + arr[i];
            if (lengthMap.containsKey(prefixSum[i])) {
                int prevIndex = lengthMap.get(prefixSum[i]);
                maxLength = Math.max(maxLength, i - prevIndex);
            } else {
                lengthMap.put(prefixSum[i], i);
            }
        }
        return maxLength;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{0,1};
        int result = findLongestSubarray(arr);
        System.out.println("Length of the longest subarray with equal number of 0s and 1s: " + result);
    }
}
