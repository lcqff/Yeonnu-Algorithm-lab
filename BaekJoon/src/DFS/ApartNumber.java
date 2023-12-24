package DFS;
//silver1 2667
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ApartNumber {
    static int n;
    static int[][] map = new int[25][25];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            map[i] = Arrays.stream(sc.nextLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        List<Integer> apartNum = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int res = DFS(0, i, j);
                if (res > 0) {
                    apartNum.add(res);
                }
            }
        }
        System.out.println(apartNum.size());
        apartNum.sort(Comparator.naturalOrder());
        apartNum.forEach(System.out::println);
    }

    private static int DFS(int houseNum, int i, int j) {
        if (i >= n || i < 0 || j >= n || j < 0) {
            return 0;
        }
        if (map[i][j] == 0) {
            return 0;
        }
        map[i][j] = 0;
        houseNum = 1;
        houseNum += DFS(houseNum, i + 1, j) + DFS(houseNum, i - 1, j)
                    + DFS(houseNum, i, j + 1) +DFS(houseNum, i, j - 1);
        return houseNum;
    }
}
