package Sort.BaekJoon;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// sliver 2
// https://www.acmicpc.net/problem/3758

public class KCPC {
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
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //팀 수
        int k = Integer.parseInt(st.nextToken()); //문제 수
        int t = Integer.parseInt(st.nextToken()); //내 팀
        int m = Integer.parseInt(st.nextToken()); //로그 수

        List<HashMap<Integer, Integer>> teams = new ArrayList<>(); // teams[teamId] = HashMap<probId, score>
        List<Integer> log = new ArrayList<>();

        for (int i = 0; i < n + 1; i++) {
            teams.add(new HashMap<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int teamId = Integer.parseInt(st.nextToken());
            int probId = Integer.parseInt(st.nextToken());
            int score = Integer.parseInt(st.nextToken());

            log.add(teamId);
            HashMap<Integer, Integer> teamMap = teams.get(teamId);
            teamMap.put(probId, Math.max(teamMap.getOrDefault(probId, 0), score));
        }

        //System.out.println(log);

        List<Integer> teamIdx = IntStream.rangeClosed(1, n).boxed().collect(Collectors.toList());

        Collections.sort(teamIdx, (o1, o2) -> {
            int o1Score = teams.get(o1).values().stream().mapToInt(Integer::intValue).sum();
            int o2Score = teams.get(o2).values().stream().mapToInt(Integer::intValue).sum();

//            System.out.printf("team %d score: %d \n", o1, o1Score);
//            System.out.printf("team %d score: %d \n", o2, o2Score);
            if (o1Score == o2Score) {
                int o1ProbNum = Collections.frequency(log, o1);
                int o2ProbNum = Collections.frequency(log, o2);

//                System.out.printf("team %d 풀이 수: %d \n", o1, o1ProbNum);
//                System.out.printf("team %d 풀이 수: %d \n", o2, o2ProbNum);
                if (o1ProbNum == o2ProbNum) {
                    int o1LastProbTime = log.lastIndexOf(o1);
                    int o2LastProbTime = log.lastIndexOf(o2);

//                    System.out.printf("team %d 마지막 제출 시간: %d \n", o1, o1LastProbTime);
//                    System.out.printf("team %d 마지막 제출 시간: %d \n", o2, o2LastProbTime);
                    return o1LastProbTime - o2LastProbTime; // 오름차순
                }
                return o1ProbNum - o2ProbNum; // 오름차순
            }
            return o2Score - o1Score; //내림차순
        });
//        System.out.println(teamIdx);
//        System.out.println(teamIdx.indexOf(t)+1);
        bw.write(Integer.toString(teamIdx.indexOf(t)+1) + "\n");
    }

}
