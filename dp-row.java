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

                if (row == 0) {
                    dp[row][col] = grid[row][col];
                }
            }
        }

               for (int row = 1; row < R; row++) {

            long fmax[] = getMax(dp, row - 1, C);

            for (int col = 0; col < C; col++) {

                dp[row][col] = grid[row][col]
                        + (dp[row - 1][col] == fmax[0]
                           ? fmax[1]
                           : fmax[0]);
            }
        }

               System.out.println(getMax(dp, R - 1, C)[0]);
    }

    static long[] getMax(long[][] dp, int row, int c) {

        long fm = Math.max(dp[row][0], dp[row][1]);
        long sm = Math.min(dp[row][0], dp[row][1]);

        for (int col = 2; col < c; col++) {

            if (dp[row][col] > fm) {
                sm = fm;
                fm = dp[row][col];
            }
            else if (dp[row][col] > sm) {
                sm = dp[row][col];
            }
        }

        return new long[] { fm, sm };
    }
}
