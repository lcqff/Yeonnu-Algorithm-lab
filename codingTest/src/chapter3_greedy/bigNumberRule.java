package chapter3_greedy;//[이코테] chapter3 그리디 실전문제 1

/**
 동빈이의 큰수의 법칙은 다양한 수로 이루어진 배열이 있을 떄 주어진 수들을 M번 더하여 가장 큰수를 만드는 방법이다.
 단, 배열의 특정한 인덱스에 해당하는 수가 연속해서 K번을 초과하여 더해 질수 없는 것이 이법칙의 특징이다.

 예를 들어 순서대로 2, 4, 5, 4, 6으로 이루어진 배열이 있을 때, M이 8이고 K가 3이라고 가정하자
 이 경우 특정한 인덱스의 수가 연속해서 세번까지만 더해질 수 있으므로 큰 수의 법칙에 따른 결과는
 6 + 6 + 6 + 5 + 6 + 6 + 6 + 5인 46이 된다.

 단, 서로 다른 인덱스에 해당하는 수가 같은 경우에도 서로 다른 것으로 간주한다.
 예를 들어 순서대로 3, 4, 3, 4, 3으로 이루어진 배열이 있을 때 M이 7이고 K가 2라고 가정하자.
 이 경우 두번째 원소에 해당하는 4와 네 번째 원소에 해당하는 4를 번갈아 두번씩 더하는 것이 가능하다.
 결과적으로 4 + 4 + 4 + 4 + 4 + 4 + 4 인 28이 도출된다.

 배열의 크기 N, 숫자가 더해지는 횟수 M, 그리고 K가 주어질 떄 동빈이의 큰수의 법칙에 따른 결과를
 제출하시오
 **/
/** 입력 조건
첫째 줄에 N(2 <= N <= 1000), M(1 <= M <= 10000), K(1 <= K <= 10000)
의 자연수가 주어지며 각자연수는 공백으로 구분한다.
둘째 줄에 N개의 자연수가 주어진다. 각 자연수는 공백으로 구분한다. 단, 각각의 자연수는 1 이상 10000 이하의 수로 주어진다.
입력으로 주어지는 K는 항상 M보다 작거나 같다.
*/
/** 출력 조건
첫째 줄에 동빈이의 큰수의 법칙에 따라 더해진 답을 출력한다.
*/

import java.util.Arrays;
import java.util.Scanner;


public class bigNumberRule {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();

        int[] numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = sc.nextInt();
        }

        Arrays.sort(numbers);
        int big1st = numbers[N-1];
        int big2nd = numbers[N-2];

        int loop = M/(K+1);
        int last = M%(K+1);

        int result = big1st*K*loop + big2nd*loop + big1st*last;
        System.out.println(result);
        //가장 큰 수 2개 구하기
        //번갈아 계산
    }
}

