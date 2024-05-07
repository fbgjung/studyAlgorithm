package Level0;

public class 꼬리문자열 {
    public String solution(String[] str_list, String ex) {
        String answer = "";
        for (String str : str_list){
            if(str.contains(ex)){
                continue; 
            }
            answer += str;
        }
        return answer;
    }
}
