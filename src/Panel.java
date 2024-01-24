import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Panel extends JPanel{

    private JButton numbers[] = new JButton[10];
    private Font font = new Font("SanSerif", Font.BOLD, 20);
    private JTextField output = new JTextField();
    private JButton backspace = new JButton("<"), equals = new JButton("=");
    private JButton add = new JButton("+"), minus = new JButton("-");
    private JButton multiply = new JButton("*"), divide = new JButton("/");
    static String firstNumber = "", secondNumber="", operation = "";

    public Panel(){
        setLayout(null);
        setFocusable(true);
        grabFocus();

        ActionListener listen = (ActionEvent e) -> {
            JButton b = (JButton)e.getSource();
            String str = b.getText();
            if (str.charAt(0) == '+' || str.charAt(0) == '-' || str.charAt(0) == '/' || str.charAt(0) == '*') {
                operation = str;
                output.setText(firstNumber + operation + secondNumber);
            }
            if (str.charAt(0)>= '0' && str.charAt(0) <= '9' ) {
                if(operation.isEmpty()) {
                    firstNumber = firstNumber + str;
                } else {
                    secondNumber = secondNumber + str;
                }
                output.setText(firstNumber + operation + secondNumber);
            } else if (str.charAt(0) == '<') {
                firstNumber=operation=secondNumber="";
                output.setText(firstNumber + operation + secondNumber);
            } else if (str.charAt(0) == '=' && !secondNumber.isEmpty()) {
                int result = switch (operation) {
                    case "+" -> Integer.parseInt(firstNumber) + Integer.parseInt(secondNumber);
                    case "*" -> Integer.parseInt(firstNumber) * Integer.parseInt(secondNumber);
                    case "/" -> Integer.parseInt(firstNumber) / Integer.parseInt(secondNumber);
                    default -> Integer.parseInt(firstNumber) - Integer.parseInt(secondNumber);
                };
                output.setText(Integer.toString(result));
                operation = secondNumber = "";
                firstNumber=Integer.toString(result);
            }
        };

        backspace.setBounds(10,250,50,50);
        backspace.setFont(font);
        backspace.addActionListener(listen);
        add(backspace);

        equals.setBounds(130,250,50,50);
        equals.setFont(font);
        equals.addActionListener(listen);
        add(equals);

        add.setBounds(190,70,50,50);
        add.setFont(font);
        add.addActionListener(listen);
        add(add);

        minus.setBounds(190,130,50,50);
        minus.setFont(font);
        minus.addActionListener(listen);
        add(minus);

        multiply.setBounds(190,190,50,50);
        multiply.setFont(font);
        multiply.addActionListener(listen);
        add(multiply);

        divide.setBounds(190,250,50,50);
        divide.setFont(font);
        divide.addActionListener(listen);
        add(divide);

        numbers[0] = new JButton("0");
        numbers[0].setBounds(70, 250, 50,50);
        numbers[0].setFont(font);
        numbers[0].addActionListener(listen);
        add(numbers[0]);

        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                numbers[x*3+y+1] = new JButton((y * 3 + x + 1) + "");
                numbers[x*3+y+1].setBounds(x * (50+10)+10, y * (50 + 10)+70, 50, 50);
                numbers[x*3+y+1].setFont(font);
                numbers[x*3+y+1].addActionListener(listen);
                add(numbers[x*3+y+1]);
            }
        }
        output.setBounds(10,10,230,50);
        output.setFont(font);
        output.setEditable(false);
        add(output);
    }
}
