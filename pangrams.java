https://www.hackerrank.com/challenges/pangrams

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        String inputText = in.nextLine();
        String temp = inputText.toLowerCase().replaceAll(" ", "");
        boolean pangrams = true;
        for (char i = 'a'; i < 'z'; i++) {
            if (temp.indexOf(i) == -1) {
                pangrams = false;
            }
        }
        System.out.println(pangrams ? "pangram" : "not pangram" );
    }
}
