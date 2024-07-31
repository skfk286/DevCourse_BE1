package day_0731.test01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class Main3 {
    public static void main(String[] args) {
        Connection conn = null;
        String SQL = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            // 1. 커넥션 생성
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/workshop", "root", "1234");
            // conn = DriverManager.getConnection("jdbc:mysql://59.27.84.200:3306/workshop", "grepp", "grepp");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("제목 : ");
            String title = br.readLine();
            System.out.println("출판사 : ");
            String pub = br.readLine();
            System.out.println("저자 : ");
            String writer = br.readLine();
            System.out.println("가격 : ");
            int price = Integer.parseInt(br.readLine());
            /**
             * Driver 추가 필요.
             * File -> Project Structure... -> + 버튼 을 통해 라이브러리 타겟 추가
             *
             * No suitable driver found for jdbc:mysql://127.0.0.1:3306/workshop
             * 자바의 강점 : 이식성, 추상화 등
             *
             * 계정 접속 정보 필요.
             * Access denied for user 'ycjung'@'localhost' (using password: NO)
             */

            // 2. SQL 작성
            SQL = "insert into book_tb(title, writer, price, publisher) values(?, ?, ?, ?)";
            // 3. PreparedStatement or Statement 에 명령어 담기
            pstmt = conn.prepareStatement(SQL); // Statement는 이렇게 미리 SQL을 넣지 않고 execute 하는 시점에 넣는 차이가 있음.
            pstmt.setString(1, title);
            pstmt.setString(2, writer);
            pstmt.setInt(3, price);
            pstmt.setString(4, pub);
            // 4. 실행하기
            // 4.1. insert/update/delete : int
            // 4.2. select : ResultSet
            int result = pstmt.executeUpdate();
            // 5. 결과값 처리
            System.out.println("SQL 실행이 완료되었습니다. "+ result);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            // 6. 사용 완료한 리소스 반납(생성한 순서의 역순으로)
            if(rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }

            if(pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }

            if(conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}