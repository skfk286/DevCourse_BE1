package day_0731.practice01.impl;

import day_0731.practice01.IFoodManager;
import day_0731.practice01.constants.SQL;
import day_0731.practice01.jdbc.DatabaseConnectionManager;
import day_0731.practice01.vo.FoodVo;
import day_0731.practice01.vo.IngredientFoodVo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FoodManagerImpl implements IFoodManager {
    private Connection conn = DatabaseConnectionManager.getInstance().getConnection();

    @Override
    public FoodVo addFood(FoodVo food) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // SQL INSERT 쿼리
            String sql = "INSERT INTO food (food_name) VALUES (?)";

            // PreparedStatement 생성
            pstmt = conn.prepareStatement(SQL.INSERT_FOOD);
            pstmt.setString(1, food.getFoodName());

            // 쿼리 실행
            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                System.out.println("요리가 정상적으로 추가되었습니다.");
                return new FoodVo(1, food.getFoodName());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 리소스 정리
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    @Override
    public FoodVo getFoodById(int foodId) {
        return null;
    }

    @Override
    public List<FoodVo> getAllFoods() {
        List<FoodVo> foodList = new ArrayList<>();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            pstmt = conn.prepareStatement(SQL.SELECT_ALL_FOODS);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                int foodId = rs.getInt("food_id");
                String foodName = rs.getString("food_name");
                FoodVo foodVo = new FoodVo(foodId, foodName);
                foodList.add(foodVo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Clean up JDBC resources
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return foodList;
    }

    @Override
    public FoodVo updateFood(FoodVo food) {
        return null;
    }

    @Override
    public boolean deleteFood(int foodId) {
        return false;
    }

    @Override
    public IngredientFoodVo addIngredientFood(IngredientFoodVo ingredientFood) {
        return null;
    }

    @Override
    public IngredientFoodVo getIngredientFoodById(int ingredientFoodId) {
        return null;
    }

    @Override
    public List<IngredientFoodVo> getIngredientFoodsByFoodId(int foodId) {
        return List.of();
    }

    @Override
    public IngredientFoodVo updateIngredientFood(IngredientFoodVo ingredientFood) {
        return null;
    }

    @Override
    public boolean deleteIngredientFood(int ingredientFoodId) {
        return false;
    }
}
