package BFS.BaekJoon;

//https://www.acmicpc.net/problem/16234
//gold 4

import java.io.*;
import java.util.*;

public class 인구이동 {
    static int n, l, r;
    static int[][] map;
    static int[][] moves = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}}; //상좌하우
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int res = 0;
        while (true) {
            //System.out.println("round: " + res);
            visited = new boolean[n][n]; //초기화
            boolean updated = false;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j]) {
                        visited[i][j] = true;
                        updated =  BFS(i, j) || updated; // 전체 map을 순회하며 하나씩 BFS하며 연합을 구한다.
                    }
                }
            }
            if (!updated) break; //만일 업데이트가 한개도 발생하지 않았으면 탈출

//            for (int i = 0; i < n; i++) {
//                for (int j = 0; j < n; j++) {
//                    System.out.print(map[i][j] + " ");
//                }
//                System.out.println();
//            }
            res++;
        }

        bw.write(res + " ");
        br.close();
        bw.flush();
        bw.close();
    }

    private static boolean BFS(int x, int y) {
        Queue<Node> contry = new LinkedList<>();
        Node node = new Node(x, y);
        contry.offer(node);

        List<int[]> union = new ArrayList<>(); // 최종값이 연합이 된다.
        union.add(new int[]{x,y});
        int sum = map[x][y];

        while (!contry.isEmpty()) {
            Node cn = contry.poll();
            int cx = cn.x;
            int cy = cn.y;

            for (int[] move : moves) {
                int nx = cx + move[0];
                int ny = cy + move[1];

                if (nx >= n || nx < 0 || ny >= n || ny < 0) {
                    continue;
                }
                if (visited[nx][ny]) continue;
                if (Math.abs(map[cx][cy] - map[nx][ny]) >= l && Math.abs(map[cx][cy] - map[nx][ny]) <= r) {
                    visited[nx][ny] = true;
                    union.add(new int[]{nx,ny});
                    sum = sum + map[nx][ny];
                    contry.offer(new Node(nx, ny));
                }
            }
        }
        if(union.size() > 1) {
            for (int[] location : union) { // 연합이 구해졌으면 연합을 계산해 Map을 초기화 시킨다.
                //System.out.print(Arrays.toString(location) + " ");
                map[location[0]][location[1]] = sum/union.size();
            }
            return true;
        }
        //System.out.println(Arrays.toString(visitedContry.get(0)));
        return false;
    }

    static class Node {
        int x;
        int y;


        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
