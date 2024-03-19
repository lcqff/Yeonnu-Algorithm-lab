package Implementation;
//silver 2 20006

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.Collectors;

//        int l = sc.nextInt(); // 플레이어 레벨
//        String n = sc.next(); // 플레이어 닉네임

public class RankingBattleQueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int p = sc.nextInt(); //플레이어 수 1~300
        int m = sc.nextInt(); // 방 정원 1~300
        Queue<List<String>> players = new LinkedList<>();
        List<List<List<String>>> rooms = new LinkedList<>();

        sc.nextLine();
        for (int i = 0; i < p; i++) {
            players.offer(Arrays.stream(sc.nextLine().split(" ")).collect(Collectors.toList()));
        }

        while (!players.isEmpty()) {
            List<String> player = players.poll();

            if (matching(m, player, rooms)) {
                continue;
            }

            //매칭 안됨
            List<List<String>> newRoom = new ArrayList<>();
            newRoom.add(player);
            rooms.add(newRoom);
        }

        for (List<List<String>> room : rooms) {
            room.sort(Comparator.comparing(player -> player.get(1)));
            printStatus(room.size() >= m);
            for (List<String> player : room) {
                System.out.printf("%s %s\n", player.get(0), player.get(1));
            }
        }

    }

    private static boolean matching(int m, List<String> player, List<List<List<String>>> rooms) {
        int l = Integer.parseInt(player.get(0));

        for (List<List<String>> room : rooms) { //매칭
            // 만석인가
            if (room.size() >= m) {
                continue;
            }
            //레벨이 맞는가
            int starterLevel = Integer.parseInt(room.get(0).get(0));
            if (starterLevel + 10 >= l && starterLevel - 10 <= l) {
                room.add(player);
                return true;
            }
        }
        return false;
    }

    private static void printStatus(boolean full) {
        if (full) {
            System.out.println("Started!");
            return;
        }
        System.out.println("Waiting!");
    }
}
