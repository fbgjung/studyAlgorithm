package Level0;
import java.util.*;

class 가위바위보 {
    public String solution(String rsp) {
        String answer = "";
        for (int i = 0; i < rsp.length(); i++) {
            if (rsp.charAt(i) == '0'){
                answer += '5';
            } else if (rsp.charAt(i) == '2'){
                answer += '0';
            } else {
                answer += '2';
            }
        }
        return answer;
    }
}

/**
 * Map 풀이
 * 훨~~~씬 빠름!!!!
 */
class 가위바위보map {
    public String solution(String rsp) {
        Map<String, String> map = new HashMap<>();
        map.put("2","0");
        map.put("0","5");
        map.put("5","2");
        
        StringBuilder answer = new StringBuilder();
        
        for (int i = 0; i < rsp.length(); i++){
            answer.append(map.get(rsp.substring(i, i+1)));
        }
        return answer.toString();
    }
}  
