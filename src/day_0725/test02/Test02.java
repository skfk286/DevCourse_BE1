package day_0725.test02;

import java.util.Arrays;
import java.util.Comparator;

public class Test02 {
    public static void main(String[] args) {
        Student[] students = new Student[3];

        students[0] = new Student("조믿음", 25, 95);
        students[1] = new Student("이준호", 22, 85);
        students[2] = new Student("양유진", 20, 100);

        // Arrays.sort(students, new NameComparator());
        Arrays.sort(students, new AgeComparator());

        for (int i = 0; i < students.length; i++) {
            System.out.println(students[i]);
        }
    }
}

class AgeComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        System.out.println("나이 비교중..");
        return o2.getAge() - o1.getAge();
    }
}

class NameComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        System.out.println("이름 비교중..");
        return o1.getName().compareTo(o2.getName());
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
