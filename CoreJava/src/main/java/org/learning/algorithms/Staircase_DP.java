package org.learning.algorithms;

import java.util.Arrays;
import java.util.Scanner;

public class Staircase_DP {

    private static long getNumberOfWaysToReachTheTop(int stairs, long mod, long[] memo){
        if(stairs <= 1){
            return 1;
        }
        if(stairs == 2)
            return 2;
        memo[stairs] = (getNumberOfWaysToReachTheTop(stairs-1,mod,memo) + getNumberOfWaysToReachTheTop(stairs-2,mod,memo))%mod;

        return memo[stairs]%mod;
    }
    public static void main(String[] args) {
        System.out.println("Enter the number of steps taken to reach the top");
        Scanner sc = new Scanner(System.in);
        int stairs = sc.nextInt();
        long mod = 1000000007;
        long[] memo = new long[stairs+1];
        Arrays.fill(memo,0);
        long ans = getNumberOfWaysToReachTheTop(stairs,mod,memo);
        System.out.println("The number of ways is "+ans);
    }
}
