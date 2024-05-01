class Solution {
    public int solution(int[] array) {
        int answer = 0;
        for (int a : array){
            String str_a = Integer.toString(a);
            String[] seven_array = str_a.split("");
            for (String seven : seven_array) {
                if (seven.equals("7")) {
                    answer += 1;
                }
            }
        }
        return answer;
    }
}