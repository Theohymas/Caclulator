import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Equals implements ActionListener{

    private CalculatorGUI gui;
    private JButton button;

    public Equals(CalculatorGUI gui)
    {
        this.gui = gui;
        button = new JButton("=");
        button.setForeground(Color.WHITE);
        button.setBackground(Color.BLACK);
        button.addActionListener(this);
    }
    
    public JButton getButton()
    {
        return button;
    }

    public void actionPerformed(ActionEvent event)
    {
        gui.calculateResult();
    }
}