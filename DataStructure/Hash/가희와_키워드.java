package DataStructure.Hash;

import java.io.*;
import java.util.*;
// https://www.acmicpc.net/problem/22233
//silver 3

public class 가희와_키워드 {

    static int n;
    static int m;

    static HashSet<String> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i=0; i<n; i++) {
            set.add(br.readLine());
        }

        for (int i=0; i<m; i++) {
            String[] keywords = br.readLine().split(",");

            for (String keyword : keywords) {
                set.remove(keyword);
            }

            bw.write(set.size() + "\n");
        }

        br.close();

        bw.flush();
        bw.close();
    }
}
