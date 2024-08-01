package day_0801.model;

import java.sql.SQLException;
import java.util.List;

public class BoardRepositoryOracle implements BoardRepository{

    @Override
    public int insert(BoardDTO board) throws SQLException {
        return 0;
    }

    @Override
    public int update(BoardDTO board) throws SQLException {
        return 0;
    }

    @Override
    public int delete(BoardDTO board) throws SQLException {
        return 0;
    }

    @Override
    public List<BoardDTO> selectAll() throws SQLException {
        return List.of();
    }

    @Override
    public BoardDTO selectOne(int no) throws SQLException {
        return null;
    }
}
