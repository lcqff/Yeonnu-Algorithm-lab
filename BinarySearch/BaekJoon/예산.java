package BinarySearch.BaekJoon;

import java.io.*;
import java.util.*;

// 이진 탐색으로 다시 풀어보기...
//https://www.acmicpc.net/problem/2512
// Sliver 2


public class 예산 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] askedMoney = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            askedMoney[i] = Integer.parseInt(st.nextToken());
        }
        int totalMoney = Integer.parseInt(br.readLine());
        Arrays.sort(askedMoney);

        for (int i=0; i<n; i++) {
            int leftCityNum = n-1-i;
            if (leftCityNum == 0) {
                if (totalMoney > askedMoney[i])
                    bw.write(Integer.toString(askedMoney[i]));
                else
                    bw.write(Integer.toString(totalMoney));
                break;
            }
            if ( (totalMoney - askedMoney[i])/leftCityNum < askedMoney[i]) {
                bw.write(Integer.toString(totalMoney/(leftCityNum+1)));
                break;
            }
            totalMoney -= askedMoney[i];
        }


        br.close();
        bw.flush();
        bw.close();
    }
}
