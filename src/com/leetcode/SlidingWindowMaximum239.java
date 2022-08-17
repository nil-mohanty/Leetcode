package com.leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SlidingWindowMaximum239 {
    public static void main(String[] args) {
        int arr [] = {1,3,-1,-3,5,3,6,7};
        int k=3;
        System.out.println("Output is "+ Arrays.toString(maxSlidingWindow2(arr,k)));
    }
    public static int [] maxSlidingWindow2 (int[] nums, int k)
    {
        //youtube link : https://www.youtube.com/watch?v=DfljaUwZsOk
        //Monotonically decreasing queue

        int ans[] = new int[nums.length-k+1];
        int j=0;
        Deque<Integer> queue = new ArrayDeque<Integer>();
        for(int i=0;i <k ; i++)
        {
            while(!queue.isEmpty() && nums[queue.peekLast()] <= nums[i])
                queue.pollLast();
            queue.addLast(i);
        }
        ans[j++]=nums[queue.peekFirst()];
        for(int i=k;i<nums.length;i++)
        {
            if(i-k>=queue.peekFirst())
                queue.pollFirst();
            while(!queue.isEmpty() && nums[queue.peekLast()] <= nums[i])
                queue.pollLast();
            queue.addLast(i);
            ans[j++]=nums[queue.peekFirst()];
        }
        return ans;
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int ans[] = new int[nums.length-k+1];
        int j=0;
        Deque<Integer> queue = new ArrayDeque<Integer>();
        for(int i=0;i <k ; i++)
        {
            while(!queue.isEmpty() && nums[queue.peekLast()] <= nums[i])
                queue.pollLast();
            queue.addLast(i);
        }
        ans[j++]=nums[queue.peekFirst()];
        for(int i=k;i<nums.length;i++)
        {
            if(i-k>=queue.peekFirst())
                queue.pollFirst();
            while(!queue.isEmpty() && nums[queue.peekLast()] <= nums[i])
                queue.pollLast();
            queue.addLast(i);
            ans[j++]=nums[queue.peekFirst()];
        }
        return ans;    }


}
