package DP.BaekJoon;
//silver 1
//1149

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class RGBStreet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //집의 수
        int[][] costs = new int[n + 1][3];
        sc.nextLine();
        for (int i = 1; i <= n; i++) {
            costs[i] = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int[][] dp = new int[1001][3]; //dp[i][0]:빨간색으로 칠할때 최소비용, dp[i][1]: 초록색으로 칠할 때 ..., dp[i][2]: 파란색...

        dp[1][0] = costs[1][0];
        dp[1][1] = costs[1][1];
        dp[1][2] = costs[1][2];

        for (int i = 2; i <= n; i++) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + costs[i][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + costs[i][1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + costs[i][2];
        }

        System.out.println(Collections.min(List.of(dp[n][0], dp[n][1], dp[n][2])));
        //완전탐색 dfs아님?

    }
}
