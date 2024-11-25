package Implementation.Etc;

import java.util.Arrays;
import java.util.Scanner;

public class GameDevelope {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt(); //맵 크기 n*m

        int x = sc.nextInt();
        int y = sc.nextInt(); // 플레이어 위치
        int direction = sc.nextInt(); // 플레이어 방향

        sc.nextLine();
        int[][] map = new int[4][4];
        for (int i = 0; i < n; i++) {
            map[i] = Arrays.stream(sc.nextLine()
                            .split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        } // 맵 저장

        int[] directions = {0, 1, 2, 3}; //북 동 남 서
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        int result = 1;

        while (true) {
            int i=0;
            while(i<4) {
                direction = (direction + 4 - 1) % 4;
                int nx = x + dx[direction];
                int ny = y + dy[direction];
                //System.out.println("다음 방향: " + direction);
                //System.out.println(nx + ", " + ny + ", 바다?: " + map[nx][ny]);
                if (map[nx][ny] == 1) { //바다
                    i++;
                } else { //바다가 아니라면
                    map[x][y] = 1; //못가는 길 됨
                    x = nx;
                    y = ny;
                    result++;
                    //System.out.println("전진: "+ x+", "+y);
                    i=0;
                }
            }
            //4바퀴 다 돌았는데 전진을 못했다면
            int inverseDirection = (direction + 4 - 2) % 4;
            //System.out.println("뒤로 가: " + inverseDirection);
            x -= dx[inverseDirection];
            y -= dy[inverseDirection]; //방향을 유지한 채 뒤로 물러선다
            if (map[x][y] == 1) {
                System.out.println(result);
                return;
            }//물러선 곳이 바다라면 종료
            result++;
        }

    }
}
