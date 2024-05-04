import java.util.*;
class 옹알이2 {
    public int solution(String[] babbling) {
        int answer = 0;
        
        for (int i = 0; i < babbling.length; i++){
            babbling[i] = babbling[i].replaceAll("ayaaya|yeye|woowoo|mama","x");
            babbling[i] = babbling[i].replaceAll("aya|ye|woo|ma"," ");        
            
            if (babbling[i].trim().length() == 0){
                answer ++;
            }
        }
        System.out.println(Arrays.toString(babbling));
        return answer;
    }
}