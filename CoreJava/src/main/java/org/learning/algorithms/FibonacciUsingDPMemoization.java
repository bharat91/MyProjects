package org.learning.algorithms;

import java.util.Arrays;
import java.util.Scanner;

public class FibonacciUsingDPMemoization {

    public static int fibonacci(int num, int[] fib){
        if(fib[num]!=-1){
            return fib[num];
        }
        fib[num] = fibonacci(num-1,fib) + fibonacci(num-2,fib);
        return fib[num];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the number upto which you want to see the fibonacci sequence\n");
        int num = sc.nextInt();
        int[] fib = new int[100]; //random large size given
        Arrays.fill(fib,-1);
        fib[0] = 0;
        fib[1] = 1;

        System.out.println("The fibonacci value for that number is "+fibonacci(num, fib));

        Arrays.stream(fib).forEach(n -> System.out.print(n+" "));
        System.out.println();
    }
}
