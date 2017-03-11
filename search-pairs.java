https://www.hackerrank.com/challenges/pairs

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
 
public class Pairs {

    private static final Integer ONE = 1;

    
    static int pairs(int[] a, int k) {
        if (null == a || a.length == 0) {
            return 0;
        }
        int result = 0;
        Map<Integer, Integer> map = countOccurrences(a);
        for (int value : a) {
            int target = value + k;
            if (map.containsKey(target)) {
                result += map.get(target);
            }
        }
        return result;
    }

    private static Map<Integer, Integer> countOccurrences(int[] a) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(a.length);
        for (int value : a) {
            if (map.containsKey(value)) {
                map.put(value, map.get(value) + 1);
            } else {
                map.put(value, ONE);
            }
        }
        return map;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;

        String n = in.nextLine();
        String[] n_split = n.split(" ");

        int _a_size = Integer.parseInt(n_split[0]);
        int _k = Integer.parseInt(n_split[1]);

        int[] _a = new int[_a_size];
        int _a_item;
        String next = in.nextLine();
        String[] next_split = next.split(" ");

        for (int _a_i = 0; _a_i < _a_size; _a_i++) {
            _a_item = Integer.parseInt(next_split[_a_i]);
            _a[_a_i] = _a_item;
        }

        res = pairs(_a, _k);
        System.out.println(res);
        in.close();
    }
}
