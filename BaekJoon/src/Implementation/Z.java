package Implementation;
//sliver 1

import java.util.Scanner;

//silver 1
public class Z {
    //다이나믹?
    static final int[][] loc = {{0,2},{1,3}};
   static int n; //2^n
    static int r; //찾을 행
    static int c; //찾을 열

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); //2^n
        r = sc.nextInt(); //찾을 행
        c = sc.nextInt(); //찾을 열

        int result = 0;
        for (int i = 1; i <= n; i++) {
            int location = checkPlace(i, n);
            result+= (int) (location*Math.pow((Math.pow(2,n)/(Math.pow(2,i))),2));
            System.out.println(result);
        }
        System.out.println(result);
    }

    private static int checkPlace(int i, int n) {
        int curX = 0;
        int curY = 0;
        if (c >= Math.pow(2,n-i)) {
            curX = 1;
            c -= Math.pow(2,n-i);
        }
        if (r >= Math.pow(2,n-i)) {
            curY = 1;
            r -= Math.pow(2,n-i);
        }
        System.out.printf("x:%d, y:%d \n",curX,curY);
        return loc[curX][curY];
    }

}

//25
//
//1: (1)*(8/2)^2= 16
//2: (2)*((8/2/2)^2 = 2*4 = 8
//1: (1)*((8/2/2/2)^2 = 1

