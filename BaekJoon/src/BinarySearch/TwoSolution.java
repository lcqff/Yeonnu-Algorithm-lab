package BinarySearch;
//gold 5 2470

import java.util.Arrays;
import java.util.Scanner;

public class TwoSolution {
    //산성 특성값: 1~1_000_000_000
    //염기성 특성값: -1~-1_000_000_000
    //두 개의 서로 다른 용액을 혼합하여 특성값이 0에 가장 가까운 용액을 만들어내는 두 용액을 찾아라

    //범위: 특성값 합이 0에 가까운 두 용액 => min:가장 작은 특성값 두개의 합, max:가장 큰 특성값 두개의 합
    //이동 여부: 음수면 start 이동 양수면 end 이동

    //-99 -2 -1 4 98
    //s: -99, e: 98 , mid: -1
    //s:-2 e:98 mid: 96
    //s:-2 e:4 mid: 2
    //s:-2 e:-1 mid: -3
    //s:-1 e:-1

    //-18 -15 -3 11 16

    //1 2 3 4 5

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //전체 용액의 수
        sc.nextLine();
        int[] solutions = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray(); //각 용액의 특성값
        Arrays.sort(solutions);

        int s = 0;
        int e = solutions.length - 1;
        int min = solutions[s] + solutions[e]; //mid
        int answer1 = s;
        int answer2 = e;

        while (s < e) {
            int sum = solutions[s] + solutions[e];
            if (Math.abs(min) > Math.abs(solutions[s] + solutions[e])) {
                min = sum;
                answer1 = s;
                answer2 = e;
            }
            if (sum < 0) {
                s = s + 1;
            }
            if (sum > 0) {
                e = e - 1;
            }
            if (sum == 0) {
                break;
            }
            //System.out.printf("s: %d, e: %d\n", solutions[s],solutions[e]);
        }
        System.out.printf("%d %d", solutions[answer1], solutions[answer2]);
    }
}
