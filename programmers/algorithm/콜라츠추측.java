public class 콜라츠추측 {
    public int solution(long num) {
        int answer = 0;
        
        while(num != 1){
            if (num % 2 == 0){
                num /= 2;
                answer++;
            } else if(num % 2 != 0){
                num *= 3;
                num +=1;
                answer++;
            }
            if (answer >= 500) {
                answer =  -1;
                break;
            }
        }
        return answer;
        
    }
    
}
