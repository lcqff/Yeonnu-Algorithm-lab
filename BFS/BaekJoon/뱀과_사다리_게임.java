package BFS.BaekJoon;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/16928
// gold 5

public class 뱀과_사다리_게임 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 사다리의 수
        int m = Integer.parseInt(st.nextToken()); // 뱀의 수

        HashMap<Integer, Integer> ladders = new HashMap<>();
        HashMap<Integer, Integer> snakes = new HashMap<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int startIdx = Integer.parseInt(st.nextToken());
            int endIdx = Integer.parseInt(st.nextToken());
            ladders.put(startIdx, endIdx);
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int startIdx = Integer.parseInt(st.nextToken());
            int endIdx = Integer.parseInt(st.nextToken());
            snakes.put(startIdx, endIdx);
        }

        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(1, 0));
        int[] board = new int[101];
        Arrays.fill(board, 101);
        board[1] = 0;

        while (!q.isEmpty()) {
            Node currentN = q.poll();
            int cIdx = currentN.getIdx();
            int cNum = currentN.getDiceNum();

            if (cIdx == 100) {
                bw.write(cNum + " ");
                break;
            }

            for (int i=1; i<=6; i++) {
                int nIdx = cIdx + i;
                if (nIdx > 100) continue;

                if (ladders.containsKey(nIdx)) {
                    nIdx = ladders.get(nIdx);
                }
                if (snakes.containsKey(nIdx)) {
                    nIdx = snakes.get(nIdx);
                }
                // 더 적은 횟수로 이동할 수 있는 경우에만 큐에 추가
                if (board[nIdx] > cNum + 1) {
                    board[nIdx] = cNum + 1;
                    q.offer(new Node(nIdx, cNum + 1));
                }
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }

    static class Node {
        int index;
        int diceNum;

        public Node(int index, int diceNum) {
            this.index = index;
            this.diceNum = diceNum;
        }

        public int getIdx() {
            return this.index;
        }

        public int getDiceNum() {
            return this.diceNum;
        }
    }
}
