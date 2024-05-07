package Level0;

public class 옹알이1 {
    public int solution(String[] babbling) {
        int answer = 0;
        for (int i = 0; i < babbling.length; i++) {
            babbling[i] = babbling[i].replaceAll("aya|ye|woo|ma", "");
        }
        for (String b : babbling){
            if(b.equals("")){
                answer ++;
            }
        }
        return answer;
    }
    
}
