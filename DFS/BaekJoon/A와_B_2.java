package DFS.BaekJoon;

// https://www.acmicpc.net/problem/12919
// gold 5

import java.io.*;

public class A와_B_2 {
    // 1. DFS
    // 2. s의 뒤에 A를 붙이기 / B를 붙이고 뒤집기
    // 3. if (s.size() == t.size() )
    //  if (s.toString().equals(t.toString()) return true;
    //      return false;
    static String s;
    static String t;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        s = br.readLine();
        t = br.readLine();

        int res = DFS(s);

        bw.write(Integer.toString(res > 0 ? 1 : 0)); // BAA의 경우 결과값 2
        br.close();
        bw.flush();
        bw.close();
    }

    private static int DFS(String str) {
        System.out.println(str);
        if (str.length() == t.length()) {
            if (str.equals(t)) {
                return 1;
            }
            return 0;
        }

        if (!t.contains(str) && !t.contains(new StringBuilder(str).reverse().toString())) {
            //System.out.println("not contained");
            return 0;
        }

        String o1 = str + "A";
        String o2 = str + "B";
        o2 = new StringBuilder(o2).reverse().toString();

        return DFS(o1) + DFS(o2);
    }
}
