package day_0731.practice01.constants;

public class SQL {
    // Food 관련 SQL 쿼리 상수
    public static final String SELECT_FOOD_BY_ID =
            "SELECT food_id, food_name FROM food WHERE food_id = ?";

    public static final String SELECT_ALL_FOODS =
            "SELECT food_id, food_name FROM food";

    public static final String INSERT_FOOD = "INSERT INTO food (food_name) VALUES (?)";
    public static final String UPDATE_FOOD = "UPDATE food SET food_name = ? WHERE food_id = ?";
    public static final String DELETE_FOOD = "DELETE FROM food WHERE food_id = ?";

    // IngredientFood 관련 SQL 쿼리 상수
    public static final String INSERT_INGREDIENT_FOOD = "INSERT INTO ingredient_food (ingredient_id, food_id, ingredient_usage) VALUES (?, ?, ?)";
    public static final String SELECT_INGREDIENT_FOOD_BY_ID =
            "SELECT ingredient_food_id, ingredient_id, food_id, ingredient_usage " +
                    "FROM ingredient_food WHERE ingredient_food_id = ?";

    public static final String SELECT_INGREDIENT_FOODS_BY_FOOD_ID =
            "SELECT ingredient_food_id, ingredient_id, food_id, ingredient_usage " +
                    "FROM ingredient_food WHERE food_id = ?";
    public static final String UPDATE_INGREDIENT_FOOD = "UPDATE ingredient_food SET ingredient_id = ?, food_id = ?, ingredient_usage = ? WHERE ingredient_food_id = ?";
    public static final String DELETE_INGREDIENT_FOOD = "DELETE FROM ingredient_food WHERE ingredient_food_id = ?";
}
