package DFS.BaekJoon;
import java.util.*;
// https://www.acmicpc.net/problem/14888
// silver 1

public class 연산자_끼워넣기 {
    // 모든 경우의 수 - 중복 순열 - DFS
    // 1. 연산자를 줄세우는 모든 경우의 수를 구한다.
    // 2. 모든 경우의 수를 계산한다.
    // 3. 최대값과 최소값을 구한다.

    static int n; // 수의 개수
    static int[] a = new int[101]; // 숫자들
    static int[] operators = new int[4]; // 연산자 개수 (n-1개)

    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i=0; i<n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i=0; i<4; i++) {
            operators[i] = sc.nextInt();
        }

        dfs(0, a[0]);
        System.out.println(max);
        System.out.println(min);
    }

    public static void dfs(int idx, int prevNum) {
        if (idx >= n-1) {
            min = Math.min(min,prevNum);
            max = Math.max(max,prevNum);
            return;
        }

        // System.out.println(Arrays.toString(operators));

        if (operators[0] != 0) {
            operators[0]--;
            dfs(idx + 1, prevNum + a[idx + 1]);
            operators[0]++;
        }
        if (operators[1] != 0) {
            operators[1]--;
            dfs(idx + 1, prevNum - a[idx + 1]);
            operators[1]++;
        }
        if (operators[2] != 0) {
            operators[2]--;
            dfs(idx + 1, prevNum * a[idx + 1]);
            operators[2]++;
        }
        if (operators[3] != 0) {
            operators[3]--;
            dfs(idx + 1, prevNum / a[idx + 1]);
            operators[3]++;
        }
    }
}
