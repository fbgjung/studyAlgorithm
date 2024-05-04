class 공원산책 {
    public int[] solution(String[] park, String[] routes) {

        int xLen = park.length;
        int yLen = park[0].length();

        int xCurrent = 0;
        int yCurrent = 0;

        char[][] arr = new char[xLen][yLen];

        for (int i = 0; i < xLen; i++) {
            arr[i] = park[i].toCharArray();
            if (park[i].contains("S")) {
                xCurrent = i;
                yCurrent = park[i].indexOf("S");
            }
        }

        for (String route : routes) {
            String[] routeArray = route.split(" ");
            String vector = routeArray[0];
            int num = Integer.parseInt(routeArray[1]); 

            int nx = xCurrent; 
            int ny = yCurrent;

            for (int i = 0; i < num; i++){
                if (vector.equals("E")) {
                    ny++ ;
                }
                if (vector.equals("W")) {
                    ny--;
                }
                if (vector.equals("S")) {
                    nx++;
                }
                if (vector.equals("N")) {
                    nx--;
                }
    
                if (nx >= 0 && ny >= 0 && nx < xLen && ny < yLen) {
                    if (arr[nx][ny] == 'X') {
                        break;
                    }

                    if (i == num-1) {
                        xCurrent = nx;
                        yCurrent = ny;
                    }
                }
            }

        }
        int[] answer = {xCurrent, yCurrent};
        return answer;
    }
}
