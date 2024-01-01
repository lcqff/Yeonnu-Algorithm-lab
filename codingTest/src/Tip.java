import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Tip {
    Scanner sc = new Scanner(System.in);

    //String을 int 배열/리스트로 변환하기
    private void stringToInt() {
        int[] arr;
        List<Integer> list;
        arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        list = Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt).toList();
    }

    //배열 오름차 순 정렬
    private void sortAscend() {
        int[] number = {15,27,12};
        Arrays.sort(number);
    }

    //배열 내림차 순 정렬
    private void sortDscend() {
        Integer[] number = {15,27,12};
        Arrays.sort(number, Collections.reverseOrder());
    }
}
