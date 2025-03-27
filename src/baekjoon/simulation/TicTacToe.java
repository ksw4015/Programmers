package baekjoon.simulation;

import java.io.*;

/**
 *
 */
public class TicTacToe {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String input = br.readLine();
            if(input.equals("end")) {
                break;
            }

            if(isAvailable(input)) {
                bw.write("valid\n");
            } else {
                bw.write("invalid\n");
            }
        }
        bw.flush();
        bw.close();
    }

    private static boolean isAvailable(String s) {
        char[] chars = s.toCharArray();
        int o = 0;
        int x = 0;

        for (char aChar : chars) {
            if (aChar == 'O') {
                o++;
            } else if (aChar == 'X') {
                x++;
            }
        }

        if(o > 4)
            return false;
        if(x > 5)
            return false;

        boolean xWins = checkWin(chars, 'X');
        boolean oWins = checkWin(chars, 'O');
        // 승자가 아무도 없을때
        if(!xWins && !oWins)
            return x + o == 9;
        // 승자는 한명뿐
        if (xWins && oWins)
            return false;
        // X가 이기면 O 보다 1개더 많아야 됨
        if (xWins && x != o + 1)
            return false;
        // O가 이기면 X랑 O의 개수가 같아야 됨
        if(oWins &&  x != o)
            return false;
        return true;
    }

    static int[][] winPositions = {
            {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // Rows
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // Columns
            {0, 4, 8}, {2, 4, 6}  // Diagonals
    };

    private static boolean checkWin(char[] board, char player) {
        for (int[] positions : winPositions) {
            if (board[positions[0]] == player && board[positions[1]] == player && board[positions[2]] == player) {
                return true;
            }
        }
        return false;
    }
}
