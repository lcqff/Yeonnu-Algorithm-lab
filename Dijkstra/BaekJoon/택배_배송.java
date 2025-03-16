package Dijkstra.BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 택배_배송 {
    // 다익스트라
    static int[] dist; //각 정점까지의 최소 거리 저장용
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>(); //graph[i][j] == i번째 정점의 j번째 간선

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 정점
        int m = Integer.parseInt(st.nextToken()); // 간선
        int start = 1; //시작 정점
        int dest = n; // 도착 정점
        dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        for (int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); // 시작 정점
            int b = Integer.parseInt(st.nextToken()); // 도착 정점
            int c = Integer.parseInt(st.nextToken()); // 길이
            graph.get(a).add(new Node(b,c));
            graph.get(b).add(new Node(a,c));
        }

        dijkstra(1);

        bw.write(dist[n]+"");

        br.close();
        bw.flush();
        bw.close();
    }

    static private void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start,0));
        dist[start] = 0; //시작 노드에서 시작 노드까지의 거리는 0

        while(!pq.isEmpty()) {
            Node node = pq.poll();
            int cn = node.getIndex(); //노드 이동
            int nd = node.getDist();

            if (dist[cn] < nd) continue; // 이미 더 짧은 길이로 방문한 경우

            for (Node neighbor: graph.get(cn)) { //현재 노드와 이웃노드 간 cost 계산
                int cost = dist[cn] + neighbor.getDist();
                if (cost < dist[neighbor.getIndex()]) {
                    dist[neighbor.getIndex()] = cost;
                    pq.offer(new Node(neighbor.getIndex(), cost));
                }
            }
        }
    }

    static class Node implements Comparable<Node>{
        int index;
        int dist;

        Node(int dest, int dist) {
            this.index = dest;
            this.dist = dist;
        }
        int getIndex() {
            return this.index;
        }
        int getDist() {
            return this.dist;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.dist, other.dist);
        }
    }
}
