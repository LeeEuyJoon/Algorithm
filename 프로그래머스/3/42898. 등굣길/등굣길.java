import java.util.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        
        // dp
        
        // dp[i][j] = (i, j) 까지의 최단 거리
        // dp[i][j] = dp[i-1][j] + dp[i][j-1]
        // dp[i][j]가 웅덩이라면 값 0으로 넣기
        
        int[][] dp = new int[n + 1][m + 1];
        dp[1][1] = 1;
        
        boolean[][] isPuddle = new boolean[n + 1][m + 1];
        for (int[] p: puddles) {
            int x = p[0];
            int y = p[1];
            isPuddle[y][x] = true;
        }
        
        for (int i = 1; i <=n; i++) {
            for (int j = 1; j <=m; j++) {
                if (i == 1 && j == 1) continue;
                if (isPuddle[i][j]) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % 1_000_000_007;                
                }
            }
        }
        
        return dp[n][m];
    }
}