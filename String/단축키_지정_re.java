package String;


import java.io.*;
import java.util.*;

public class 단축키_지정_re {
    static String[][] options;
    static boolean[] isRegistered = new boolean[26];
    static int[] shortcutIdx;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        options = new String[n][5];
        shortcutIdx = new int[n];
        Arrays.fill(shortcutIdx, -1);

        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            options[i] = word.split(" ");
            findShortcut(i);

//            System.out.println(shortcutIdx[i]);
            for (int j = 0; j < word.length(); j++) {
                if (shortcutIdx[i] == j) {
                    bw.write('[');
                    bw.write(word.charAt(j));
                    bw.write(']');
                    continue;
                }
                bw.write(word.charAt(j));
            }
            bw.write('\n');
        }
        br.close();
        bw.flush();
        bw.close();
    }

    private static void findShortcut(int order) {
        int idx = 0;
        for (String word : options[order]) {
            char firstChar = Character.toLowerCase(word.charAt(0));
            if (!isRegistered[firstChar - 'a']) {
                isRegistered[firstChar - 'a'] = true;
                shortcutIdx[order] = idx;
                return;
            }
            idx += word.length() + 1;
        }

        idx = 0;
        for (String word : options[order]) {
            for (int i = 0; i < word.length(); i++) {
                char currentChar = Character.toLowerCase(word.charAt(i));
                if (!isRegistered[currentChar - 'a']) {
                    isRegistered[currentChar - 'a'] = true;
                    shortcutIdx[order] = idx;
                    return;
                }
                idx++;
            }
            idx += 1;
        }
    }
}
