public class CalculatorTest
{
    public static void main(String[] args)
    {
        CalculatorGUI testGUI = new CalculatorGUI();

        System.out.println("Expected 2.0 got "+ firstTest(testGUI,"1","+","1"));
        System.out.println("Expected 3.0 got "+ firstTest(testGUI,"1","+","2"));
        System.out.println("Expected 13.0 got "+ firstTest(testGUI,"5","+","8"));
        System.out.println("Expected 10.0 got "+ firstTest(testGUI,"5.5","+","4.5"));
        System.out.println("Expected 145.0 got "+ firstTest(testGUI,"100","+","45"));


        System.out.println("Expected 1.0 got "+ firstTest(testGUI,"2","-","1"));
        System.out.println("Expected -1.0 got "+ firstTest(testGUI,"1","-","2"));
        System.out.println("Expected 5.0 got "+ firstTest(testGUI,"8","-","3"));
        System.out.println("Expected 1.0 got "+ firstTest(testGUI,"5.5","-","4.5"));
        System.out.println("Expected 594.0 got "+ firstTest(testGUI,"675","-","81"));

        System.out.println("Expected 5.0 got "+ firstTest(testGUI,"10","/","2"));
        System.out.println("Expected 2.5 got "+ firstTest(testGUI,"5","/","2"));
        System.out.println("Expected 7.0 got "+ firstTest(testGUI,"21","/","3"));
        System.out.println("Expected 100.0 got "+ firstTest(testGUI,"300","/","3"));
        System.out.println("Expected 11.0 got "+ firstTest(testGUI,"55","/","5"));

        System.out.println("Expected 12.0 got "+ firstTest(testGUI,"3","x","4"));
        System.out.println("Expected 30.0 got "+ firstTest(testGUI,"5","x","6"));
        System.out.println("Expected 7.0 got "+ firstTest(testGUI,"1.4","x","5"));
        System.out.println("Expected 660.0 got "+ firstTest(testGUI,"66","x","10"));
        System.out.println("Expected 1.0 got "+ firstTest(testGUI,"0.1","x","10"));

        System.exit(0);
    }

    public static double firstTest(CalculatorGUI GUI, String firstNumber, String operator, String secondNumber)
    {
        GUI.buttonClicked(firstNumber);
        GUI.operatorClicked(operator);
        GUI.buttonClicked(secondNumber);
        GUI.calculateResult();
        return GUI.getAnswer();
    }
}

