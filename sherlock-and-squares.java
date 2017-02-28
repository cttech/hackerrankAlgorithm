https://www.hackerrank.com/challenges/sherlock-and-squares
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

  
    public static void main(String[] args) {
         Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int m = in.nextInt();
            int sqrtCount = 0;
            int a = (int)Math.pow(n, .5);
            for(; a <= m; a++){
                if(a*a >= n && a*a <= m)
                    sqrtCount++;
                else if(a*a > m)
                    break;
            }
            System.out.println(sqrtCount);;
        }
        
    }
}
