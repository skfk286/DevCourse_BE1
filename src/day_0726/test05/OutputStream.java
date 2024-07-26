package day_0726.test05;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class OutputStream {
    public static void main(String[] args) throws IOException {
        Student s = new Student("그렙", 20);
        // 객체를 Stream 으로 보낼때에는 '직렬화'(Serializable) 라는 개념이 필요.
        // Serializable 를 implements 를 해서 보내야 된다.
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("student.ycjung"));
        oos.writeObject(s);
        oos.close();
    }
}
