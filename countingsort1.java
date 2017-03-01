https://www.hackerrank.com/challenges/countingsort1

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
            System.out.print(a[i]+" ");
        }
    }
}
