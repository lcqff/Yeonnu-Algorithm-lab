package chapter4_implementation;
// [이코테] chapter4 구현 실전문제 1

import java.util.Scanner;

public class UDRL {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        sc.nextLine();
        String[] movement = sc.nextLine().split(" ");
        System.out.println(size);
        int x = 1;
        int y = 1;
        for (String m : movement) {
            switch (m) {
                case "U":
                    if (x>1) x--;
                    break;
                case "D":
                    if (x<size) x++;
                    break;
                case "R":
                    if (y<size) y++;
                    break;
                case "L":
                    if (y>1) y--;
            }
        }
        System.out.println(x+" "+y);

    }
}
