package edu.elon.template.applet;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalculatorApplet extends JApplet {
	private String textBox;
	private String op;
	private double firstNum;
	private double secondNum;
	private CalculatorApplet app = this;
	private JTextField answer;
	public class NumberListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String num = ((JButton)e.getSource()).getText();
			textBox = textBox+num;
			answer.setText(textBox);
		}
		
	}
	
	public class OpListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String operation = ((JButton)e.getSource()).getText();
			op = operation;
			firstNum = Double.parseDouble(answer.getText());
			textBox = "";
			answer.setText(textBox);
		}
		
	}
	public void init(){
		setLayout(new BorderLayout());
		textBox = "";
		op = "";
		firstNum = 0;
		secondNum = 0;
		answer = new JTextField(25);
		JPanel calculator = createCalc();
		add(answer, BorderLayout.NORTH);
		add(calculator);
	}

	private JPanel createCalc() {
		JPanel calculator = new JPanel();
		calculator.setLayout(new GridLayout(4,4));
		JButton seven = new JButton("7");
		seven.addActionListener(new NumberListener());
		JButton eight = new JButton("8");
		eight.addActionListener(new NumberListener());
		JButton nine = new JButton("9");
		nine.addActionListener(new NumberListener());
		JButton four = new JButton("4");
		four.addActionListener(new NumberListener());
		JButton five = new JButton("5");
		five.addActionListener(new NumberListener());
		JButton six = new JButton("6");
		six.addActionListener(new NumberListener());
		JButton one = new JButton("1");
		one.addActionListener(new NumberListener());
		JButton two = new JButton("2");
		two.addActionListener(new NumberListener());
		JButton three = new JButton("3");
		three.addActionListener(new NumberListener());
		JButton divide = new JButton("/");
		divide.addActionListener(new OpListener());
		JButton multiply = new JButton("*");
		multiply.addActionListener(new OpListener());
		JButton subtract = new JButton("-");
		subtract.addActionListener(new OpListener());
		JButton add = new JButton("+");
		add.addActionListener(new OpListener());
		JButton decimal = new JButton(".");
		decimal.addActionListener(new NumberListener());
		JButton equals = new JButton("=");
		equals.addActionListener(e -> {
			secondNum = Double.parseDouble(answer.getText());
			firstNum = evaluate(firstNum, secondNum, op);
			answer.setText(""+firstNum);
		});
		JButton zero = new JButton("0");
		zero.addActionListener(new NumberListener());
		calculator.add(seven);
		calculator.add(eight);
		calculator.add(nine);
		calculator.add(divide);
		calculator.add(four);
		calculator.add(five);
		calculator.add(six);
		calculator.add(multiply);
		calculator.add(one);
		calculator.add(two);
		calculator.add(three);
		calculator.add(subtract);
		calculator.add(zero);
		calculator.add(decimal);
		calculator.add(equals);
		calculator.add(add);
		return calculator;
	}

	private double evaluate(double fNum, double sNum, String op2) {
		double num = 0.0;
		switch(op2){
		case "+":
			num = fNum+sNum;
			break;
		case "-":
			num = fNum-sNum;
			break;
		case "/":
			num = fNum/sNum;
			break;
		case "*":
			num = fNum*sNum;
			break;
		default:
			return 0;
		}
		return num;
	}
	
}
