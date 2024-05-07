package Level0;

public class 안전지대 {

    static int[] dx = {-1,-1,0,1,1,1,0,-1};
    static int[] dy = {0,1,1,1,0,-1,-1,-1};
    
    public int solution(int[][] board) {
        int answer = 0;
        int n = board.length;
        
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (board[i][j] == 1) {
                    
                    for (int d = 0; d < 8; d++){
                        int nx = dx[d] + i;
                        int ny = dy[d] + j;
                        
                        if (0 <= nx && nx < n && 0 <= ny && ny < n && board[nx][ny] == 0){
                            board[nx][ny] = 2;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (board[i][j] == 0){
                    answer++;
                }
            }
        }
        
        return answer;
    }
    
}
