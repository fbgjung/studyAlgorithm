import java.util.*;

class 괄호회전하기 {
    public int hi(String s) {
        int answer = 0;
        for (int i = 0; i < s.length(); i++){
            Stack<Character> stack = new Stack<>();
            String str = s.substring(i, s.length()) + s.substring(0, i); // 문자열 회전

            for (int j = 0; j < s.length(); j++){
                char c = str.charAt(j);
                if(stack.isEmpty()){
                    stack.push(c);
                } else if (c == ')' && stack.peek() == '(') {
                    stack.pop();
                } else if (c == '}' && stack.peek() == '{') {
                    stack.pop();
                } else if (c == ']' && stack.peek() == '[') {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
            if (stack.isEmpty()){
                answer++;
            }
        }
        return answer;
    }
}
