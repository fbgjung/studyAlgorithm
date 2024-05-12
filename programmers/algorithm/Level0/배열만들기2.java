package Level0;

import java.util.ArrayList;
import java.util.List;

/**
 * 이렇게 푼 사람 또 있을까.. ..
 */
public class 배열만들기2 {
    public int[] solution(int l, int r) {
        
        List<Integer> list = new ArrayList<>();
        for (int i = l; i <= r; i++){
            if (Integer.toString(i).contains("1") || Integer.toString(i).contains("2") || Integer.toString(i).contains("3") || Integer.toString(i).contains("4") || Integer.toString(i).contains("6") || Integer.toString(i).contains("7") || Integer.toString(i).contains("8") || Integer.toString(i).contains("9")) {
                continue;
                
            } else { list.add(i);}
        }
       
        if(list.size() == 0) {
            list.add(-1);
        }
        
        int[] answer = new int[list.size()];
         
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
    
}
