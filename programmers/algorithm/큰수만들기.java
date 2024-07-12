
class 큰수만들기 {
    static String solution(String number, int k) {
        String answer = "";
        StringBuilder sb = new StringBuilder();

        int len = number.length() - k; // 구해야하는 길이
        char[] arr = number.toCharArray();

        int startIdx = 0;
        for (int i = 0; i < len; i++) {
            char max = '0';
            for (int j = startIdx; j <= i + k; j++) {
                if (arr[j] > max) {
                    max = arr[j];
                    startIdx = j + 1;
                }
            }
            sb.append(Character.toString(max));
        }
        System.out.println(sb);
        answer = sb.toString();
        return answer;
    }

    public static void main(String[] args) {
        solution("1924", 2); // 94
        solution("1231234", 3); // 3234
        solution("4177252841", 4); // 775841
    }      
}
