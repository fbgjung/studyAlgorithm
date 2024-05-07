package Level0;

public class 문자열바꿔서찾기 {
    /**
     * 문자열은 불면이기 때문에 myString.charAt(i) = 'B' 와 같은 형식으로 사용할 수 없다.
     * 대신, 새로운 문자열에 추가해주는 방식으로 구현했다.
     */
    public int solution(String myString, String pat) {
        int answer = 0;
        String myNewString = "";
        for (int i = 0; i < myString.length(); i++){
            if(myString.charAt(i) == 'A') myNewString += "B";
            if(myString.charAt(i) == 'B') myNewString += "A";
            
        }
        
        if (myNewString.contains(pat)){
            answer = 1;
        } else {answer = 0;}
        return answer;
    }
    
}
