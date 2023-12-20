package chapter5_DFS_BFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node2 {
    int x;
    int y;

    public Node2(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

public class MazeEscape2 {
    static int n, m;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int[][] maze = new int[201][201];
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            maze[i] = Arrays.stream(sc.nextLine().split("")).mapToInt(Integer::parseInt).toArray();
        }



        System.out.println(BFS(maze, 0, 0));

    }

    private static int BFS(int[][] maze, int x, int y) {
        Queue<Node2> queue = new LinkedList<Node2>();
        queue.offer(new Node2(x, y));
        while (!queue.isEmpty()) {
            Node2 node = queue.poll();
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
                    queue.offer(new Node2(nx, ny));
                    maze[nx][ny] = maze[x][y] + 1;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <m ; j++) {
                System.out.print(maze[i][j]);
            }
            System.out.println();
        }
        return maze[n-1][m-1];
    }
}
