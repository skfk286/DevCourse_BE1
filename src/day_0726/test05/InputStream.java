package day_0726.test05;

import java.io.*;

public class InputStream {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("student.ycjung"));

        Student s = (Student)ois.readObject();
        System.out.println(s);
        ois.close();
    }
}
