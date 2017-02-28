https://www.hackerrank.com/challenges/almost-sorted

import java.io.*;

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    final int N = Integer.parseInt(br.readLine());
    final int[] arr = new int[N];
    String[] line = br.readLine().split(" ");
    for(int i = 0; i < N; ++i){
      arr[i] = Integer.parseInt(line[i]);
    }
    

    System.out.print(solve(arr, N));
  }
  
  private static String solve(final int[] A, final int N){
    int l = 0;
    int r = N - 1;
    

    while(l < r && A[l] <= A[l+1]){
      ++l;
    }
    

    if(l == r){
      return "yes";
    }
    

    while(r > l && A[r] >= A[r-1]){
      --r;
    }
    

    if((l > 0 && A[r] < A[l-1]) || (r < N-1 && A[l] > A[r+1])){
      return "no";
    }
        

    int m;
    for(m = l+1; m < r && A[m] >= A[m+1]; ++m){}
    if(m == r){
      return "yes\n" + ((r-l < 2) ? "swap " : "reverse ") + (l+1) + " " + (r+1);
    }
    

    if(m-l > 1 || A[l] < A[r-1] || A[r] > A[l+1]){
      return "no";
    }
    

    for(int k = r-1; m < k && A[m] <= A[m+1]; ++m){}
    return (r-m > 1) ? "no" : "yes\nswap " + (l+1) + " " + (r+1);
  }
}
