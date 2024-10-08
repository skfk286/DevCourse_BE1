package day_0725.test04;

import java.util.Arrays;

public class Test04 {

    public static int ha = 0;

    public static void main(String[] args) {
        Student[] students = new Student[9];

        students[0] = new Student("조믿음", 25, 95);
        students[1] = new Student("이준호", 22, 85);
        students[2] = new Student("양유진", 20, 100);
        students[3] = new Student("조믿음", 25, 95);
        students[4] = new Student("이준호", 22, 85);
        students[5] = new Student("양유진", 20, 100);
        students[6] = new Student("조믿음", 25, 95);
        students[7] = new Student("이준호", 22, 85);
        students[8] = new Student("양유진", 20, 100);

        // 람다식
        Arrays.sort(students, (o1, o2) -> {
            int num = 100; // 람다도 하나의 메소드라서 안에서 필요한 변수 만들어 쓰는건 지장 없음
            System.out.println("이름으로 정렬중..");
            /** 주의. 람다 안에서는 student = new Student[10]; 과 같은 외부 변수를 변경해서는 안된다. */
            ha = 200; // 클래스 맴버 변수는 변경 가능.
            return o1.getName().compareTo(o2.getName());
        }); // 이름 정렬
        
        for (int i = 0; i < students.length; i++) {
            System.out.println(students[i]);
        }

        // Arrays.sort(students, new NameComparator());
        Arrays.sort(students, (o1, o2) -> o2.getAge() - o1.getAge()); // 나이 정렬

        System.out.println("---------------------------------------");
        for (int i = 0; i < students.length; i++) {
            System.out.println(students[i]);
        }

        /**
         * 람다는 무명 클래스로 메소드 하나끼리 객체를 매번 정의해야 하는 상황에서 태어남.
         * (매개변수) -> {메소드 실행문} 이지만,
         * 매개변수가 하나이면 소괄호 생략 가능
         * 메소드 실행문이 return 한 문장이면 중괄호와 return 키워드 생략 가능
         */
    }
}

class Student {
    private String name;
    private int age;
    private int score;

    public Student(String name, int age, int score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }
}