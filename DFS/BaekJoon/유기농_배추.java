package DFS.BaekJoon;

import java.util.Arrays;
import java.util.Scanner;

// https://www.acmicpc.net/problem/1012
// silver 2
public class 유기농_배추 {
    // 1. 전체 map을 돌아가며 1인 부분을 찾는다.
    // 2. 1인 부분을 찾으면 DFS 완전탐색한다.
    // 3. 방문한 부분은 0으로 바꾼다.
    // 4. 완전 탐색이 종료되면 배추흰나비를 +1한다.
    // 5. 1 반복

    static int t; //테스트 케이스의 개수
    static int n; // 배추밭의 가로길이
    static int m; // 세로길이
    static int k; // 배추가 심어져 있는 위치의 개수

    static int warm = 0;

    static int[][] cabbages = new int[51][51];
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        t = sc.nextInt();
        for (int i = 0; i < t; i++) { //각 테스트 케이스별 결과 도출
            testCase();
        }

        for (int i = 0; i < t; i++) { //각 테스트 케이스별 결과 도출

        }
    }

    private static void testCase() {
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < k; i++) { //배추 위치 입력
            int[] cabbage = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int x = cabbage[0];
            int y = cabbage[1];
            cabbages[y][x] = 1;
        }

//        for (int i = 0; i < m; i++) { //배추밭 출력
//            for (int j = 0; j < n; j++) {
//                System.out.print(cabbages[i][j] + " ");
//            }
//            System.out.println();
//        }

        // 1. 전체 map을 돌아가며 1인 부분을 찾는다.
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (cabbages[i][j] == 1) {
                    // 2. 1인 부분을 찾으면 DFS 완전탐색한다.
                    DFS(i, j);
                    // 4. 완전 탐색이 종료되면 배추흰나비를 +1한다.
                    warm++;
                }
            }
        }

        System.out.println(warm);
        warm = 0;
    }

    public static void DFS(int x, int y) {
        if (x >= m || x < 0 || y >= n || y < 0) {
            return;
        }
        if (cabbages[x][y] == 0) {
            return;
        }

        // 3. 방문한 부분은 0으로 바꾼다.
        cabbages[x][y] = 0;
        DFS(x - 1, y);
        DFS(x + 1, y);
        DFS(x, y - 1);
        DFS(x, y + 1);
    }
}
