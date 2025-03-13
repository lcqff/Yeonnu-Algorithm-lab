package Implementation.BaekJoon;

import java.io.*;
import java.util.*;

public class 빗물 {

    static int h; //높이
    static int w; //가로

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] blocks = new int[w];
        for (int i=0; i<w; i++) {
            blocks[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        for (int i=0; i<w; i++) {
            int currentH = blocks[i];
            int lMaxH = 0;
            int rMaxH = 0;
            for (int lIdx = 0; lIdx<i; lIdx++) {
                lMaxH = Math.max(lMaxH, blocks[lIdx]);
            }
            for (int rIdx = i+1; rIdx<w; rIdx++) {
                rMaxH = Math.max(rMaxH, blocks[rIdx]);
            }
            if (lMaxH > currentH && rMaxH > currentH) {
                sum += Math.min(lMaxH, rMaxH) - currentH;
            }
        }

        bw.write(sum+"");

        br.close();
        bw.flush();
        bw.close();
    }
}
