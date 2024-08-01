package day_0801.model;

import java.sql.SQLException;
import java.util.List;

interface BoardRepository {
    int insert(BoardDTO board) throws SQLException;
    int update(BoardDTO board) throws SQLException;
    int delete(BoardDTO board) throws SQLException;
    List<BoardDTO> selectAll() throws SQLException;
    BoardDTO selectOne(int no) throws SQLException;
}
