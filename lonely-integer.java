//https://www.hackerrank.com/challenges/lonely-integer

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    private static int lonelyInteger(int[] a) {
         int result = 0;
        for(int c: a){
            int count = 0; 
            int numTofind = c;
             for(int d : a){
                if(numTofind == d){
                    count++;
                }     
              }
             if(count == 1){
                result  = numTofind;
             }
        }
       return result;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        System.out.println(lonelyInteger(a));
    }

}

