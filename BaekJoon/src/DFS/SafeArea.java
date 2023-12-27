package DFS;
//silver1 2468

import java.util.Arrays;
import java.util.Scanner;

public class SafeArea {
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int maxH = 0;
        sc.nextLine();
        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            map[i] = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int maxInt = Arrays.stream(map[i]).max().getAsInt();
            if (maxInt > maxH) {
                maxH = maxInt;
            }
        }

        int[] resultArr = new int[maxH];
        for (int k = 0; k < maxH; k++) { //k 이하의 지역은 물에 잠긴다.
            int result = 0;
            int[][] cpyMap = new int[n][n];
            for (int i = 0; i < n; i++) {
                System.arraycopy(map[i], 0, cpyMap[i], 0, n);
            }
            //System.out.println(Arrays.deepToString(cpyMap));
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dfs(i, j, k, cpyMap)) {
                        result++;
                    }
                }
            }
            //System.out.println(Arrays.deepToString(cpyMap));
            resultArr[k] = result;
        }
        //System.out.println(Arrays.toString(resultArr));
        System.out.println(Arrays.stream(resultArr).max().getAsInt());
    }

    private static boolean dfs(int x, int y, int k, int[][] map) {
        //맵 범위에서 벗어남
        if (x < 0 || x >= n || y < 0 || y >= n) {
            return false;
        }
        //잠기는 구역
        if (map[x][y] <= k) {
            return false;
        }
        map[x][y] = 0;
        dfs(x + 1, y, k, map);
        dfs(x - 1, y, k, map);
        dfs(x, y + 1, k, map);
        dfs(x, y - 1, k, map);
        return true;
    }
}
