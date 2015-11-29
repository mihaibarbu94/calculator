package ic.doc;

//MODEL

public class RPCalculator {
    private static final String EMPTY_STRING = "";
    private String digitsAcc;
    private Updatable view;
    private int res;

    public RPCalculator(Updatable view) {
        this.view      = view;
        this.res       = 0;
        this.digitsAcc = EMPTY_STRING;
    }

    public String printStack() {
        return digitsAcc;
    }

    public void perform(String actionCommand) throws ArithmeticException {
        switch (actionCommand) {
            case "+":
            case "-":
            case "*":
            case "/":
            case "Space" :
            case "Delete":
            case "Clear" :
                performArithmetic(actionCommand);
                performAction(actionCommand);
                break;
            default:
                digitsAcc += actionCommand;
        }
        view.update(this);
    }

    private void performArithmetic(String actionCommand) {
        if (!digitsAcc.equals(EMPTY_STRING)) {
            switch (actionCommand){
                case "+":
                    res = safeAdd(res, Integer.parseInt(digitsAcc));
                    break;
                case "-":
                    res = safeSubtract(res, Integer.parseInt(digitsAcc));
                    break;
                case "*":
                    res = safeMultiply(res, Integer.parseInt(digitsAcc));
                    break;
                case "/":
                    res = safeDivide(res, Integer.parseInt(digitsAcc));
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
                    digitsAcc = digitsAcc.substring(0, digitsAcc.length() - 1);
                    break;
                case "Clear":
                    digitsAcc = digitsAcc.replace(digitsAcc, EMPTY_STRING);
                    res = 0;
            }
        }
    }

    private int safeAdd(int left, int right) throws ArithmeticException {
        if (right > 0 ? left > Integer.MAX_VALUE - right
                : left < Integer.MIN_VALUE - right) {
            handleError();
        }
        return left + right;
    }

    private int safeSubtract(int left, int right) throws ArithmeticException {
        if (right > 0 ? left < Integer.MIN_VALUE + right
                : left > Integer.MAX_VALUE + right) {
            handleError();
        }
        return left - right;
    }

    private int safeMultiply(int left, int right) throws ArithmeticException {
        if (right > 0 ? left > Integer.MAX_VALUE/right
                || left < Integer.MIN_VALUE/right
                : (right < -1 ? left > Integer.MIN_VALUE/right
                || left < Integer.MAX_VALUE/right
                : right == -1
                && left == Integer.MIN_VALUE)) {
            handleError();
        }
        return left * right;
    }

    private int safeDivide(int left, int right) throws ArithmeticException {
        if ((left == Integer.MIN_VALUE) && (right == -1)) {
            handleError();
        }
        return left / right;
    }

    private void handleError() {
        digitsAcc = "ERROR";
        view.update(this);
        throw new ArithmeticException("Integer overflow");
    }
}
