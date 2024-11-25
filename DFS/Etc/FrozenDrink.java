package DFS.Etc;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//4 5
//00110
//00011
//11111
//00000

public class FrozenDrink {
    List<Integer> visitedNode = null;
    static int N;
    static int M;
    static int[][] iceFrame;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        iceFrame = new int[N][M];
        sc.nextLine();

        for (int i = 0; i < N; i++) {
            int[] iceRow = Arrays.stream(sc.nextLine().split("")).mapToInt(Integer::parseInt).toArray();
            iceFrame[i] = iceRow;
        }

        testInput(N,M,iceFrame);

        int result = 0;
        for (int i = 0; i <N ; i++) {
            for (int j = 0; j <M ; j++) {
                if (dfs(i, j)) {
                    result++;
                }
            }
        }
        System.out.println(result);
    }

    private static boolean dfs(int x, int y) {
        //0이면 계속 탐색, 1이면 돌아가기
        if (x < 0 || x >= N || y < 0 || y >= M) {
            return false;
        }
        if(iceFrame[x][y] == 0) {
            iceFrame[x][y] = 1;
            dfs(x+1,y);
            dfs(x-1,y);
            dfs(x,y+1);
            dfs(x,y-1);
            return true;
        } else {
            return false;
        }
    }
    private static void testInput(int N, int M,int[][] iceFrame) {
        for (int i = 0; i <N ; i++) {
            for (int j = 0; j <M ; j++) {
                System.out.print(iceFrame[i][j]);
            }
            System.out.println();
        }
    }
}
