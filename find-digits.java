https://www.hackerrank.com/challenges/find-digits

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

     public static void calculateIt(int num){
         String s = Integer.toString(num);
            int count = 0;
            for(int j=0;j<s.length();j++){
                int tmp = Character.getNumericValue(s.charAt(j));
                if(tmp!=0 && num % tmp == 0)
                    count++;
            }
            System.out.println(count);
        
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            calculateIt(n);
        }
    }
}
