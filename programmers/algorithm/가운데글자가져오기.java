public class 가운데글자가져오기 {
    public String solution(String s) {
        String answer = "";
        int startIdx = 0;
        String[] array = s.split("");
        
        if (s.length() % 2 == 0){
            startIdx = s.length() / 2;
            for (int i = startIdx-1; i <= startIdx; i++){
                answer += array[i];
            }
        } else {
            startIdx = (s.length()-1) / 2;
            answer += array[startIdx];
        }
        
        return answer;
    }
}
