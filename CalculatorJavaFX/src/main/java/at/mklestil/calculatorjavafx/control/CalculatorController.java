package at.mklestil.calculatorjavafx.control;

import at.mklestil.calculatorjavafx.model.MathModel;
import at.mklestil.calculatorjavafx.view.NumberButton;
import at.mklestil.calculatorjavafx.view.CalculatorScene;
import at.mklestil.calculatorjavafx.view.OperatorButton;
import javafx.event.Event;
import javafx.event.EventHandler;

import java.util.ArrayList;

public class CalculatorController {

    private CalculatorScene view;

    private double number1 = 0;
    private double number2 = 0;

    private double numberKoma = 0;

    private String operator = "";

    private boolean check = false;
    private boolean oCheck = false;

    private MathModel model = new MathModel();

    public CalculatorController(CalculatorScene view){
        this.view = view;

        //Set Event Handler on Buttons
        ArrayList<NumberButton> listOfButtons = view.getListOfButtons();
        for(NumberButton btn : listOfButtons){
            btn.setOnAction(myBtnHandler(btn));
        }

        //Set Event Handler for operation
        ArrayList<OperatorButton> operatorButtons = view.getListOfOperatorButtons();
        for(OperatorButton oBtn : operatorButtons){
            oBtn.setOnAction(myOperatorBtnHandler(oBtn));
        }
    }

    // Btn Logic
    public EventHandler myBtnHandler(NumberButton btn){
        EventHandler eventHandler = new EventHandler<>() {
            @Override
            public void handle(Event event) {
                view.setDisplay("" + btn.getValue());
                if (oCheck == false){
                    number1 = btn.getValue() + numberKoma;
                }else{
                    number2 = btn.getValue() + numberKoma;
                }
            }
        };
        return eventHandler;
    }

    public EventHandler myOperatorBtnHandler(OperatorButton btn){
        EventHandler eventHandler = new EventHandler<>() {
            @Override
            public void handle(Event event) {
                view.setDisplay("" + btn.getTyp());
                System.out.println(btn.getTyp());
                if (!btn.getTyp().equals("Enter") && !btn.getTyp().equals(".") && !btn.getTyp().equals("Clear")) {
                    oCheck = true;
                    operator = btn.getTyp();
                } else if (btn.getTyp().equals("Enter")) {
                    check = true;
                    double value = model.getMath(number1, number2, operator);
                    System.out.println(value);
                    view.setDisplay("" + value);
                    resetCheck();
                }else if(btn.getTyp().equals(".")){
                    System.out.println(". pressed");
                    if(oCheck){
                        numberKoma = number2 / 10.0 ;
                    }else {
                        numberKoma = number1 / 10.0;
                    }
                    System.out.println("Koma: " + numberKoma);

                }
                else if(btn.getTyp().equals("Clear")){
                    System.out.println("Clear");
                    view.setDisplay("");
                }
            }
        };
        return eventHandler;
    }

    private void resetCheck() {
        check = false;
        oCheck = false;
        number1 = 0;
        number2 = 0;
        numberKoma = 0;
    }

}
