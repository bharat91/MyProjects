package org.learning.algorithms;

import java.util.HashMap;
import java.util.Map;

public class LongestSubarrayWithSumModK {

    static int findLongestSubarray(int[] arr, int k) {
        Map<Integer, Integer> modMap = new HashMap<>();
        int maxLength = 0;
        int prefixSum = 0;

        modMap.put(0, -1);

        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];
            int modValue = ((prefixSum % k) + k) % k;

            if (modMap.containsKey(modValue)) {
                int prevIndex = modMap.get(modValue);
                maxLength = Math.max(maxLength, i - prevIndex);
            } else {
                modMap.put(modValue, i);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 7, 6, 1, 4, 5};
        int k = 3;
        int result = findLongestSubarray(arr, k);
        System.out.println("Length of the longest subarray with sum divisible by " + k + ": " + result);
    }
}
