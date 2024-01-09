package BinarySearch;
//silver1 히오스 프로게이머 16564

import java.util.Arrays;
import java.util.Scanner;

public class HOSProGamer {
    public static void main(String[] args) {
        //범위: 팀 목표 레벨 s: min(X), e:max(X)+K
        //범위 이동 여부: K가 부족한가 남는가

        //s:10 e:30 m:20
        //20-10, 20, 20-15 //부족
        //s:10 e:19 m:14
        //14-10, 20, 14 //남음 //answer에 저장
        //s:15 e:19 m:17
        //17-10, 20, 17-15 //7+2 //남음 //answer에 저장
        //s:18 e:19 m:18
        //18-10,20,18-15 //8+3 //부족
        //s:18 e:17

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //캐릭터 개수
        int k = sc.nextInt(); //레벨업 가능한 레벨 총합
        int[] characterLevels = new int[n];
        for (int i = 0; i < n; i++) {
            characterLevels[i] = sc.nextInt();
        }

        int answer = 0;
        int start = Arrays.stream(characterLevels).min().getAsInt();
        int end = Arrays.stream(characterLevels).max().getAsInt() + k;
        while (start <= end) {
            int upgradedLevel = 0;
            int min = (start + end) / 2;
            for (int characterLevel : characterLevels) {
                if (characterLevel < min) {
                    upgradedLevel += min - characterLevel;
                }
                if (upgradedLevel > k) { //부족
                    end = min - 1;
                    break;
                }
            }
            if (upgradedLevel <= k) {
                start = min + 1; //남음
                answer = min;
            }
            //System.out.printf("%d, %d, %d\n", start, end, min);
        }
        System.out.println(answer);
    }
}
