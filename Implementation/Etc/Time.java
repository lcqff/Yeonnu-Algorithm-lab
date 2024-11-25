package Implementation.Etc;
// [이코테] chapter4 구현 실전문제 2

import java.util.Scanner;
public class Time {
    //00~59 범위의 숫자 중 숫자 3이 포함되는 개수
    //30~39: 10
    //그외 n0~n9: 1
    //10+5*1 = 15개
    //3이 포함되지 않는 개수: 45개

    //시간에 3이 포함되는 경우: timeInclude3*60*60
    //시간에 3이 포함되지 않고 분에 3이 포함되는 경우: timeNotInclude3*15*60
    //시간과 분에 3이 포함되지 않고 초에 3이 포함되는 경우: timeNotInclude3*45*15

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] numInclude3 = {3,13,23};

        int timeInclude3Num = 0;
        for (int i=0; i<numInclude3.length; i++){
            if(n<numInclude3[i]){
                timeInclude3Num = i;
                break;
            }
        }
        int result = timeInclude3Num*60*60 + (n-timeInclude3Num+1)*(15*60+45*15);
        System.out.println(result);
    }

}
