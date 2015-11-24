package ic.doc;

//MODEL

public class RPCalculator {

    String digitsAcc;
    GridLayoutView view;
    int res;
    boolean hasOperator;

    public RPCalculator(GridLayoutView view) {
        this.view = view;
        this.res = 0;
        this.digitsAcc = "";
        this.hasOperator = false;
    }

    public boolean hasGotABinaryOperator() {
        return hasOperator;
    }


    public String printStack() {
        return digitsAcc;
    }

    public void perform(String actionCommand) {

        switch(actionCommand) {
            case "Space":
                if (!digitsAcc.equals("")) {
                    res = Integer.parseInt(digitsAcc);
                    digitsAcc = "";
                }
                break;
            case "Delete":
                if (!digitsAcc.equals("")) {
                    digitsAcc
                            = digitsAcc.substring(0, digitsAcc.length() - 1);
                }
                break;
            case "+":
                if (!digitsAcc.equals("")) {
                    res += Integer.parseInt(digitsAcc);
                    digitsAcc = String.valueOf(res);
                }
                break;
            case "-":
                if (!digitsAcc.equals("")) {
                    res -= Integer.parseInt(digitsAcc);
                    digitsAcc = String.valueOf(res);
                }
                break;
            case "*":
                if (!digitsAcc.equals("")) {
                    res *= Integer.parseInt(digitsAcc);
                    digitsAcc = String.valueOf(res);
                }
                break;
            case "/":
                if (!digitsAcc.equals("")) {
                    res /= Integer.parseInt(digitsAcc);
                    digitsAcc = String.valueOf(res);
                }
                break;
            default:
                digitsAcc += actionCommand;
        }
        view.update(this);

    }
}
