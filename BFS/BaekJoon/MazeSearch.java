package BFS.BaekJoon;
//silver 1

import BFS.node.Node2;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MazeSearch {

    static int n, m;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine();
        int[][] maze = new int[101][101];
        for (int i = 0; i < n; i++) {
            maze[i] = Arrays.stream(sc.nextLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        System.out.println(BFS(maze, 0, 0));

    }

    private static int BFS(int[][] maze, int x, int y) {
        Queue<Node2> q = new LinkedList<>();
        q.offer(new Node2(x, y));
        while (!q.isEmpty()) {
            Node2 node = q.poll();
            x = node.getX();
            y = node.getY();
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }
                if (maze[nx][ny] == 0) {
                    continue;
                }
                if (maze[nx][ny] == 1) {
                    maze[nx][ny] = maze[x][y] + 1;
                    q.offer(new Node2(nx, ny));
                }
            }
        }
        return maze[n - 1][m - 1];
    }
}
