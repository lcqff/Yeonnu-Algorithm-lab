package DP.BaekJoon;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/17484
// silver 3
public class 진우의_달_여행_Small {
    //DP

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 행 <= 6
        int m = Integer.parseInt(st.nextToken()); // 열

        int[][] cost = new int[n][m];
        int[][][] dp = new int[n][m][3];

        for (int i = 0; i < n; i++) {
            cost[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < m; j++) {
                Arrays.fill(dp[i][j], Integer.MAX_VALUE);
            }
        }

        for (int j = 0; j < m; j++) {
            dp[n - 1][j][0] = cost[n - 1][j];
            dp[n - 1][j][1] = cost[n - 1][j];
            dp[n - 1][j][2] = cost[n - 1][j];
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < m; j++) { // -1, 0, 1
                if (j > 0) {
                    dp[i][j][0] = cost[i][j] + Math.min(dp[i + 1][j - 1][1], dp[i + 1][j - 1][2]); //왼쪽에서 온다
                }
                if (j < m - 1) {
                    dp[i][j][2] = cost[i][j] + Math.min(dp[i + 1][j + 1][0], dp[i + 1][j + 1][1]); //오른쪽에서 온다
                }
                dp[i][j][1] = cost[i][j] + Math.min(dp[i + 1][j][0], dp[i + 1][j][2]); //앞에서 온다
                //System.out.printf("dp: %d %d %d | ", dp[i][j][0], dp[i][j][1], dp[i][j][2]);
            }
           //System.out.println();
        }

        int min = Integer.MAX_VALUE;
        for (int j = 0; j < m; j++) {
            min = Collections.min(List.of(min, dp[0][j][0], dp[0][j][1], dp[0][j][2]));
        }

        bw.write(Integer.toString(min));
        br.close();
        bw.flush();
        bw.close();
    }
}
