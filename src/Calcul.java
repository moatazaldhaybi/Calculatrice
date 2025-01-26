import java.awt.Button;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Calcul implements ActionListener {

  JFrame frame;
  JTextField textfield;

  JButton[] numberButtons = new JButton[10];
  JButton[] operandButton = new JButton[9];

  JButton addButton,subButton,mulButton,divButton,decButton,equButton,clrButton,delButton,negButton;
  JPanel panel;

  Font myFont = new Font("Ink Free",Font.BOLD,30);
  double num1=0, num2=0, result=0;
  char operator;

  public Calcul(){
    frame = new JFrame("Calculatrice");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(500,600);
    frame.setLayout(null);
    textfield = new JTextField();
    textfield.setBounds(50,25,300,50);
    textfield.setFont(myFont);
    textfield.setEditable(false);




    addButton = new JButton("+");
    subButton = new JButton("-"); 
    mulButton = new JButton("*");
    divButton = new JButton("/");
    decButton = new JButton(".");
    equButton = new JButton("=");
    delButton = new JButton("Del");
    clrButton = new JButton("Clr");
    negButton = new JButton("(-)");


    operandButton[0]=addButton;
    operandButton[1]=subButton;
    operandButton[2]=mulButton;
    operandButton[3]=divButton;
    operandButton[4]=decButton;
    operandButton[5]=equButton;
    operandButton[6]=delButton;
    operandButton[7]=clrButton;
    operandButton[8]=negButton;

    for(int i =0; i<9;i++){
      operandButton[i].addActionListener(this);
      operandButton[i].setFont(myFont);
      operandButton[i].setFocusable(false);

    }

    for(int i =0; i<10;i++){
      numberButtons[i] = new JButton(String.valueOf(i));
      numberButtons[i].addActionListener(this);
      numberButtons[i].setFocusable(false);

    }

    negButton.setBounds(50,430,100,50);
    delButton.setBounds(150,430,100,50);
    clrButton.setBounds(250,430,100,50);

    panel = new JPanel();
    panel.setBounds(50,100,300,300);
    panel.setLayout(new GridLayout(4,4,10,10));

    panel.add(numberButtons[1]);
    panel.add(numberButtons[2]);
    panel.add(numberButtons[3]);
    panel.add(addButton);

    panel.add(numberButtons[4]);
    panel.add(numberButtons[5]);
    panel.add(numberButtons[6]);
    panel.add(subButton);

    panel.add(numberButtons[7]);
    panel.add(numberButtons[8]);
    panel.add(numberButtons[9]);
    panel.add(mulButton);
    panel.add(decButton);
    panel.add(numberButtons[0]);
    panel.add(equButton);
    panel.add(divButton);
    
    frame.add(panel);
    frame.add(negButton);
    frame.add(delButton);
    frame.add(clrButton);
    frame.add(textfield);
    frame.setVisible(true);
  }

  public void actionPerformed(ActionEvent event){
    for(int i =0; i<10;i++){
      if(event.getSource() == numberButtons[i]){
        textfield.setText(textfield.getText().concat(String.valueOf(i)));
      }
    }

    if(event.getSource() == decButton){
      textfield.setText(textfield.getText().concat("."));
    }
    if(event.getSource() == addButton){
      num1 = Double.parseDouble(textfield.getText());
      operator = '+';
      textfield.setText("");
    }
    if(event.getSource() == subButton){
      num1 = Double.parseDouble(textfield.getText());
      operator = '-';
      textfield.setText("");
    }
    if(event.getSource() == mulButton){
      num1 = Double.parseDouble(textfield.getText());
      operator = '*';
      textfield.setText("");
    }
    if(event.getSource() == divButton){
      num1 = Double.parseDouble(textfield.getText());
      operator = '/';
      textfield.setText("");
    }

    if(event.getSource() == equButton){
      num2 = Double.parseDouble(textfield.getText());

      switch (operator) {
        case '+':
          result = num1 + num2;
          break;
      
        case '-':
          result = num1 - num2;
          break;

        case '*':
          result = num1 * num2;
          break;
        
        case '/':
          result = num1 / num2;
          break;
      }

      textfield.setText(String.valueOf(result));
      num1 = result;
    }

    if(event.getSource() == clrButton){
      textfield.setText("");
    }
    if(event.getSource() == delButton){
      String s = textfield.getText();
      textfield.setText("");

      for(int i=0; i<s.length()-1; i++){
        textfield.setText(textfield.getText()+s.charAt(i))  ;
      }
    }
    if(event.getSource() == negButton){
      double temps = Double.parseDouble(textfield.getText());
      temps*=-1;
      textfield.setText(String.valueOf(temps));
    }
  }
  
}
