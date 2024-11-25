package Sort.Etc;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class ElementSwap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //배열 구성 최대 개수
        int k = sc.nextInt(); //최대 바꿔치기 연산
        sc.nextLine();
        Integer[] arrA = Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        Integer[] arrB = Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);

        Arrays.sort(arrA);
        Arrays.sort(arrB, Collections.reverseOrder());

        for (int i = 0; i < k; i++) {
            if (arrA[i] >= arrB[i]) {
               break;
            }
            arrA[i] = arrB[i];
        }

        int sum = Arrays.stream(arrA).reduce(0, Integer::sum);
        System.out.println(sum);
    }
}

