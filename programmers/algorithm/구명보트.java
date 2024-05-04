import java.util.*;

class 구명보트 {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int idx = 0;
        
        Arrays.sort(people);
        
        for(int i = people.length-1; i >= idx; i--){
            if(people[idx] + people[i] <= limit){
                idx++;
                answer++;
            } else {
                answer++;
            }
        }
        return answer;
    }
}