package Algorithm.twoPointer;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/2531
// silver 1
public class 회전_초밥 {

    static int n, d, k, c; // 접시의 수, 초밥 가짓수, 연속 수, 쿠폰 번호
    static int[] sushis;

    public static void main(String[] args) throws IOException {
        // two pointer
        // 1. 회전하기 전 초밥의 종류 count를 구한다.
        // 2. start와 end를 +1씩 한다.
        // 3. end sushi의 count를 +1한다. start sushi의 count를 -1한다.
        // 4. end sushi count가 0이라면 초밥 종류 -1한다. start sushi count가 1이라면 초밥 종류를 +1한다.
        // 5. 초밥 종류가 count보다 크다면 count를 업데이트한다.
        // 6. 만일 서비스 초밥을 포함하지 않는다면 count를 +1해서 업데이트 한다.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        sushis = new int[n];

        for (int i = 0; i < n; i++) {
            sushis[i] = Integer.parseInt(br.readLine());
        }

        // bw.write(Arrays.toString(sushis));

        int res = twoPointer();
        bw.write(String.valueOf(res));

        bw.flush();
        bw.close();
        br.close();
    }

    // 크기를 k로 제한한 twoPointer
    private static int twoPointer() {
        int[] sushiCount = new int[d + 1];
        sushiCount[c] += 1; //쿠폰 스시는 있는셈 친다.
        int sushiKinds = 1;

        // 회전하기 전 초밥 count
        for (int i = 0; i < k; i++) {
            if (sushiCount[sushis[i]] == 0) {
                sushiKinds++;
            }
            sushiCount[sushis[i]] += 1;
        }

        int max = sushiKinds;

        //스시 회전시 초밥 count
        for (int i = 0; i < n; i++) {
            int excludeSushi = sushis[i];
            int endSushi = sushis[(i + k) % n];
            sushiCount[endSushi] += 1;

            if (sushiCount[endSushi] == 1) {
                sushiKinds++;
            }

            sushiCount[excludeSushi] -= 1; //  if (sushiCount[endSushi] == 1) 다음 실행돼야함
            if (sushiCount[excludeSushi] == 0) {
                sushiKinds--;
            }

            max = Math.max(max, sushiKinds);

            //System.out.println(Arrays.toString(sushiCount));
            //System.out.println(sushiKinds);
        }
        return max;
    }
}

// two pointer
// 0. 쿠폰번호 cup
// 1. 최소 중복의 갯수 dup = k-d>0 ? k-d : 0; 을 구한다.
// 2. two pointer을 통해 중복이 dup인 연속된 초밥 k개인 경우 a를 구한다.
// 3. a 중 cup이 포함되지 않은 경우 b가 있으면 바로 b를 return한다.
// 4. 모든 경우의 수를 구했으면 a를 return한다.
// 5. 경우의 수가 존재하지 않으면 dup+1을 하여 1번으로 돌아간다.

//그냥 two pointer.......
//    private static int twoPointer() {
//        int answer = 0;
//        for (int i = dup; i < d; i++) {
//            int[] sushiCount = new int[d + 1];
//            int start = 0;
//            int end = 0;
//            while (start <= end && start != n) {
//                int endSushi = sushis[end];
//                if (sushiCount[endSushi] < i + 1) { //각 초밥의 개수는 최대 i+1개 (if dup=0, 각 초밥의 최대 개수 = 1)
//                    sushiCount[endSushi] += 1; //count + 1
//                    end += 1;
//                    continue;
//                }
//                if (sushiCount[endSushi] >= i + 1) {
//                    // 경우의 수 추가
//                    int startSushi = sushis[start];
//                    int[] choice = Arrays.copyOfRange(sushis, start, end);
//                    //System.out.println(Arrays.toString(choice));
//                    answer = choice.length;
//                    if (Arrays.stream(choice).anyMatch(sushi -> sushi == c)) {
//                        return answer + 1;
//                    }
//                    sushiCount[startSushi] -= 1;
//                    start += 1;
//                }
//            }
//            if (answer != 0) {
//                return answer;
//            }
//        }
//        return answer;
//    }