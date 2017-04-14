//https://www.hackerrank.com/challenges/bonetrousleimport java.io.*;
import java.util.*;

public class Bonetrousle {

    public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int t = input.nextInt();
		for (int q = 0; q < t; q++) {
			long n = input.nextLong();
			long k = input.nextLong(); 
			long b = input.nextInt(); 

			

			long temp = n - (b * (b + 1)) / 2;
			if (temp % b == 0) {
				temp = temp / b;
			} else {
				temp = temp / b + 1; 
			}
			

			long overbuy = temp * b + (b) * (b + 1) / 2 - n;
			long[] answers = new long[(int) b];
			for (int a = 0; a < b; a++) {
				answers[a] = temp + a + 1;
			}
			for (int a = 1; a <= b; a++) {
				if (overbuy > 0) {
					if (overbuy > answers[a - 1] - a) {
						overbuy -= answers[a - 1] - a;
						answers[a - 1] = a;
					} else {
						answers[a - 1] -= overbuy;
						overbuy = 0;
					}
				}
			}
			long sum = 0;
			boolean OK = true;
			for (int a = 0; a < b; a++) {
				sum += answers[a];
				if (answers[a] <= 0) {
					OK = false;
				}
				if (answers[a] > k) {
					OK = false;
				}
			}
			if(sum != n){
				OK = false;
			}
			if (!OK) {
				System.out.println("-1");
			} else {
				StringBuilder output = new StringBuilder();
				for (int a = 0; a < b; a++) {
					output.append(answers[a]);
					if(a != b-1){
						output.append(" ");
					}
				}
				System.out.println(output);
			}
		}
	}
}
