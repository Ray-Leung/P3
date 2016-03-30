/**
 * Created by Administrator on 2015/12/27.
 */
public class UniquePaths {
    public static void  main(String[] args) {

        int[][] ns = {{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,1},{0,0},{0,0},{0,0}};
        int[][] n2 = {{0, 0},{1, 0}};
        int n = new UniquePaths().solve2(n2);
    }

    public int solve1(int m, int n) {
        int [] res = new int[n];

        res[0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                res[j] += res[j - 1];
            }
        }
        return res[n-1];
    }

    public int solve2(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        if (obstacleGrid[m - 1][n - 1] == 1 || obstacleGrid[0][0] == 1 || obstacleGrid == null) return 0;
        if (m == 1 || n == 1) return 1;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) dp[j] = 0;
                else if (j == 0 && obstacleGrid[i][j] != 1) dp[j] = dp[j] == 0 ? 0 : 1;
                else dp[j] += dp[j - 1];
            }
        }
        return dp[n-1];
    }}
