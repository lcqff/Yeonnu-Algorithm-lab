package Implementation.BaekJoon;

import java.io.*;
import java.util.*;

public class 창고_다각형 {
    static int n; //기둥의 개수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        List<Node> bars = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int l = input[0];
            int h = input[1];
            bars.add(new Node(l, h));
        }

        bars.sort(Comparator.comparingInt(Node::getX)); // 정렬
        int highestBarIdx = 0;
        int highest = 0;
        for (int i=0; i<bars.size(); i++) {
            if (bars.get(i).getH() >= highest) { //Highest가 여러개일수 있다.
                highestBarIdx = i;
                highest = bars.get(i).getH();
            }
        }

        //System.out.println("highestBarIdx: " + highestBarIdx);

        Stack<Node> goUp = new Stack<>(); //Highest bar 포함
        Stack<Node> goDown = new Stack<>(); //Highest bar 포함
        for (int i = highestBarIdx; i >= 0; i--) {
            goUp.push(bars.get(i));
            //System.out.println("x: " + bars.get(i).getX() + " h: " + bars.get(i).getH());
        }
        //System.out.println("========");
        for (int i = highestBarIdx; i < bars.size(); i++) { // 역순으로 pop되도록 담아준다.
            goDown.push(bars.get(i));
            //System.out.println("x: " + bars.get(i).getX() + " h: " + bars.get(i).getH());
        }

        int cx = -1;
        int ch = 0;
        int size = 0;

        while (!goUp.isEmpty()) { //goUp
            Node bar = goUp.pop();
            int nx = bar.getX();
            int nh = bar.getH();
            if (nh < ch) {
                continue;
            }
            size += ch * (nx - cx);
//            System.out.println("ch: " + ch + " nx: " + nx + " cx: " + cx);
//            System.out.println("ch * (nx - cx) = " + ch * (nx - cx));
            ch = nh;
            cx = nx;
        }

        //마지막 goUp bar(최대 높이 bar)의 넓이 추가
        size += ch * 1;
        cx = 1001;
        ch = 0;

        while (!goDown.isEmpty()) { // go down
            Node bar = goDown.pop();
            int nx = bar.getX() + 1;
            int nh = bar.getH();

            if (nh < ch) {
                continue;
            }
            size += ch * (cx - nx);
//            System.out.println("ch: " + ch + " cx: " + cx + " nx: " + nx);
//            System.out.println("ch * (cx - nx) = " + ch * (cx - nx));
            ch = nh;
            cx = nx;
        }

        System.out.println(size);
        bw.flush();
        bw.close();
    }
}

class Node {
    int x;
    int h;

    public Node(int x, int h) {
        this.x = x;
        this.h = h;
    }

    public int getX() {
        return this.x;
    }

    public int getH() {
        return this.h;
    }
}