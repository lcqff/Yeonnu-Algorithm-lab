package Implementation.Etc;

import java.util.Scanner;

public class KnightOfChess {
    public static void main(String[] args) {
        int[] Move1 = {-2,+2};
        int[] Move2 = {-1,+1};

        Scanner sc = new Scanner(System.in);
        String position = sc.nextLine();
        int x = Character.getNumericValue(position.charAt(1));
        int y = (int)position.charAt(0) - 96;
        System.out.println(x + " " +y);

        int result = 0;
        for(int m1:Move1){
            if ( 0 < x+m1 && x+m1 <= 8) {
                System.out.println("x: "+(x+m1));
                for(int m2:Move2) {
                    if(0 < y+m2 && y+m2 <= 8) {
                        System.out.println("y: "+(y+m2));
                       result ++;
                    }
                }
            }
            if ( 0 < y+m1 && y+m1 <= 8) {
                System.out.println("y: "+(y+m1));
                for(int m2:Move2) {
                    if(0 < x+m2 && x+m2 <= 8) {
                        System.out.println("x: "+(x+m2));
                        result ++;
                    }
                }
            }
        }
        System.out.println(result);
    }
}
