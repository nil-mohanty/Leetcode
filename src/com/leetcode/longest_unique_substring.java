package com.leetcode;

import java.util.HashSet;

public class longest_unique_substring {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println("Output is "+lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        int start = 0; //Pointer for begining
        int end = 0; // Pointer to move till the end
        int maxSize = 0; //hold the final output

        HashSet<Character> countOfChars = new HashSet<Character>(); // Hashset to check uniqueness of char
        while(end<s.length()) // till end reaches the end of the string
        {
            // if char is found, uniqueness violated; increase start index and remove the char at the start
            if(countOfChars.contains(s.charAt(end)))
            {
                countOfChars.remove(s.charAt(start));
                start++;
            }
            // if not found proceed , add the end char to hashset and proceed with maxSize updation
            else
            {
                countOfChars.add(s.charAt(end));
                end++;
                maxSize = Math.max(maxSize,countOfChars.size());
            }
        }
        return maxSize;

    }
}
