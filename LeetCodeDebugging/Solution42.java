package com.java.DSA.LeetCodeDebugging;

public class Solution42 {
    public int repeatedStringMatch(String a, String b) {
        int i = 0, j = 0, first = -1;
        if(a.length() >= b.length()){
            String x = a + a;
            if(a.indexOf(b) != -1)
                return 1;
            else if(x.indexOf(b) != -1)
                return 2;
            else
                return -1;
        }
        boolean c = true;
        while(i < a.length()){
            if(a.charAt(i) == b.charAt(j)){
                if(a.charAt(i) == b.charAt(0) && c)
                    first = i;
                i++;
                j++;
                c = false;
            }
            else{
                i++;
                j = 0;
                first = -1;
                c = true;
            }
        }
        if(first == -1)
            return -1;
        j = 0;
        int count = 1;
        if(first == 0)
            count = 0;
        while(j < b.length()){
            if(a.charAt(first % a.length()) == b.charAt(j)){
                if(first % a.length() == 0)
                    count++;
                j++;
                first++;
            }
            else{
                return -1;
            }
        }
        return count;
    }
}
