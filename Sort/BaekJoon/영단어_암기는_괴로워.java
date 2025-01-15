package Sort.BaekJoon;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/20920
// Sliver 3

public class 영단어_암기는_괴로워 {

    //Sorting
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> words = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            if (word.length() >= m) {
                words.put(word, words.getOrDefault(word, 0) + 1);
            }
        }

        List<String> keySets = new ArrayList<>(words.keySet());

        keySets.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {

                if (words.get(o1).equals(words.get(o2))) {
                    if (o1.length() == o2.length()) {
                        return o1.compareTo(o2);// 3. 알파벳 사전순으로 (오름차순)
                    }
                    return o2.length() - o1.length(); // 2. 단어 길이가 길수록 (내림차순)
                }
                return words.get(o2) - words.get(o1); // 1. 더 자주 나오는 단어일수록 (내림차순)
            }
        });

        for (String word : keySets) {
            bw.write(word + "\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }
}