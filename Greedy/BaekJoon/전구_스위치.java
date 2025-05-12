package Greedy.BaekJoon;

//https://www.acmicpc.net/problem/2138
//Gold 4

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//어케푸는겨...?

public class 전구_스위치 {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        String cs = br.readLine();
        String gs = br.readLine();

        boolean[] csb1 = new boolean[n]; //첫번째 스위치 안누른 경우
        boolean[] csb2 = new boolean[n]; //첫번째 스위치를 누른 경우
        boolean[] gsb = new boolean[n];

        for (int i = 0; i < n; i++) {
            csb1[i] = (cs.charAt(i) == '1');
            csb2[i] = (cs.charAt(i) == '1');
            gsb[i] = (gs.charAt(i) == '1');
        }

        int res1 = 0;
        int res2 = 0;

        csb2[0] = !csb2[0];
        csb2[1] = !csb2[1];
        res2++;

        for (int i = 1; i < n - 1; i++) {
            if (csb1[i - 1] == !gsb[i - 1]) {
                csb1[i - 1] = !csb1[i - 1];
                csb1[i] = !csb1[i];
                csb1[i + 1] = !csb1[i + 1];
                res1++;
                //System.out.println("click " + (i + 1) + ": " + Arrays.toString(csb1));
            }
        }

        if (csb1[n - 2] == !gsb[n - 2]) { //제일 마지막 전구
            csb1[n - 2] = !csb1[n - 2];
            csb1[n - 1] = !csb1[n - 1];
            res1++;
            //System.out.println("click " + n + ": " + Arrays.toString(csb1));
        }

        if (csb1[n - 1] != gsb[n - 1]) {
            res1 = -1;
        }

        //System.out.println("----------");

        for (int i = 1; i < n - 1; i++) {
            if (csb2[i - 1] == !gsb[i - 1]) {
                csb2[i - 1] = !csb2[i - 1];
                csb2[i] = !csb2[i];
                csb2[i + 1] = !csb2[i + 1];
                res2++;
                //System.out.println("click " + (i + 1) + ": " + Arrays.toString(csb2));
            }
        }

        if (csb2[n - 2] == !gsb[n - 2]) { //제일 마지막 전구
            csb2[n - 2] = !csb2[n - 2];
            csb2[n - 1] = !csb2[n - 1];
            res2++;
            //System.out.println("click " + n + ": " + Arrays.toString(csb2));
        }

        if (csb2[n - 1] != gsb[n - 1]) {
            res2 = -1;
        }

        if (res2 == -1 && res1 == -1) {
            bw.write(-1 + " ");
        } else if (res2 < 0) {
            bw.write(res1 + " ");
        } else if (res1 < 0) {
            bw.write(res2 + " ");
        } else {
            bw.write(Math.min(res1, res2) + " ");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
