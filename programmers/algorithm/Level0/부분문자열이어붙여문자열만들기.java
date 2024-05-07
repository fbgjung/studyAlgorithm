package Level0;

public class 부분문자열이어붙여문자열만들기 {
    public String solution(String[] my_strings, int[][] parts) {
        String answer = "";
        for (int i = 0; i < my_strings.length; i++){
            for (int j = parts[i][0]; j <= parts[i][1]; j++){
                answer += my_strings[i].charAt(j);
            }
        }
        return answer;
    }
}
