//https://www.hackerrank.com/challenges/string-transmission
import java.io.*;
import java.util.*;
import java.math.*;
public class Solution {
    private final static short MAX_N = 1000;
    private final static int MOD = 1000000007;
    public static void main(String[] args) throws IOException{
        StringBuffer sb = new StringBuffer();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        for(byte T = Byte.parseByte(br.readLine()); T > 0; --T){
        
            String[] temp = br.readLine().split(" ");
            short N = Short.parseShort(temp[0]);
            short K = Short.parseShort(temp[1]);
            char[] STR = br.readLine().toCharArray();
            int X = solve(N, K, STR, MOD);
            sb.append(X + "\n");
        }
        System.out.print(sb);
    }
    private static int solve(short N, short K, char[] STR, int MOD){
        
        int total = SNCR(N, K, MOD);
        
        short[] divisors = getDivisors(N);
        short numDivisors = (short)divisors.length;
        int[][] dp = new int[numDivisors][N + K + 1];
        boolean flag = false;
        
        for (short divisorIndex = 0; divisorIndex < numDivisors; ++divisorIndex) {
            short divisor = divisors[divisorIndex];
            short quotient = (short)(N / divisor);
            dp[divisorIndex][0] = 1;
            
            for (short i = 0; i < divisor; ++i) {
               
                int zero = 0;
                for (short j = i; j < N; j += divisor) {
                    zero += (STR[j] == '0') ? 1 : 0;
                }
                int[] prev = dp[divisorIndex];
                dp[divisorIndex] = new int[MAX_N];
               
                for (short j = 0; j <= K; ++j) {
                    if (prev[j] > 0) {
                        dp[divisorIndex][j + zero] = mod(dp[divisorIndex][j + zero] + prev[j], MOD);
                        dp[divisorIndex][j + quotient - zero] = mod(dp[divisorIndex][j + quotient - zero] + prev[j], MOD);
                    }
                }
            }
            flag = (dp[divisorIndex][0] > 0) ? true : flag;
           
            for (short i = 0; i < divisorIndex; ++i) {
           
                if (divisor % divisors[i] == 0) {
           
                    for (short j = 0; j <= K; ++j) {
                        dp[divisorIndex][j] = mod(dp[divisorIndex][j] - dp[i][j], MOD);
                    }
                }
            }
           
            for (short i = 1; i <= K; total = mod(total - dp[divisorIndex][i++], MOD)){}
        }        
        total = (flag) ? mod(total - 1, MOD) : total;
        return total;
    }
    private static short[] getDivisors(short N){
        List<Short> divisors = new ArrayList<Short>();
        for (short i = 1; i < N ; ++i) {
            if (N % i == 0) {
                divisors.add(i);
            }
        }
        short i = 0;
        short[] out = new short[divisors.size()];
        for(short v : divisors){
            out[i++] = v;
        }
        return out;
    }
    private static int mod(int n, int m){
        return (n%m + m)%m;
    }
    private static int SNCR(int N, int K, int MOD){
       
        int[] row = new int[K+1];
        
        row[0] = 1;
        
        for(int i = 1; i <= K; ++i){
        
            row[i] = 1;
            for(int j = i-1; j > 0; --j){
                row[j] = (row[j] + row[j-1]) % MOD;
            }
        }
        
        for(int i = K+1; i <= N; ++i){
        
            for(int j = K; j > 0; --j){
                row[j] = (row[j] + row[j-1]) % MOD;
            }
        }
        
        int out = 0;
        for(int i = 0; i <= K; out = (out + row[i++])%MOD){}
        return out;
    }
}

