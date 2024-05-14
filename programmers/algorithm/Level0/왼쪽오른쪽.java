package Level0;

import java.util.ArrayList;
import java.util.List;

public class 왼쪽오른쪽 {
    public String[] solution(String[] str_list) {
        List<String> list = new ArrayList<>();
        int idx = 0;
        String target = "";
        
        for (int i = 0; i < str_list.length; i++) {
            if (str_list[i].equals("l") || str_list[i].equals("r")){
                idx = i;
                target = str_list[i];
                break;
            }
        }
        
        if (target.equals("l")){
            for (int i = 0; i < idx; i++){
                list.add(str_list[i]);
            }
        } else if(target.equals("r")){
            for (int i = idx+1; i < str_list.length; i++){
                list.add(str_list[i]);
            }
        }
        
        String[] answer = new String[list.size()];
        for (int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}
