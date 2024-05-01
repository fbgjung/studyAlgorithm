import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photos) {  
        
        List<Integer> result = new ArrayList<>();
        Map<String, Integer> datas = new HashMap<>();
        
        for (int i = 0; i < name.length;i++) {
            datas.put(name[i], yearning[i]);
        }
        
        for (String[] photo : photos){
            int temp = 0;
            for (String p : photo) {
                
                if (datas.get(p) == null) {
                    temp += 0;
                } else {
                    temp += datas.get(p);
                }
            }
            result.add(temp);
        }
        
        // Integer일 경우, List -> Array
        int[] answer = new int[result.size()];
        for (int i = 0 ; i < result.size() ; i++) {
            answer[i] = result.get(i).intValue();
        }
        
        return answer;
    }
}