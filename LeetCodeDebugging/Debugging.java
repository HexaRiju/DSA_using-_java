package com.java.DSA.LeetCodeDebugging;

import java.sql.SQLOutput;
import java.util.*;

public class Debugging {
    public static void main(String[] args){
        //System.out.println(specialArray(new int[]{0,4,3,0,4}));
//        int[] nums1 = {1,2,3,0,0,0};
//        int[] nums2 = {2,5,6};
//        merge(nums1,3,nums2,3 );
//        //System.out.println(Arrays.toString(nums1));
//        System.out.println(thirdMax(new int[] {1,2,-2147483648}));
        //System.out.println(threeSum(new int[] {2,-3,0,-2,-5,-5,-4,1,2,-2,2,0,2,-4,5,5,-10}));
        //System.out.println(spiralOrder(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}}));
        //System.out.println(Arrays.deepToString(generateMatrix(3)));
        //System.out.println(Arrays.deepToString(spiralMatrixIII(5,6,1,4)));
//        Solution1 sol = new Solution1();
//        int [][] arr = new int[][]{{1,2,3,4},{5,0,7,8},{0,10,11,12},{13,14,15,0}};
//        sol.setZeroes(arr);
//        System.out.println(Arrays.deepToString(arr));
//        int[] arr1 = new int[]{-1,1,0,-3,0};
//        System.out.println(Arrays.toString(new Solution2().productExceptSelf(arr1)));
        //System.out.println(new Solution3().canJump(new int[]{3,2,1,0,4}));
        int[] arr = new int[]{2,1,1,2};
//        Solution5 s = new Solution5();
//        s.sortColors(arr);
//        Solution4 s = new Solution4();
//        s.rotate(arr,3);
//        System.out.println(Arrays.toString(arr));
//        System.out.println(Arrays.toString(arr));
//        Solution6 solution6 = new Solution6();
//        System.out.println(solution6.rob(arr));
//        Solution7 solution7 = new Solution7();
//        System.out.println(solution7.canJump(new int[]{3,2,1,0,4}));
//        Solution8 solution8 = new Solution8();
//        System.out.println(solution8.search(new int[]{1,0,1,1,1}, 0));
//        Solution9 solution9 = new Solution9();
//        System.out.println(solution9.findMin(new int[]{13,15,17,11}));
//        Solution10 solution10 = new Solution10();
//        System.out.println(Arrays.toString(solution10.findRightInterval(new int[][]{{1,4},{2,3},{3,4}})));
//        Solution11 solution11 = new Solution11();
//        System.out.println(solution11.reachNumber(-3));//** very importent concept.
//        Solution12 solution12 = new Solution12();
//        System.out.println(solution12.maxValue(6,1,10));// good question
//        Solution13 solution13 = new Solution13();
//        System.out.println(solution13.minEatingSpeed(new int[]{805306368,805306368,805306368},1000000000));
        Solution14 solution14 = new Solution14();
        System.out.println(solution14.minAbsoluteSumDiff(new int[] {1,7,5}, new int[] {2,3,5}));
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
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> lists = new ArrayList<>();
        return rightDown(matrix,0,0,list,lists);
    }
    public static List<Integer> rightDown(int[][] matrix , int i, int j,List<Integer> list, List<List<Integer>> lists) {
        while(j < matrix[i].length && !lists.contains(new ArrayList<>(Arrays.asList(i,j)))){
            lists.add(new ArrayList<>(Arrays.asList(i,j)));
            list.add(matrix[i][j]);
            j++;
        }
        j = j - 1;
        if(i+1 < matrix.length && !lists.contains(new ArrayList<>(Arrays.asList(++i,j)))){
            return downLeft(matrix, i, j, list, lists);
        }
        return list;
    }
    public static List<Integer> downLeft(int[][] matrix, int i, int j,List<Integer> list, List<List<Integer>> lists) {
        while(i < matrix.length && !lists.contains(new ArrayList<>(Arrays.asList(i,j)))){
            lists.add(new ArrayList<>(Arrays.asList(i,j)));
            list.add(matrix[i][j]);
            i++;
        }
        i = i - 1;
        if(j - 1 >= 0 && !lists.contains(new ArrayList<>(Arrays.asList(i,--j)))){
            return leftUp(matrix, i, j, list, lists);
        }
        return list;
    }
    public static List<Integer> leftUp(int[][] matrix, int i, int j,List<Integer> list, List<List<Integer>> lists) {
        while(j >=0 && !lists.contains(new ArrayList<>(Arrays.asList(i,j)))){
            lists.add(new ArrayList<>(Arrays.asList(i,j)));
            list.add(matrix[i][j]);
            j--;
        }
        j = j + 1;
        if(i - 1 >= 0 && !lists.contains(new ArrayList<>(Arrays.asList(--i,j)))){
            return upRight(matrix, i, j, list, lists);
        }
        return list;
    }
    public static List<Integer> upRight(int[][] matrix, int i, int j,List<Integer> list, List<List<Integer>> lists) {
        while(i >=0 && !lists.contains(new ArrayList<>(Arrays.asList(i,j)))){
            lists.add(new ArrayList<>(Arrays.asList(i,j)));
            list.add(matrix[i][j]);
            i--;
        }
        i = i + 1;
        if(j + 1 < matrix[i].length && !lists.contains(new ArrayList<>(Arrays.asList(i,++j)))){
            return rightDown(matrix, i, j, list,lists);
        }
        return list;
    }
    public static int[][] generateMatrix(int n){
        int[][] m = new int[n][n];
        int top = 0,left = 0;
        int down = n - 1,right = n - 1;
        int r = 1;
        while(top <= down && left <= right){
            for(int i = top ; i <= right; i++){
                m[top][i] = r++;
            }
            top++;
            for(int i = top; i <= down; i++){
                m[i][right] = r++;
            }
            right--;
            for(int i = right; i >= left; i--){
                m[down][i] = r++;
            }
            down--;
            for(int i = down; i >= top; i--){
                m[i][left] = r++;
            }
            left++;
        }
        return m;
    }
    public static int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] m = new int[rows*cols][2];
        int p = 1;
        int r = 0;
        m[0][0] = rStart;
        m[0][1] = cStart;
        boolean b = true;
        while(b){
            b = false;
            r++;
            for(int i = 0; i < r; i++){//right
                cStart++;
                if((rStart >=0 && rStart<= rows-1) && (cStart >= 0 && cStart <= cols - 1)){
                    m[p][0] = rStart;
                    m[p][1] = cStart;
                    p++;
                    b = true;
                }
            }
            for(int i = 0; i < r; i++){//down
                rStart++;
                if((rStart >=0 && rStart<= rows-1) && (cStart >= 0 && cStart <= cols - 1)){
                    m[p][0] = rStart;
                    m[p][1] = cStart;
                    p++;
                    b = true;
                }
            }
            r++;
            for(int i = 0; i < r; i++){//left
                cStart--;
                if((rStart >=0 && rStart<= rows-1) && (cStart >= 0 && cStart <= cols - 1)){
                    m[p][0] = rStart;
                    m[p][1] = cStart;
                    p++;
                    b = true;
                }
            }
            for(int i = 0; i < r; i++){//up
                rStart--;
                if((rStart >=0 && rStart<= rows-1) && (cStart >= 0 && cStart <= cols - 1)){
                    m[p][0] = rStart;
                    m[p][1] = cStart;
                    p++;
                    b = true;
                }
            }
        }
        return m;
    }
}

