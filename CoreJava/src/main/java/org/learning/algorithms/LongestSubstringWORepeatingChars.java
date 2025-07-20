package org.learning.algorithms;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWORepeatingChars {

    static int solve(String word){
        int maxTillNow = 0;
        Set<Character> charSet = new HashSet<>();

        int start = 0;
        int end = start+1;
        charSet.add(word.charAt(start));
        while(start<=end && end<word.length()){
            if(charSet.contains(word.charAt(end))){
                maxTillNow = Math.max(maxTillNow,end-start);
                while (charSet.contains(word.charAt(end))) {
                    charSet.remove(word.charAt(start));
                    start++;
                }
                charSet.add(word.charAt(end));
            }else{
                charSet.add(word.charAt(end));
            }
            end++;
        }
        return maxTillNow;
    }

    public static void main(String[] args) {
        String word = "bbbbb";
        int count = solve(word);
        System.out.println("The longest substring which can be formed without repeating characters has a length of "+count);
    }
}
