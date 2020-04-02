import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Clear implements ActionListener{

    private CalculatorGUI gui;
    private JButton button;

    public Clear(CalculatorGUI gui)
    {
        this.gui = gui;
        button = new JButton("CLEAR");
        button.setForeground(Color.GREEN);
        button.setBackground(Color.BLACK);
        button.addActionListener(this);
    }
    
    public JButton getButton()
    {
        return button;
    }

    public void actionPerformed(ActionEvent event)
    {
        gui.clearResult();
    }
}