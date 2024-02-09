package DP;
//sliver 3
//1463

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MakeToOne {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //1보다 크거나 같고, 106보다 작거나 같은 정수
        int[] dp = new int[1000001];

        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 1;

        for (int i = 4; i <= n; i++) {
            List<Integer> candidate = new ArrayList<>();
            if (i % 3 == 0) {
                candidate.add(dp[i / 3] + 1);
            }
            if (i%2==0) {
                candidate.add(dp[i / 2] + 1);
            }
            candidate.add(dp[i -1 ] + 1);
            dp[i] = Collections.min(candidate);
        }

        System.out.println(dp[n]);
    }
}