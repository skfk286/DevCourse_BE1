package day_0725.test03;

import java.util.Arrays;
import java.util.Comparator;

public class Test03 {
    public static void main(String[] args) {
        Student[] students = new Student[3];

        students[0] = new Student("조믿음", 25, 95);
        students[1] = new Student("이준호", 22, 85);
        students[2] = new Student("양유진", 20, 100);

        // 무명 클래스의 등장..
        Arrays.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                System.out.println("나이 비교중..");
                return o1.getAge() - o2.getAge();
            }
        });

        for (int i = 0; i < students.length; i++) {
            System.out.println(students[i]);
        }
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

