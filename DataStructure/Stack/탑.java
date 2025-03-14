package DataStructure.Stack;

import java.io.*;
import java.util.*;

public class 탑 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Integer> tops = new Stack<>();

        HashMap<Integer,Integer> map = new HashMap<>();
        int top = Integer.parseInt(st.nextToken());
        tops.push(top);
        bw.write(0 + " ");
        map.put(top, 1);

        for (int i = 1; i < n; i++) {
            top = Integer.parseInt(st.nextToken());
            map.put(top, i+1);
            while (true) {
                if (tops.isEmpty()) {
                    bw.write(0 + " ");
                    tops.push(top);
                    break;
                }
                if (top <= tops.peek()) {
                    // bw.write(tops.peek() + " ");
                    bw.write(map.get(tops.peek())+" ");
                    tops.push(top);
                    break;
                }
                tops.pop();
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
