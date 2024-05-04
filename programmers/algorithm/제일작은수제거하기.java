import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        
        List<Integer> answer = new ArrayList<>();
        int minNum = 99999;
        
        for (int a : arr) {
            minNum = Math.min(minNum, a);
        }
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == minNum) {
                continue;
            } else {
                answer.add(arr[i]);
            }
        }
        
        if (answer.size() == 0) {
            answer.add(-1);
        }
        
        int[] result = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            result[i] = answer.get(i).intValue();
        }

        return result;
    }
}