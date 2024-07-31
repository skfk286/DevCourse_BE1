package day_0731.practice01.vo;

public class FoodVo {

    private int foodId;         // 음식 식별자
    private String foodName;    // 음식 이름

    // 기본 생성자
    public FoodVo() {
    }

    // 매개변수가 있는 생성자
    public FoodVo(int foodId, String foodName) {
        this.foodId = foodId;
        this.foodName = foodName;
    }

    // getter and setter methods
    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    @Override
    public String toString() {
        return "Food{" +
                "foodId=" + foodId +
                ", foodName='" + foodName + '\'' +
                '}';
    }
}
