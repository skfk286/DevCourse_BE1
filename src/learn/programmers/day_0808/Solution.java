package learn.programmers.day_0808;

/**
 * 프로그래머스 문제
 * 두 원 사이의 정수 쌍
 */
public class Solution {

    /**
     * 문제 3번 : 원형 내의 포함된 좌표점 모두 계산
     * @param r1
     * @param r2
     * @return
     */
    public static long solution_solve_1(int r1, int r2) {
        long answer = 0;

        int count = 0;



        System.out.println(count);

        return answer;
    }

    // 테스트 케이스는 통과하나,
    // 런타임 오류 발생 코드
    public static long solution_solve_2(int r1, int r2) {
        long answer = 0;
        for (int i = -r2; i <= r2; i++ ) {
            for (int j = -r2; j <= r2; j++) {
                double result = Math.pow(i, 2) + Math.pow(j, 2);
                if (Math.pow(r1, 2) <= result && result <= Math.pow(r2, 2)) {
                    answer++;
                }
            }
        }

        return answer;
    }

    public static long solution_solve_3(int r1, int r2) {
        long answer = 0;

        int count = 0;
        int min = r1 * r1;
        int max = r2 * r2;

        for (int x = 0; x <= r2; x++ ) {
            for (int y = 0; y <= r2; y++) {
                int result = (int)(Math.pow(x, 2) + Math.pow(y, 2));
                if (min <= result && result <= max) {
                    count++;
                }
            }
        }
        answer = (long)(count * 4);

        return answer;
    }

    public static void main(String[] args) {
        // System.out.println(solution_solve_3(1, 1000000));
        int n = 1000000;

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {

                System.out.println(i + "," + j);
            }
        }
    }
}
