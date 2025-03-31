package two_pointer;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/2467
// Gold 5

public class 용액 {
    static int n; //용액의 수
    static int[] drugs;
    static int minSum = Integer.MAX_VALUE;
    static int[] answer = new int[2];
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        drugs = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            drugs[i] = Integer.parseInt(st.nextToken());
        }
        twoPointer();

        bw.write(drugs[answer[0]] + " " + drugs[answer[1]]);
        br.close();
        bw.flush();
        bw.close();
    }

    private static void twoPointer() {
        int left = 0;
        int right = n - 1;

        while (left < right) {
            if (Math.abs(drugs[left] + drugs[right]) <= minSum) {
                minSum = Math.abs(drugs[left] + drugs[right]);
                answer[0] = left;
                answer[1] = right;
                if (drugs[left] + drugs[right] == 0) return;

            }
            if (drugs[left] + drugs[right] < 0) left++;
            else right--;
        }
    }

}
