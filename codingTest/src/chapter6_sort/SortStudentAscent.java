package chapter6_sort;

import java.util.Scanner;

public class SortStudentAscent {
    static int n;
    static String[] names;
    static int [] grades;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        sc.nextLine();
        names =  new String[n];
        grades = new int[n];
        for (int i = 0; i <n ; i++) {
            String line = sc.nextLine();
            names[i] = line.split(" ")[0];
            grades[i] =  Integer.parseInt(line.split(" ")[1]);
        }

        String[] rank = countingSort();
        for (String student: rank) {
            if (student != null) {
                System.out.print(student);
            }
        }
    }

    private static String[] countingSort() {
        String[] rank =  new String[101]; //0~100점

        for (int i=0; i<n; i++ ) {
            rank[grades[i]] = names[i] + " ";
        }
        return rank;
    }
}
