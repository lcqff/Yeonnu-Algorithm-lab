package chpater8_DP;

import java.util.Scanner;

public class FloorConstruction {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[1001];

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 3;

        for (int i = 3; i <=n; i++) {
//            if(i%2 == 0) { //짝수
//                dp[i] = (int) Math.pow(dp[i-2],2)%796_796;
//            }
//            else { //홀수
//                dp[i] = (dp[i-1]*2-1)%796_796;
//            }
            dp[i] = (dp[i-2]*2 + dp[i-1])%796_796;
        }
        System.out.println(dp[n]);
    }
}
