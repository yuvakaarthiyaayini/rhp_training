import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int q = sc.nextInt();

        int limit = 200000;

        int arr[] = new int[limit + 2];

        for (int i = 0; i < n; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();

            arr[l]++;
            arr[r + 1]--;
        }

        int cover[] = new int[limit + 1];

        for (int i = 1; i <= limit; i++) {
            cover[i] = cover[i - 1] + arr[i];
        }

        int pre[] = new int[limit + 1];

        for (int i = 1; i <= limit; i++) {
            pre[i] = pre[i - 1];

            if (cover[i] >= k) {
                pre[i]++;
            }
        }

        while (q-- > 0) {
            int l = sc.nextInt();
            int r = sc.nextInt();

            System.out.println(pre[r] - pre[l - 1]);
        }
    }
}
