package Level0;

public class n보다커질때까지더하기 {
    public int solution(int[] numbers, int n) {
        int answer = 0;
            
        for (int num : numbers){
            answer += num;
            if (answer > n) break;
        }
        
        return answer;
    }
    
}
