package Algorithm.sliding_window;

import java.io.*;

// https://www.acmicpc.net/problem/1522
// Silver 1
public class 문자열_교환 {
    // 1. 문자열의 a 개수를 구한다.
    // 2. a의 개수 크기의 window를 만든다.
    // 3. index 0을 window의 시작으로 문자열을 순회하며, window안에 있는 b의 최소 개수를 구한다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int aCount = 0;
        String[] str = br.readLine().split("");
        for (String s: str) {
            if (s.equals("a")) aCount++;
        }
        int min = str.length;
        int bCount = 0;
        for (int i=0; i<str.length; i++) { //문자열의 양 끝은 이어져있다.
            for(int j=0; j<aCount; j++) {
                int index = (i+j)%str.length;
                //System.out.print(str[index]);
                if(str[index].equals("b")) bCount++;
            }
            //System.out.println();
            min = Math.min(min,bCount);
            bCount = 0;
        }

        br.close();

        bw.write(Integer.toString(min));
        bw.flush();
        bw.close();
    }
}
