package BFS;
//silver1 1697

import BFS.node.Node2;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class HideAndSeek {
    static int k;
    static int[] visitedNode = new int[100_001];
    static Queue<Node2> q = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        k = sc.nextInt();

        System.out.println(bfs(n));
    }

    private static int bfs(int n) {
        q.offer(new Node2(n, 0));
        visitedNode[n] = 1;
        int result = 0;
        if (checkNode(n,0)) return 0;
        while (!q.isEmpty()) {
            Node2 node = q.poll();
            int x = node.getX();
            int y = node.getY();

            if (checkNode(x * 2, y + 1) || checkNode(x - 1, y + 1) || checkNode(x + 1, y + 1)) {
                return y + 1;
            }
        }
        return result;
    }

    private static boolean checkNode(int x, int y) {
        if (x > 100_000 || x < 0) {
            return false;
        }
        if (x == k) {
            return true;
        }
        if (visitedNode[x] != 1) {
            q.offer(new Node2(x, y));
            visitedNode[x] = 1;
        }
        return false;
    }
}
