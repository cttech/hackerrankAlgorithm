https://www.hackerrank.com/challenges/gem-stones

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void calculateGemstones(String [] inputSet){
        int flag = 0;
        for(char c ='a';c<='z';c++){
        int count=0;
        for(int i=0;i<inputSet.length;i++){

        if(inputSet[i].indexOf(c)!=-1)
            count++;
        if(count==inputSet.length)
            flag++;
        }
    }System.out.println(flag);
    } 
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        String [] inputSet = new String[t];
        for (int i = 0; i < t; i++) {
            String str = in.next();
            inputSet[i] = str;
        }
        calculateGemstones(inputSet);
        
        
    }
}
