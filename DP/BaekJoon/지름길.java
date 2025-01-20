package DP.BaekJoon;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/1446
// silver 1

public class 지름길 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); //지름길 개수 <= 12
        int d = Integer.parseInt(st.nextToken()); // 고속도로 길이 <= 10_000

        //HashMap<Integer, FastPass> map = new HashMap<>(); //startPoint, FastPass
        // 동일한 지점에서 출발하나 도착하는 곳이 다른 지름길이 있을 수 있다.

        List<FastPass> pass = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int sp = Integer.parseInt(st.nextToken());
            int ep = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            if (ep > d) continue;
            if (dist >= ep - sp) continue;
            pass.add(new FastPass(sp,ep,dist));
        }

        int[] dp = new int[d + 1];
        for (int i = d - 1; i >= 0; i--) {
            dp[i] = dp[i + 1] + 1;
            for (FastPass p : pass) {
                if (p.getSp() == i) {
                    //System.out.printf("dp[%d] = dist + dp[%d] = %d + %d = %d \n", i, p.getEp(), p.getDist(), dp[p.getEp()], p.getDist() + dp[p.getEp()]);
                    dp[i] = Math.min(p.getDist() + dp[p.getEp()], dp[i]);
                }
            }
        }

        bw.write(dp[0] + " ");

        br.close();
        bw.flush();
        bw.close();
    }

    public static class FastPass {
        int sp;
        int ep;
        int dist;

        public FastPass(int sp, int ep, int dist) {
            this.sp = sp;
            this.ep = ep;
            this.dist = dist;
        }

        public int getSp(){
            return this.sp;
        }

        public int getDist() {
            return this.dist;
        }

        public int getEp() {
            return this.ep;
        }
    }
}
