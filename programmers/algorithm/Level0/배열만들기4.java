package Level0;

import java.util.ArrayList;
import java.util.List;

public class 배열만들기4 {
    public int[] solution(int[] arr) {
        List<Integer> stack = new ArrayList<>();
        int i = 0;
        
        while(i < arr.length){
            if (stack.isEmpty()){
                stack.add(arr[i]);
                i++;
            } else {
                int last = stack.get(stack.size()-1);
                if (last < arr[i]) {
                    stack.add(arr[i]);
                    i++;
                } else if(last >= arr[i]){
                    stack.remove(stack.size()-1);
                }
            } 
        }
        
        int[] answer = new int[stack.size()];
        for (int j = 0 ; j < stack.size(); j++) {
            answer[j] = stack.get(j);
        }
        return answer;
    }
}