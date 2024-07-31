package day_0731.practice01;

import day_0731.practice01.impl.FoodManagerImpl;
import day_0731.practice01.vo.FoodVo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        boolean isWorking = true;
        IFoodManager foodManager = new FoodManagerImpl();
//        2. main 함수에 포함되어야 하는 기능 예시는 아래와 같습니다.
//        1)데이터 추가
//        2)데이터전체목록
//        3)데이터검색-제목으로
//        4)데이터검색-가격순 ..
//        5)데이터 수정 -> [하위 메뉴로 수정항목 선택여부]
//        6)데이터 삭제
//** 키보드로 데이터를 입력받거나 sout으로 화면에 출력하는 내용은 반드시 main에서만 코딩할 것 **
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            while(isWorking) {
                System.out.println("======================================");
                System.out.println("0. 종료");
                System.out.println("1. 데이터 추가(요리)");
                System.out.println("2. 데이터 전체목록(요리)");
                System.out.println("3. 데이터 검색-(요리 아이디)");
                System.out.println("4. 데이터 수정"); // 나중
                System.out.println("5. 데이터 삭제"); // 나중
                System.out.println("======================================");
                System.out.print("입력 : ");
                int work = Integer.parseInt(br.readLine());
                switch (work) {
                    case 0:
                        isWorking = false;
                        System.out.println("프로그램을 종료합니다.");
                        break;
                    case 1:
                        System.out.println("======================================");
                        System.out.print("요리 이름을 입력하세요 : ");
                        String foodName = br.readLine();
                        FoodVo foodInVo1 = new FoodVo();
                        foodInVo1.setFoodName(foodName);
                        foodManager.addFood(foodInVo1);
                        break;
                    case 2:
                        System.out.println("저장된 모든 요리 정보를 출력합니다.");
                        List<FoodVo> list = foodManager.getAllFoods();
                        for(FoodVo foodVo : list) {
                            System.out.println(foodVo.toString());
                        }
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    default:
                        System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
                        break;

                }
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
