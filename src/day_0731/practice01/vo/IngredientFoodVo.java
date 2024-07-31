package day_0731.practice01.vo;

import java.math.BigDecimal;

public class IngredientFoodVo {

    private int ingredientFoodId;  // 매핑 식별자
    private int ingredientId;      // 성분 식별자
    private int foodId;            // 음식 식별자
    private BigDecimal ingredientUsage;  // 성분 사용량

    // 기본 생성자
    public IngredientFoodVo() {
    }

    // 매개변수가 있는 생성자
    public IngredientFoodVo(int ingredientFoodId, int ingredientId, int foodId, BigDecimal ingredientUsage) {
        this.ingredientFoodId = ingredientFoodId;
        this.ingredientId = ingredientId;
        this.foodId = foodId;
        this.ingredientUsage = ingredientUsage;
    }

    // getter and setter methods
    public int getIngredientFoodId() {
        return ingredientFoodId;
    }

    public void setIngredientFoodId(int ingredientFoodId) {
        this.ingredientFoodId = ingredientFoodId;
    }

    public int getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(int ingredientId) {
        this.ingredientId = ingredientId;
    }

    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }

    public BigDecimal getIngredientUsage() {
        return ingredientUsage;
    }

    public void setIngredientUsage(BigDecimal ingredientUsage) {
        this.ingredientUsage = ingredientUsage;
    }

    @Override
    public String toString() {
        return "IngredientFood{" +
                "ingredientFoodId=" + ingredientFoodId +
                ", ingredientId=" + ingredientId +
                ", foodId=" + foodId +
                ", ingredientUsage=" + ingredientUsage +
                '}';
    }
}
