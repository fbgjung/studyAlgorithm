import java.util.Arrays;

public class 가장많이받은선물 {
    public int solution(String[] friends,  String[] gifts) {
        int result = 0;
        int n = friends.length;
        int map[][] = new int[n][n];

        for (int i = 0; i < gifts.length; i++) {
            String[] gift = gifts[i].split(" ");
            String a = gift[0];
            String b = gift[1];

            int aIdx = Arrays.asList(friends).indexOf(a);
            int bIdx = Arrays.asList(friends).indexOf(b);

            map[aIdx][bIdx]++;
        }
    
        // 선물 지수 계산
        int[] giftRate = new int[n];
        for (int i = 0; i < n; i++) {
            int give = 0;
            int take = 0;
            for (int j = 0; j < n; j++) {
                give += map[i][j];
                take += map[j][i];
            }
            giftRate[i] = give - take;
        }

        // 누가 다음달에 선물을 가장 많이 받을지 계산
        for (int i = 0; i < n; i++) {
            int temp = 0;
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                
                if (map[i][j] > map[j][i] || (map[i][j] == map[j][i] && giftRate[i] > giftRate[j])) {
                    temp++;
                }
            }

            if (temp > result) result = temp;
        }

        return result;
    }
    
    public static void main(String[] args) {
        가장많이받은선물 solutionInstance1 = new 가장많이받은선물();
        int result1 = solutionInstance1.solution(new String[] {"muzi", "ryan", "frodo", "neo"}, new String[] {"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"});        
        System.out.println(result1);

        가장많이받은선물 solutionInstance2 = new 가장많이받은선물();
        int result2 = solutionInstance2.solution(new String[]{"a", "b", "c"}, new String[]{"a b", "b a", "c a", "a c", "a c", "c a"});
        System.out.println(result2);

        가장많이받은선물 solutionInstance3 = new 가장많이받은선물();
        int result3 = solutionInstance3.solution(new String[]{"joy", "brad", "alessandro", "conan", "david"}, new String[]{"alessandro brad", "alessandro joy", "alessandro conan", "david alessandro", "alessandro david"});
        System.out.println(result3);
    }
}
