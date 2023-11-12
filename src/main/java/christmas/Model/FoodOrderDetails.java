package christmas.Model;

import static christmas.Constants.DomainConstants.MAX_FOOD_AMOUNT;
import static christmas.Constants.DomainConstants.MIN_FOOD_AMOUNT;
import static christmas.Constants.Message.ExceptionMsg.OrderErrorMsg.ASK_ORDER_INPUT_IN_VALID_FORMAT;
import static christmas.Model.Menu.MENU_CATEGORY_BEVERAGE;

import java.util.Map;

public class FoodOrderDetails {
    private Map<String, Integer> foodOrderDetails;
    public FoodOrderDetails(Map<String, Integer> orderInput){
        validate();
        this.foodOrderDetails = orderInput;
    }

    private void validate(){
        isFoodInMenu();
        isFoodAmountInValidRange();
        isOnlyBeverageOrdered();
    }

    private void isFoodInMenu(){
        if(!Menu.isExistsInMenu(foodOrderDetails)){
            throw new IllegalStateException(ASK_ORDER_INPUT_IN_VALID_FORMAT.getMessage());
        }
    }

    private void isFoodAmountInValidRange(){
        for(Integer foodAmount : foodOrderDetails.values()){
            if(foodAmount < MIN_FOOD_AMOUNT || foodAmount > MAX_FOOD_AMOUNT){
                throw new IllegalStateException(ASK_ORDER_INPUT_IN_VALID_FORMAT.getMessage());
            }
        }
    }

    private void isOnlyBeverageOrdered(){
        if(!Menu.isOtherCategoryExistsExcept(MENU_CATEGORY_BEVERAGE, foodOrderDetails)){
            throw new IllegalStateException(ASK_ORDER_INPUT_IN_VALID_FORMAT.getMessage());
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
