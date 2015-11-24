package ic.doc;

// View

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class GridLayoutView implements Updatable {

    private final List<JButton> orderedButtons;
    private final GridLayout grid = new GridLayout(0, 3);
    private final JTextField textField = new JTextField(60);

    public GridLayoutView(ActionListener controller) {
        JFrame frame = new JFrame("Reverse Polish Calculator");
        JPanel panel = new JPanel();
        orderedButtons = factory();
        frame.setSize(300, 200);
        panel.setLayout(grid);

        for (JButton button : orderedButtons) {
            button.addActionListener(controller);
            panel.add(button);
        }
        panel.add(textField);
        frame.getContentPane().add(panel);
        frame.setVisible(true);

    }

    public void update(RPCalculator model) {
            textField.setText(model.printStack());
    }

    private List<JButton> factory() {
        List<JButton> orderedButtons = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            orderedButtons.add(new JButton(String.valueOf(i)));
        }
        orderedButtons.add(new JButton("Space"));
        orderedButtons.add(new JButton(String.valueOf(0)));
        orderedButtons.add(new JButton("Delete"));
        orderedButtons.add(new JButton("*"));
        orderedButtons.add(new JButton("+"));
        orderedButtons.add(new JButton("/"));
        orderedButtons.add(new JButton("-"));
        return orderedButtons;
    }

}
