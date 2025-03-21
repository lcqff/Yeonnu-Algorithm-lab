package DFS.BaekJoon;

import java.io.*;
import java.util.*;

public class 촌수계산 {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static int end;
    static int res = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken())-1;
        end = Integer.parseInt(st.nextToken())-1;
        int m = Integer.parseInt(br.readLine());
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken()) - 1;
            int child = Integer.parseInt(st.nextToken()) - 1;
            graph.get(parent).add(child);
            graph.get(child).add(parent);
        }
        DFS(start, 0);
        bw.write(res + "");

        br.close();
        bw.flush();
        bw.close();
    }

    private static void DFS(int start, int kinship) {
        visited[start] = true;
        if (start == end) {
            res = kinship;
            return;
        }
        for (int connect : graph.get(start)) {
            if (!visited[connect]) {
                DFS(connect, kinship + 1);
            }
        }
    }
}
