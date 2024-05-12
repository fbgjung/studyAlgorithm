/**
 * 실패 코드 (시간초과, 실패)
 */
// class 숫자짝꿍fail {
//     public String solution(String X, String Y) {
//         String answer = "";
//         List<Character> list = new ArrayList<>();
//         char[] Xarr = X.toCharArray();
//         char[] Yarr = Y.toCharArray();
        
//         for (int i = 0; i < X.length(); i++) {
//             for (int j = 0; j < Y.length(); j++) {
                
//                 if(Xarr[i] == Yarr[j]){
//                     list.add(Xarr[i]);
//                     Yarr[j] = '.'; 
                    
//                 }
//             }
//         }
        
//         if (list.size() == 0){
//             answer = "-1";
//         } else {
//             Collections.sort(list, Collections.reverseOrder());
//             for (char l : list) {
//                 answer += l;
//             }
//         }
        
//         answer = answer.replaceAll("^[0][0]$", "0"); // 이렇게하면, 반례 0000, 000 일때 !!
//         return answer;
//     }
// }

class 숫자짝꿍 {
    public String solution(String X, String Y) {
        StringBuilder sb = new StringBuilder();
        String answer = "";

        int[] x = {0,0,0,0,0,0,0,0,0,0};
        int[] y = {0,0,0,0,0,0,0,0,0,0};
        
        for (int i = 0; i < X.length(); i++){
            x[X.charAt(i)-48]++;
        }
        for (int i = 0; i < Y.length(); i++){
            y[Y.charAt(i)-48]++;
        }
        
        for (int i = 9; i >= 0; i--){
            for (int j = 0; j < Math.min(x[i], y[i]); j++){
                sb.append(i);
            }
        }
        
        answer = sb.toString();
        if (answer.length() == 0) {
            return "-1";
        } else if(answer.charAt(0) == '0'){
            return "0";
        }
        
        return answer;
    }
}