import javax.swing.*;
import java.awt.*;

public class CalculatorGUI
{
    private JFrame mainFrame;
    private JPanel digitPanel;
    private JLabel display;

    private double memory;
    private String currentOperator;
    private boolean readyStatus;

    public CalculatorGUI()
    {
        memory = 0.0;
        currentOperator = "";
        readyStatus = true;

        mainFrame = new JFrame();
        JPanel mainPanel = new JPanel();
        JPanel operators = new JPanel();
        
        operators.setLayout(new GridLayout(0, 1));
        operators.add(new Operator("+", this).getButton());
        operators.add(new Operator("-", this).getButton());
        operators.add(new Operator("x", this).getButton());
        operators.add(new Operator("/", this).getButton());
        operators.add(new Clear(this).getButton());

        mainFrame.setContentPane(mainPanel);
        mainPanel.setLayout(new BorderLayout());

        digitPanel = new JPanel();
        digitPanel.setBackground(Color.BLACK);
        digitPanel.setLayout(new GridLayout(4,3));

        display = new JLabel("0");
        display.setBackground(Color.BLACK);
        display.setPreferredSize(new Dimension(25,50));
        
        for(int i = 0; i < 10; i++)
        {
            Digit digitButton = new Digit(""+i, this);
            digitPanel.add(digitButton.getButton());
        }

        digitPanel.add(new Digit("+/-", this).getButton());
        digitPanel.add(new Digit(".", this).getButton());

        mainPanel.add("Center", digitPanel);
        mainPanel.add("North", display);
        mainPanel.add("South", new Equals(this).getButton());
        mainPanel.add("East", operators);

        mainFrame.setTitle("Gangsta Calculator");
        mainFrame.setSize(450, 450);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
    }

    public void buttonClicked(String buttonLabel)
    {
        String tmp = display.getText();
        if (readyStatus)
        {
            tmp = "";
        }
        readyStatus = false;

        if(!buttonLabel.equals("+/-"))
        {
            if(tmp.indexOf(".") != -1 && buttonLabel.equals("."))
            {
                System.out.println("only one gansta decimal");
            }
            else
            {
                tmp = tmp + buttonLabel;
            }
        }
        else
        {
            if(tmp.startsWith("-"))
            {
                tmp = tmp.substring(1);
            }
            else
            {
                tmp = "-" + tmp;
            }
        }
        display.setText(tmp);
    }

    public void calculateResult()
    {
        doSum("");
    }

    public void operatorClicked(String name)
    {
        doSum(name);
    }

    public void clearResult()
    {
        memory = 0.0;
        readyStatus = true;
        currentOperator = "";
        display.setText("0");
    }

    private void doSum(String name)
    {
        Double value = Double.parseDouble(display.getText());
        switch(currentOperator)
        {
            case "+": memory = memory + value; break;
            case "-": memory = memory - value; break;
            case "x": memory = memory * value; break;
            case "/": memory = memory / value; break;
            case "": memory = value; break;

        }
        currentOperator = name;
        display.setText("" + memory);
        readyStatus = true;
    }
}