package org.learning.algorithms;

import java.util.Scanner;

public class MaximumHeightStairCase_BinarySearch {

    static int getMaxHeight(int A){
        int count = 0;
        int i=1;
        int n = A;

        while(A>0){
            if(count==A) break;
            count++;
            A = A-count;
        }

        return count;
    }
    public static void main(String[] args) {
        System.out.println("Please enter the number of blocks with which we need to make the tallest staircase");
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();

        System.out.println("The maximum height of staircase can be "+getMaxHeight(A));
    }
}
