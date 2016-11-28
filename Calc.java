import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calc  extends JFrame{
	private static final long serialVersionUID = 1;	
	private int WIDTH =	320; 
	private int HEIGHT = 460;
	private JLabel accumulator;
	JPanel panel;
	
	public Calc() {
		setTitle("Calculator");
		setSize(WIDTH,HEIGHT);
		setResizable(true);
		panel = new JPanel();
		panel.setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		createContents();
		setVisible(true);
	}
	
	private void createContents() {
		accumulator = new JLabel("0");
		Font largeFont = new Font("Roboto Thin", Font.PLAIN,56);
		accumulator.setFont(largeFont);
		accumulator.setHorizontalAlignment(SwingConstants.RIGHT);
		add(accumulator, BorderLayout.NORTH);
		ButtonsListener bL = new ButtonsListener();
		OperationListener oL = new OperationListener();
		
		JPanel jp = new JPanel();
			jp.setLayout(new GridLayout(5,4));
			
			final JButton buttonP = new JButton(".");
			final JButton button0 = new JButton("0");
			final JButton button1 = new JButton("1");
			final JButton button2 = new JButton("2");
			final JButton button3 = new JButton("3");
			final JButton button4 = new JButton("4");
			final JButton button5 = new JButton("5");
			final JButton button6 = new JButton("6");
			final JButton button7 = new JButton("7");
			final JButton button8 = new JButton("8");
			final JButton button9 = new JButton("9");
			final JButton buttonEqu = new JButton("=");
			final JButton buttonPlus = new JButton("+");
			final JButton buttonMinus = new JButton("-");
			final JButton buttonTimes = new JButton("*");
			final JButton buttonDiv = new JButton("/");
			final JButton buttonCE = new JButton("CE");
			final JButton buttonCA = new JButton("CA");
			final JButton buttonEmp = new JButton("");
			final JButton buttonEmp2 = new JButton("");
			
			Font font = new Font("Roboto Light", Font.PLAIN,32);
			buttonP.setFont(largeFont);
			button0.setFont(font);
			button1.setFont(font);
			button2.setFont(font);
			button3.setFont(font);
			button4.setFont(font);
			button5.setFont(font);
			button6.setFont(font);
			button7.setFont(font);
			button8.setFont(font);
			button9.setFont(font);	
			buttonPlus.setFont(font);
			buttonMinus.setFont(font);
			buttonTimes.setFont(font);
			buttonDiv.setFont(font);
			buttonEqu.setFont(font);
			buttonCE.setFont(font);
			buttonCA.setFont(font);
			
			
			buttonP.addActionListener(bL);
			button0.addActionListener(bL);
			button1.addActionListener(bL);
			button2.addActionListener(bL);
			button3.addActionListener(bL);
			button4.addActionListener(bL);
			button5.addActionListener(bL);
			button6.addActionListener(bL);
			button7.addActionListener(bL);
			button8.addActionListener(bL);
			button9.addActionListener(bL);
			
			buttonPlus.addActionListener(oL);
			buttonMinus.addActionListener(oL);
			buttonTimes.addActionListener(oL);
			buttonDiv.addActionListener(oL);
			buttonEqu.addActionListener(oL);
			buttonCE.addActionListener(oL);
			buttonCA.addActionListener(oL);
			
			jp.add(buttonEmp);
			jp.add(buttonEmp2);
			jp.add(buttonCE);
			jp.add(buttonCA);			
			jp.add(button1);
			jp.add(button2);
			jp.add(button3);
			jp.add(buttonPlus);
			jp.add(button4);
			jp.add(button5);
			jp.add(button6);
			jp.add(buttonMinus);
			jp.add(button7);
			jp.add(button8);
			jp.add(button9);
			jp.add(buttonTimes);
			jp.add(button0);			
			jp.add(buttonP);			
			jp.add(buttonEqu);
			jp.add(buttonDiv);
			
			
			add(jp, BorderLayout.CENTER);			
	}
		
	private class OperationListener implements ActionListener {
		private double oldNum = 0;
		private String operation = null;
		public void actionPerformed(ActionEvent event) {
			if (((JButton)event.getSource()).getText()=="+") {
				operation = "add";
				oldNum = Double.parseDouble(accumulator.getText());
				accumulator.setText(" ");
			}
			else if (((JButton)event.getSource()).getText()=="-") {
				operation = "subtract";
				oldNum = Double.parseDouble(accumulator.getText());
				accumulator.setText(" ");
			}
			else if (((JButton)event.getSource()).getText()=="/") {
				operation = "divide";
				oldNum = Double.parseDouble(accumulator.getText());
				accumulator.setText(" ");
			}
			else if (((JButton)event.getSource()).getText()=="*") {
				operation = "multiply";
				oldNum = Double.parseDouble(accumulator.getText());
				accumulator.setText(" ");
			}
			else if (((JButton)event.getSource()).getText()=="="){
				accumulator.setText(Double.toString(Math(oldNum,operation)));
			}
			else if ((((JButton)event.getSource()).getText()=="CE")) {
				clearOldNum();
				
			}
			else if ((((JButton)event.getSource()).getText()=="CA")) {
				clearAll();
			}
		}
		
		public  void clearOldNum() {
			oldNum = 0;
		}
		public void clearAll() {
			clearOldNum();
			accumulator.setText(" ");
		}
		
		public double Math (double oldNum, String operation) {
			if (operation.equals("add")) {
				return (oldNum + Double.parseDouble(accumulator.getText()));
			}
			else if (operation.equals("subtract")) {
				return (oldNum - Double.parseDouble(accumulator.getText()));
			}
			else if (operation.equals("multiply")) {
				return (oldNum * Double.parseDouble(accumulator.getText()));
			}
			else if (operation.equals("divide")) {
				return (oldNum / Double.parseDouble(accumulator.getText()));
			}
			else {
				return 0;
			}
		}
	}
	
	private class ButtonsListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (((JButton)event.getSource()).getText()=="1") {
				if(accumulator.getText().equals("0")) {					
					accumulator.setText(((JButton)event.getSource()).getText());
					return;
				}
				String in = accumulator.getText() + ((JButton)event.getSource()).getText();
				accumulator.setText(in);
			}
			else if (((JButton)event.getSource()).getText()=="2") {
				if(accumulator.getText().equals("0")) {					
					accumulator.setText(((JButton)event.getSource()).getText());
					return;
				}
				String in = accumulator.getText() + ((JButton)event.getSource()).getText();
				accumulator.setText(in);
			}
			else if (((JButton)event.getSource()).getText()=="3") {
				if(accumulator.getText().equals("0")) {					
					accumulator.setText(((JButton)event.getSource()).getText());
					return;
				}
				String in = accumulator.getText() + ((JButton)event.getSource()).getText();
				accumulator.setText(in);
			}
			else if (((JButton)event.getSource()).getText()=="4") {
				if(accumulator.getText().equals("0")) {					
					accumulator.setText(((JButton)event.getSource()).getText());
					return;
				}
				String in = accumulator.getText() + ((JButton)event.getSource()).getText();
				accumulator.setText(in);
			}
			else if (((JButton)event.getSource()).getText()=="5") {
				if(accumulator.getText().equals("0")) {					
					accumulator.setText(((JButton)event.getSource()).getText());
					return;
				}
				String in = accumulator.getText() + ((JButton)event.getSource()).getText();
				accumulator.setText(in);
			}
			else if (((JButton)event.getSource()).getText()=="6") {
				if(accumulator.getText().equals("0")) {					
					accumulator.setText(((JButton)event.getSource()).getText());
					return;
				}
				String in = accumulator.getText() + ((JButton)event.getSource()).getText();
				accumulator.setText(in);
			}
			else if (((JButton)event.getSource()).getText()=="7") {
				if(accumulator.getText().equals("0")) {					
					accumulator.setText(((JButton)event.getSource()).getText());
					return;
				}
				String in = accumulator.getText() + ((JButton)event.getSource()).getText();
				accumulator.setText(in);
			}
			else if (((JButton)event.getSource()).getText()=="8") {
				if(accumulator.getText().equals("0")) {					
					accumulator.setText(((JButton)event.getSource()).getText());
					return;
				}
				String in = accumulator.getText() + ((JButton)event.getSource()).getText();
				accumulator.setText(in);
			}
			else if (((JButton)event.getSource()).getText()=="9") {
				if(accumulator.getText().equals("0")) {					
					accumulator.setText(((JButton)event.getSource()).getText());
					return;
				}
				String in = accumulator.getText() + ((JButton)event.getSource()).getText();
				accumulator.setText(in);
			}
			else if (((JButton)event.getSource()).getText()=="0") {
				if (accumulator.getText().equals("0")) {
					return;
				} 
				else {
					String in = accumulator.getText() +((JButton)event.getSource()).getText();
					accumulator.setText(in);
				}
			}
			else {
				String acc = accumulator.getText();
				if(acc.indexOf(".") == -1) {
					String in = accumulator.getText() + ((JButton)event.getSource()).getText();
					accumulator.setText(in);
				}
			}
		}
	}
	public static void main (String[] args) {
		new Calc();
	}
}
