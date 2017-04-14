//https://www.hackerrank.com/challenges/sansa-and-xor
import java.io.*;

public class Solution {
  public static void main(String[] args) throws IOException {
    StringBuffer sb = new StringBuffer();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    
    for(byte T = Byte.parseByte(br.readLine()); T > 0; --T){
      
    
      final int N = Integer.parseInt(br.readLine());
      final int[] arr = new int[N];
      String[] line = br.readLine().split(" ");
      for(int i = 0; i < N; ++i){
        arr[i] = Integer.parseInt(line[i]);
      }
      
    
      sb.append(solve(arr, N)).append("\n");
    }
    System.out.print(sb);
  }

  private static int solve(final int[] A, final int N){
    int xor = 0;
    if((N & 1) == 1){
      for(int i = 0; i < N; i += 2){
        xor ^= A[i];
      }
    }
    return xor;
  }
}
