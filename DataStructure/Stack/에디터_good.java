package DataStructure.Stack;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


public class 에디터_good {
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        List<String> s = Arrays.stream(br.readLine().split("")).collect(Collectors.toList());
        Stack<String> leftStr = new Stack<>();
        Stack<String> rightStr = new Stack<>();
        for (String string : s) {
            leftStr.push(string);
        }
        m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            String[] command = br.readLine().split(" ");
            if (command[0].equals("P")) { //문자열 추가
                leftStr.push(command[1]);
                continue;
            }
            if (command[0].equals("L")) { //왼쪽 이동
                if (!leftStr.isEmpty()) {
                    rightStr.push(leftStr.pop());
                    //res.add(stack.pop()); // O(k)
                }
                continue;
            }
            if (command[0].equals("D")) { //오른쪽 이동
                if (!rightStr.isEmpty()) {
                    leftStr.push(rightStr.pop());
                    //res = res.remove(res.toString().toString().size() - 1)); // O(k)
                }
                continue;
            }
            if (command[0].equals("B")) { //삭제
                if (!leftStr.isEmpty()) {
                    leftStr.pop();
                }
                continue;
            }
        }
//        while (!stack.isEmpty()) {
//            res.toString().toString().add(stack.pop()); // O(k)
//        }

        while(!leftStr.isEmpty()) {
            rightStr.push(leftStr.pop());
        }
        while(!rightStr.isEmpty()) {
            bw.write(rightStr.pop());
        }
        bw.flush();
        bw.close();
    }

}

