package chapter7_binarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FindingPart {
        static List<Integer> storeParts = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //가게에 있는 부품 종류 개수
        sc.nextLine();
        storeParts = Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt).toList();
        int m = sc.nextInt(); //손님이 요청한 부품 종류 개수
        sc.nextLine();
        int[] askedParts = new int[m];
        askedParts = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        //N은 최대 100만개, M은 최대 10만개

//        for (int part:askedParts) {
//            if (storeParts.contains(part)) {
//                System.out.println("yes");
//            } else {
//                System.out.println("no");
//            }

        for (int part : askedParts) {
            if (binarySearch(0, storeParts.size()-1, part)) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }

    private static boolean binarySearch(int start, int end, int target) {
        if (start >= end) return false;
        int mid = (start+end)/2;
        if (storeParts.get(mid) == target) return true;
        if (storeParts.get(mid) > target) return binarySearch(start,mid-1,target);
        if (storeParts.get(mid) < target) return binarySearch(mid+1,end,target);
        return false;
    }
}
