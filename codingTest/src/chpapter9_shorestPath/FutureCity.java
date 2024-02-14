package chpapter9_shorestPath;

import java.util.Arrays;
import java.util.Scanner;

//5 7
//1 2
//1 3
//1 4
//2 4
//3 4
//3 5
//4 5
//4 5
public class FutureCity {
    //k 방문 뒤 x로
    //양방향 이동 가능
    private static final int INFINIT = (int) Math.exp(9);

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //N: 회사 개수, M: 경로 개수
        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();
        int[][] lines = new int[N][N]; //연결정보
        for (int i = 0; i < N; i++) {
            Arrays.fill(lines[i], INFINIT);
            lines[i][i] = 0;
        }

        for (int i = 0; i < M; i++) {
            int[] connCity = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            //연결된 두 회사
            lines[connCity[0] - 1][connCity[1] - 1] = 1;
            lines[connCity[1] - 1][connCity[0] - 1] = 1;
        }
        int X = sc.nextInt() - 1; //최종 방문
        int K = sc.nextInt() - 1; //첫번째 방문

        for (int step = 0; step < N; step++) {
            for (int i = 0; i < N; i++) {
                if (i == step) {
                    continue;
                }
                for (int j = 0; j < N/2; j++) {
                    lines[i][j] = Math.min(lines[i][j], lines[i][step] + lines[step][j]);
                    lines[j][i] = lines[i][j];
                }
            }
        }

//        for (int[] line : lines) {
//            for (int i = 0; i < N; i++) {
//                System.out.printf("%d ", line[i]);
//            }
//            System.out.println();
//        }
        if (lines[1][K] == INFINIT || lines[K][X] == INFINIT) {
            System.out.println(-1);
            return;
        }
        System.out.println(lines[1][K] + lines[K][X]);
    }

    //1 2
    //1 3
    //1 4
    //2 4
    //3 4
    //3 5
    //4 5

    //  1 2 3 4 5
    //1 0 1 1 1 0
    //2 1 0 0 1 0
    //3 1 0 0 1 1
    //4 1 1 1 0 1
    //5 0 0 1 1 0
}
