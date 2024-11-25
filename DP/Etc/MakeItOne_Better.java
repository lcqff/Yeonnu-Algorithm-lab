package DP.Etc;

import java.util.Scanner;

public class MakeItOne_Better {
    //DP 테이블 그려보기
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x  = sc.nextInt();
        int[] dp = new int[3001];

        for (int i = 2; i < x+1; i++) {
            dp[i] = dp[i-1] +1;
            if(i%2==0) {
                dp[i] = Math.min(dp[i],dp[i/2]+1);
            }
            if(i%3==0) {
                dp[i] = Math.min(dp[i],dp[i/3]+1);
            }
            if(i%5==0) {
                dp[i] = Math.min(dp[i],dp[i/5]+1);
            }
        }
        System.out.println(dp[x]);
    }
}
