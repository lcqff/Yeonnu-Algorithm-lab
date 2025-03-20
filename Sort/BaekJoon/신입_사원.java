package Sort.BaekJoon;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/1946
// Sliver 1

public class 신입_사원 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            testcase();
        }

        br.close();
        bw.flush();
        bw.close();

    }

    private static void testcase() throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[][] points = new int[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int paperP = Integer.parseInt(st.nextToken());
            int interviewP = Integer.parseInt(st.nextToken());
            points[i] = new int[]{paperP, interviewP};
        }

        Arrays.sort(points, (o1, o2) -> {
            if (o1[0] < o2[0]) {
                return -1; // 오름차순
            }
            return 1;
        });

        int answer = 0;
        int IP = Integer.MAX_VALUE; //최대 인터뷰 순위
        for (int i = 0; i < n; i++) {
            if (points[i][1] <= IP) {
                IP = points[i][1];
                //System.out.printf("%d %d\n", points[i][0], points[i][1]);
                answer++;
            }
        }

        bw.write(answer + "\n");
    }
}
