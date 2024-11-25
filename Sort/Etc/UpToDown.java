package Sort.Etc;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class UpToDown {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        Integer [] number = new Integer[n];
        for (int i = 0; i < n ; i++) {
            number[i] = sc.nextInt();
        }

        Arrays.sort(number, Collections.reverseOrder());
        for (int num:number ) {
            System.out.print(num);
            System.out.print(" ");
        }
    }
}
