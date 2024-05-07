package Level0;

import java.util.*;

class ad제거하기 {
    public String[] solution(String[] strArr) {
        List<String> list = new ArrayList<>();
        
        for (String str : strArr) {
            if (!str.contains("ad")){
                list.add(str);
            }
        }
        
        String[] answer = new String[list.size()];
        for (int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}


/**
 * strean 활용하기
 */

class ad제거하기2 {
    public String[] solution(String[] strArr) {
        return Arrays.stream(strArr).filter(s -> !s.contains("ad")).toArray(String[]::new);
    }
}