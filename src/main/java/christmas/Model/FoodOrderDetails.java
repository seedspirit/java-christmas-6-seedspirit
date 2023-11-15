package christmas.Model;

import static christmas.Constants.DomainConstants.MAX_FOOD_AMOUNT;
import static christmas.Constants.DomainConstants.MIN_FOOD_AMOUNT;
import static christmas.Constants.Message.ExceptionMsg.OrderErrorMsg.ASK_ORDER_INPUT_IN_VALID_FORMAT;
import static christmas.Model.Menu.MENU_CATEGORY_BEVERAGE;

import java.util.Map;

public class FoodOrderDetails {
    private Map<String, Integer> foodOrderDetails;
    public FoodOrderDetails(Map<String, Integer> orderInput){
        validate(orderInput);
        this.foodOrderDetails = orderInput;
    }

    private void validate(Map<String, Integer> orderInput){
        isFoodInMenu(orderInput);
        isFoodAmountInValidRange(orderInput);
        isAllFoodAmountInValidRange(orderInput);
        isOnlyBeverageOrdered(orderInput);
    }

    private void isFoodInMenu(Map<String, Integer> orderInput){
        if(!Menu.isExistsInMenu(orderInput)){
            throw new IllegalArgumentException(ASK_ORDER_INPUT_IN_VALID_FORMAT.getMessage());
        }
    }

    private void isFoodAmountInValidRange(Map<String, Integer> orderInput){
        for(Integer foodAmount : orderInput.values()){
            if(foodAmount < MIN_FOOD_AMOUNT || foodAmount > MAX_FOOD_AMOUNT){
                throw new IllegalArgumentException(ASK_ORDER_INPUT_IN_VALID_FORMAT.getMessage());
            }
        }
    }

    private void isAllFoodAmountInValidRange(Map<String, Integer> orderInput){
        if(orderInput.values().stream().mapToInt(Integer::intValue).sum() > MAX_FOOD_AMOUNT){
            throw new IllegalArgumentException(ASK_ORDER_INPUT_IN_VALID_FORMAT.getMessage());
        }
    }

    private void isOnlyBeverageOrdered(Map<String, Integer> orderInput){
        if(!Menu.isOtherCategoryExistsExcept(MENU_CATEGORY_BEVERAGE, orderInput)){
            throw new IllegalArgumentException(ASK_ORDER_INPUT_IN_VALID_FORMAT.getMessage());
        }
    }

    public Integer getPreDiscountTotal(){
        return Menu.calculatePreDiscountTotal(foodOrderDetails);
    }

    public Integer countItemsInCategory(String category){
        return Menu.countAmountOfMenuCategory(foodOrderDetails, category);
    }

    public Map<String, Integer> getFoodOrderDetails() {
        return foodOrderDetails;
    }

}
