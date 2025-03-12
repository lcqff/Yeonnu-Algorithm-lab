package Implementation.BaekJoon;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/9017
// Sliver 3
public class 크로스_컨트리 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            testCase();
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static void testCase() throws IOException {
        HashMap<Integer, ArrayList<Integer>> teamMembers = new HashMap<>();
        HashMap<Integer, Integer> teamNum = new HashMap<>();

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] allMember = new int[n];
        for (int i = 0; i < n; i++) {
            int teamMember = Integer.parseInt(st.nextToken());
            allMember[i] = teamMember;
            teamNum.put(teamMember, teamNum.getOrDefault(teamMember, 0) + 1);
        }

        int order = 1;
        for (int i = 0; i < n; i++) {
            int team = allMember[i];
            if (teamNum.get(team) < 6) {
                continue;
            }
            teamMembers.computeIfAbsent(team, k -> new ArrayList<>()).add(order);
            order++;
        }

        int winer = 0;
        int winerPoint = Integer.MAX_VALUE;
        for (int team : teamMembers.keySet()) {
            int teamPoint = teamMembers.get(team).stream().limit(4).mapToInt(Integer::intValue).sum();
//            System.out.println(teamMembers.get(team));
//            System.out.println(teamPoint);

            if (teamNum.get(team) < 6) {
                continue;
            }
            if (winerPoint > teamPoint) {
                winerPoint = teamPoint;
                winer = team;
            }
            if (winerPoint == teamPoint && teamMembers.get(winer).get(4) > teamMembers.get(team).get(4)) {
                winer = team;
            }
        }

        bw.write(winer + "\n");
    }
}
