package Greedy.BaekJoon;

import java.util.*;

// https://www.acmicpc.net/problem/11501
// silver  2

public class 주식 {
    // 1. 현재 max를 0으로 한다.
    // 2. 배열의 제일 뒤 (제일 마지막 날)부터 0번 인덱스까지 순회한다.
    // 3. 현재 값이 max보다 큰 경우 max를 현재값으로 한다.
    // 4. 현재 값이 max보다 작은 경우 (res += max - 현재값)을 한다. (greedy)

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // 테스트케이스;

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            long max = 0;
            long res = 0; // int 아님 주의: n의 최대 크기와 주식 최대값 고려
            Stack<Integer> nums = new Stack<>();
            for (int j = 0; j < n; j++) {
                nums.push(sc.nextInt());
            }

            while (!nums.isEmpty()) {//역순회
                int num = nums.pop();
                if (max <= num) {
                    max = num;
                } else {
                    res += max - num;
                }
                //System.out.println("i: " + i + " max: " + max + " res: " + res);
            }

            System.out.println(res);
        }
    }
}
