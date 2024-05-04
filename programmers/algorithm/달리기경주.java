import java.util.*;

class 달리기경주 {
    public String[] solution(String[] players, String[] callings) {
        
        int num = players.length;
                
        Map<String, Integer> ranking = new HashMap<>();
        for (int i = 0; i < num; i++) {
            ranking.put(players[i], i);
        }
        
        for (String c : callings) {
            int playerRanking = ranking.get(c); // 호출된 선수의 현재 랭킹
            
            String frontPlayer = players[playerRanking-1]; // 앞 선수의 이름
            
            players[playerRanking] = frontPlayer;
            players[playerRanking-1] = c;
            
            ranking.put(c, playerRanking-1);
            ranking.put(frontPlayer, playerRanking);
        }
        return players;
    }
}