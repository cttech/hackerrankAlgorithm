https://www.hackerrank.com/challenges/tutorial-intro

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int Search = in.nextInt();
        int arraySize = in.nextInt();
        int [] Arr = new int[arraySize];
        int result = 0;
        for (int i = 0; i < arraySize; i++) {
            Arr[i] = in.nextInt();
        }
        for (int i = 0; i < Arr.length; i++) {
            if(Arr[i] == Search){
                result = i;
                break;
            }
        }
        System.out.println(result);
        
    }
}
