package BinarySearch.BaekJoon;

import java.util.Arrays;
import java.util.Scanner;

//silver1 2792
public class JewelBox {
    //구하려는 값: 최소 질투심(가장 많이 가져가는 학생의 보석 개수)
    //나누는 범위: 가능한 질투심의 범위
    //s: 1, e: 각 보석의 중 최대인 보석의 개수

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] jewels = new int[m];
        for (int i = 0; i <m ; i++) {
            jewels[i] = sc.nextInt();
        }

        int start = 1;
        int end = Arrays.stream(jewels).max().getAsInt();
        int mid = 0;
        int answer = 0;
        while (start<=end) {
            mid = (start+end)/2;
            System.out.printf("start: %d %d %d\n",start, end,mid);
            int group = 0;
            for (int jewel : jewels) {
                group += jewel/mid;
                group += jewel%mid!=0 ? 1 : 0;
            }

            if (group>n) start = mid+1;
            if (group<=n) {
                end = mid - 1;
                answer = mid;
                System.out.println(start+" "+ end+ " out");
            }
            System.out.printf("end: %d %d %d\n",start, end,mid);
        }
        System.out.printf("%d %d %d\n",start, end,mid);
        System.out.println(answer);
    }
}
