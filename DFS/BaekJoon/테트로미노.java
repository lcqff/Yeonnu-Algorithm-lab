package DFS.BaekJoon;

import java.util.*;

// https://www.acmicpc.net/problem/14500
// gold 4
public class 테트로미노 {
    // 1. 1번 칸부터 시작하여 깊이 4까지 이어지는 노드의 모든 경우의 수를 구한다. (DFS)
    // 2. DFS가 끝나면 1번칸은 방문 처리한다 (0 저장)
    // 3. 모든 경우의 수중 합의 최댓값을 저장한다.
    // 3. 방문하지 않은 다음 노드에서 위를 반복한다. (미방문 노드가 3개 남을때까지)


    static int n;
    static int m;

    static int[][] map = new int[501][501];

    static boolean[][] visited = new boolean[501][501];

    static int max = Integer.MIN_VALUE;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // 세로 크기 (x)
        m = sc.nextInt(); // 가로 크기 (y)

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
                // System.out.print(map[i][j] + " ");
            }
            // System.out.println();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = true;
                DFS(i, j, 1, map[i][j]);
                visited[i][j] = false;
            }
        }
        System.out.println(max);
    }

    private static void DFS(int x, int y, int depth, int size) {
        if (depth >= 4) { //크기 4에 도달할 경우 반환
            max = Math.max(max, size);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                continue;
            }
            if (visited[nx][ny]) { // 이미 방문한 경우
                continue;
            }
            visited[nx][ny] = true;
            DFS(nx, ny, depth + 1, size + map[nx][ny]);
            if(depth+1 == 3) { // ㅗ 모양을 찾는다
                DFS(x, y, depth + 1, size + map[nx][ny]);
            }
            visited[nx][ny] = false;
        }
    }
}
