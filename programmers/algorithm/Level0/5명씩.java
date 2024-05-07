package Level0;

import java.util.*;

class 다섯명씩 {
    public String[] solution(String[] names) {
        List<String> list = new ArrayList<>();
        
        for (int i = 0; i < names.length; i++){
            if (i % 5 == 0){
                list.add(names[i]);
            }
        }
        
        String[] answer = new String[list.size()];
        for (int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}