package learn.programmers;

import java.util.Arrays;
import java.util.HashSet;

public class Main_두_개_뽑아서_더하기_answer {

    public static int[] solution(int[] numbers) {
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

        int[] result = solution(numbers);

        System.out.println(Arrays.toString(result));
    }
}
