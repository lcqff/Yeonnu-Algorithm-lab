package DP.BaekJoon;
//silver 4
//2839

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SugarDelivery {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //배달해야할 설탕 kg
        int[] dp = new int[5001];

        dp[0] = -1;
        dp[1] = -1;
        dp[2] = -1;
        dp[3] = 1;
        dp[4] = -1;
        dp[5] = 1;

        for (int i = 6; i <= n; i++) {
            if (notSumOf5And3(i)) {
                dp[i] = -1;
                continue;
            }
            List<Integer> candidate = new ArrayList<>();
            if (dp[i - 5] != -1) {
                candidate.add(dp[i - 5] + 1);
            }
            if (dp[i - 3] != -1) {
                candidate.add(dp[i - 3] + 1);
            }
            dp[i] = Collections.min(candidate);
            //System.out.printf("dp[%d] = %d\n", i, dp[i]);
        }

        System.out.println(dp[n]);
    }

    private static boolean notSumOf5And3(int n) {
        if (n % 5 == 0 || n % 3 == 0) {
            return false;
        }
        int k = n;
        while (k >= 3) {
            k = k - 5;
            //System.out.printf("n = %d k=%d\n",n,k);
            if (k % 3 == 0) {
                return false;
            }
        }
        return true;
    }
}