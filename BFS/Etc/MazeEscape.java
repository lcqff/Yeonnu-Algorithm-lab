package BFS.Etc;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node {
    private int x;
    private int y;

    public Node(int x, int y) {
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

public class MazeEscape {
    static int n,m;
    static int[][] maze = new int[201][201];
    public static int dx[] = {-1, 1, 0, 0};
    public static int dy[] = {0, 0, -1, 1};

    private static int BFS(int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(x, y));
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            x = node.getX();
            y = node.getY();
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= n || nx < 0 || ny >= m || ny < 0) {
                    continue;
                }
                if (maze[nx][ny] == 0) {
                    continue;
                }
                if (maze[nx][ny] == 1){
                    maze[nx][ny] = maze[x][y] + 1;
                    queue.offer(new Node(nx,ny));
                }
            }
        }
        return maze[n-1][m-1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            maze[i] = Arrays.stream(sc.nextLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        System.out.println(BFS(0, 0));

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <m ; j++) {
                System.out.print(maze[i][j]);
            }
            System.out.println();
        }
    }
}
