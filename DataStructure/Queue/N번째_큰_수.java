package DataStructure.Queue;

import java.io.*;
import java.util.*;

//https://www.acmicpc.net/problem/2075
// Sliver 3

public class N번째_큰_수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                pq.offer(Integer.parseInt(st.nextToken()));
            }
        }

        for (int i=0; i<n-1; i++) {
            pq.poll();
        }
        bw.write(Integer.toString(pq.poll()));

        br.close();
        bw.flush();
        bw.close();
    }
}
