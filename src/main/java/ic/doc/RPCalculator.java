package ic.doc;

//MODEL

public class RPCalculator {
        private Updatable view;
        private String output;

    public RPCalculator(Updatable view) {
        this.view = view;
        this.output = "";
    }

    public String printStack() {
        return output;
    }

    public int safeAdd(int left, int right) throws ArithmeticException {
        if (right > 0 ? left > Integer.MAX_VALUE - right
                : left < Integer.MIN_VALUE - right) {
            handleError();
        }
        int res = left + right;
        output = String.valueOf(res);
        view.update(this);
        return res;
    }

    public int safeSubtract(int left, int right) throws ArithmeticException {
        if (right > 0 ? left < Integer.MIN_VALUE + right
                : left > Integer.MAX_VALUE + right) {
            handleError();
        }
        int res = left - right;
        output = String.valueOf(res);
        view.update(this);
        return res;
    }

    public void printOperand(String operandToPrint) {
    	output = operandToPrint;
    	view.update(this);
    }

    private void handleError() {
        output = "ERROR";
        view.update(this);
        throw new ArithmeticException("Integer overflow");
    }
}
