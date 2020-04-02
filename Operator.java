import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Operator implements ActionListener {

    private String name;
    private CalculatorGUI gui;
    private JButton button;

    public Operator(String n, CalculatorGUI gui)
    {
        name = n;
        this.gui = gui;
        button = new JButton(n);
        button.setForeground(Color.RED);
        button.setBackground(Color.BLACK);
        button.addActionListener(this);
    }
    
    public JButton getButton()
    {
        return button;
    }

    public void actionPerformed(ActionEvent event)
    {
        gui.operatorClicked(name);
    }
}