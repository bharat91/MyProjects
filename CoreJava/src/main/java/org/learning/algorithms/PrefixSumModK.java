package org.learning.algorithms;

import java.util.HashMap;
import java.util.Map;

public class PrefixSumModK {

    static int solve(int[] arr, int target){
        int ans = 0;

        int[] prefixSum = new int[arr.length];
        Map<Integer,Integer> sumMap = new HashMap<>();
        sumMap.put(0, 1);

        prefixSum[0] = arr[0];
        int modValue0 = ((prefixSum[0] % target) + target) % target;
        ans += sumMap.getOrDefault(modValue0, 0);
        sumMap.put(modValue0, sumMap.getOrDefault(modValue0, 0) + 1);

        for(int i=1;i<arr.length;i++){

            prefixSum[i] = prefixSum[i-1] + arr[i];
            int modValue = ((prefixSum[i] % target) + target) % target;
            ans += sumMap.getOrDefault(modValue, 0);
            sumMap.put(modValue, sumMap.getOrDefault(modValue, 0) + 1);
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{4, 5, 0, -2, -3, 1};
        int count = solve(arr,5);
        System.out.println("Count of subarrays with sum divisible by k: " + count);
    }
}
