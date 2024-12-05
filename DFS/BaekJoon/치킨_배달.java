package DFS.BaekJoon;

// https://www.acmicpc.net/problem/15686
// GOLD 5

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 치킨_배달 {
    // 치킨 거리의 최솟값
    // 치킨집을 폐업시키는 모든 경우의 수에서 가정집까지의 치킨거리를 계산한다.

    static int n;
    static int m;
    static List<int[]> houses = new ArrayList<>(); // 집 좌표
    static List<int[]> chickens = new ArrayList<>(); //치킨집 좌표
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int num = sc.nextInt();
                if (num == 1) {
                    houses.add(new int[]{i, j});
                }
                if (num == 2) {
                    chickens.add(new int[]{i, j});
                }
            }
        }

        // m개만 남기고 치킨집을 폐업시키는 모든 경우의 수 // DFS
        List<int[]> lefts = new ArrayList<>();
        DFS(0, lefts);
        System.out.println(min);
    }

    public static void DFS(int idx, List<int[]> lefts) {
        if (idx > chickens.size()) {
            return;
        }
        if (chickens.size() - idx + lefts.size() < m) {
            return;
        }
        if (lefts.size() >= m) {
            // 치킨거리 계산
            int tatalChickendist = 0;
            for (int[] house : houses) {
                int closestChickenDist = getClosest(house, lefts);
                tatalChickendist += closestChickenDist;
            }
            min = Math.min(min, tatalChickendist);
            return;
        }

        // 죽인다.
        DFS(idx + 1, lefts);
        // 살린다
        lefts.add(chickens.get(idx));
        DFS(idx + 1, lefts);
        lefts.remove(chickens.get(idx));
    }

//    private static int[] getClosest(int[] house, List<int[]> lefts) {
//        //house중에서 가장 가까운 치킨집을 구함
//        // BFS
//        Queue<Node> q = new LinkedList<>();
//        q.offer(new Node(house[0], house[1]));
//
//        while (!q.isEmpty()) {
//            Node node = q.poll();
//            int x = node.getX();
//            int y = node.getY();
//            for (int i = 0; i < 4; i++) {
//                int nx = x + dx[i];
//                int ny = y + dy[i];
//                if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
//                    continue;
//                }
//                for (int[] left : lefts) {
//                    if (nx == left[0] && ny == left[1]) {
//                        return new int[]{nx, ny};
//                    }
//                }
//                q.offer(new Node(nx, ny));
//            }
//        }
//        return null;
//    }

    // BFS 쓰지말고 그냥 가정집과 현재 존재하는 치킨접 거리 전부 계산해서 비교로 구하기
    private static int getClosest(int[] house, List<int[]> lefts){
        int res = Integer.MAX_VALUE;
        for (int[] left : lefts) {
            int dist = calculate(house,left);
            res  = Math.min(res,dist);
        }
        return res;
    }

    private static int calculate(int[] house, int[] chicken) {
        return Math.abs(house[0] - chicken[0]) + Math.abs(house[1] - chicken[1]);
    }
}
