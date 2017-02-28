https://www.hackerrank.com/challenges/save-the-prisoner

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
    int T = in.nextInt();
        for (int i = 0; i < T; i++) {
            int N = in.nextInt();
            int M = in.nextInt();
            int S = in.nextInt();
            int ans;
            if(N-S+1>M){
                ans=S+M-1;}
               else{
                M = M-(N-S+1);
                M=M%N;
                if(M==0)
                 ans = N;
                else ans =M;
            }
            System.out.println(ans);
        }
    }
}
