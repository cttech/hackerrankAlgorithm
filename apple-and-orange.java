https://www.hackerrank.com/challenges/apple-and-orange

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static boolean HitHouse(int s, int t, int tPos, int d)
    {
        int FruitPos = tPos + d;
        return s <= FruitPos && FruitPos <= t;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int t = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        int m = in.nextInt();
        int n = in.nextInt();

        int hitCount = 0;
        for(int apple_i=0; apple_i < m; apple_i++){
            int distance = in.nextInt();
            if (distance > 0) {
                if (HitHouse(s, t, a, distance)) hitCount++;
            }
        }
        System.out.println(hitCount);
        
        hitCount = 0;
        for(int orange_i=0; orange_i < n; orange_i++){
            int distance = in.nextInt();
            if (distance < 0) {
                if (HitHouse(s, t, b, distance)) hitCount++;
            }        
        }
        System.out.println(hitCount);
        
    }
}
