/**
 * 부분 실패
 */
// class 이상한문자만들기fail {
//     public String solution(String s) {
//         StringBuilder sb = new StringBuilder();
        
//         String[] arr = s.split(" ");
        
//         for (String a : arr){
//             for (int i = 0; i < a.length(); i++){
                
//                 if(i % 2 == 0){
//                     char c = Character.toUpperCase(a.charAt(i));
//                     sb.append(c);
//                 } else {
//                     char c = Character.toLowerCase(a.charAt(i));
//                     sb.append(c);
//                 }
//             }
//             sb.append(" ");
//         }
        
//         sb.deleteCharAt(sb.length() - 1); // 마지막 공백 제거
//         return sb.toString();
//     }
// }


/**
 * 반례 등장
 */
class 이상한문자만들기 {
    public String solution(String s) {
        int idx = 0;
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == ' ') {
                idx = 0;
                sb.append(s.charAt(i));
                continue;
            } else {
                if (idx % 2 == 0) {
                    char c = Character.toUpperCase(s.charAt(i));
                    sb.append(c);
                    idx++;
                } else {
                    char c = Character.toLowerCase(s.charAt(i));
                    sb.append(c);
                    idx++;
                }
            }
        }
        return sb.toString();
    }
}
