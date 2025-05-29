package Dijkstra.BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/4485
// gold 4

public class 녹색_옷_입은_애가_젤다지 {
    static int n;
    static int[][] map;
    static int[][] move = new int[][]{
            {-1, 0, 1, 0}, //u l d r
            {0, -1, 0, 1}
    };

    static int[][] res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int k = 0;

        while (true) {
            n = Integer.parseInt(br.readLine());
            k++;
            map = new int[n][n];
            res = new int[n][n];
            if (n == 0) {
                break;
            }
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                Arrays.fill(res[i], Integer.MAX_VALUE);
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            dijkstra();

            //System.out.println(res[n-1][n-1]);
            bw.write("Problem " + k + ": " + res[n - 1][n - 1] + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        pq.add(new Node(0, 0, map[0][0]));
        res[0][0] = map[0][0];

        while (!pq.isEmpty()) {
            Node cn = pq.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cn.x + move[0][i];
                int ny = cn.y + move[1][i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                    continue;
                }

                int ncost = cn.cost + map[nx][ny];
                if (res[nx][ny] > ncost) { //기록된 값보다 더 작다면
                    res[nx][ny] = ncost;
                    pq.add(new Node(nx, ny, ncost));
                }
            }
        }
    }

    private static class Node implements Comparable<Node> {
        int x;
        int y;
        int cost;

        Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node other) {
            return this.cost - other.cost; // 오름차순 (비용이 적은 순)
        }
    }
}
