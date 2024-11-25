package BFS.BaekJoon;
//gold 5 7569

import BFS.node.Node3;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Tomato2 {
    public static void main(String[] args) {

        int[] dx = {1, -1, 0, 0, 0, 0};
        int[] dy = {0, 0, 1, -1, 0, 0};
        int[] dz = {0, 0, 0, 0, 1, -1};

        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(); //상자 가로 x
        int n = sc.nextInt(); //상자 세로 y
        int h = sc.nextInt(); //쌓이는 상자 수 z
        int[][][] tomatos = new int[101][101][101];

        sc.nextLine();
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                tomatos[i][j] = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            }
        }

        //1: 익은 토마토
        //0: 안익은 토마도
        //-1: 토마토 없음
        Queue<Node3> q = new LinkedList<>();
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (tomatos[i][j][k] == 1) {
                        q.offer(new Node3(k, j, i));
                    }
                }
            }
        }

        int res = 0;

        while (!q.isEmpty()) {
            Node3 node3 = q.poll();
            int x = node3.getX();
            int y = node3.getY();
            int z = node3.getZ();
            //System.out.printf("x,y,z:%d %d %d\n",x,y,z);
            for (int i = 0; i < 6; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                int nz = z + dz[i];
                if (nz >= h || nz < 0 || nx >= m || nx < 0 || ny >= n || ny < 0) {continue;
                }
                if (tomatos[nz][ny][nx] == -1) {
                    continue;
                }
                if (tomatos[nz][ny][nx] == 0) {
                    q.offer(new Node3(nx, ny, nz));
                    //System.out.printf("nx,ny,nz:%d %d %d\n",nx,ny,nx);
                    tomatos[nz][ny][nx] = tomatos[z][y][x] + 1;
                    res = tomatos[nz][ny][nx];
                }
            }
        }

//        for (int i = 0; i < h; i++) {
//            for (int j = 0; j < n; j++) {
//                for (int k = 0; k < m; k++) {
//                    System.out.printf("%d ",tomatos[i][j][k]);
//                }
//                System.out.println();
//            }
//        }

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (tomatos[i][j][k] == 0) {
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }
        System.out.println(res!=0?res-1:0);

    }
}
