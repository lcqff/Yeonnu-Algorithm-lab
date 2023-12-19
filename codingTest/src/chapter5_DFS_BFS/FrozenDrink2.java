package chapter5_DFS_BFS;

import java.util.Arrays;
import java.util.Scanner;

public class FrozenDrink2 {
    static int n,m;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         n = sc.nextInt();
         m = sc.nextInt();
        int[][] iceFrame = new int[n][m];
        sc.nextLine();
        for (int i = 0; i <n ; i++) {
            iceFrame[i] = Arrays.stream(sc.nextLine().split("")).mapToInt(Integer::parseInt).toArray();
        }
        //입력

        int result = 0;
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <m ; j++) {
                if (DFS(iceFrame,i,j)) result++;
            }
        }
        //탐색
    }

    private static boolean DFS(int[][] iceFrame, int i, int j) {
        //맵 벗어날 시 탈출
        if (i>=n || i<0 || j>=m || j<0) {
            return false;
        }
        //1이면 탈출
        if (iceFrame[i][j] == 1) return false;
        //0이면 재귀
        iceFrame[i][j] = 1;
        DFS(iceFrame,i+1,j);
        DFS(iceFrame,i-1,j);
        DFS(iceFrame,i,j+1);
        DFS(iceFrame,i,j-1);
        return true;
    }
}
