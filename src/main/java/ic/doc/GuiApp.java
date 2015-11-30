package ic.doc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Controller
public class GuiApp {

    private GridLayoutView view     = new GridLayoutView(new Controller());
    private RPCalculator calculator = new RPCalculator(view);

    class Controller implements ActionListener {
    	private static final String EMPTY_STRING = "";
        private int res = 0;
        private String digitsAcc = "";
        private boolean opInputted = false;

    	public void actionPerformed(ActionEvent event) {
           perform(event.getActionCommand());
        }
    	
    	public void perform(String actionCommand) throws ArithmeticException {
    	   switch (actionCommand) {
    	       case "+":
    	       case "-":
    	       case "*":
    	       case "/":
    	       		performArithmetic(actionCommand);
    	       		opInputted = true;
    	       		break;
    	       case "Space" :
    	       case "Delete":
    	       case "Clear" :
    	           	performAction(actionCommand);
    	           	opInputted = false;
    	           	break;
    	       default:
    	           digitsAcc += actionCommand;
    	           opInputted = false;
    	           calculator.printOperand(digitsAcc);
    	           
    	   }
    	}

    	private void performArithmetic(String actionCommand) {
    	   if (!digitsAcc.equals(EMPTY_STRING) && !opInputted) {
    	       switch (actionCommand){
    	           case "+":
    	               res = calculator.safeAdd(res,
							   		Integer.parseInt(digitsAcc));
    	               break;
    	           case "-":
    	               res = calculator.safeSubtract(res,
							   				Integer.parseInt(digitsAcc));
    	               break;
    	       }
    	       digitsAcc = String.valueOf(res);
    	   }
    	 }
    	
    	 private void performAction(String actionCommand) {
    	    if (!digitsAcc.equals(EMPTY_STRING)) {
    	        switch (actionCommand){
    	            case "Space":
    	                res = Integer.parseInt(digitsAcc);
    	                digitsAcc = EMPTY_STRING;
    	                break;
    	            case "Delete":
    	                digitsAcc = digitsAcc.substring(0,
													digitsAcc.length() - 1);
    	    	        calculator.printOperand(digitsAcc);
    	                break;
    	            case "Clear":
    	                digitsAcc = digitsAcc.replace(digitsAcc, EMPTY_STRING);
    	                res = 0;
    	    	        calculator.printOperand(digitsAcc);

    	        }
    	    }
    	  }
    }

    public static void main(String[] args) {
        new GuiApp();
    }

}
