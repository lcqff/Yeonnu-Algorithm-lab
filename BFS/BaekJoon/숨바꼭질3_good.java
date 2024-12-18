package BFS.BaekJoon;

// https://www.acmicpc.net/problem/13549
// gold 5

import java.io.*;
import java.util.*;

public class 숨바꼭질3_good {
    // BFS
    // 0. if (k==x) min = Math.min(min,t);
    // 1. if(k<x) { n-1로 1초의 시간을 들여 이동한다; t++ }
    // 2. n+1로 1초의 시간을 들여 이동한다. t--
    // 3. 또는 2n으로 0초의 시간을 들여 이동한다.

    static int n; // 수빈이 위치
    static int k; // 동생 위치
    static boolean[] visited = new boolean[100001];

    //static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int t = BFS();

        bw.write(Integer.toString(t));

        br.close();
        bw.flush();
        bw.close();
    }

    private static int BFS() {
        Deque<Node> node = new LinkedList<>();
        node.offer(new Node(n, 0));

        while (!node.isEmpty()) {
            Node current = node.poll();
            int x = current.getX();
            int t = current.getT();

            //System.out.printf("x = %d, t = %d \n", x, t);
            if (x < 0 || x > 100000) {
                continue;
            }
            if (visited[x]) {
                continue;
            }

            if (k == x) {
                return t;
            }

            visited[x] = true;

            if (x < k) {
                if (x * 2 <= 100000) {
                    node.addFirst(new Node(x * 2, t)); //큐의 제일 앞에 추가하도록 한다. (우선순위 높음)
                }
                node.offer(new Node(x + 1, t + 1));
            }

            if (x >= 1) {
                node.offer(new Node(x - 1, t + 1));
            }
        }

        return -1;
    }
}

class Node {
    int x; //현재 위치
    int t; //걸린 시간

    public int getX() {
        return this.x;
    }

    public int getT() {
        return this.t;
    }

    public Node(int x, int t) {
        this.x = x;
        this.t = t;
    }
}