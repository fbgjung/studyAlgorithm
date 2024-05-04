
class 자릿수더하기 {
    public int solution(int n) {
        int answer = 0;
        String str_n = Integer.toString(n);

        String[] arr = str_n.split("");
        
        for (String a : arr){
            answer += Integer.parseInt(a);
        }

        return answer;
    }
}