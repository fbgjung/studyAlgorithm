class 자연수뒤집어배열로만들기 {
    public int[] solution(long n) {
        String str = String.valueOf(n);
        String[] strarray = str.split("");
        int idx = 0;
        int[] answer = new int[strarray.length];
        for (int i = strarray.length-1; i>=0; i--){
            answer[idx++] = Integer.parseInt(strarray[i]);
        }        
        return answer;
    }
}