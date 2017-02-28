https://www.hackerrank.com/challenges/minimum-distances

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int A[] = new int[n];
        for(int A_i=0; A_i < n; A_i++){
            A[A_i] = in.nextInt();
        }
        int count = 0 ;
    for(int i=0;i<n;i++)
{
   for(int j=i+1;j<n;j++)
       {

       if( A[i] == A[j] && i != j)
           { 

           int value = Math.abs(j-i);
           if(count != 0)
           count = Math.min(value,count);
           else
               count = value;
       }
    }
    }
 if(count!=0)
 System.out.println(count);
else
    System.out.println("-1");

    }
}
