class S2016년 {
    /**
     * 1월 1일 금요일
     */
    public String solution(int a, int b) {
        String answer = "";
        String[] day = {"FRI","SAT","SUN", "MON", "TUE", "WED", "THU"};
        int temp = 0;
        int[] num = {31,29,31,30,31,30,31,31,30,31,30,31};
            
        for ( int i = 0; i < a-1; i++) {
            temp += num[i];
        }
        temp += (b-1);
        temp = temp % 7; 
        answer = day[temp];

        return answer;
    }
}