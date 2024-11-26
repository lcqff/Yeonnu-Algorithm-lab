package Implementation.BaekJoon;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://www.acmicpc.net/problem/3190 gold 4
 */


public class 뱀 {
    // 1. 뱀을 이동시킨다.
    // 2. 뱀의 머리가 벽에 있는지 확인한다.
    // 3. 뱀의 머리 좌표가 (이전 뱀 좌표 범위의) 좌표와 겹치는 확인한다 (꼬리 포함!!!!!)
    // 4. 뱀의 머리가 사과에 있는지 확인하고 사과에 있다면 뱀의 꼬리 좌표를 추가한다.
    // 5. 사과가 없다면 꼬리를 삭제한다.

    static int n; // 보드의 크기 (2 ≤ N ≤ 100)
    static int k; //사과의 개수
    static List<List<Integer>> apples = new ArrayList<>();
    static int l; //방향 전환 횟수
    static HashMap<Integer, String> directions = new HashMap<>();
    static int[][] RDLU = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; //좌하우상
    static HashMap<String, Integer> DL =
            new HashMap<>() {{
                    put("D",1);
                    put("L",-1);
            }};
    static int currentDirection = 0; // 오른쪽을 보고 출발한다.

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < k; i++) {
            apples.add(Arrays.stream(sc.nextLine().split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList()));
        }
        l = k = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < l; i++) {
            String[] direction = sc.nextLine().split(" ");
            directions.put(Integer.parseInt(direction[0]), direction[1]);
        }

        int time = 0;
        Deque<Node> snake = new LinkedList<>();
        snake.add(new Node(1, 1));
        while (true) {
            time++;
            //System.out.println( time+"초");

            Node pHead = snake.peekLast();
            int nx = pHead.x + RDLU[currentDirection][0];
            int ny = pHead.y + RDLU[currentDirection][1];

            //벽에 부딪히는가?
            if (nx < 1 || nx > n || ny < 1 || ny > n) {
                //System.out.println("벽 충돌!");
                System.out.println(time);
                return;
            }

            // 몸에 부딪히는가?
            for(Node position : snake) {
                if (position.x == nx && position.y == ny){
                    //System.out.println("뱀 충돌!");
                    System.out.println(time);
                    return;
                }
            }

            // 사과를 먹지 않은 경우 꼬리 위치를 제거함
            if (!apples.contains(List.of(nx, ny))) {
                snake.poll();
            } else {
                apples.remove(List.of(nx,ny));
            }

            // 뱀 이동
            snake.offer(new Node(nx,ny));

            // 방향 전환
            if (directions.containsKey(time)) {
                currentDirection += DL.get(directions.get(time)); //-1 or +1
                currentDirection = (currentDirection + 4) % 4; // 방향을 0~3 범위로 보정
                //System.out.println("방향 전환: " + currentDirection);
            }

//            for(Node position : snake) {
//                System.out.print("{ " + position.x + " ," + position.y + " }, ");
//            }
//            System.out.println("----------");
        }
    }

    public static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}



