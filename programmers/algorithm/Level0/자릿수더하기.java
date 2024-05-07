package Level0;

public class 자릿수더하기 {
    public int solution(int n) {
        int answer = 0;
        String str = Integer.toString(n); // int -> string
        
        for (int i = 0; i < str.length(); i++){
            answer += Integer.parseInt(str.substring(i, i+1));
        }
        return answer;
    }
    
}

/**
 * other solution
 */
class 자릿수더하기2 {
    public int solution(int n) {
        int answer = 0;

        while(n > 0){
            answer += n%10;
            n /=10;
        }
        return answer;
    }
}
