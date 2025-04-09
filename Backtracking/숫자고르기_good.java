package Backtracking;

import java.io.*;
import java.util.*;

//https://www.acmicpc.net/problem/2668
//gold 5

public class 숫자고르기_good {
    //Backtracking
    static int n;
    static int[] numbers;

    static int max = 0;
    static List<Integer> answer = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        numbers = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }

        boolean[] visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            if (answer.contains(i)) continue;
            visited[i] = true;
            DFS(visited, i, i);
            visited[i] = false;
        }

        bw.write(answer.size() + "\n");
        answer.sort(Comparator.naturalOrder());
        for (int i = 0; i < answer.size(); i++) {
            bw.write(answer.get(i) + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static void DFS(boolean[] visited, int sIdx, int cIdx) {
        int tIdx = numbers[cIdx];
        if (sIdx == tIdx) {
            //System.out.println("sIdx = " + sIdx + " cIdx = " + cIdx + " tIdx = " + tIdx);
            for (int i = 1; i <= n; i++) {
                if (visited[i]) {
                    //System.out.print(i + " ");
                    answer.add(i);
                }
            }
            //System.out.println();
            return; //사이클 끝
        }

        if (!visited[tIdx]) {
            visited[tIdx] = true;
            DFS(visited, sIdx, tIdx);
            visited[tIdx] = false;
        }
    }
}