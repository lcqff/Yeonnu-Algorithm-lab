package DataStructure.Queue;

import java.io.*;
import java.util.*;

//https://www.acmicpc.net/problem/1927
//Sliver 2

public class 최소_힙 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine()); // < 100_000
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                if (pq.isEmpty()) {
                    bw.write("0" + '\n');
                    continue;
                }
                bw.write(Integer.toString(pq.poll()) + '\n');
                continue;
            }
            pq.offer(num);
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
