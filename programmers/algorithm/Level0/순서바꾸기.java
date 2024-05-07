package Level0;

import java.util.*;

class 순서바꾸기 {
    public int[] solution(int[] num_list, int n) {
        
        List<Integer> list = new ArrayList<>();
        
        for (int i = n; i < num_list.length; i++){
            list.add(num_list[i]);
        }
        for (int i = 0; i < n; i++){
            list.add(num_list[i]);
        }
        
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}