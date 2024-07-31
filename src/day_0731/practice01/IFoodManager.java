package day_0731.practice01;

import day_0731.practice01.vo.FoodVo;
import day_0731.practice01.vo.IngredientFoodVo;

import java.util.List;

/**
 * IFoodManager 인터페이스는 음식과 성분-음식 매핑에 대한 CRUD 작업을 정의합니다.
 */
public interface IFoodManager {

    // 음식 관련 메서드
    /**
     * 음식 추가
     * @param food 추가할 음식 객체
     * @return 추가된 음식 객체
     */
    FoodVo addFood(FoodVo food);

    /**
     * 음식 ID로 음식 검색
     * @param foodId 검색할 음식 ID
     * @return 검색된 음식 객체, 존재하지 않으면 null
     */
    FoodVo getFoodById(int foodId);

    /**
     * 모든 음식 목록 가져오기
     * @return 음식 객체 리스트
     */
    List<FoodVo> getAllFoods();

    /**
     * 음식 정보 수정
     * @param food 수정할 음식 객체
     * @return 수정된 음식 객체, 존재하지 않으면 null
     */
    FoodVo updateFood(FoodVo food);

    /**
     * 음식 삭제
     * @param foodId 삭제할 음식 ID
     * @return 성공 여부
     */
    boolean deleteFood(int foodId);

    // 성분-음식 매핑 관련 메서드
    /**
     * 성분-음식 매핑 추가
     * @param ingredientFood 추가할 성분-음식 매핑 객체
     * @return 추가된 성분-음식 매핑 객체
     */
    IngredientFoodVo addIngredientFood(IngredientFoodVo ingredientFood);

    /**
     * 성분-음식 매핑 ID로 매핑 검색
     * @param ingredientFoodId 검색할 성분-음식 매핑 ID
     * @return 검색된 성분-음식 매핑 객체, 존재하지 않으면 null
     */
    IngredientFoodVo getIngredientFoodById(int ingredientFoodId);

    /**
     * 음식 ID로 성분-음식 매핑 목록 가져오기
     * @param foodId 검색할 음식 ID
     * @return 성분-음식 매핑 객체 리스트
     */
    List<IngredientFoodVo> getIngredientFoodsByFoodId(int foodId);

    /**
     * 성분-음식 매핑 정보 수정
     * @param ingredientFood 수정할 성분-음식 매핑 객체
     * @return 수정된 성분-음식 매핑 객체, 존재하지 않으면 null
     */
    IngredientFoodVo updateIngredientFood(IngredientFoodVo ingredientFood);

    /**
     * 성분-음식 매핑 삭제
     * @param ingredientFoodId 삭제할 성분-음식 매핑 ID
     * @return 성공 여부
     */
    boolean deleteIngredientFood(int ingredientFoodId);
}