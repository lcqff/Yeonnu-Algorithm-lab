package Greedy.BaekJoon;

import java.io.*;
import java.util.*;

//sliver 3
// https://www.acmicpc.net/problem/19941

public class 햄버거_분배 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        String[] str = br.readLine().split("");

        int res = 0;
        for (int pIdx = 0; pIdx < str.length; pIdx++) {
            //1. str 순회하며 P를 찾는다.
            if (!str[pIdx].equals("P")) {
                continue;
            }

            //2. P를 찾은 경우 왼쪽에 있는 햄버거 중 가장 멀리 있는 햄버거를 먹는다.
            for (int hIdx = Math.max(pIdx - k, 0); hIdx <= Math.min(pIdx + k, str.length-1); hIdx++) {
                if (str[hIdx].equals("H")) {
                    res++;
                    str[hIdx] = "E";
                    //System.out.println(Arrays.toString(str));
                    break;
                }
            }
        }

        br.close();

        bw.write(Integer.toString(res));
        bw.flush();
        bw.close();
    }
}
