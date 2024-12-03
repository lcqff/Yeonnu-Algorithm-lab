package Implementation.BaekJoon;

// https://www.acmicpc.net/problem/14891
// gold 5

import java.util.Arrays;
import java.util.Scanner;

public class 톱니바퀴 {
    static int[][] cogwheels = new int[4][8];
    static int[] cogwheelIdx = new int[4]; //idx번 톱니바퀴의 12시 방향을 가리키는 인덱스
    static boolean[] visited = new boolean[4];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 4; i++) {
            cogwheels[i] = Arrays.stream(sc.nextLine().split(""))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int k = sc.nextInt(); //회전 횟수
        for (int i = 0; i < k; i++) {
            int cogwheelNum = sc.nextInt() - 1;
            int direction = (sc.nextInt()) * -1; //반시계 입력: -1, 시계방향 입력: 1 -> 반시계 회전시 인덱스 +1, 시계 회전시 인덱스 -1;
            rotate(cogwheelNum, direction);
        }

        calculate();
    }

    private static void rotate(int idx, int d) {
        visited[idx] = true;
        if (idx - 1 >= 0 && !visited[idx - 1]) {
            int nine = cogwheels[idx][(cogwheelIdx[idx] + 6) % 8];
            int nextThree = cogwheels[idx - 1][(cogwheelIdx[idx - 1] + 2) % 8];
            if (nine != nextThree) {
                rotate(idx - 1, d * -1); // 반대 방향으로 회전
            }
        }
        if (idx + 1 < 4 && !visited[idx + 1]) {
            int three = cogwheels[idx][(cogwheelIdx[idx] + 2) % 8];
            int nextNine = cogwheels[idx + 1][(cogwheelIdx[idx + 1] + 6) % 8];
            if (three != nextNine) {
                rotate(idx + 1, d * -1);
            }
        }
        cogwheelIdx[idx] = (cogwheelIdx[idx] + d + 8) % 8;

       // System.out.println("회전: " + idx + " , " + cogwheelIdx[idx]);
        visited[idx] = false;
    }

    private static void calculate() {
        int res = 0;
        if (cogwheels[0][cogwheelIdx[0]] == 1) {
            res += 1;
        }
        if (cogwheels[1][cogwheelIdx[1]] == 1) {
            res += 2;
        }
        if (cogwheels[2][cogwheelIdx[2]] == 1) {
            res += 4;
        }
        if (cogwheels[3][cogwheelIdx[3]] == 1) {
            res += 8;
        }

//        System.out.println(cogwheelIdx[0]);
//        System.out.println(cogwheelIdx[1]);
//        System.out.println(cogwheelIdx[2]);
//        System.out.println(cogwheelIdx[3]);
        System.out.println(res);
    }
}
