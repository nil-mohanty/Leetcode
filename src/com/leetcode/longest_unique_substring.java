package com.leetcode;

import java.util.HashSet;

public class longest_unique_substring {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println("Output is "+lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        int start = 0;
        int end = 0;
        int maxSize = 0;

        HashSet<Character> countOfChars = new HashSet<Character>();
        while(end<s.length())
        {
            if(countOfChars.contains(s.charAt(end)))
            {
                countOfChars.remove(s.charAt(start));
                start++;
            }
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
