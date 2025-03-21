package Implementation.BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

// https://www.acmicpc.net/problem/7682
// Gold 5
public class 틱택토 {
    // 1. X와 O의 개수가 동일하거나, X가 O보다 한개 더 많은 경우만 가능
    // 2. 1이 통과한 경우
    // 2-1. X와 O 개수가 같다: X가 연속 3개 있으면 안됨
    // 2-2. X가 O보다 한개 더 많다: O가 연속 3개 있으면 안됨
    // 3. 게임이 종료되어야 한다. (판이 다 차있거나, 연속 3개인 값이 존재해야한다.)

    static int[][] winnerCase = new int[][]{
            {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, //가로 3열
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // 세로 3열
            {0, 4, 8}, {2, 4, 6} //대각선 2열
    };
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String line = br.readLine();
            if (line.equals("end")) {
                break;
            }
            String[] map = line.split("");

            int countX = (int) Arrays.stream(map).filter(x -> x.equals("X")).count();
            int countO = (int) Arrays.stream(map).filter(x -> x.equals("O")).count();
            //System.out.printf("X개수: %d, O개수: %d\n", countX, countO);

            // 1. O와 X 개수 비교
            if (countX > countO + 1 || countX < countO) {
                bw.write("invalid\n");
                continue;
            }

            int lineX = 0;
            int lineO = 0;
            for (int[] winLine : winnerCase) {
                if (map[winLine[0]].equals("O") && map[winLine[1]].equals("O") && map[winLine[2]].equals("O")) {
                    lineO++;
                } else if (map[winLine[0]].equals("X") && map[winLine[1]].equals("X") && map[winLine[2]].equals("X")){
                    lineX++;
                }
            }

//            if (lineX >1 || lineO>1) {
//                bw.write("invalid\n");
//                continue;
//            }
            // 대각선의 경우 두개의 라인이 동시에 존재할수 있으므로 주석처리함

            // 2. 성공 여부 비교
            if (checkSuccess(countX, countO, lineX, lineO)) {
                bw.write("invalid\n");
                continue;
            }

            // 3. 게임 종료 여부
            if (isGameNotEnd(countX+countO, lineX, lineO)) {
                bw.write("invalid\n");
                continue;
            }
            bw.write("valid\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }


    private static boolean checkSuccess(int countX, int countO, int lineX, int lineO){
        if (countX == countO + 1 && lineO >= 1) { // O가 연속 3개 있으면 안된다.
            return true;
        }
        if (countX == countO && lineX >= 1) { //X가 연속 3개 있으면 안된다.
            return true;
        }
        return false;
    }

    private static boolean isGameNotEnd(int notEmptySpace, int lineX, int lineO){
        if (lineX != 0) { // X가 이긴 경우
            return false;
        }
        if (lineO != 0) { // O가 이긴 경우
            return false;
        }
        if (notEmptySpace == 9) { //판이 다 차서 게임이 종료된 경우
            return false;
        }
        return true;
    }
}
