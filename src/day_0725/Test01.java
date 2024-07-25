package day_0725;

import java.util.Arrays;

public class Test01 {
    public static void main(String[] args) {
        Student[] students = new Student[3];

        students[0] = new Student("조믿음", 25, 95);
        students[1] = new Student("이준호", 22, 85);
        students[2] = new Student("양유진", 20, 100);

        Arrays.sort(students);

        for (int i = 0; i < students.length; i++) {
            System.out.println(students[i]);
        }
    }
}

// Sort 방법 선택적.
// 1. Comparable<Student>
// 2. Arrays.sort(student)
class Student implements Comparable<Student>{
    private String name;
    private int age;
    private int score;

   public Student(String name, int age, int score) {
       this.name = name;
       this.age = age;
       this.score = score;
   }

    @Override
    public int compareTo(Student o) {
        System.out.println("비교중..");
        return this.age - o.age;
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
