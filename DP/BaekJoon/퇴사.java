package DP.BaekJoon;

import java.util.*;

// https://www.acmicpc.net/problem/14501
// silver 3
public class 퇴사 {

    // 오늘치 일을 하거나 하지 않는다 => max( p[idx] + dfs(idx+t[idx]-1) , dfs(idx+1));

    static int n;
    static int[] t = new int[16]; //상담에 걸리는 일수
    static int[] p = new int[16]; //상담 비용
    static int[] di = new int[16];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            t[i] = sc.nextInt();
            p[i] = sc.nextInt();
        }

        dp();
        System.out.println(di[0]);
    }

    private static void dp() {
        for (int i = n-1; i >= 0; i--) {
            if (t[i] + i - 1 < n) {
                di[i] = Math.max(di[i + 1], p[i] + di[i + t[i]]);
                System.out.println(i + ": " + di[i]);
                continue;
            }
            di[i] = di[i + 1];
            System.out.println(i + ": " + di[i]);
        }
    }
}
