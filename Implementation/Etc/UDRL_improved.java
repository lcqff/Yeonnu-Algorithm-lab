package Implementation.Etc;
// [이코테] chapter4 구현 실전문제 1

import java.util.Scanner;

public class UDRL_improved {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        sc.nextLine();
        String[] movement = sc.nextLine().split(" ");
        System.out.println(size);
        int x = 1, y = 1;

        String[] way = {"U", "D", "L", "R"};
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (String m : movement) {
            int nx = x, ny = y;
            for (int i = 0; i < way.length; i++) {
                if (way[i].equals(m)) {
                    nx += dx[i];
                    ny += dy[i];
                }
            }
            if (nx >= size | nx < 1 | ny >= size | ny < 1) {
                nx = x;
                ny = y;
            }
            x = nx;
            y = ny;
        }
        System.out.println(x + " " + y);

    }
}
