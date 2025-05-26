package DataStructure.Stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class 스카이라인_쉬운거_good {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Integer> stack = new Stack<>();
        int n = Integer.parseInt(br.readLine());
        int res = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            if (h == 0) {
                stack.clear();
                continue;
            }
            while (!stack.isEmpty() && stack.peek() > h) { //더 낮은 건물 등장
                stack.pop();
            }
            if (stack.isEmpty() || stack.peek() < h) { //더 높은 건물 등장
                res++;
                //System.out.println(x);
                stack.push(h);
            }
            //높이가 같은 경우엔 아무것도 하지 않는다.
        }

        bw.write(res + " ");
        br.close();
        bw.flush();
        bw.close();


    }
}

