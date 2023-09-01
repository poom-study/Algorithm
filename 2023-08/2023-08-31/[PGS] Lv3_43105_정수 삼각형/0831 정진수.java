//package DP;

public class Solution {
    static public int solution(int[][] triangle) {
        int N = triangle.length;
        int[][] dp = new int[N][N];

        //초기화
        for(int i=0; i<N; i++){
            dp[N-1][i] = triangle[N-1][i];
        }

        for(int i=N-2; i>=0; i--){
            for(int j=0; j<triangle[i].length; j++){
                dp[i][j] = Math.max(dp[i+1][j] + triangle[i][j], dp[i+1][j+1] + triangle[i][j]);
            }
        }
        return dp[0][0];
    }
}
