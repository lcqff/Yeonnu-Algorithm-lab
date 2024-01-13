package chpater8_DP;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

class Node3 {
    int x;
    int n;

    public Node3(int x, int n) {
        this.x = x;
        this.n = n;
    }

    public int getX() {
        return x;
    }

    public int getN() {
        return n;
    }
}

public class MakeItOne {
    //BottomUp
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        List<Integer> DPTable = new ArrayList<>();

        Queue<Node3> q = new LinkedList<>();
        q.offer(new Node3(1,0));
        DPTable.add(1);
        while (true) {
            Node3 node = q.poll();
            int nodeX = node.getX();
            int nodeN = node.getN();
            if(nodeX == x) { //정답 도출
                System.out.println(nodeN);
                break;
            }
            if (nodeX>x) { //범위 벗어남
                continue;
            }

            if (!DPTable.contains(nodeX*5)) {
                q.offer(new Node3(nodeX*5,nodeN+1));
                DPTable.add(nodeX*5);
            }
            if (!DPTable.contains(nodeX*3)) {
                q.offer(new Node3(nodeX*3,nodeN+1));
                DPTable.add(nodeX*3);
            }
            if (!DPTable.contains(nodeX*2)) {
                q.offer(new Node3(nodeX*2,nodeN+1));
                DPTable.add(nodeX*2);
            }
            if (!DPTable.contains(nodeX+1)) {
                q.offer(new Node3(nodeX+1,nodeN+1));
                DPTable.add(nodeX+1);
            }
        }
    }
}
