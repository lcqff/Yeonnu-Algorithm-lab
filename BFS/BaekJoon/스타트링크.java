package BFS.BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 스타트링크 {
    static int[] visited; // 메모리 초과 방지

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int f = Integer.parseInt(st.nextToken()); // 총 높이
        int s = Integer.parseInt(st.nextToken()); // 현재 위치
        int g = Integer.parseInt(st.nextToken()); // 목표 위치
        int u = Integer.parseInt(st.nextToken()); // 한번에 올라가는 높이
        int d = Integer.parseInt(st.nextToken()); // 한번에 내려가는 높이

        visited = new int[f+1];
        Arrays.fill(visited,Integer.MAX_VALUE);

        int res = BFS(f, s, g, u, d);
        if (res == -1) {
            bw.write("use the stairs");

        } else {
            bw.write(res + "");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static int BFS(int f, int s, int g, int u, int d) {
        if (s == g) return 0;

        Queue<Floor> floor = new LinkedList<>();
        floor.offer(new Floor(s, 0));
        visited[s] = 0;
        int[] upDown = new int[] {u,-d};

        while (!floor.isEmpty()) {
            Floor currentF = floor.poll();
            int c = currentF.current;
            int n = currentF.num;

            //System.out.println(c + " " + n);
            // 올라가는 경우
            for (int nextMove : upDown){
                int nextFloor = c + nextMove;
                if (nextFloor == g) {
                    return n + 1;
                }

                if (nextFloor > f || nextFloor < 1 || nextFloor == c) {
                    continue;
                }
                if (visited[nextFloor] <= n) {
                    continue;
                }
                visited[nextFloor] = n;
                floor.add(new Floor(nextFloor, n + 1));
            }
        }

        return -1;
    }

    static class Floor {
        int current;
        int num;

        public Floor(int current, int num) {
            this.current = current;
            this.num = num;
        }
    }
}
