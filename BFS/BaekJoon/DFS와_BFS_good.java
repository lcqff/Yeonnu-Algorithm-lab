package BFS.BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/1260
//sliver 2

public class DFS와_BFS_good {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //정점 수
        int m = Integer.parseInt(st.nextToken()); //간선 수
        int v = Integer.parseInt(st.nextToken()); //시작 정점

        int[][] connections = new int[n+1][n+1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int startP = Integer.parseInt(st.nextToken());
            int targetP = Integer.parseInt(st.nextToken());
            connections[startP][targetP] = 1;
            connections[targetP][startP] = 1;
        }

        //System.out.println(Arrays.deepToString(connections));

        boolean[] visited = new boolean[n+1];
        DFS(connections, v, visited);
        bw.write("\n");
       visited = new boolean[n+1];
        BFS(connections, v, visited);

        br.close();
        bw.flush();
        bw.close();
    }

    private static void DFS(int[][] connections, int p, boolean[] visited) throws IOException {
        //재귀
        //System.out.println("point: " + p);

        if (visited[p]) return; //방문한 적 있다.

        bw.write(Integer.toString(p) + ' ');
        visited[p] = true;
        for (int i = 0; i<connections[p].length; i++) {
            int np = connections[p][i];
            if (np != 0) {
                //System.out.println("is Connected to " + i);
                DFS(connections, i, visited);
            }
        }
    }

    private static void BFS(int[][] connections, int p, boolean[] visited) throws IOException {
        //Queue
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(p, connections[p]));

        while(!q.isEmpty()) {
            Node n = q.poll();
            int cp = n.getP();
            int[] connectedP = n.getC();

            if (visited[cp]) continue;

            visited[cp] = true;
            bw.write(cp + " ");

            for (int i=0; i<connectedP.length; i++) {
                if (connectedP[i] != 0) {
                    q.offer(new Node(i,connections[i]));
                }
            }
        }
    }

    public static class Node {
        int p;
        int[] c;

        public Node(int p, int[] c) {
            this.p = p;
            this.c = c;
        }

        public int getP() {
            return this.p;
        }

        public int[] getC() {
            return this.c;
        }
    }
}