package ShortestPath.Etc;
//다익스트라 알고리즘

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Telegram {
    static private final int INF = (int) Math.exp(9);
    static int[] shortestCostTable = new int[200_001];
    static PriorityQueue<Node> q = new PriorityQueue<>();
    static int n;
    static int m;
    //static int[][] costs = new int[30_001][30_001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); //도시 개수
        m = sc.nextInt(); // 통로 개수
        int c = sc.nextInt() - 1; // 도시 c
        sc.nextLine();

        int[][] costs = new int[n][n]; //i에서 j 도시로 가는데 걸리는 시간
        for (int[] cost : costs) {
            Arrays.fill(cost, INF);
        }
        for (int i = 0; i < m; i++) {
            int[] xyz = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int x = xyz[0] - 1;
            int y = xyz[1] - 1;
            int z = xyz[2];
            costs[x][y] = z;
        }

//        for (int[] cost : costs) {
//            for (int a : cost) {
//                System.out.printf("%d ", a);
//            }
//            System.out.println();
//        }

        Arrays.fill(shortestCostTable, INF);
        q.add(new Node(0, c));
        int[] res = dijkstra(costs);

        System.out.printf("%d %d", res[0], res[1]);
    }

    private static int[] dijkstra(int[][] costs) {
        while (!q.isEmpty()) {
            Node node = q.poll();
            int nodeNum = node.getNodeNum();
            for (int targetNode = 0; targetNode < n; targetNode++) {
                int newCost = costs[nodeNum][targetNode];
                if (shortestCostTable[targetNode] > newCost) {
                    //System.out.printf("nodeNum: %d, targetNode: %d, cost: %d\n", nodeNum, targetNode,costs[nodeNum][targetNode]);
                    shortestCostTable[targetNode] = newCost;
                    q.add(new Node(costs[nodeNum][targetNode], targetNode));
                }
            }
        }
        int sum = 0;
        List<Integer> costTime = new ArrayList<>();
        for (int cost : shortestCostTable) {
            if (cost < INF) {
                sum++;
                costTime.add(cost);
            }
        }
        return new int[]{sum, Collections.max(costTime)};
    }

}
//3 2 1
//1 2 4
//1 3 4