package BFS.BaekJoon;

import java.util.*;

// https://www.acmicpc.net/problem/14940
// Silver 1

public class 쉬운_최단거리 {
    static int[][] map = new int[1001][1001];
    static int[][] res = new int[1001][1001];
    static int n;
    static int m;

    static int[][] yx = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}}; //상우하좌

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); //세로 크기 (y)
        m = sc.nextInt(); //가로 크기 (x)
        sc.nextLine();

        int startX=0;
        int startY=0;
        for (int i = 0; i < n; i++) { //y
            for (int j = 0; j < m; j++) { //x
                map[i][j] = sc.nextInt();
                if (map[i][j] == 2) {
                    startX=j;
                    startY=i;
                }
                res[i][j] = (map[i][j] == 1) ? -1 : 0;
            }
        }

        BFS(startY, startX);

        for (int i = 0; i < n; i++) {
            for (int j=0; j<m; j++) {
                System.out.print(res[i][j]+ " ");
            }
            System.out.println();
        }
    }

    public static int BFS(int i, int j) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(i, j, 0));
        res[i][j] = 0;

        while (!q.isEmpty()) {
            Node node = q.poll();

            for (int t = 0; t < 4; t++) {
                int ny = node.getY() + yx[t][0];
                int nx = node.getX() + yx[t][1];
                int distance = node.getDistance();
                //System.out.println(ny + ", " + nx + "," + distance);

                if (ny >= n || ny < 0 || nx >= m || nx < 0) {
                    continue;
                }

                if (map[ny][nx] == 0) {
                    continue;
                }

                if (map[ny][nx] == 1) {
                    q.offer(new Node(ny, nx, distance + 1));
                    res[ny][nx] = distance + 1;
                    map[ny][nx] = 0;
                }
            }
        }
        return -1;
    }

    public static class Node {
        int y = 0;
        int x = 0;

        int distance = 0;

        public Node(int y, int x, int distance) {
            this.y = y;
            this.x = x;
            this.distance = distance;
        }

        public int getY() {
            return y;
        }

        public int getX() {
            return x;
        }

        public int getDistance() {
            return distance;
        }
    }
}