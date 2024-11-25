package BinarySearch.Etc;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TteokbokkiTteok_fail {
    static List<Integer> riceCake;
    static int n;
    static int m;
    static int mid;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         n = sc.nextInt(); //떡 개수 (최대 1000만)
        m = sc.nextInt(); //요청한 떡 길이 (최대 2억cm)
        sc.nextLine();
        riceCake = Arrays.stream(sc.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        Collections.sort(riceCake);
        riceCake.sort(Comparator.naturalOrder());
        riceCake.add(0,0);


        int H = binarySearch(0, n - 1);
        System.out.println(H);

    }

    private static int binarySearch(int start, int end) {
        if (start < end) {
            mid = (start + end) / 2;
            System.out.printf("%d %d %d\n",start, mid, end);
            int resSum =  riceCake.subList(mid,end).stream().mapToInt(Integer::intValue).sum();
            if (resSum > m) return binarySearch(mid+1,end);
            if (resSum < m) return binarySearch(start,mid-1);
        }

        System.out.printf("%d %d %d\n",start, mid, end);

        int resSum = riceCake.subList(mid,end).stream().mapToInt(Integer::intValue).sum();
        if (resSum == m) return riceCake.get(mid);
        if (resSum > m) return riceCake.get(mid) + (resSum - m)/(end-mid);
        if (resSum < m) return (int) (riceCake.get(mid) + Math.ceil((double) (resSum - m) /n));
        return 0;
    }

    //너무어려움ㅠ
    //문제가 좀 이상한 거 같기도....?
}
