package DFS.BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/22251
//Gold 5
public class 빌런_호석 {
    //DFS

    static int[][] changeN;
    static String n;
    static int k, p;
    static String x;

    static int answer = 0;
    static int[][] leds = new int[][]{
            {1, 1, 1, 0, 1, 1, 1}, {0, 0, 1, 0, 0, 1, 0}, {1, 0, 1, 1, 1, 0, 1},
            {1, 0, 1, 1, 0, 1, 1}, {0, 1, 1, 1, 0, 1, 0}, {1, 1, 0, 1, 0, 1, 1},
            {1, 1, 0, 1, 1, 1, 1}, {1, 0, 1, 0, 0, 1, 0}, {1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 0, 1, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = st.nextToken(); // 최대 층
        k = Integer.parseInt(st.nextToken()); // 자리 수
        p = Integer.parseInt(st.nextToken()); // 반전시킬 최대 LED 개수
        x = st.nextToken(); // 현재 멈춰있는 층

        changeN = new int[k][10]; //i번째 숫자가 0~9로 바뀌는 경우 변경되는 led 개수 저장
        boolean isMax = false; //최대층 가능성 있는가?

        for (int i = x.length(); i < k; i++) {
            x = "0".concat(x);
        }

        for (int i = 0; i < k; i++) {
            int cn = Integer.parseInt(String.valueOf(x.charAt(i)));
            for (int j = 0; j <= 9; j++) { // 0~9 led 비교
                if (j == cn) {
                    continue;
                }
                ;
                int diffLed = 0;
                for (int led = 0; led < 7; led++) {
                    if (leds[j][led] != leds[cn][led]) {
                        diffLed++;
                    }
                }
                changeN[i][j] = diffLed;
            }
//            System.out.println(cn + " changes to");
//            System.out.println(Arrays.toString(changeN[i]) + " numbers of LED change");
        }

        // 조합
        DFS(0, 0, true, "");

        bw.write(answer-1 + ""); //시작지점과 동일 층인 경우 제외

        br.close();
        bw.flush();
        bw.close();
    }

    private static void DFS(int cIdx, int sum, boolean isMax, String res) {
        if (cIdx >= k) {
            if (Integer.parseInt(res) == 0) return;
            //System.out.printf(res + " ");
            answer++;
            return;
        }
        for (int i = 0; i <= 9; i++) {
            if (isMax && Integer.parseInt(String.valueOf(n.charAt(cIdx))) < i) {
                continue;
            }
            if(sum + changeN[cIdx][i] > p) continue;
            if (isMax && Integer.parseInt(String.valueOf(n.charAt(cIdx))) == i) {
                //System.out.println("sum: " + (sum + changeN[cIdx][i]) + " changed to: " + i);
                DFS(cIdx + 1, sum + changeN[cIdx][i], true, res.concat(String.valueOf(i)));
                continue;
            }
            //System.out.println("sum: " + (sum + changeN[cIdx][i]) + " changed to: " + i);
            DFS(cIdx + 1, sum + changeN[cIdx][i], false, res.concat(String.valueOf(i)));
        }
    }
}
