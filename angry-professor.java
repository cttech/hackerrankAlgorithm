https://www.hackerrank.com/challenges/angry-professor

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    public static void isClassCancelled(int[] Students, int k){
       int countRightEntry = 0;
       int countWrongEntry = 0;
        for(int a: Students){
            if(a <= 0){
                countRightEntry = countRightEntry + 1;
            }else{
                countWrongEntry = countWrongEntry + 1;
            }
        }
      
        if (countRightEntry >= k ) {
           System.out.println("NO");
       }else{
            System.out.println("YES");
        }
    }

    public static void main(String[] args) {
       Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int k = in.nextInt();
            int a[] = new int[n];
            for(int a_i=0; a_i < n; a_i++){
                a[a_i] = in.nextInt();
            }
            isClassCancelled(a, k);
        }
    }
}
