package BinarySearch.BaekJoon;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/19637
// silver 3
public class IF문_좀_대신_써줘 {
    // 이분탐색

    static String[][] titles;
    static int n;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 칭호 개수
        int m = Integer.parseInt(st.nextToken()); // 캐릭터 개수

        titles = new String[n][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            titles[i][0] = st.nextToken();
            titles[i][1] = st.nextToken();
        }

        for (int i = 0; i < m; i++) {
            binarySearch(Integer.parseInt(br.readLine()));
        }
        br.close();
        bw.flush();
        bw.close();
    }

    private static void binarySearch(int key) throws IOException {
        int left = 0;
        int right = n - 1;

        while (left <= right) {
            int middle = (left + right) / 2;
            int value = Integer.parseInt(titles[middle][1]);

            if (value < key) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        bw.write(titles[left][0] + "\n");
    }
}
