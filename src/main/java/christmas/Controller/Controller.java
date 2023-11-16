package christmas.Controller;

import christmas.Model.Benefits;
import christmas.Model.ReservationDetails;
import christmas.Model.FoodOrderDetails;
import christmas.View.InputView;
import christmas.View.OutputView;
import java.util.Map;

public class Controller {
    private FoodOrderDetails foodOrderDetails;
    public void startProcess(){
        ReservationDetails reservationDetails = makeReservation();
        Benefits benefits = applyBenefits(reservationDetails);
        printResult(reservationDetails, benefits);
    }

    private ReservationDetails makeReservation(){
        InputView inputView = new InputView();
        Integer visitDate = inputView.visitDateInput();
        receiveFoodOrder(inputView);
        ReservationDetails reservationDetails = new ReservationDetails(foodOrderDetails, visitDate);

        return reservationDetails;
    }

    private void receiveFoodOrder(InputView inputView) {
        boolean invalidOrder;
        do {
            invalidOrder = isOrderValid(inputView);
        } while(!invalidOrder);
    }

    private boolean isOrderValid(InputView inputView){
        try{
            Map<String, Integer> orderInput = inputView.orderInput();
            foodOrderDetails = new FoodOrderDetails(orderInput);

            return true;
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());

            return false;
        }
    }

    private Benefits applyBenefits(ReservationDetails reservationDetails){
        Benefits benefits = new Benefits();
        benefits.apply(reservationDetails);

        return benefits;
    }

    private void printResult(ReservationDetails reservationDetails, Benefits benefits){
        OutputView outputView = new OutputView();
        outputView.printWhole(reservationDetails, benefits);
    }
}
