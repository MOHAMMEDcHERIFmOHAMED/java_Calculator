import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator implements ActionListener {

    JLabel label;
    JButton[] btns = new JButton[ 10 ];
    JButton[] opbtns = new JButton[ 9 ];
    JButton addbtn , subbtn , multbtn , deletebtn , clearbtn , divbtn  , equbtn , decbtn , ngbtn ;
    JTextField textField;
    JPanel InputPanel = new JPanel();
    JPanel BtnsPanel = new JPanel();
    double num1 , num2 , result ;
    char operator ;

    public Calculator() {

        JFrame frame = new JFrame();
        frame.setTitle("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 700);
        frame.setLayout(null);

        textField = new JTextField( );
        textField.setBounds(25 , 50,350,50);
        textField.setFont(new Font("MV BOLI", Font.ITALIC , 40));
        textField.setEditable(false);

        addbtn = new JButton("+");
        subbtn = new JButton("-");
        multbtn = new JButton("*");
        deletebtn = new JButton("Del");
        clearbtn = new JButton("Clear");
        divbtn = new JButton("/");
        equbtn = new JButton("=");
        decbtn = new JButton(".");
        ngbtn = new JButton("(-)") ;

        addbtn.addActionListener(this);
        subbtn.addActionListener(this);
        multbtn.addActionListener(this);
        divbtn.addActionListener(this);
        equbtn.addActionListener(this);
        decbtn.addActionListener(this);
        deletebtn.addActionListener(this);
        decbtn.addActionListener(this);
        ngbtn.addActionListener(this);
        clearbtn.addActionListener(this);

        opbtns[0] = addbtn;
        opbtns[1] = subbtn;
        opbtns[2] = multbtn;
        opbtns[3] = deletebtn;
        opbtns[4] = clearbtn;
        opbtns[5] = divbtn;
        opbtns[6] = equbtn;
        opbtns[7] = decbtn;
        opbtns[8] = ngbtn;

        // Panel to hold buttons
        BtnsPanel.setBounds(25, 100, 340, 400);
        BtnsPanel.setLayout(new GridLayout(5, 4, 10, 10));

        for (int i = 0; i < 10; i++) {
            btns[i] = new JButton(String.valueOf(i));
            btns[i].addActionListener(this);
        }

        // Add number buttons and operation buttons to panel
        for (int i = 1; i <= 3; i++) BtnsPanel.add(btns[i]);
        BtnsPanel.add(addbtn);
        for (int i = 4; i <= 6; i++) BtnsPanel.add(btns[i]);
        BtnsPanel.add(subbtn);
        for (int i = 7; i <= 9; i++) BtnsPanel.add(btns[i]);
        BtnsPanel.add(multbtn);
        BtnsPanel.add(decbtn);
        BtnsPanel.add(btns[0]);
        BtnsPanel.add(equbtn);
        BtnsPanel.add(divbtn);
        BtnsPanel.add(clearbtn);
        BtnsPanel.add(ngbtn);
        BtnsPanel.add(deletebtn);

        frame.add(textField);
        frame.add(BtnsPanel);
        frame.setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i = 0 ; i < 10 ; i++  ){
            if(e.getSource() == btns[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i))) ;
                System.out.println("concatinated" + i);
            }
        }

        if (e.getSource() == decbtn) textField.setText(textField.getText().concat("."));
        if (e.getSource() == divbtn) setoperation('/');
        if (e.getSource() == multbtn) setoperation('*');
        if (e.getSource() == addbtn) setoperation('+');
        if (e.getSource() == subbtn) setoperation('-');
        if (e.getSource() == deletebtn) {
            System.out.println("deleted");
            String currentText = textField.getText();
            if (currentText.length() > 0) {
                textField.setText(currentText.substring(0, currentText.length() - 1));
            }
        }
        if (e.getSource() == ngbtn) {
            double value = Double.parseDouble(textField.getText());
            value *= -1;
            textField.setText(String.valueOf(value));
        }
        if (e.getSource() == clearbtn) textField.setText("");
        if (e.getSource() == equbtn) calc(operator);

    }
    public void setoperation(char op){
        num1 = Double.parseDouble(textField.getText());
        textField.setText("");
        operator = op ;
    }
    public void calc(char operator){
        num2 = Double.parseDouble(textField.getText());
        switch(operator){
            case '+' : result =  num1 + num2;
                break;
            case '-' : result =  num1 - num2;
                break;
            case '*' : result =  num1 * num2;
                break;
            case '/' : result =  num1 / num2;
                break;
        }
        System.out.println(result);
        textField.setText(String.valueOf(result));
    }

}
