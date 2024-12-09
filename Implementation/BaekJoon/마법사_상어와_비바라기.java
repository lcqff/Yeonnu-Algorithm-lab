package Implementation.BaekJoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 마법사_상어와_비바라기 {

    static int m; //이동횟수
    static int n; //행열
    static int a[][] = new int[51][51];
    static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    static List<int[]> rainyLoc = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        n = sc.nextInt();
        m = sc.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        rainyLoc = List.of(new int[]{n - 1, 0}, new int[]{n - 1, 1}, new int[]{n - 2, 0}, new int[]{n - 2, 1});

        for (int i = 0; i < m; i++) {
            //System.out.print(i + "번째 명령: ");
            rainyLoc = rainy(rainyLoc);
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum += a[i][j];
            }
        }
        System.out.println(sum);
    }

    private static List<int[]> rainy(List<int[]> rainyLoc) {
//        for (int[] l : rainyLoc) {
//            System.out.print(Arrays.toString(l) + " ");
//        }
//        System.out.println();

        int d = sc.nextInt() - 1;
        int s = sc.nextInt();
        List<int[]> rainedLoc = new ArrayList<>();
        for (int i = 0; i < rainyLoc.size(); i++) {
            int nx = Math.abs(rainyLoc.get(i)[0] + dx[d] * s + n*50) % n;
            int ny = Math.abs(rainyLoc.get(i)[1] + dy[d] * s + n*50) % n;
            rainedLoc.add(new int[]{nx, ny});
            a[nx][ny] += 1;
            // 구름이 있는 칸의 바구니에 저장된 물의 양이 1 증가한다.
        }
        //System.out.println();

        rainyLoc = rainedLoc;

        // 구름이 모두 사라진다.
        // 물이 증가한 칸 (r, c)에 물복사버그 마법을 시전한다
        dupWaterMasic(rainedLoc);

        List<int[]> newRainyLoc = new ArrayList<>();
        //System.out.println(" 구름 생성 후:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] >= 2 && !isRainedBefore(i, j, rainyLoc)) {
                    // 바구니에 저장된 물의 양이 2 이상인 모든 칸에 구름이 생기고, 물의 양이 2 줄어든다
                    // 구름이 생기는 칸은 3에서 구름이 사라진 칸이 아니어야 한다.
                    a[i][j] -= 2;
                    newRainyLoc.add(new int[]{i, j});
                }
                //System.out.print(a[i][j] + " ");
            }
            //System.out.println();
        }
        return newRainyLoc;
    }

    private static boolean isRainedBefore(int x, int y, List<int[]> rainyLoc) {
        for (int[] r : rainyLoc) {
            if (r[0] == x && r[1] == y) {
                return true;
            }
        }
        return false;
    }

    private static void dupWaterMasic(List<int[]> rainedLoc) {
        // 대각선 방향으로 거리가 1인 칸에 물이 있는 바구니의 수만큼 (r, c)에 있는 바구니의 물이 양이 증가한다
        int[] dx = {-1, -1, 1, 1};
        int[] dy = {-1, 1, -1, 1};
        for (int[] loc : rainedLoc) {
            int basketNum = 0;
            for (int i = 0; i < 4; i++) {
                int nx = loc[0] + dx[i];
                int ny = loc[1] + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                    continue;
                }
                if (a[nx][ny] > 0) {
                    basketNum++;
                }
            }
            a[loc[0]][loc[1]] += basketNum;
        }
    }
}
