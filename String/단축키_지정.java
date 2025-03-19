package String;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/1283
// sliver 1

public class 단축키_지정 {
    //단어 저장
    static HashMap<String, String> shortCuts = new HashMap<>();
    static List<String[]> shortCutPoint = new ArrayList<>();
    //static HashMap<String, Integer> shortCutPoint = new HashMap<>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine()); // 옵션의 개수 <=30
        for (int i = 0; i < n; i++) {
            findShorCut();
        }
        br.close();

        for (String[] shortCut : shortCutPoint) {
            String option = shortCut[0];
            int shortCutIdx = Integer.parseInt(shortCut[1]);
            if (shortCutIdx < 0) {
                bw.write(option + "\n");
                continue;
            }
            for (int i=0; i<option.length(); i++) {
                if (i == shortCutIdx) {
                    bw.write("[" + option.charAt(i) + "]");
                    continue;
                }
                bw.write(option.charAt(i));
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }

    private static void findShorCut() throws IOException {
        String option = br.readLine();
        String[] words = option.split(" ");
        int shortCutIdx = 0;
        for (int i=0; i<words.length; i++) {
            String firstChar = String.valueOf(words[i].charAt(0)).toUpperCase();
            //존재하지 않는 단축키면 그것을 단축키로 한다.
            if (!shortCuts.containsKey(firstChar)) {
                shortCuts.put(firstChar, option);
                shortCutPoint.add(new String[] {option, Integer.toString(shortCutIdx)});
                return;
            }
            shortCutIdx += words[i].length() + 1;
        }
        shortCutIdx = 0;

        // 모든 단어의 첫글자가 이미 지정이 되어있다면 알파벳으로 한다.
        for (String word : words) {
            for (int i=0; i<word.length(); i++) {
                String c = String.valueOf(word.charAt(i)).toUpperCase();
                if (!shortCuts.containsKey(c)) {
                    shortCuts.put(c, option);
                    shortCutPoint.add(new String[] {option, Integer.toString(shortCutIdx + i)});
                    return;
                }
            }
            shortCutIdx += word.length() + 1;
        }

        // 어떠한 것도 단축키로 지정할 수 없다.
        shortCutPoint.add(new String[] {option, "-1"});
    }
}
