package Implementation.Etc;

import java.util.Scanner;

public class KnightOfChess_improved {
    public static void main(String[] args) {
        int[][] movements = {{2, 1}, {2, -1}, {-2, 1}, {-2, -1}, {1, 2}, {1, -2}, {-1, 2}, {-1, -2}};

        Scanner sc = new Scanner(System.in);
        String position = sc.nextLine();
        int x = position.charAt(1) - '0';
        int y = position.charAt(0) - 'a' + 1;
        System.out.println(x + " " + y);

        int result = 0;
        for (int[] m : movements) {
            int nx = x + m[0];
            int ny = y + m[1];
            if (0 < nx && nx < 8 && 0 < ny && ny < 8) {
                result ++;
            }
        }
        System.out.println(result);
    }
}
