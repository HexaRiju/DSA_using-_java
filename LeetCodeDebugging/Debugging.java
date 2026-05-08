package com.java.DSA.LeetCodeDebugging;

import java.util.*;

public class Debugging {
    public static void main(String[] args){
        //System.out.println(specialArray(new int[]{0,4,3,0,4}));
//        int[] nums1 = {1,2,3,0,0,0};
//        int[] nums2 = {2,5,6};
//        merge(nums1,3,nums2,3 );
//        //System.out.println(Arrays.toString(nums1));
//        System.out.println(thirdMax(new int[] {1,2,-2147483648}));
        System.out.println(threeSum(new int[] {2,-3,0,-2,-5,-5,-4,1,2,-2,2,0,2,-4,5,5,-10}));

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
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int []arr = new int [m + n];
        int i = 0;
        int j = 0;
        int k = 0;
        while(i < m && j < n){
            if(nums1[i] <= nums2[j]){
                arr[k++] = nums1[i++];
            }
            else{
                arr[k++] = nums2[j++];
            }
        }
        while(i < m){
            arr[k++] = nums1[i++];
        }
        while(j < n){
            arr[k++] = nums2[j++];
        }
        k = 0;
        while(k < m + n){
            nums1[k] = arr[k];
            k++;
        }
    }
        public static int thirdMax(int[] nums) {
            Set<Integer> set = new HashSet<>();
            for(int x : nums)
                set.add(x);
            List<Integer> list = new ArrayList<>(set);
            int max3 = Integer.MIN_VALUE;
            if(list.size() < 3) {
                for (int i : list)
                    max3 = Math.max(max3, i);
                return max3;
            }
            else{
                for(int i = 0; i < list.size(); i++){
                    if(list.get(i) > 0 && list.get(i) < list.size() && list.get(i) != list.get(list.get(i) - 1)){
                        int temp = list.get(i);
                        list.set(i, list.get(list.get(i) - 1));
                        list.set(list.get(i)-1,temp);
                    }
                }
            }
            return list.get(list.size() - 3);
        }
    public static List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        int i = 0, j = nums.length - 1, k = i + 1;
        while(i < nums.length){
            while(k < j){
                int sum = nums[i] + nums[k] + nums[j];
                if( sum > 0){
                    j--;
                }
                else if(sum < 0){
                    k++;
                }
                else {
                    List<Integer> temp = new ArrayList<>();
                    set.add(Arrays.asList(nums[i], nums[k], nums[j]));
                    k++;
                    j--;
                }
            }
            i++;
            k = i+1;
            j = nums.length-1;
        }
        return new ArrayList<>(set);
    }
}

