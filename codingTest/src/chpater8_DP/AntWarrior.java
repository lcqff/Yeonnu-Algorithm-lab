package chpater8_DP;

import java.util.Arrays;
import java.util.Scanner;

public class AntWarrior {
    //얻을 수 있는 식량의 최댓값

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int[] storage = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] dp = new int[101];

        dp[0] = storage[0];
        dp[1] = storage[1];
        dp[2] = storage[2] + storage[0];

        for (int i = 3; i <n ; i++) {
            dp[i] = Math.max(dp[i-2]+storage[i], dp[i-3]+storage[i]);
        }

        System.out.println(Arrays.toString(dp));
        System.out.println(Arrays.stream(dp).max().getAsInt());
    }
}
