package sliding_window;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/20437
// Gold 5
public class 문자열_게임2 {
    // Sliding window
    // 그러나 window 사이즈 정해지지 않음 (Deque x)
    // 시간초과 주의

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            testcase();
        }
        br.close();
        bw.flush();
        bw.close();
    }

    private static void testcase() throws IOException {
        String str = br.readLine();
        int k = Integer.parseInt(br.readLine());
        HashMap<Character, List<Integer>> map = new HashMap<>();
        int shortestPath = Integer.MAX_VALUE;
        int longestPath = 0;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            List<Integer> cIdx = map.getOrDefault(c, new ArrayList<>());
            cIdx.add(i);
            map.put(c, cIdx);

            if (cIdx.size() >= k) {
                int ccIdx = cIdx.size() - 1;
                int len = cIdx.get(ccIdx) - cIdx.get(ccIdx - (k-1)) + 1;
//                System.out.print(cIdx.get(ccIdx - 1) + " " + cIdx.get(ccIdx) + "\n");
//                for (int t = cIdx.get(ccIdx - 1); t <= cIdx.get(ccIdx); t++) {
//                    System.out.print(str.charAt(t));
//                }
//                System.out.println();
                shortestPath = Math.min(shortestPath, len);
                longestPath = Math.max(longestPath, len);
            }
        }

        if (longestPath == 0) {
            bw.write(-1 + "\n");
            return;
        }
        bw.write(shortestPath + " " + longestPath + "\n");
    }
}
