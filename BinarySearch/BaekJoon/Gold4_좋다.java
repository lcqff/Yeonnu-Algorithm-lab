package BinarySearch.BaekJoon;

// https://www.acmicpc.net/problem/1253

import java.io.*;
import java.util.*;

// 이분탐색으로 풀었는데
// 정석적인 이분탐색으로 푼 거 같지도 않고
// 투포인터로 다시 풀어보기

public class Gold4_좋다 {
    static int n;
    static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        nums = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken()); // 최대값 1,000,000,000
        }
        // nums가 정렬되어있다는 보장 없음
        Arrays.sort(nums);

        int res = 0;
        for (int i = 0; i < n; i++) {
            int cn = nums[i];
            for (int candidateIdx = 0; candidateIdx < n; candidateIdx++) {
                if (candidateIdx == i) continue;;
                if (binarySearch(candidateIdx, i, 0, n-1)) {
                    res++;
                    break;
                }
            }
        }

        bw.write(res + " ");
        br.close();
        bw.flush();
        bw.close();
    }

    private static boolean binarySearch(int candidateIdx, int cnIdx, int sIdx, int lIdx) {
        int candidateNum = nums[cnIdx] - nums[candidateIdx];
        // nums 중에서 candidateNum을 찾는다.

        if (sIdx > lIdx || sIdx < 0 || lIdx >= n) {
            return false;
        }
        int mIdx = (sIdx + lIdx) / 2;
        if (mIdx != candidateIdx && mIdx != cnIdx && nums[mIdx] == candidateNum) {
            System.out.println(nums[cnIdx] + "[" + cnIdx + "] = " + nums[candidateIdx] + " + " + nums[mIdx]);
            return true;
        }
        if (nums[mIdx] >= candidateNum) {
            return binarySearch(candidateIdx, cnIdx, sIdx, mIdx-1);
        }
        if (nums[mIdx] < candidateNum) {
            return binarySearch(candidateIdx, cnIdx, mIdx+1, lIdx);
        }
        System.out.println("??");
        return false;
    }
}


//3
//0 0 0


// 3
// -5 0 5