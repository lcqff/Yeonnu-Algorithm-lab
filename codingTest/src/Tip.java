package codingTest.src;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Tip {
    Scanner sc = new Scanner(System.in);
    int[] intArr = {15,27,12};
    Integer[] integerArr = {15,27,12};

    List<Integer> intList;


    //String을 int 배열/리스트로 변환하기
    private void stringToInt() {
        intArr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        intList = Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt).toList();
    }

    //배열 오름차 순 정렬
    private void sortAscend() {
        Arrays.sort(intArr);
    }

    //배열 내림차 순 정렬
    private void sortDscend() {
        Arrays.sort(integerArr, Collections.reverseOrder());
    }

    private void sortList() {
        intList = Arrays.stream(sc.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList()); //불변 리스트 아니여야함

        Collections.sort(intList); //1
        intList.sort(Comparator.naturalOrder()); //2
    }

    //합치기
    private void sum() {
        int sum=IntStream.of(intArr).sum();

    }

    //배열 초기화
    private void initArray() {
        Arrays.fill(intArr, (int) Math.exp(9));
    }
}
