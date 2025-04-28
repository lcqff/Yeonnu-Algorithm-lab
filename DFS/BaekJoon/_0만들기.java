package DFS.BaekJoon;

//https://www.acmicpc.net/problem/19941
//Gold 5

import java.io.*;

public class _0만들기 {
    static int t; //테스트케이스 수
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            DFS(1, 1, 2, n, "1");
            bw.write('\n');
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static void DFS(int ps, int pn, int cn, int lastN, String ans) throws IOException{
        // ps: 이전 값 합, pn:직전 값, cn: 현재 값

        if (cn > lastN && ps==0) {
            //출력
            //System.out.println(ans);
            bw.write(ans+'\n');
            return;
        }
        if (cn > lastN) {
            return;
        }

        if (pn < 0) {
            DFS(ps - pn + (pn * 10 - cn), pn * 10 - cn, cn + 1, lastN, ans +" "+ cn);
        } else {
            DFS(ps - pn + (pn * 10 + cn), pn * 10 + cn, cn + 1, lastN, ans + " " + cn);
        }
        DFS(ps + cn, cn, cn + 1, lastN, ans + '+' + cn);
        DFS(ps - cn, -cn, cn + 1, lastN, ans + '-' + cn);
    }
}
