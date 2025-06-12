package two_pointer;

// https://www.acmicpc.net/problem/1806
// 두 포인터의 크기 고정 -> 슬라이딩 윈도우
// 두 포인터의 크기 유동적 -> 투포인터

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Gold4_부분합 {

    static int n, s; // n-수열길이, s-부분합 최소값
    static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int res = twoPointer(0, 0, nums[0]);
        bw.write(res + "");

        br.close();
        bw.flush();
        bw.close();
    }

    private static int twoPointer(int left, int right, int sum) {
        int resLen = Integer.MAX_VALUE;
        while (left <= right && right <= n - 1) {
            if (sum < s) { // right + 1
                right += 1;
                if (right == n) break;
                sum += nums[right];
            } else { // left + 1, 정답 갱신
                resLen = Math.min(resLen, right - left + 1);
                //System.out.printf("[%d~%d] sum: %d, len: %d\n", left, right, sum, resLen);
                sum -= nums[left];
                left += 1;
            }
        }
        if (resLen > n) resLen = 0;
        return resLen;
    }
}
