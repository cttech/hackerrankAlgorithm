https://www.hackerrank.com/challenges/funny-string


import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
         Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            String s = in.next();
            char[] inputText = s.toCharArray();
            String revText = new StringBuilder(s).reverse().toString();
            char[] revinputText = revText.toCharArray();
            boolean isFunny = true;
            for (int i = 1; i < inputText.length; i++) {
                if(Math.abs(((int)inputText[i] - (int)inputText[i-1])) != Math.abs((int)revinputText[i] - (int)revinputText[i-1])){
                    isFunny = false;
                    break;
                }
            }
            System.out.println(isFunny ? "Funny" : "Not Funny");
        }
    }
}
