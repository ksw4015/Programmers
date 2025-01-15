package programmers.sort;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/**
 * 백준 줄세우기
 *
 * 우선 아무나 한 명을 뽑아 줄의 맨 앞에 세운다. 그리고 그 다음부터는 학생이 한 명씩 줄의 맨 뒤에 서면서 다음 과정을 거친다.
 *
 * 자기 앞에 자기보다 키가 큰 학생이 없다면 그냥 그 자리에 서고 차례가 끝난다.
 * 자기 앞에 자기보다 키가 큰 학생이 한 명 이상 있다면 그중 가장 앞에 있는 학생(A)의 바로 앞에 선다. 이때, A부터 그 뒤의 모든 학생들은 공간을 만들기 위해 한 발씩 뒤로 물러서게 된다.
 */
public class LineUp {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i = 1 ; i <= n ; i++) {
            int cls = sc.nextInt();
            int[] students = new int[20];
            for(int j = 0 ; j < 20 ; j++) {
                students[j] = sc.nextInt();
            }
            bw.write(solution(cls, students) + "\n");
        }
        bw.flush();
        bw.close();
    }

    private static String solution(int i, int[] students) {
        int answer = 0;
        for(int n = 1 ; n < students.length ; n++) { // 줄 세우려는 학생
            int index = -1;
            for(int m = n - 1 ; m >= 0 ; m--) { // 줄 세우려는 학생 앞에 학생부터 맨앞 학생까지
                if(students[m] > students[n]) {
                    index = m;
                }
            }
            if(index != -1) {  // Hit
                int tmp = students[n];
                for(int k = n ; k > index ; k--) {
                    students[k] = students[k-1];
                    answer++;
                }
                students[index] = tmp;
            }
        }
        return i + " " + answer;
    }
}
