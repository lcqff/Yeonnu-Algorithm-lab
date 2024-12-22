package Greedy.BaekJoon;

// silver 3
// https://www.acmicpc.net/problem/20310

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class 타노스 {
    // 그리디
    static List<Integer> s;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        s = Arrays.stream(br.readLine().split("")).map(Integer::parseInt).collect(Collectors.toList());

        int n = Collections.frequency(s, 1); // 1의 개수
        int m = s.size() - n; // 0의 개수

        int count1 = 0;
        int count0 = 0;

        for (int b : s) {
            if (b == 0 && count0++ < m / 2) {
                bw.write(Integer.toString(b));
                continue;
            }
            if (b == 1 && count1++ >= n / 2) {
                bw.write(Integer.toString(b));
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
