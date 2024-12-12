package Implementation.BaekJoon;

import java.util.*;

// https://www.acmicpc.net/problem/1138
// silver 2

public class 한_줄로_서기 {
    static int n; //사람 수
    public static void main(String[] args) {
        List<Integer> heights = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        List<Integer> res = new ArrayList<>();

        n = sc.nextInt();
        for (int i=0; i<n; i++) {
            heights.add(sc.nextInt()); //키가 작은 순으로 사람들의 키가 저장된다 (1~)
        }

        for (int i=heights.size()-1; i>=0; i--){
            int height = heights.get(i);
            res.add(height, i+1); // height번째 인덱스에 height를 넣는다.
        }

        for (int i=0; i<n; i++) {
            System.out.print(res.get(i) + " ");
        }
    }
}
