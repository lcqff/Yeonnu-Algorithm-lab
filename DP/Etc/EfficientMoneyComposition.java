package DP.Etc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EfficientMoneyComposition {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //화폐개수
        int m = sc.nextInt(); //만들어야 하는 돈
        int[] dp = new int[10_001];
        List<Integer> moneys = new ArrayList<>();
        for (int i = 0; i <n ; i++) {
            moneys.add(sc.nextInt());
            dp[moneys.get(i)] = 1; // 2 3
        }

        for (int i = moneys.get(n-1)+1; i <=m ; i++) { // 4부터
            int min = 1001;
            for (int money:moneys) {
                if (dp[i-money] != 0 ) {
                    if(min>dp[i-money]+1) {
                        min = dp[i-money]+1;
                    }
                }
            }
            dp[i] = min;
        }
        //System.out.println(Arrays.toString(dp));
        System.out.println(dp[m] !=0 ? dp[m] : -1);
    }
}
