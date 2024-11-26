package DataStructure.Hash;

import java.util.*;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42576
 * level 1
 */

public class 완주하지_못한_선수 {
    public String solution1(String[] participant, String[] completion) {
        HashMap<String,Integer> hm = new HashMap<>();

        for (String player : participant) {
            hm.put(player, hm.getOrDefault(player,0)+1);
            // 중복 입력 고려해서 Array to Hash
        }
        //System.out.println(hm.toString());

        for (String player : completion) {
            hm.put(player, hm.get(player)-1);
        }
        //System.out.println(hm.toString());

        for (String key : hm.keySet()) {
            if (hm.get(key) != 0)
                return key;
        }
        return "";
    }

    public String solution2(String[] participant, String[] completion) {
        // 1. particiapnt, completion 정렬
        // 2. 두 배열 동시에 0번 인덱스부터 올라가며 두 값 비교
        // 3. 만일 동일하지 않은 값 발생시 participant의 해당 값 리턴
        Arrays.sort(participant);
        Arrays.sort(completion);
        //System.out.println(Arrays.toString(participant));
        //System.out.println(Arrays.toString(completion));

        for (int i=0; i < completion.length; i++) {
            if (!participant[i].equals(completion[i])) {
                return participant[i];
            }
            //System.out.println(participant[i] + " is completion");
        }
        return participant[participant.length-1];
    }
}
