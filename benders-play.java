//https://www.hackerrank.com/challenges/benders-play

import java.util.*;
import java.io.*;

public class Solution {
    static List<Integer>[] map = null;
    static boolean[] visited = null;
    static int[] order = null;
    
    static int idx = 0;

    static void go() {

        int n = in.nextInt();
        int m = in.nextInt();
        map = new List[n];
        for(int i = 0; i < n; i++)
            map[i] = new ArrayList<Integer>();

        while(m-- > 0) {
            int from = in.nextInt() - 1;
            int to = in.nextInt() - 1;
            map[from].add(to);
        }

        visited = new boolean[n];
        order = new int[n];
        idx = 0;
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                dfs(i);
            }
        }

        int[] nim = new int[n];
        for(int i = 0; i < n; i++) {
            int c = order[i];
            int len = map[c].size();
            int[] y = new int[len];
            for(int j = 0; j < len; j++) {
                y[j] = nim[map[c].get(j)];
            }
            int x = 0;
            while(x < len) {
                int z = y[x];
                if (z == x) {
                    x++;
                    continue;
                }
                if (z < x || z >= len || y[z] == z) {
                    y[x] = y[--len];
                } else {
                    y[x] = y[z];
                    y[z] = z;
                }
            }
            nim[c] = x;
        }

        int q = in.nextInt();
        while(q-- > 0) {
            int k = in.nextInt();
            int N = 0;
            for(int i = 0; i < k; i++) {
                int next = in.nextInt() - 1;
                N ^= nim[next];
            }
            if (N == 0) {
                out.println("Iroh");
            } else {
                out.println("Bumi");
            }
        }
    }

    static void dfs(int c) {
        visited[c] = true;
        for(int next : map[c]) {
            if(!visited[next])
                dfs(next);
        }
        order[idx++] = c;
    }

    static InputReader in;
    static PrintWriter out;

    public static void main(String[] args) {
        in = new InputReader(System.in);
        out = new PrintWriter(System.out);

        go();

        out.close();
    }

    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if (numChars == -1)
                throw new InputMismatchException();
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        public int nextInt() {
            return (int) nextLong();
        }

        public long nextLong() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public String nextString() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuilder sb = new StringBuilder(1024);
            do {
                sb.append((char) c);
                c = read();
            } while (!isSpaceChar(c));
            return sb.toString();
        }

        public static boolean isSpaceChar(int c) {
            switch (c) {
                case -1:
                case ' ':
                case '\n':
                case '\r':
                case '\t':
                    return true;
                default:
                    return false;
            }
        }
    }
}
