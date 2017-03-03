https://www.hackerrank.com/challenges/find-the-median


import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] ar = new int[N];
        String[] temp = br.readLine().split(" ");
        for(int i = 0; i < N; i++){
            ar[i] = Integer.parseInt(temp[i]);
        }
        
        int min = 0;
        int max = N;
        int mid = N/2;
        while (max-min > 1){
            int index = partition(ar, min, max);
            if (index < mid){
                min = index+1;
            } else if (index > mid){
                max = index;
            } else {
                break;
            }
        }
        System.out.println(ar[mid]);
    }
    private static int partition(int[] ar, int min, int max){
        
        int length = max - min;
        int mid = min + length/2;
        int pivotVal = ar[mid];
        
        ar[mid] = ar[--max];
        ar[max] = pivotVal;
        
        int storeMaximum = min;
        for(int i = min; i < max; i++){
            if (ar[i] < pivotVal){
                int temp = ar[i];
                ar[i] = ar[storeMaximum];
                ar[storeMaximum++] = temp;
            }
        }
        
        ar[max] = ar[storeMaximum];
        ar[storeMaximum] = pivotVal;
        
        return storeMaximum;
    }
}
