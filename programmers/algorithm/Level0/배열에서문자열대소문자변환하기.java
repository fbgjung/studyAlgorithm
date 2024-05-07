package Level0;

public class 배열에서문자열대소문자변환하기 {
    public String[] solution(String[] strArr) {
        String[] answer = {};
        
        for (int i = 0; i < strArr.length; i++){
            if(i % 2 == 0) {
                answer[i] = strArr[i].toLowerCase();
            } else {
                answer[i] = strArr[i].toUpperCase();
            }
        }
        return answer;
    }
}


/**
 * other solution
 */
class 배열에서문자열대소문자변환하기2 {
    public String[] solution(String[] strArr) {
        String[] answer = new String[strArr.length];
        
        for (int i = 0; i < strArr.length; i+=2){
            if (i > strArr.length) break;
            answer[i] = strArr[i].toLowerCase();
        }
        
        for (int i = 1; i < strArr.length; i+=2){
            answer[i] = strArr[i].toUpperCase();
        }
        return answer;
    }
}