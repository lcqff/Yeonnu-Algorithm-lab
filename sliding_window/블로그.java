package sliding_window;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/21921
// sliver 3

public class 블로그 {
    //slide window
    // 시간초과 주의

    static int n; //지난 일수
    static int x; //x일동안 가장 많이 들어온 방문자 수를 구하라
    static int[] visitors;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken()); //2

        visitors = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Deque<Integer> window = new LinkedList<>(); //Sliding Window

        int num = 1;
        int max = 0;
        int sum = 0;
        for (int i = 0; i < x-1; i++) { // x=3, i= 0~2, q = [0,1]
            window.push(visitors[i]);
            sum += visitors[i];
        }
        for (int i = x-1; i < visitors.length; i++) { //queue의 크기를 window 사이즈로 유지한다.
            window.push(visitors[i]);
            sum += visitors[i];
            // System.out.printf("sum : %d \n", sum);

            if (sum == max) {
                num++;
            }
            if (sum > max) {
                max = sum;
                num = 1;
            }
            sum -= window.removeLast();
        }

        if (max == 0) {
            bw.write("SAD");
        } else {
            bw.write(Integer.toString(max));
            bw.write('\n');
            bw.write(Integer.toString(num));
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
