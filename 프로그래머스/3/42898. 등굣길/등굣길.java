class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[m][n];
        for(int[] puddle : puddles){
            dp[puddle[0]-1][puddle[1]-1] = -1;
        }
        
        for(int i = 0; i < m; i++){
            if(dp[i][0] == -1) break;
            dp[i][0] = 1;
        }
        
        for(int j = 0; j < n; j++){
            if(dp[0][j] == -1) break;
            dp[0][j] = 1;
        }
        
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(dp[i][j] == -1) continue;
                
                int fromUp = dp[i-1][j] == -1? 0 : dp[i-1][j];
                int fromLeft = dp[i][j-1] == -1? 0 : dp[i][j-1];
                
                dp[i][j] = (fromUp + fromLeft)%1000000007;
            }
        }
        
        return dp[m-1][n-1];
    }
}