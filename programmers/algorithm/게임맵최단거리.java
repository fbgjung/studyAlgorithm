import java.util.*;
class 게임맵최단거리 {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    
    public int solution(int[][] maps) {
        int answer = 0;
        int n = maps.length;
        int m = maps[0].length;
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,0});
        
        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            visited[x][y] = true;
            
            if (x == n-1 && y == m-1){
                answer = maps[n-1][m-1];
                break; // 중요!!!!!

            } else {
                answer = -1;
            }
            
            for (int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (0 <= nx && nx < n && 0 <= ny && ny < m && maps[nx][ny] == 1 && visited[nx][ny] == false){
                    queue.offer(new int[]{nx,ny});
                    maps[nx][ny] += maps[x][y];
                    visited[nx][ny] = true;
                }
            }
            
        } 
        
        return answer;
    }
}