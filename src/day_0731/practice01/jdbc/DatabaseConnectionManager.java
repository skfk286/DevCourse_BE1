package day_0731.practice01.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * DatabaseConnectionManager는 데이터베이스 커넥션을 싱글톤 패턴으로 관리합니다.
 */
public class DatabaseConnectionManager {

    private static DatabaseConnectionManager instance;
    private Connection connection;

    // 데이터베이스 URL, 사용자명, 비밀번호
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/workshop_test";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";

    // private 생성자
    private DatabaseConnectionManager() {
        try {
            // 드라이버 클래스 로드
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 커넥션 생성
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("데이터베이스 연결에 실패했습니다.", e);
        }
    }

    // 인스턴스 접근 메서드
    public static DatabaseConnectionManager getInstance() {
        if (instance == null) {
            instance = new DatabaseConnectionManager();
        }
        return instance;
    }

    // 커넥션 반환 메서드
    public Connection getConnection() {
        return connection;
    }

    // 커넥션 닫기 메서드
    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException("커넥션 종료에 실패했습니다.", e);
            }
        }
    }
}