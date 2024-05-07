package Level0;

class 문자열뒤집기2 {
    /**
     * 코딩 기초 트레이닝
     */
    public String solution(String my_string, int s, int e) {
        StringBuilder answer = new StringBuilder(my_string.substring(s, e+1));
        answer.reverse();
        return my_string.substring(0,s) + answer + my_string.substring(e+1, my_string.length());
    }
}