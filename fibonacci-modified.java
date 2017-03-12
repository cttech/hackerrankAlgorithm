https://www.hackerrank.com/challenges/fibonacci-modified
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
         Scanner in = new Scanner(System.in);
        BigInteger firstNum = in.nextBigInteger();
        BigInteger secondNum = in.nextBigInteger();
        int targetNum = in.nextInt();
        BigInteger temp1 = firstNum;
        BigInteger temp2 = secondNum;
        BigInteger currentNum = new BigInteger("0");
        for (int i = 2; i < targetNum; i++) {
            currentNum = temp2.pow(2).add(temp1);
            temp1 = temp2;
            temp2 = currentNum;
        }
        System.out.println(currentNum);
    }
}


