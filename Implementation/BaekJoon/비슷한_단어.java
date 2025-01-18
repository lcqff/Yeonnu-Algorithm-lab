package Implementation.BaekJoon;

import java.io.*;
import java.util.*;

public class 비슷한_단어 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String target = br.readLine();
        int res = 0;
        for (int i = 0; i < n - 1; i++) {
            String compare = br.readLine();
            //System.out.println("compare = " + compare + " & " + target);
            if (oneCharDiff(target, compare) || plusOneChar(target, compare)) {
                res++;
            }
        }

        // 문자열에 동일한 char가 여러개 포함될 경우는?

        // 1. 동일한 단어에 문자가 한 개 더 포함된 경우
        // 2. 단어 길이 동일, 문자 한 개만 차이날 경우
        // 3. 완전 동일할 경우

        br.close();
        bw.write(Integer.toString(res));
        bw.flush();
        bw.close();
    }

    private static boolean plusOneChar(String target, String compare) {
        if (Math.abs(target.length() - compare.length()) != 1) {
            return false;
        }

        if (target.length() > compare.length()) { //길이가 긴 쪽이 compare
            String temp = compare;
            compare = target;
            target = temp;
        }

        List<String> targetList = new ArrayList<>(List.of(target.split("")));
        String[] compareArr = compare.split("");

        for (String compareC : compareArr) {
            // 동일한 문자를 가진 경우
            targetList.remove(compareC);
//            System.out.println("remove this char:" + compareC);
//            System.out.println(targetList);
            if (targetList.isEmpty()) {
                return true;
            }
        }
        //System.out.println(targetList);
        return false;
    }

    private static boolean oneCharDiff(String target, String compare) {
        if (target.length() != compare.length()) {
            return false;
        }
        int chance = 1;

        List<String> targetList = new ArrayList<>(List.of(target.split("")));

        String[] compareArr = compare.split("");

        for (String compareC : compareArr) {
            if (targetList.contains(compareC)) {
                // 동일한 문자를 가진 경우
                targetList.remove(compareC);
                continue;
            }
            // 다른 문자인 경우
            //System.out.println("One Diff Char : " + compareC);
            chance--;
            if (chance < 0) {
                return false;
            }
        }
        //System.out.println("Is One Char Diff: " + target + " & " + compare);
        return true;
    }
}
