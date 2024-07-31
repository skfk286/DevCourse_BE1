package day_0731.test01;

import java.sql.*;

public class Main2 {
    public static void main(String[] args) {
        Connection conn = null;
        String SQL = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            // 1. 커넥션 생성
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/workshop", "root", "1234");
            // conn = DriverManager.getConnection("jdbc:mysql://59.27.84.200:3306/workshop", "grepp", "grepp");
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
            SQL = "select * from book_tb";
            // 3. PreparedStatement or Statement 에 명령어 담기
            pstmt = conn.prepareStatement(SQL); // Statement는 이렇게 미리 SQL을 넣지 않고 execute 하는 시점에 넣는 차이가 있음.
            // 4. 실행하기
            // 4.1. insert/update/delete : int
            // 4.2. select : ResultSet
            rs = pstmt.executeQuery();
            while (rs.next()) {
                int bno = rs.getInt("bno");
                String title = rs.getString("title");
                String writer = rs.getString("writer");
                int price = rs.getInt("price");
                String publisher = rs.getString("publisher");
                System.out.println("bno = " + bno + ", title = " + title + ", writer = " + writer + ", price = " + price + ", publisher = " + publisher);
            }
            // 5. 결과값 처리
            System.out.println("SQL 실행이 완료되었습니다. ");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
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
