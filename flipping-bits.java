https://www.hackerrank.com/challenges/flipping-bits
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
  private static final long MASK = (1L << 32L) - 1L;
  public static void main(String[] args) throws IOException {
    StringBuffer sb = new StringBuffer();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    for(byte T = Byte.parseByte(br.readLine()); T > 0; --T){
      long N = Long.parseLong(br.readLine());
      sb.append(N ^ MASK).append("\n");
    }
    System.out.print(sb);
  }
}

