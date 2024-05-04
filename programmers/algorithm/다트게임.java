class 다트게임 {
    public int solution(String dartResult) {
        int[] scores = new int[3];
        int index = -1;
        int answer = 0;
        
        String[] dart = dartResult.split("");

        for (int i = 0; i < dart.length; i++) {
            if(dart[i].matches("[0-9]")) {
                index++;
                scores[index] = Integer.parseInt(dart[i]);

                if(dart[i+1].matches("[0-9]")) {
                    scores[index] *= 10;
                    i++;
                }
            }

            switch(dart[i]) {
                case "D":
                    scores[index] = (int)Math.pow(scores[index], 2);
                    break;
                case "T":
                    scores[index] = (int)Math.pow(scores[index], 3);
                    break;
                case "*":
                    scores[index] *= 2;
                    if(index-1 >= 0) scores[index-1] *= 2;
                    break;
                case "#":
                    scores[index] *= -1;
            }
        }

        for(int score : scores) {
            answer += score;
        }

        return answer;
    }
}