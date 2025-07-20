package org.learning.algorithms;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {


    static int[] solve(int[] arr, int k){
        int[] res = new int[2];

        Map<Integer, Integer> indexMap = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(!indexMap.containsKey(k-arr[i])){
                indexMap.putIfAbsent((arr[i]),i);
            }else{
                res[0] = indexMap.get(k-arr[i]);
                res[1] = i;
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,7,11,15};
        int k = 9;
        int[] res = solve(arr,k);
        System.out.println("The indices whose values sum up to the target "+k+" are "+res[0]+" and "+res[1]);
    }
}
