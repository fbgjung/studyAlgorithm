package Level0;

import java.util.ArrayList;
import java.util.List;

public class 배열의원소삭제하기 {
    public int[] solution(int[] arr, int[] delete_list) {
        List<Integer> list = new ArrayList<>();
        
        for (int a : arr) {
            list.add(a);
        }
        
        for (int del : delete_list){
        
            int index = list.indexOf(del);
            if(index != -1) {
                list.remove(index);
            }
        }
        
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    } 
}
