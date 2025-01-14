package Implementation.BaekJoon;

import java.io.*;
import java.util.*;

public class 수_이어_쓰기 {
    // greedy
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = br.readLine().split(""); // 최대 3000
        int base = 1;

        int strP = 0;
        while (strP < str.length) {
            String bn = Integer.toString(base);
            base++;
            for (String b : bn.split("")) { //1 자리수가 넘는다면
                if (b.equals(str[strP])) {
                    strP++;
                }
                if (strP == str.length) break;
            }
        }

        br.close();

        bw.write(Integer.toString(base-1));
        bw.flush();
        bw.close();
    }
}