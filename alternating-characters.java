https://www.hackerrank.com/challenges/alternating-characters

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
            String s = in.next();
            char[] inputText = s.toCharArray();
            int CountDeletion = 0;
            for (int i = 0; i < inputText.length; i++) {
                if(i != 0 && (inputText[i] == inputText[i-1])){
                    CountDeletion++;
                }
             }
            
            System.out.println(CountDeletion);
        }
    }
}
