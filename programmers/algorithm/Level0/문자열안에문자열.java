package Level0;

public class 문자열안에문자열 {
    // str1 안에 str2가 있다면 1 없다면 2 반환
    /**
     * 문자열끼리는 contains 쓸 수 있다.
     */
    public int solution(String str1, String str2) {
        int answer = 0;
        if(str1.contains(str2)){
            answer = 1;
        } else {answer = 2;}
        return answer;
    }
}
