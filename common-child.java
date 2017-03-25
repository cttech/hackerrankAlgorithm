import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		String a = in.next();
		String b = in.next();
		System.out.println(MaximumCommonLength(a, b));

		in.close();
	}

	static int MaximumCommonLength(String s1, String s2) {
		int length1 = s1.length();
		int length2 = s2.length();
		int[][] cLengths = new int[length1 + 1][length2 + 1];
		for (int i = 1; i <= length1; i++) {
			for (int j = 1; j <= length2; j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					cLengths[i][j] = cLengths[i - 1][j - 1] + 1;
				} else {
					cLengths[i][j] = Math.max(cLengths[i - 1][j], cLengths[i][j - 1]);
				}
			}
		}
		return cLengths[length1][length2];
	}
}
