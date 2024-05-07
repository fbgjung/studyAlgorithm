package Level0;

import java.util.*;

class n의배수고르기 {
    public int[] solution(int n, int[] numlist) {
        List<Integer> list = new ArrayList<>();
        for (int num : numlist){
            if(num % n == 0){
                list.add(num);
            }
        }
        
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}
