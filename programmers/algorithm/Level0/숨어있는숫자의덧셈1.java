package Level0;

class 숨어있는숫자의덧셈1 {
    public int solution(String my_string) {
        int answer = 0;
        String[] arr = my_string.split("");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].matches("[0-9]")){
                answer += Integer.parseInt(arr[i]);
            }
        }
        return answer;
    }
}