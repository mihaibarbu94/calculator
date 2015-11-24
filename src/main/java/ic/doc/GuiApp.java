package ic.doc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Controller
public class GuiApp {

    private GridLayoutView view = new GridLayoutView(new Controller());
    private RPCalculator calculator = new RPCalculator(view);

    class Controller implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            calculator.perform(event.getActionCommand());
        }
    }

    public static void main(String[] args) {
        new GuiApp();
    }

}
