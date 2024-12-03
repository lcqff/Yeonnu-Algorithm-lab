package DP.BaekJoon;

import java.util.Scanner;

// https://www.acmicpc.net/problem/11726
// silver 3
public class 타일링_2xn {
    // 1. 나올수 있는 경우는 세로로 긴 타일 1개 / 세로로 긴 타일 2개를 합쳐놓은 것 뿐
    // 2. 트리를 그려본 결과 동일한 값(남은 가로의 길이)에 대한 결과로 동일한 경우의 수가 반복되어 사용
    // 3. Dp -> di[n] = di[n-1] + di[n-2] (n>2) , di[0] = 1, di[1] = 1

    static int n; // 가로 길이
    static int[] di = new int[1001];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        di[0] = 1;
        di[1] = 1;
        int i = 2;
        while(i<=n) {
            di[i] = (di[i-1] + di[i-2])%10007;
            //System.out.println("di[" + i +"] : " + di[i]);
            i++;
        }
        System.out.println(di[n]);
    }
}
