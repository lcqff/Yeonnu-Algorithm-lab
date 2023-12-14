import java.util.Arrays;
import java.util.Scanner;

public class Tip {
    Scanner sc = new Scanner(System.in);

    //String 배열 int 배열로 변환하기
    private void stringArrayToInt() {
        int[] map;
        map = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }
}
