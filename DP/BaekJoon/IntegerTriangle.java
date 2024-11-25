package DP.BaekJoon;
//silver 1
//1932

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class IntegerTriangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//삼각형 크기;
        int[][] dp = new int[n + 1][n + 1];

        sc.nextLine();
        int[][] tri = new int[n + 1][n + 1];
        for (int i = 0; i < n; i++) {
            tri[i] = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        dp[0][0] = tri[0][0];

        //System.out.println(dp[0][0]);
        for (int i = 1; i <n ; i++) {
            dp[i][0] = dp[i-1][0] + tri[i][0];
            dp[i][i] = dp[i-1][i-1] + tri[i][i];
            //System.out.printf("%d ",dp[i][0]);
            for (int j = 1; j <i ; j++) {
                dp[i][j] = Math.max(dp[i-1][j-1],dp[i-1][j])+tri[i][j];
                //System.out.printf("%d ",dp[i][j]);
            }
            //System.out.printf("%d ",dp[i][i]);
            //System.out.println();
        }
        System.out.println(Arrays.stream(dp[n-1]).max().getAsInt());
    }
}

//    7
//   3 8
//  8 1 0
// 2 7 4 4
//4 5 2 6 5

//     7
//   10 15
//  18 11 15
// 20 18 15 19
//24 23 17 21 24