package BinarySearch;
//silver 1 접두사 찾기 14426
import java.util.Arrays;
import java.util.Scanner;

public class FindingPrefix {
    //n: 문자열 집합 개수 (10_000개 이하)
    //m: 접두사 후보 개수 (10_000개 이하)
    //문자열 하나 길이 최대 500개
    //각각 세는 식으로 한다면? => n*m*500개 = 50_000_000_000 졵나많음

    //알파벳 순으로 정렬
    //mid 첫글자와 prefix의 첫글자 비교
    //나머지 반 버리기
    //반복

    //46분
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //집합 개수
        int m = sc.nextInt(); //prefix 개수
        String[] words = new String[n];
        String[] prefixes = new String[m];
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            words[i] = sc.nextLine();
        }
        for (int i = 0; i < m; i++) {
            prefixes[i] = sc.nextLine();
        }

        Arrays.sort(words);
        //System.out.println(Arrays.toString(words));

        int result = 0;
        for (String prefix : prefixes) {
            int start = 0;
            int end = words.length - 1;
            while (start <= end) {
                int mid = (start + end) / 2;
                if (words[mid].indexOf(prefix) == 0) { //제일 앞에 포함되는지 확인
                    result++;
                    //System.out.println("prefix: "+prefix);
                    break;
                }
                if (isMidSmallerThan(words[mid],prefix)) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        System.out.println(result);
    }

    private static boolean isMidSmallerThan(String word, String prefix) {
        for (int i = 0; i <word.length() ; i++) {
            if (word.charAt(i) < prefix.charAt(i)) return true;
            if (word.charAt(i) > prefix.charAt(i)) return false;
        }
        return true;
    }

}
