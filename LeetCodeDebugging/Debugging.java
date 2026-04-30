package com.java.DSA.LeetCodeDebugging;

public class Debugging {
    public static void main(String[] args){
        System.out.println(specialArray(new int[]{0,4,3,0,4}));
    }
    public static int specialArray(int[] nums) {
        int x = nums.length;
        int count = 0;
        for(int i = x; i >= 0; i--){
            for(int j = 0; j < x; j++){
                if(i <= nums[j])
                    count++;
            }
            if(count == i)
                return i;
            count = 0;
        }
        return -1;
    }
}
