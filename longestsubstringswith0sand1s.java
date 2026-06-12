import java.util.*;

public class Main {

    public static int longestBalancedSubstring(String s) {

        HashMap<Integer, Integer> map = new HashMap<>();

        int prefixSum = 0;
        int maxLen = 0;

        map.put(0, -1);

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '0')
                prefixSum += -1;
            else
                prefixSum += 1;

            if (map.containsKey(prefixSum)) {

                int len = i - map.get(prefixSum);
                maxLen = Math.max(maxLen, len);

            } else {

                map.put(prefixSum, i);
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a binary string: ");
        String s = sc.next();

        int ans = longestBalancedSubstring(s);

        System.out.println("Length of longest balanced substring = " + ans);

        sc.close();
    }
}
