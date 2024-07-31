package day_0731.practice01.vo;

import java.math.BigDecimal;

public class IngredientVo {

    private int ingredientId;         // 성분 식별자
    private String ingredientName;    // 성분 이름
    private BigDecimal tan;           // 탄
    private BigDecimal dan;           // 단
    private BigDecimal gi;            // 지
    private BigDecimal dang;          // 당

    // 기본 생성자
    public IngredientVo() {
    }

    // 매개변수가 있는 생성자
    public IngredientVo(int ingredientId, String ingredientName, BigDecimal tan, BigDecimal dan, BigDecimal gi, BigDecimal dang) {
        this.ingredientId = ingredientId;
        this.ingredientName = ingredientName;
        this.tan = tan;
        this.dan = dan;
        this.gi = gi;
        this.dang = dang;
    }

    // getter and setter methods
    public int getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(int ingredientId) {
        this.ingredientId = ingredientId;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public BigDecimal getTan() {
        return tan;
    }

    public void setTan(BigDecimal tan) {
        this.tan = tan;
    }

    public BigDecimal getDan() {
        return dan;
    }

    public void setDan(BigDecimal dan) {
        this.dan = dan;
    }

    public BigDecimal getGi() {
        return gi;
    }

    public void setGi(BigDecimal gi) {
        this.gi = gi;
    }

    public BigDecimal getDang() {
        return dang;
    }

    public void setDang(BigDecimal dang) {
        this.dang = dang;
    }

    // Method to calculate calories
    public BigDecimal calculateCalories() {
        // Constants for calorie calculation
        BigDecimal calorieFactorTanDan = new BigDecimal("4");
        BigDecimal calorieFactorGi = new BigDecimal("9");
        BigDecimal calorieFactorDang = new BigDecimal("3.8");

        // Calculate total calories
        BigDecimal calories = tan.multiply(calorieFactorTanDan)
                .add(dan.multiply(calorieFactorTanDan))
                .add(gi.multiply(calorieFactorGi))
                .add(dang.multiply(calorieFactorDang));
        return calories;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "ingredientId=" + ingredientId +
                ", ingredientName='" + ingredientName + '\'' +
                ", tan=" + tan +
                ", dan=" + dan +
                ", gi=" + gi +
                ", dang=" + dang +
                ", calories=" + calculateCalories() +
                '}';
    }
}
