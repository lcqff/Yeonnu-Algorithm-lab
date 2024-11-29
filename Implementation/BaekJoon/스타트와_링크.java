package Implementation.BaekJoon;

import java.util.*;

/**
 * https://www.acmicpc.net/problem/14889
 * silver 1
 */

//4
//0 1 2 3
//4 0 5 6
//7 1 0 2
//3 4 5 0

//4
//0 5 9 6
//5 0 6 10
//9 6 0 7
//6 10 7 0

public class 스타트와_링크 {
    // 1. n명중에서 n/2명을 선택하는 모든 경우의 수를 구한다 (조합, 백트래킹)
    // 2. 조합 중에서 S1과 S2의 모든 경우의 차를 구한다.
    // 3. 그 중 최솟값을 반환한다.

    public static int n;
    public static int[][] power = new int[21][21];
    public static boolean[] visited = new boolean[101];
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        sc.nextLine();
        for ( int i=0; i<n; i++) {
            power[i] = Arrays.stream(sc.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        // 2. n명중에서 n/2명을 선택하는 모든 경우의 수를 구한다 (조합, 백트래킹)
        boolean[] visited = new boolean[101];
        comb(0,0);
        System.out.print(min);
    }

    public static void comb(int idx, int count) { //인덱스, 재귀 깊이(조합 개수)
        if (count == n/2) {
            //점수차이 계산
            int team1 = 0;
            int team2 = 0;

            for (int i=0; i<n; i++) {
                for (int j=0; j<n; j++) {
                    if (visited[i] && visited[j]) {
                        team1 += power[i][j];
                    }
                    if (!visited[i] && !visited[j]) {
                        team2 += power[i][j];
                    }
                }
            }

            int res = Math.abs(team1-team2);
            if (res < min) {
                min = res;
            }
            if (res == 0) {
                return; // 종료
            }
        }

        for (int i=idx; i<n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                comb(i+1,count+1);
                visited[i] = false;
            }
        }
    }
}
