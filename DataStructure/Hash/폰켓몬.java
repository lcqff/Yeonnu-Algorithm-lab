package DataStructure.Hash;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/1845
 * 프로그래머스
 * level 1
 */

class 폰켓몬 {
    // 1. 제시된 포켓몬 배열에서 중복을 제거한 순수 포켓몬의 종류만 도출
    // 2. 남은 배열의 크기가 n/2보다 큰 경우 n/2, 작은 경우 배열의 크기가 됨

    public int solution(int[] nums) {
        int answer = 0;

        // 중복제거
        HashSet<Integer> poketmons = new HashSet<>(
                Arrays.stream(nums).
                        boxed().
                        collect(Collectors.toList())
        );

        answer = Math.min(poketmons.size(), nums.length/2);
        return answer;
    }
}