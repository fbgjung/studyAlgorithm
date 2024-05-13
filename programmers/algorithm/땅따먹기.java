public class 땅따먹기 {
    int solution(int[][] land) {
        int answer = 0;

        int[][] dp = new int[land.length][4];
        
        for (int i = 0; i < 4; i++){
            dp[0][i] = land[0][i];
        }
        
        for (int k = 1; k < land.length; k++){
            for (int i = 0; i < 4; i++){
                for (int j = 0; j < 4; j++){
                    if (i == j) continue;
                    else{
                        dp[k][i] = Math.max(dp[k][i], dp[k-1][j]+land[k][i]);
                    }
                }
            }
        }
        
        for (int i = 0 ; i < 4; i++){
            answer = Math.max(answer, dp[land.length-1][i]);
        }
        
        return answer;
    }
}