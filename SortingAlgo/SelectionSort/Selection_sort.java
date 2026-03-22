package com.java.DSA.SortingAlgo.SelectionSort;

import java.util.Arrays;

public class Selection_sort {
    public static void main(String[] args) {
        int[] arr = {1,4,3,5,2};
        sort(arr);
    }
    public static void sort(int[] arr){
        for(int i = 0 ; i < arr.length ; i++){
            int t = i;
            for(int j = i + 1 ; j < arr.length ; j++){
                if(arr[t] > arr[j]){
                    t = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[t];
            arr[t] = temp;
        }

        System.out.println(Arrays.toString(arr));
    }
}
