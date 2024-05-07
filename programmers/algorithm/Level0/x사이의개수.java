package Level0;

import java.util.*;

class x사이의개수 {
    public int[] solution(String myString) {
        List<Integer> list = new ArrayList<>();
        String temp = "";
        
        for (int i = 0; i < myString.length(); i++){
            
            if (myString.charAt(i) == 'x'){
                list.add(temp.length());
                temp = "";
            } else {
                temp += myString.charAt(i);
            }
        }
        
        list.add(temp.length());
        
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}