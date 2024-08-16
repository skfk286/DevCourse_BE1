package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 *
 * @see: https://ykh6242.tistory.com/entry/Java-Stream2-%EA%B0%80%EA%B3%B5%ED%95%98%EA%B8%B0#google_vignette
 */
public class JavaStream_가공하기_및_결과만들기 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Eric", "Elana", "Java");

        /**
         * Filtering
         * 필터(filter)는 스트림 내 요소들을 하나씩 평가해 걸러내는 작업이다. 인자로 받는 Predicate는 Boolean을 리턴하는 함수형 인터페이스로 평가식이 들어간다.
         * Stream<T> filter(Predicate<? supter T> predicate);
         */
        Stream<String> stream1 =
                names.stream()
                        .filter(name -> name.contains("a")); // *[Elana, Java]*

        System.out.println(stream1.toList());

        /**
         * Mapping
         * 맵(map)은 스트림 내 각 요소들을 특정 값으로 변환해준다. 이 때 값을 변환하기 위해 람다식을 인자로 받는다.
         * <R> Stream<R> map(Fucntion<? super T, ? extends R> mapper);
         */
        Stream<String> stream2 =
                names.stream()
                        .map(String::toUpperCase); // *[ERIC, ELENA, JAVA]*

        System.out.println(stream2.toList());



        List<Product> productList = new ArrayList<>();
        productList.add(new Product(23));
        productList.add(new Product(14));
        productList.add(new Product(13));
        productList.add(new Product(23));
        productList.add(new Product(13));

        Stream<Integer> stream3 =
                productList.stream()
                        .map(Product::getAmount); // *[23, 14, 13, 23, 13]*


        /**
         * flatMap
         */
        List<Student> students = new ArrayList<>();
        students.add(new Student(78, 75, 33));
        students.add(new Student(90, 75, 33));
        students.add(new Student(90, 75, 33));
        students.add(new Student(90, 75, 33));

        students.stream()
                .flatMapToInt(student -> IntStream.of(student.getKor(),
                        student.getEng(),
                        student.getMath()))
                .average().ifPresent(avg -> System.out.println(Math.round(avg * 10) / 10.0));


    }
}

class Product {
    int amount;
    Product(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }
}

class Student {
    int kor;
    int eng;
    int math;

    Student(int kor, int eng, int math) {
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }

    public int getKor() {
        return kor;
    }

    public int getEng() {
        return eng;
    }

    public int getMath() {
        return math;
    }
}