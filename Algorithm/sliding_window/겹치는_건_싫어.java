package Algorithm.sliding_window;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

// https://www.acmicpc.net/problem/20922
// silver 1

public class 겹치는_건_싫어 {
    static int n; // 수열의 길이
    static int k; // 동일한 정수가 k개 이하로 포함한 최장 연속문자열을 구하라
    static int max = 0;

    public static void main(String[] args) throws IOException {
        int start = 0;
        int end = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int[] intSizes = new int[11];
        int[] str = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        while (end < n) {
//            System.out.println(Arrays.toString(intSizes));
//            System.out.printf("start %d: %d, end %d: %d \n", start, str[start], end, str[end]);
//            System.out.println(Arrays.toString(str));
            int endInt = str[end]; // 추가되는 정수

            // 추가 가능한 경우
            if (intSizes[endInt] < k) {
                intSizes[endInt]++;
                end++;
                max = Math.max(max, end - start); // 길이 갱신
            } else { // 초과한 경우, start를 이동
                int startInt = str[start];
                intSizes[startInt]--;
                start++;
            }
            //System.out.println(Arrays.stream(str).boxed().toList().subList(start, end));
        }

        bw.write(Integer.toString(max));

        br.close();
        bw.flush();
        bw.close();
    }
}
