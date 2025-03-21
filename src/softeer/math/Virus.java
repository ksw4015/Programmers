package softeer.math;

import java.io.IOException;
import java.util.Scanner;

public class Virus {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        long K = sc.nextLong();
        long P = sc.nextLong();
        long N = sc.nextLong();

        long D = 1_000_000_007L;

        // (K * P^N) % D를 계산
        long result = (K * modPow(P, N, D)) % D;

        System.out.println(result);
    }

    // 모듈러 거듭제곱 (Exponentiation by Squaring)
    public static long modPow(long base, long exp, long mod) {
        long result = 1;
        base = base % mod; // 기본적으로 모듈러 적용

        while (exp > 0) {
            if ((exp & 1) == 1) {  // 지수가 홀수이면 result에 base를 곱함
                result = (result * base) % mod;
            }
            base = (base * base) % mod; // base를 제곱하여 업데이트
            exp >>= 1; // 지수를 절반으로 나눔
        }

        return result;
    }
}
