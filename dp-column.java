import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int R = sc.nextInt();
        int C = sc.nextInt();

        int grid[][] = new int[R][C];
        long dp[][] = new long[R][C];

        for (int row = 0; row < R; row++) {
            for (int col = 0; col < C; col++) {
                grid[row][col] = sc.nextInt();

                if (col == 0) {
                    dp[row][col] = grid[row][col];
                }
            }
        }

        for (int col = 1; col < C; col++) {

            long fmax[] = getMax(dp, col - 1, R);

            for (int row = 0; row < R; row++) {

                dp[row][col] = grid[row][col]
                        + (dp[row][col - 1] == fmax[0]
                           ? fmax[1]
                           : fmax[0]);
            }
        }

        System.out.println(getMax(dp, C - 1, R)[0]);
    }

    static long[] getMax(long dp[][], int col, int r) {

        long fm = Math.max(dp[0][col], dp[1][col]);
        long sm = Math.min(dp[0][col], dp[1][col]);

        for (int row = 2; row < r; row++) {

            if (dp[row][col] > fm) {
                sm = fm;
                fm = dp[row][col];
            }
            else if (dp[row][col] > sm) {
                sm = dp[row][col];
            }
        }

        return new long[]{fm, sm};
    }
}
