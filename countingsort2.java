https://www.hackerrank.com/challenges/countingsort2

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in=new Scanner(System.in);
        int[] a=new int[100];
        int n=in.nextInt();
        for(int i=0;i<n;i++)
            {
            a[in.nextInt()]++;
        }
        for(int i=0;i<100;i++)
            {
           if(a[i]!=0)
               {
               for(int j=0;j<a[i];j++)
                   {
                   System.out.print(i+" ");
               }
           }
        }
    }
}
