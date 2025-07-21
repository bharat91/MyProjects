package org.learning.algorithms;

import java.util.HashMap;
import java.util.Map;

public class PrefixSumEqualsK {

    static int solve(int[] arr, int target){
        int ans = 0;

        int[] prefixSum = new int[arr.length];
        Map<Integer,Integer> sumMap = new HashMap<>();
        sumMap.put(0, 1);
        prefixSum[0] = arr[0];
        sumMap.put(prefixSum[0], 1);
        for(int i=1;i<arr.length;i++){

            prefixSum[i] = prefixSum[i-1] + arr[i];
            if(sumMap.containsKey(prefixSum[i] - target)){
                ans += sumMap.get(prefixSum[i] - target);
            }
            sumMap.put(prefixSum[i], sumMap.getOrDefault(prefixSum[i], 0) + 1);
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{1,-1,0};
        int count = solve(arr,0);
        System.out.println("Count of subarrays with sum equals to k: " + count);
    }
}
