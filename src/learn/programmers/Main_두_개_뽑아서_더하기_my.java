package learn.programmers;

import java.util.*;

public class Main_두_개_뽑아서_더하기_my {

    // 나의 문제풀이
    public static int[] solution(int[] numbers) {
        int[] answer = {};

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {

                int add = numbers[i] + numbers[j];

                if (!list.contains(add)) {
                    list.add(add);
                }
            }
        }

        answer = list.stream().sorted().
                mapToInt(Integer::intValue).toArray();

        return answer;
    }

    // 프로그래머스 책 풀이
    public static int[] solution2(int[] numbers) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }

        return set.stream().sorted().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int[] numbers = {2, 1, 3, 4, 1};
//        int[] numbers = {5,0,2,7};

        int[] result = solution2(numbers);

        System.out.println(Arrays.toString(result));

    }
}
