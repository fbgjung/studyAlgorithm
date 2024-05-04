import java.util.*;
class 서울에서김서방찾기 {
    public String solution(String[] seoul) {
        String answer = "";
        
        for (String s : seoul) {
            if (s.equals("Kim")) {
                answer = "김서방은 " + Arrays.asList(seoul).indexOf(s) + "에 있다";
            }
        }
        return answer;
    }
}