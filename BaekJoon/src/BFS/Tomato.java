package BFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//gold 5 7576

/**
 * 동시에 깊이를 탐색해야 하는 문제인 경우 해당 지점들 먼저 큐에 저장해두기
 */


public class Tomato {
    static int m, n;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] tomatoes = new int[1001][1001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt(); //상자 가로칸 수
        n = sc.nextInt(); //상자 세로칸 수
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            tomatoes[i] = Arrays.stream(sc.nextLine()
                            .split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        Queue<Node> q = new LinkedList<>();
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <m ; j++) {
                if (tomatoes[i][j] == 1) {
                    q.offer(new Node(i,j)); // 익은 토마토 좌표 먼저 큐에 저장
                }
            }
        }

        int res = bfs(q);

        for (int i = 0; i <n ; i++) { //안 익은 토마토 존재
            for (int j = 0; j <m ; j++) {
                if (tomatoes[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }
//
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j <m ; j++) {
//                System.out.print(tomatoes[i][j] + " ");
//            }
//            System.out.println();
//        }

        System.out.println(res==0 ? 0 : res-1);
    }

    private static int bfs(Queue<Node> q) {
        int result = 0;
        while (!q.isEmpty()) {
            Node node = q.poll();
            int x = node.getX();
            int y = node.getY();
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= n || nx < 0 || ny >= m || ny < 0) {
                    continue;
                }
                if (tomatoes[nx][ny] == -1 ) { // 비어 있는 칸
                    continue;
                }
                if (tomatoes[nx][ny] == 0) { //안익은 토마토
                    q.offer(new Node(nx,ny));
                    tomatoes[nx][ny] = tomatoes[x][y]+1;
                    //System.out.printf("%d %d %d\n",nx,ny,tomatoes[nx][ny]);
                    result = tomatoes[nx][ny];
                }
            }
        }
        return result;
    }
}
